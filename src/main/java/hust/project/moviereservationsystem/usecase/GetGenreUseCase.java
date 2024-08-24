package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.port.IGenrePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetGenreUseCase {
    private final IGenrePort genrePort;

    public GenreEntity getDetailGenre(Long genreId) {
        return genrePort.getGenreById(genreId);
    }
}
