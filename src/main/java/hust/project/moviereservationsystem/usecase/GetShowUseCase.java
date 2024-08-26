package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.entity.response.AllShowsItemResponse;
import hust.project.moviereservationsystem.entity.response.AllShowsResponse;
import hust.project.moviereservationsystem.entity.response.CinemaShowItemResponse;
import hust.project.moviereservationsystem.entity.response.CinemaShowResponse;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import hust.project.moviereservationsystem.port.ICinemaPort;
import hust.project.moviereservationsystem.port.IMoviePort;
import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetShowUseCase {
    private final IShowPort showPort;
    private final ICinemaPort cinemaPort;
    private final ICinemaHallPort cinemaHallPort;
    private final IMoviePort moviePort;

    public AllShowsResponse getAllShows(GetShowRequest filter) {
        var shows = showPort.getAllShows(filter);

        var cinemaHallIds = shows.stream()
                .map(ShowEntity::getCinemaHallId)
                .collect(Collectors.toSet())
                .stream()
                .toList();

        var cinemaHalls = cinemaHallPort.getCinemaHallsByIds(cinemaHallIds);

        var cinemaIds = cinemaHalls.stream()
                .map(CinemaHallEntity::getCinemaId)
                .toList();

        var cinemas = cinemaPort.getCinemasByIds(cinemaIds);

        var cinemaShows = new ArrayList<AllShowsItemResponse>();
        for (var cinema : cinemas) {
            var _cinemaHallIIds = cinemaHalls.stream()
                    .filter(cinemaHall -> cinemaHall.getCinemaId().equals(cinema.getId()))
                    .map(CinemaHallEntity::getId)
                    .collect(Collectors.toSet());

            var _shows = shows.stream()
                    .filter(show -> _cinemaHallIIds.contains(show.getCinemaHallId()))
                    .toList();

            cinemaShows.add(new AllShowsItemResponse(cinema, _shows));
        }

        return new AllShowsResponse((long) cinemas.size(), cinemaShows);

    }

    public CinemaShowResponse getShowsByCinemaIdAndDate(Long cinemaId, LocalDate date) {
        var result = new CinemaShowResponse();

        var cinema = cinemaPort.getCinemaById(cinemaId);
        result.setCinema(cinema);

        var cinemaHalls = cinemaHallPort.getCinemaHallsByCinemaId(cinemaId);
        var cinemaHallIds = cinemaHalls.stream()
                .map(CinemaHallEntity::getId)
                .toList();

        var shows = showPort.getShowsByCinemaHallIdsAndDate(cinemaHallIds, date);
        if (shows.isEmpty()) {
            return null;
        }

        Map<Long, List<ShowEntity>> mapMovieIdToShow = new HashMap<>();
        for (var show : shows) {
            mapMovieIdToShow.computeIfAbsent(show.getMovieId(), k -> new ArrayList<>()).add(show);
        }

        var movieIds = mapMovieIdToShow.keySet().stream().toList();
        var movies = moviePort.getMoviesByIds(movieIds);
        var mapIdToMovie = movies.stream().collect(Collectors.toMap(MovieEntity::getId, Function.identity()));

        result.setTotalMovies((long) movieIds.size());

        List<CinemaShowItemResponse> cinemaShowItemResponses = new ArrayList<>();

        for (var movieId : mapMovieIdToShow.keySet()) {
            var movie = mapIdToMovie.get(movieId);
            cinemaShowItemResponses.add(new CinemaShowItemResponse(movie, mapMovieIdToShow.get(movieId)));
        }

        result.setMovies(cinemaShowItemResponses);

        return result;
    }

    public ShowEntity getDetailShow(Long id) {
        var show = showPort.getShowById(id);
        var movie = moviePort.getMovieById(show.getMovieId());
        var cinemaHall = cinemaHallPort.getCinemaHallById(show.getCinemaHallId());
        show.setMovie(movie);
        show.setCinemaHall(cinemaHall);
        return show;
    }

}
