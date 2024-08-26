package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.UpdateSeatTypeRequest;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSeatTypeUseCase {
    private final ISeatTypePort seatTypePort;

    public void deleteSeatType(Long id) {
        seatTypePort.deleteById(id);
    }
}
