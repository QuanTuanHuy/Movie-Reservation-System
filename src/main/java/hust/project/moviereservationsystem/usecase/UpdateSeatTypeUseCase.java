package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.UpdateSeatTypeRequest;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSeatTypeUseCase {
    private final ISeatTypePort seatTypePort;

    public SeatTypeEntity updateSeatType(Long id, UpdateSeatTypeRequest request) {
        var seatType = seatTypePort.getById(id);
        if (request.getDescription() != null) {
            seatType.setDescription(request.getDescription());
        }
        if (request.getPrice() != null) {
            seatType.setPrice(request.getPrice());
        }
        return seatTypePort.save(seatType);
    }
}
