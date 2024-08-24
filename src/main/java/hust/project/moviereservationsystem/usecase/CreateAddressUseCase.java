package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.AddressEntity;
import hust.project.moviereservationsystem.entity.request.CreateAddressRequest;
import hust.project.moviereservationsystem.exception.CreateAddressException;
import hust.project.moviereservationsystem.mapper.AddressMapper;
import hust.project.moviereservationsystem.port.IAddressPort;
import hust.project.moviereservationsystem.port.ICityPort;
import hust.project.moviereservationsystem.port.IDistrictPort;
import hust.project.moviereservationsystem.port.IWardPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateAddressUseCase {
    private final IAddressPort addressPort;
    private final ICityPort cityPort;
    private final IDistrictPort districtPort;
    private final IWardPort wardPort;
    private final AddressMapper addressMapper;

    public AddressEntity createAddress(CreateAddressRequest request) {
        if (request.getCity() == null || request.getDistrict() == null ||
                request.getWard() == null || !StringUtils.hasText(request.getDescription())) {
            log.error("[CreateAddressUseCase] city, district, ward, description must not be null");
            throw new CreateAddressException();
        }

        var address = addressMapper.toEntityFromRequest(request);

        var cityEntity = cityPort.getCityByCode(request.getCity().getCode());
        if (cityEntity == null) {
            cityEntity = cityPort.save(addressMapper.toEntityFromRequest(request.getCity()));
        }

        var districtEntity = districtPort.getDistrictByCode(request.getDistrict().getCode());
        if (districtEntity == null) {
            districtEntity = districtPort.save(addressMapper.toEntityFromRequest(request.getDistrict()));
        }

        var wardEntity = wardPort.getWardByCode(request.getWard().getCode());
        if (wardEntity == null) {
            wardEntity = wardPort.save(addressMapper.toEntityFromRequest(request.getWard()));
        }

        address.setDescription(request.getDescription());
        address.setCityCode(cityEntity.getCode());
        address.setDistrictCode(districtEntity.getCode());
        address.setWardCode(wardEntity.getCode());

        address = addressPort.save(address);
        address.setCity(cityEntity);
        address.setDistrict(districtEntity);
        address.setWard(wardEntity);

        return address;
    }
}
