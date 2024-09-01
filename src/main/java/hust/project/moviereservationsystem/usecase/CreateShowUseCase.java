package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.CreateShowRequest;
import hust.project.moviereservationsystem.exception.CreateShowException;
import hust.project.moviereservationsystem.mapper.ShowMapper;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateShowUseCase {
    private final IShowPort showPort;
    private final ShowMapper showMapper;
    private final GetMovieUseCase getMovieUseCase;
    private final ICinemaHallPort cinemaHallPort;
    private final CreateShowSeatUseCase createShowSeatUseCase;

    @Transactional(rollbackFor = Exception.class)
    public ShowEntity createShow(CreateShowRequest request) {
        if (request.getCinemaHallId() == null || request.getMovieId() == null
            || request.getStartTime() == null) {
            log.error("[CreateShowUseCase] all fields are required");
            throw new CreateShowException();
        }

        var show = showMapper.toEntityFromRequest(request);

        var movie = getMovieUseCase.getDetailMovie(request.getMovieId());
        var cinemaHall = cinemaHallPort.getCinemaHallById(request.getCinemaHallId());

        var startTime = request.getStartTime();
        var endTime = startTime.plusMinutes(movie.getDuration());

        if (!isValidShow(request.getCinemaHallId(), startTime, endTime)) {
            log.error("[CreateShowUseCase] time is not valid");
            throw new CreateShowException();
        }
        show.setEndTime(endTime);

        show = showPort.save(show);
        show.setCinemaHall(cinemaHall);
        show.setMovie(movie);

        // Auto create seats for show
        createShowSeatUseCase.createShowSeats(show.getId());

        return show;

    }

    private Boolean isValidShow(Long cinemaHallId, LocalDateTime startTime, LocalDateTime endTime) {
        return !(showPort.existsByCinemaHallIdAndInternalTime(cinemaHallId, startTime) ||
                showPort.existsByCinemaHallIdAndInternalTime(cinemaHallId, endTime));
    }
}
