package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.CreateSeatTypeRequest;
import hust.project.moviereservationsystem.entity.request.UpdateSeatTypeRequest;
import hust.project.moviereservationsystem.service.ISeatTypeService;
import hust.project.moviereservationsystem.usecase.CreateSeatTypeUseCase;
import hust.project.moviereservationsystem.usecase.DeleteSeatTypeUseCase;
import hust.project.moviereservationsystem.usecase.GetSeatTypeUseCase;
import hust.project.moviereservationsystem.usecase.UpdateSeatTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatTypeService implements ISeatTypeService {
    private final CreateSeatTypeUseCase createSeatTypeUseCase;
    private final GetSeatTypeUseCase getSeatTypeUseCase;
    private final UpdateSeatTypeUseCase updateSeatTypeUseCase;
    private final DeleteSeatTypeUseCase deleteSeatTypeUseCase;

    @Override
    public SeatTypeEntity createSeatType(CreateSeatTypeRequest request) {
        return createSeatTypeUseCase.createSeatType(request);
    }

    @Override
    public List<SeatTypeEntity> getAllSeatTypes() {
        return getSeatTypeUseCase.getAllSeatTypes();
    }

    @Override
    public SeatTypeEntity updateSeatType(Long id, UpdateSeatTypeRequest request) {
        return updateSeatTypeUseCase.updateSeatType(id, request);
    }

    @Override
    public void deleteSeatType(Long id) {
        deleteSeatTypeUseCase.deleteSeatType(id);
    }
}
