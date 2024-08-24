package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;
import hust.project.moviereservationsystem.mapper.GenreMapper;
import hust.project.moviereservationsystem.port.IGenrePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGenreUseCase {
    private final IGenrePort genrePort;
    private final GenreMapper genreMapper;

    public GenreEntity createGenre(CreateGenreRequest request) {
        var genreEntity = genreMapper.toEntityFromRequest(request);
        return genrePort.save(genreEntity);
    }
}
