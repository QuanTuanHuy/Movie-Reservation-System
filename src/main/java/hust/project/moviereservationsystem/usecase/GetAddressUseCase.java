package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.AddressEntity;
import hust.project.moviereservationsystem.entity.CityEntity;
import hust.project.moviereservationsystem.entity.DistrictEntity;
import hust.project.moviereservationsystem.entity.WardEntity;
import hust.project.moviereservationsystem.port.IAddressPort;
import hust.project.moviereservationsystem.port.ICityPort;
import hust.project.moviereservationsystem.port.IDistrictPort;
import hust.project.moviereservationsystem.port.IWardPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAddressUseCase {
    private final IAddressPort addressPort;
    private final ICityPort cityPort;
    private final IDistrictPort districtPort;
    private final IWardPort wardPort;

    public List<AddressEntity> getAddressByIds(List<Long> ids) {
        var addressEntities = addressPort.getAddressByIds(ids);

        var cityCodes = addressEntities.stream().map(AddressEntity::getCityCode).toList();
        var cityEntities = cityPort.getCitiesByCodes(cityCodes);
        var mapCodeToCity = cityEntities.stream().collect(Collectors.toMap(CityEntity::getCode, Function.identity()));

        var districtCodes = addressEntities.stream().map(AddressEntity::getDistrictCode).toList();
        var districtEntities = districtPort.getDistrictsByCodes(districtCodes);
        var mapCodeToDistrict = districtEntities.stream().collect(Collectors.toMap(DistrictEntity::getCode, Function.identity()));

        var wardCodes = addressEntities.stream().map(AddressEntity::getWardCode).toList();
        var wardEntities = wardPort.getWardsByCodes(wardCodes);
        var mapCodeToWard = wardEntities.stream().collect(Collectors.toMap(WardEntity::getCode, Function.identity()));

        return addressEntities.stream().peek(
                addressEntity -> {
                    addressEntity.setCity(mapCodeToCity.get(addressEntity.getCityCode()));
                    addressEntity.setDistrict(mapCodeToDistrict.get(addressEntity.getDistrictCode()));
                    addressEntity.setWard(mapCodeToWard.get(addressEntity.getWardCode()));
                }
        ).toList();
    }
}
