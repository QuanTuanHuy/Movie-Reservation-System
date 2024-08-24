package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.DistrictEntity;

import java.util.List;

public interface IDistrictPort {
    DistrictEntity save(DistrictEntity districtEntity);

    List<DistrictEntity> getDistrictsByName(String name);

    List<DistrictEntity> getDistrictsByCodes(List<String> codes);

    DistrictEntity getDistrictByCode(String code);
}
