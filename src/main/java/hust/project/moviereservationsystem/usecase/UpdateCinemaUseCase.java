package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.UpdateCinemaRequest;
import hust.project.moviereservationsystem.port.ICinemaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateCinemaUseCase {
    private final ICinemaPort cinemaPort;
    private final GetAddressUseCase getAddressUseCase;

    public CinemaEntity updateCinema(Long cinemaId, UpdateCinemaRequest request) {
        var cinemaEntity = cinemaPort.getCinemaById(cinemaId);
        if (StringUtils.hasText(request.getName())) {
            cinemaEntity.setName(request.getName());
        }
        if (StringUtils.hasText(request.getPhoneNumber())) {
            cinemaEntity.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getIsActive() != null) {
            cinemaEntity.setIsActive(request.getIsActive());
        }
        if (request.getTotalCinemaHalls() != null) {
            cinemaEntity.setTotalCinemaHalls(request.getTotalCinemaHalls());
        }
        var address = getAddressUseCase.getAddressByIds(List.of(cinemaEntity.getAddressId())).get(0);
        cinemaEntity = cinemaPort.save(cinemaEntity);
        cinemaEntity.setAddress(address);
        return cinemaEntity;
    }
}
