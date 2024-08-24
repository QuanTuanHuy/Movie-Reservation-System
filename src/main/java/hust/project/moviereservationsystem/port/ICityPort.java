package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.CityEntity;

import java.util.List;

public interface ICityPort {
    CityEntity save(CityEntity cityEntity);

    List<CityEntity> getCitiesByName(String name);

    List<CityEntity> getCitiesByCodes(List<String> codes);

    CityEntity getCityByCode(String code);
}
