package hust.project.moviereservationsystem.mapper;

import hust.project.moviereservationsystem.entity.AddressEntity;
import hust.project.moviereservationsystem.entity.CityEntity;
import hust.project.moviereservationsystem.entity.DistrictEntity;
import hust.project.moviereservationsystem.entity.WardEntity;
import hust.project.moviereservationsystem.entity.request.CreateAddressRequest;
import hust.project.moviereservationsystem.entity.request.CreateCityRequest;
import hust.project.moviereservationsystem.entity.request.CreateDistrictRequest;
import hust.project.moviereservationsystem.entity.request.CreateWardRequest;
import hust.project.moviereservationsystem.model.AddressModel;
import hust.project.moviereservationsystem.model.CityModel;
import hust.project.moviereservationsystem.model.DistrictModel;
import hust.project.moviereservationsystem.model.WardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {
    public abstract AddressEntity toEntityFromModel(AddressModel model);

    public abstract AddressModel toModelFromEntity(AddressEntity entity);

    public abstract CityEntity toEntityFromModel(CityModel model);

    public abstract CityModel toModelFromEntity(CityEntity entity);

    public abstract DistrictEntity toEntityFromModel(DistrictModel model);

    public abstract DistrictModel toModelFromEntity(DistrictEntity entity);

    public abstract WardEntity toEntityFromModel(WardModel model);

    public abstract WardModel toModelFromEntity(WardEntity entity);

    @Mapping(target = "city", ignore = true)
    @Mapping(target = "district", ignore = true)
    @Mapping(target = "ward", ignore = true)
    public abstract AddressEntity toEntityFromRequest(CreateAddressRequest request);

    public abstract CityEntity toEntityFromRequest(CreateCityRequest request);

    public abstract DistrictEntity toEntityFromRequest(CreateDistrictRequest request);

    public abstract WardEntity toEntityFromRequest(CreateWardRequest request);
}
