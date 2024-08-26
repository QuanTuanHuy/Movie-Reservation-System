package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.CinemaEntity;
import hust.project.moviereservationsystem.entity.request.GetCinemaRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateCinemaException;
import hust.project.moviereservationsystem.exception.DeleteCinemaException;
import hust.project.moviereservationsystem.exception.GetCinemaException;
import hust.project.moviereservationsystem.mapper.CinemaMapper;
import hust.project.moviereservationsystem.port.ICinemaPort;
import hust.project.moviereservationsystem.repository.ICinemaRepository;
import hust.project.moviereservationsystem.repository.specification.CinemaSpecification;
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
public class CinemaAdapter implements ICinemaPort {
    private final ICinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;

    @Override
    public CinemaEntity save(CinemaEntity cinemaEntity) {
        try {
            var cinemaModel = cinemaMapper.toModelFromEntity(cinemaEntity);
            return cinemaMapper.toEntityFromModel(cinemaRepository.save(cinemaModel));
        } catch (Exception e) {
            throw new CreateCinemaException();
        }
    }

    @Override
    public Pair<PageInfo, List<CinemaEntity>> getAllCinemas(GetCinemaRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());
        var result = cinemaRepository.findAll(CinemaSpecification.getAllCinemas(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfo(result);

        return Pair.of(pageInfo, cinemaMapper.toEntitiesFromModels(result.getContent()));
    }

    @Override
    public CinemaEntity getCinemaById(Long cinemaId) {
        return cinemaMapper.toEntityFromModel(cinemaRepository.findById(cinemaId)
                .orElseThrow(GetCinemaException::new));
    }

    @Override
    public List<CinemaEntity> getCinemasByIds(List<Long> ids) {
        return cinemaMapper.toEntitiesFromModels(cinemaRepository.findByIdIn(ids));
    }

    @Override
    public void deleteCinemaById(Long cinemaId) {
        try {
            cinemaRepository.deleteById(cinemaId);
        } catch (Exception e) {
            throw new DeleteCinemaException();
        }
    }
}
