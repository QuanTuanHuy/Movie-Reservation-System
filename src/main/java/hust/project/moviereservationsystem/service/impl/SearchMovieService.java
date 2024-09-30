package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.model.document.MovieDocument;
import hust.project.moviereservationsystem.repository.IMovieElasticsearchRepository;
import hust.project.moviereservationsystem.service.ISearchMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchMovieService implements ISearchMovieService {
    private final IMovieElasticsearchRepository movieElasticsearchRepository;

    @Override
    public MovieDocument getMovieById(Long id) {
        return movieElasticsearchRepository.findById(id).orElse(null);
    }
}
