package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.DistrictEntity;
import hust.project.moviereservationsystem.exception.CreateDistrictException;
import hust.project.moviereservationsystem.exception.GetDistrictException;
import hust.project.moviereservationsystem.mapper.AddressMapper;
import hust.project.moviereservationsystem.port.IDistrictPort;
import hust.project.moviereservationsystem.repository.IDistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictAdapter implements IDistrictPort {
    private final IDistrictRepository districtRepository;
    private final AddressMapper addressMapper;

    @Override
    public DistrictEntity save(DistrictEntity districtEntity) {
        try {
            var districtModel = addressMapper.toModelFromEntity(districtEntity);
            return addressMapper.toEntityFromModel(districtRepository.save(districtModel));
        } catch (Exception e) {
            throw new CreateDistrictException();
        }
    }

    @Override
    public List<DistrictEntity> getDistrictsByName(String name) {
        return districtRepository.findByNameLike(name)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public List<DistrictEntity> getDistrictsByCodes(List<String> codes) {
        return districtRepository.findByCodeIn(codes)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public DistrictEntity getDistrictByCode(String code) {
        return addressMapper.toEntityFromModel(districtRepository.findByCode(code).orElse(null));
    }

}
