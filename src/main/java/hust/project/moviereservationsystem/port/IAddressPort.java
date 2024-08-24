package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.AddressEntity;

import java.util.List;

public interface IAddressPort {
    AddressEntity save(AddressEntity addressEntity);

    List<AddressEntity> getAddressByIds(List<Long> ids);

    AddressEntity getAddressById(Long id);
}
