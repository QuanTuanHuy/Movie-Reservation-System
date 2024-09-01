package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.exception.CreateShowSeatException;
import hust.project.moviereservationsystem.exception.GetShowSeatException;
import hust.project.moviereservationsystem.mapper.ShowSeatMapper;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import hust.project.moviereservationsystem.repository.IShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowSeatAdapter implements IShowSeatPort {
    private final IShowSeatRepository showSeatRepository;
    private final ShowSeatMapper showSeatMapper;

    @Override
    public ShowSeatEntity save(ShowSeatEntity showSeatEntity) {
        try {
            var showSeatModel = showSeatMapper.toModelFromEntity(showSeatEntity);
            return showSeatMapper.toEntityFromModel(showSeatRepository.save(showSeatModel));
        } catch (Exception e) {
            throw new CreateShowSeatException();
        }
    }

    @Override
    public List<ShowSeatEntity> getAllShowSeatsByShowId(Long showId) {
        return showSeatMapper.toEntitiesFromModels(showSeatRepository.findByShowId(showId));
    }

    @Override
    public List<ShowSeatEntity> saveAll(List<ShowSeatEntity> showSeatEntities) {
        try {
            var showSeatModels = showSeatMapper.toModelsFromEntities(showSeatEntities);
            return showSeatMapper.toEntitiesFromModels(showSeatRepository.saveAll(showSeatModels));
        } catch (Exception e) {
            throw new CreateShowSeatException();
        }
    }

    @Override
    public List<ShowSeatEntity> getShowSeatsByBookingId(Long bookingId) {
        return showSeatMapper.toEntitiesFromModels(showSeatRepository.findByBookingId(bookingId));
    }

    @Override
    public List<ShowSeatEntity> getShowSeatsByIds(List<Long> ids) {
        return showSeatMapper.toEntitiesFromModels(showSeatRepository.findByIdIn(ids));
    }

    @Override
    public List<ShowSeatEntity> getShowSeatsByUserId(Long userId) {
        return showSeatMapper.toEntitiesFromModels(
                showSeatRepository.findByUserIdAndBookingIdIsNull(userId)
        );
    }

    @Override
    public ShowSeatEntity getShowSeatById(Long id) {
        return showSeatMapper.toEntityFromModel(
                showSeatRepository.findById(id).orElseThrow(GetShowSeatException::new));
    }

    @Override
    public void deleteShowSeatByShowId(Long showId) {
        showSeatRepository.deleteAllByShowId(showId);
    }
}
