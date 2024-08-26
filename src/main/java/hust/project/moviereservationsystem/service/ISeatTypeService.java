package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.entity.request.CreateSeatTypeRequest;
import hust.project.moviereservationsystem.entity.request.UpdateSeatTypeRequest;

import java.util.List;

public interface ISeatTypeService {
    SeatTypeEntity createSeatType(CreateSeatTypeRequest request);

    List<SeatTypeEntity> getAllSeatTypes();

    SeatTypeEntity updateSeatType(Long id, UpdateSeatTypeRequest request);

    void deleteSeatType(Long id);
}
