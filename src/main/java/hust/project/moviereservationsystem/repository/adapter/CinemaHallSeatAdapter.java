package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.CinemaHallSeatEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaHallSeatRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateCinemaHallSeatException;
import hust.project.moviereservationsystem.exception.GetCinemaHallSeatException;
import hust.project.moviereservationsystem.mapper.CinemaHallSeatMapper;
import hust.project.moviereservationsystem.port.ICinemaHallSeatPort;
import hust.project.moviereservationsystem.repository.ICinemaHallSeatRepository;
import hust.project.moviereservationsystem.repository.specification.CinemaHallSeatSpecification;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallSeatAdapter implements ICinemaHallSeatPort {
    private final ICinemaHallSeatRepository cinemaHallSeatRepository;
    private final CinemaHallSeatMapper cinemaHallSeatMapper;

    @Override
    public CinemaHallSeatEntity save(CinemaHallSeatEntity seatEntity) {
        try {
            var seatModel = cinemaHallSeatMapper.toModelFromEntity(seatEntity);
            return cinemaHallSeatMapper.toEntityFromModel(cinemaHallSeatRepository.save(seatModel));
        } catch (Exception e) {
            throw new CreateCinemaHallSeatException();
        }
    }

    @Override
    public Pair<PageInfo, List<CinemaHallSeatEntity>> getAll(GetCinemaHallSeatRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        var result = cinemaHallSeatRepository.findAll(CinemaHallSeatSpecification.getAll(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfo(result);

        return Pair.of(pageInfo, cinemaHallSeatMapper.toEntitiesFromModels(result.getContent()));
    }

    @Override
    public CinemaHallSeatEntity getById(Long id) {
        return cinemaHallSeatMapper.toEntityFromModel(
                cinemaHallSeatRepository.findById(id).orElseThrow(GetCinemaHallSeatException::new));
    }

    @Override
    public List<CinemaHallSeatEntity> getByCinemaHallId(Long cinemaHallId) {
        return cinemaHallSeatMapper.toEntitiesFromModels(
                cinemaHallSeatRepository.findByCinemaHallId(cinemaHallId));
    }

    @Override
    public CinemaHallSeatEntity getByCodeAndCinemaHallId(String code, Long cinemaHallId) {
        return cinemaHallSeatMapper.toEntityFromModel(
                cinemaHallSeatRepository.findByCodeAndCinemaHallId(code, cinemaHallId).orElse(null));
    }
}
