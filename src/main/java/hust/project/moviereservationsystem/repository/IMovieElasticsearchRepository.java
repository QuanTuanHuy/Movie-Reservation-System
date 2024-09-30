package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.model.document.MovieDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IMovieElasticsearchRepository extends ElasticsearchRepository<MovieDocument, Long> {
}
