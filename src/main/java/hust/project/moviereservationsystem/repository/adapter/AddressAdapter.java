package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.AddressEntity;
import hust.project.moviereservationsystem.exception.CreateAddressException;
import hust.project.moviereservationsystem.exception.GetAddressException;
import hust.project.moviereservationsystem.mapper.AddressMapper;
import hust.project.moviereservationsystem.port.IAddressPort;
import hust.project.moviereservationsystem.repository.IAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressAdapter implements IAddressPort {
    private final IAddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressEntity save(AddressEntity addressEntity) {
        try {
            var addressModel = addressMapper.toModelFromEntity(addressEntity);
            return addressMapper.toEntityFromModel(addressRepository.save(addressModel));
        } catch (Exception e) {
            throw new CreateAddressException();
        }
    }

    @Override
    public List<AddressEntity> getAddressByIds(List<Long> ids) {
        return addressRepository.findByIdIn(ids)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public AddressEntity getAddressById(Long id) {
        return addressMapper.toEntityFromModel(addressRepository.findById(id).orElseThrow(GetAddressException::new));
    }
}
