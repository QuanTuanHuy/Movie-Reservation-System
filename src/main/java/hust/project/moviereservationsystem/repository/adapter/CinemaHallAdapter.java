package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.CinemaHallEntity;
import hust.project.moviereservationsystem.exception.CreateCinemaHallException;
import hust.project.moviereservationsystem.exception.DeleteCinemaHallException;
import hust.project.moviereservationsystem.exception.GetCinemaHallException;
import hust.project.moviereservationsystem.mapper.CinemaHallMapper;
import hust.project.moviereservationsystem.port.ICinemaHallPort;
import hust.project.moviereservationsystem.repository.ICinemaHallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaHallAdapter implements ICinemaHallPort {
    private final ICinemaHallRepository cinemaHallRepository;
    private final CinemaHallMapper cinemaHallMapper;

    @Override
    public CinemaHallEntity save(CinemaHallEntity cinemaHallEntity) {
        try {
            var cinemaHallModel = cinemaHallMapper.toModelFromEntity(cinemaHallEntity);
            return cinemaHallMapper.toEntityFromModel(cinemaHallRepository.save(cinemaHallModel));
        } catch (Exception e) {
            throw new CreateCinemaHallException();
        }
    }

    @Override
    public List<CinemaHallEntity> getCinemaHallsByCinemaId(Long cinemaId) {
        return cinemaHallMapper.toEntitiesFromModels(cinemaHallRepository.findByCinemaId(cinemaId));
    }

    @Override
    public List<CinemaHallEntity> getCinemaHallsByIds(List<Long> ids) {
        return cinemaHallMapper.toEntitiesFromModels(cinemaHallRepository.findByIdIn(ids));
    }

    @Override
    public CinemaHallEntity getCinemaHallById(Long id) {
        return cinemaHallMapper.toEntityFromModel(cinemaHallRepository.findById(id)
                .orElseThrow(GetCinemaHallException::new));
    }

    @Override
    public void deleteCinemaHallById(Long cinemaHallId) {
        try {
            cinemaHallRepository.deleteById(cinemaHallId);
        } catch (Exception e) {
            throw new DeleteCinemaHallException();
        }
    }
}
