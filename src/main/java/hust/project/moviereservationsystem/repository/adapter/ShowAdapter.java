package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.ShowEntity;
import hust.project.moviereservationsystem.entity.request.GetShowRequest;
import hust.project.moviereservationsystem.exception.CreateShowException;
import hust.project.moviereservationsystem.exception.DeleteShowException;
import hust.project.moviereservationsystem.exception.GetShowException;
import hust.project.moviereservationsystem.mapper.ShowMapper;
import hust.project.moviereservationsystem.port.IShowPort;
import hust.project.moviereservationsystem.repository.IShowRepository;
import hust.project.moviereservationsystem.repository.specification.ShowSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowAdapter implements IShowPort {
    private final IShowRepository showRepository;
    private final ShowMapper showMapper;

    @Override
    public ShowEntity save(ShowEntity showEntity) {
        try {
            var showModel = showMapper.toModelFromEntity(showEntity);
            return showMapper.toEntityFromModel(showRepository.save(showModel));
        } catch (Exception e) {
            throw new CreateShowException();
        }
    }

    @Override
    public List<ShowEntity> getAllShows(GetShowRequest filter) {
        return showMapper.toEntitiesFromModels(
                showRepository.findAll(ShowSpecification.getAllShows(filter))
        );
    }

    @Override
    public List<ShowEntity> getShowsByCinemaHallIdIn(List<Long> cinemaHallIds) {
        return showMapper.toEntitiesFromModels(showRepository.findByCinemaHallIdIn(cinemaHallIds));
    }

    @Override
    public List<ShowEntity> getShowsByCinemaHallIdsAndDate(List<Long> cinemaHallIds, LocalDate date) {
        return showMapper.toEntitiesFromModels(
                showRepository.findAll(ShowSpecification.getShowsByCinemaHallsIdsAndDate(cinemaHallIds, date))
        );
    }

    @Override
    public List<ShowEntity> getShowsByIds(List<Long> ids) {
        return showMapper.toEntitiesFromModels(showRepository.findAllById(ids));
    }

    @Override
    public ShowEntity getShowById(Long id) {
        return showMapper.toEntityFromModel(showRepository.findById(id).orElseThrow(GetShowException::new));
    }

    @Override
    public void deleteShowById(Long id) {
        try {
            showRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteShowException();
        }
    }

    @Override
    public boolean existsByCinemaHallIdAndInternalTime(Long cinemaHallId, LocalDateTime internalTIme) {
        return showRepository.exists(ShowSpecification.isOverlap(cinemaHallId, internalTIme));
    }
}
