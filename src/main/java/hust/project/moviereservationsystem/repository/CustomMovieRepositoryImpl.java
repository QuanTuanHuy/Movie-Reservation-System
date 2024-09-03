package hust.project.moviereservationsystem.repository;

import hust.project.moviereservationsystem.entity.request.GetMovieRequest;
import hust.project.moviereservationsystem.model.MovieModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomMovieRepositoryImpl implements ICustomMovieRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Page<MovieModel> getAllMovies(GetMovieRequest filter, Pageable pageable) {
        StringBuilder rawQuery = new StringBuilder()
                .append("SELECT * FROM movies ")
                .append("WHERE (:title = '' OR title LIKE CONCAT('%', :title, '%')) ")
                .append("AND release_date <= :release_date ")
                .append("AND (:language = '' OR language LIKE CONCAT('%', :language, '%')) ")
                .append("AND id IN ")
                .append("(")
                .append("SELECT m.id")
                .append("    FROM movies m JOIN movie_genres mg ON m.id = mg.movie_id")
                .append("    JOIN genres g ON mg.genre_id = g.id")
                .append("    WHERE (:genre = '' OR g.name LIKE CONCAT('%', :genre, '%')) ")
                .append(")");
        var query = entityManager.createNativeQuery(rawQuery.toString(), MovieModel.class);
        query.setParameter("title", filter.getTitle());
        query.setParameter("release_date", filter.getReleaseDate());
        query.setParameter("language", filter.getLanguage());
        query.setParameter("genre", filter.getGenre());

        int totalRecords = query.getResultList().size();

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<MovieModel> movies = query.getResultList();

        return new PageImpl<>(movies, pageable, totalRecords);
    }
}
