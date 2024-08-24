package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.WardEntity;
import hust.project.moviereservationsystem.exception.CreateWardException;
import hust.project.moviereservationsystem.exception.GetWardException;
import hust.project.moviereservationsystem.mapper.AddressMapper;
import hust.project.moviereservationsystem.port.IWardPort;
import hust.project.moviereservationsystem.repository.IWardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WardAdapter implements IWardPort {
    private final IWardRepository wardRepository;
    private final AddressMapper addressMapper;

    @Override
    public WardEntity save(WardEntity wardEntity) {
        try {
            var wardModel = addressMapper.toModelFromEntity(wardEntity);
            return addressMapper.toEntityFromModel(wardRepository.save(wardModel));
        } catch (Exception e) {
            throw new CreateWardException();
        }
    }

    @Override
    public List<WardEntity> getWardsByName(String name) {
        return wardRepository.findByNameLike(name)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public List<WardEntity> getWardsByCodes(List<String> codes) {
        return wardRepository.findByCodeIn(codes)
                .stream()
                .map(addressMapper::toEntityFromModel)
                .toList();
    }

    @Override
    public WardEntity getWardByCode(String code) {
        return addressMapper.toEntityFromModel(wardRepository.findByCode(code).orElse(null));
    }

}
