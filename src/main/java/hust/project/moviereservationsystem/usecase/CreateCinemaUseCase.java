package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.CreateCinemaRequest;
import hust.project.moviereservationsystem.exception.CreateCinemaException;
import hust.project.moviereservationsystem.mapper.CinemaMapper;
import hust.project.moviereservationsystem.port.ICinemaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCinemaUseCase {
    private final ICinemaPort cinemaPort;
    private final CinemaMapper cinemaMapper;
    private final CreateAddressUseCase createAddressUseCase;

    @Transactional(rollbackFor = Exception.class)
    public CinemaEntity createCinema(CreateCinemaRequest createCinemaRequest) {
        if (cinemaPort.existsByName(createCinemaRequest.getName())) {
            log.error("[CreateCinemaUseCase] cinema name is already existed");
            throw new CreateCinemaException();
        }

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
