package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.exception.CreateGenreException;
import hust.project.moviereservationsystem.exception.GetGenreException;
import hust.project.moviereservationsystem.mapper.GenreMapper;
import hust.project.moviereservationsystem.port.IGenrePort;
import hust.project.moviereservationsystem.repository.IGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreAdapter implements IGenrePort {
    private final IGenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreEntity save(GenreEntity genreEntity) {
        try {
            var genreModel = genreMapper.toModelFromEntity(genreEntity);
            return genreMapper.toEntityFromModel(genreRepository.save(genreModel));
        } catch (Exception e) {
            throw new CreateGenreException();
        }
    }

    @Override
    public GenreEntity getGenreById(Long genreId) {
        return genreMapper.toEntityFromModel(genreRepository.findById(genreId)
                .orElseThrow(GetGenreException::new));
    }

    @Override
    public List<GenreEntity> getGenresByIds(List<Long> genreIds) {
        return genreMapper.toEntitiesFromModels(genreRepository.findByIdIn(genreIds));
    }

    @Override
    public GenreEntity getGenreByName(String name) {
        return genreMapper.toEntityFromModel(genreRepository.findByName(name)
                .orElseThrow(GetGenreException::new));
    }
}
