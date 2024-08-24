package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.AddressEntity;
import hust.project.moviereservationsystem.entity.BaseEntity;
import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.port.ICinemaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetCinemaUseCase {
    private final ICinemaPort cinemaPort;
    private final GetAddressUseCase getAddressUseCase;

    public Pair<PageInfo, List<CinemaEntity>> getAllCinemas(GetCinemaRequest filter) {
        var result = cinemaPort.getAllCinemas(filter);
        var cinemaEntities = result.getSecond();

        var addressIds = cinemaEntities.stream().map(CinemaEntity::getAddressId).toList();
        var addressEntities = getAddressUseCase.getAddressByIds(addressIds);
        var mapIdToAddress = addressEntities.stream()
                .collect(Collectors.toMap(AddressEntity::getId, Function.identity()));

        cinemaEntities = cinemaEntities.stream().peek(
                cinemaEntity -> {
                    cinemaEntity.setAddress(mapIdToAddress.get(cinemaEntity.getAddressId()));
                }
        ).toList();

        return Pair.of(result.getFirst(), cinemaEntities);
    }

    public CinemaEntity getDetailCinema(Long cinemaId) {
        var cinemaEntity = cinemaPort.getCinemaById(cinemaId);
        var addressEntity = getAddressUseCase.getAddressByIds(List.of(cinemaEntity.getAddressId())).get(0);
        cinemaEntity.setAddress(addressEntity);

        return cinemaEntity;
    }
}
