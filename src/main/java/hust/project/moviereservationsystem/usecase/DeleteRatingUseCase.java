package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.port.IRatingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRatingUseCase {
    private final IRatingPort ratingPort;

    public void deleteRating(Long id) {
        ratingPort.deleteById(id);
    }
}
