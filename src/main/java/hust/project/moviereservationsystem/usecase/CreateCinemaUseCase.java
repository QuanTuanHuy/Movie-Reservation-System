package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.mapper.CinemaMapper;
import hust.project.moviereservationsystem.port.ICinemaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCinemaUseCase {
    private final ICinemaPort cinemaPort;
    private final CinemaMapper cinemaMapper;
    private final CreateAddressUseCase createAddressUseCase;

    @Transactional(rollbackFor = Exception.class)
    public CinemaEntity createCinema(CreateCinemaRequest createCinemaRequest) {
        var cinemaEntity = cinemaMapper.toEntityFromRequest(createCinemaRequest);

        var addressRequest = createCinemaRequest.getAddress();
        var addressEntity = createAddressUseCase.createAddress(addressRequest);

        cinemaEntity.setAddressId(addressEntity.getId());
        cinemaEntity.setCityCode(addressEntity.getCityCode());
        cinemaEntity.setIsActive(true);

        cinemaEntity = cinemaPort.save(cinemaEntity);
        cinemaEntity.setAddress(addressEntity);

        return cinemaEntity;
    }
}
