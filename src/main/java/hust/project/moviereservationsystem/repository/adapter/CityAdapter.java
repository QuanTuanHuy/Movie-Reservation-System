package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.CityEntity;
import hust.project.moviereservationsystem.exception.CreateCityException;
import hust.project.moviereservationsystem.mapper.AddressMapper;
import hust.project.moviereservationsystem.port.ICityPort;
import hust.project.moviereservationsystem.repository.ICityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityAdapter implements ICityPort {
    private final ICityRepository cityRepository;
    private final AddressMapper addressMapper;

    @Override
    public CityEntity save(CityEntity cityEntity) {
        try {
            var cityModel = addressMapper.toModelFromEntity(cityEntity);
            return addressMapper.toEntityFromModel(cityRepository.save(cityModel));
        } catch (Exception e) {
            throw new CreateCityException();
        }
    }

    @Override
    public List<CityEntity> getCitiesByName(String name) {
        return cityRepository.findByNameLike(name)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public List<CityEntity> getCitiesByCodes(List<String> codes) {
        return cityRepository.findByCodeIn(codes)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public CityEntity getCityByCode(String code) {
        return addressMapper.toEntityFromModel(cityRepository.findByCode(code).orElse(null));
    }
}
