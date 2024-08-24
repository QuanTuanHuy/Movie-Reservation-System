package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.WardModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IWardRepository extends IBaseRepository<WardModel> {
    Optional<WardModel> findByCode(String code);

    List<WardModel> findByNameLike(String name);

    List<WardModel> findByCodeIn(List<String> codes);
}
