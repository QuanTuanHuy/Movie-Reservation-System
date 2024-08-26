package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;

import java.util.List;

public interface ISeatTypePort {
    SeatTypeEntity save(SeatTypeEntity seatTypeEntity);

    List<SeatTypeEntity> getAllSeatTypes();

    SeatTypeEntity getByType(String type);

    SeatTypeEntity getById(Long id);

    void deleteById(Long id);
}
