package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSeatTypeUseCase {
    private final ISeatTypePort seatTypePort;

    public List<SeatTypeEntity> getAllSeatTypes() {
        return seatTypePort.getAllSeatTypes();
    }
}
