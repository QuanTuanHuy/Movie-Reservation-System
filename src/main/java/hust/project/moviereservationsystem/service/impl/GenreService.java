package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.GenreEntity;
import hust.project.moviereservationsystem.entity.request.CreateGenreRequest;
import hust.project.moviereservationsystem.service.IGenreService;
import hust.project.moviereservationsystem.usecase.CreateGenreUseCase;
import hust.project.moviereservationsystem.usecase.GetGenreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService {
    private final CreateGenreUseCase createGenreUseCase;
    private final GetGenreUseCase getGenreUseCase;

    @Override
    public GenreEntity createGenre(CreateGenreRequest request) {
        return createGenreUseCase.createGenre(request);
    }

    @Override
    public GenreEntity getDetailGenre(Long genreId) {
        return getGenreUseCase.getDetailGenre(genreId);
    }
}
