package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.CreateSeatTypeRequest;
import hust.project.moviereservationsystem.exception.CreateSeatTypeException;
import hust.project.moviereservationsystem.mapper.SeatTypeMapper;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateSeatTypeUseCase {
    private final ISeatTypePort seatTypePort;
    private final SeatTypeMapper seatTypeMapper;

    @Transactional(rollbackFor = Exception.class)
    public SeatTypeEntity createSeatType(CreateSeatTypeRequest request) {
        if (request.getType() == null || request.getPrice() == null) {
            log.error("[CreateSeatTypeUseCase] type, price is null");
            throw new CreateSeatTypeException();
        }

        var existedSeatType = seatTypePort.getByType(request.getType());
        if (existedSeatType != null) {
            throw new CreateSeatTypeException();
        }

        return seatTypePort.save(seatTypeMapper.toEntityFromRequest(request));
    }
}
