package hust.project.moviereservationsystem.port;

import hust.project.moviereservationsystem.entity.WardEntity;

import java.util.List;

public interface IWardPort {
    WardEntity save(WardEntity wardEntity);

    List<WardEntity> getWardsByName(String name);

    List<WardEntity> getWardsByCodes(List<String> codes);

    WardEntity getWardByCode(String code);
}
