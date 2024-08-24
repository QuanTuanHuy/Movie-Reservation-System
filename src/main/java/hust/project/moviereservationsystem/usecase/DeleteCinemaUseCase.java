package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.port.ICinemaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCinemaUseCase {
    private final ICinemaPort cinemaPort;

    public void deleteCinema(Long cinemaId) {
        var cinemaEntity = cinemaPort.getCinemaById(cinemaId);
        cinemaEntity.setIsActive(false);
        cinemaPort.save(cinemaEntity);
    }
}
