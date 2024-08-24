package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.AddressModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepository extends IBaseRepository<AddressModel> {
    List<AddressModel> findByIdIn(List<Long> ids);
}
