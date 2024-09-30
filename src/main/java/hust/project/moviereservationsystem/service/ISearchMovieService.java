package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.model.document.MovieDocument;

public interface ISearchMovieService {
    MovieDocument getMovieById(Long id);
}
