package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.DistrictModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDistrictRepository extends IBaseRepository<DistrictModel> {
    Optional<DistrictModel> findByCode(String code);

    List<DistrictModel> findByNameLike(String name);

    List<DistrictModel> findByCodeIn(List<String> codes);
}
