package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.CityModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICityRepository extends IBaseRepository<CityModel> {
    Optional<CityModel> findByCode(String code);

    List<CityModel> findByNameLike(String name);

    List<CityModel> findByCodeIn(List<String> codes);
}
