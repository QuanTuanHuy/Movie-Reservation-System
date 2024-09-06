package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.MovieEntity;
import hust.project.moviereservationsystem.entity.RatingEntity;
import hust.project.moviereservationsystem.entity.UserEntity;
import hust.project.moviereservationsystem.entity.request.CreateRatingRequest;
import hust.project.moviereservationsystem.exception.CreateMovieException;
import hust.project.moviereservationsystem.exception.CreateRatingException;
import hust.project.moviereservationsystem.port.IMoviePort;
import hust.project.moviereservationsystem.port.IRatingPort;
import hust.project.moviereservationsystem.port.IUserPort;
import hust.project.moviereservationsystem.repository.ICustomMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateRatingUseCase {
    private final IRatingPort ratingPort;
    private final IMoviePort moviePort;
    private final IUserPort userPort;
    private final ICustomMovieRepository customMovieRepository;

    @Transactional(rollbackFor = Exception.class)
    public RatingEntity createRating(CreateRatingRequest request, Long userId) {
        MovieEntity movie = moviePort.getMovieById(request.getMovieId());
        UserEntity user = userPort.getUserById(userId);

        boolean ratingIsExisted = ratingPort.existsByUserIdAndMovieId(userId, request.getMovieId());
        if (ratingIsExisted) {
            log.error("[CreateRatingUseCase] rating is already existed");
            throw new CreateRatingException();
        }

        boolean isWatched = customMovieRepository.isUserWatchedMovie(userId, request.getMovieId());

        if (!isWatched) {
            log.error("[CreateRatingUseCase] movie is not watched by user");
            throw new CreateRatingException();
        }

        RatingEntity rating = new RatingEntity();
        rating.setRatingStar(request.getRatingStar());
        rating.setContent(request.getContent());
        rating.setMovieId(request.getMovieId());
        rating.setUserId(userId);
        rating.setUserName(user.getFirstName() + " " + user.getLastName());

        return ratingPort.save(rating);

    }
}
