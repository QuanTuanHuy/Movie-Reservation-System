package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.SeatTypeModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISeatTypeRepository extends IBaseRepository<SeatTypeModel> {
    Optional<SeatTypeModel> findByType(String type);
}
