package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.port.IMoviePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMovieUseCase {
    private final IMoviePort moviePort;

    public void deleteMovie(Long movieId) {
        moviePort.deleteMovie(movieId);
    }
}
