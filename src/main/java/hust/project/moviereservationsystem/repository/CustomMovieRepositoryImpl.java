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

    @Override
    public Page<MovieModel> getAllMovies(GetMovieRequest filter, Pageable pageable) {
        // fix later
        StringBuilder rawQuery = new StringBuilder()
                .append("SELECT DISTINCT m.* FROM movies m ")
                .append("JOIN movie_genres mg ON m.id = mg.movie_id ")
                .append("JOIN genres g ON mg.genre_id = g.id ")
                .append("WHERE 1=1 ");

        if (filter.getTitle() != null) {
            rawQuery.append("AND m.title LIKE CONCAT('%', :title, '%') ");
        }
        if (filter.getLanguage() != null) {
            rawQuery.append("AND m.language LIKE CONCAT('%', :language, '%') ");
        }
        if (filter.getReleaseDate() != null) {
            rawQuery.append("AND m.release_date <= :release_date ");
        }
        if (filter.getGenre() != null) {
            rawQuery.append("AND g.name LIKE CONCAT('%', :genre, '%') ");
        }

        var query = entityManager.createNativeQuery(rawQuery.toString(), MovieModel.class);

        if (filter.getTitle() != null) {
            query.setParameter("title", filter.getTitle());
        }
        if (filter.getLanguage() != null) {
            query.setParameter("language", filter.getLanguage());
        }
        if (filter.getReleaseDate() != null) {
            query.setParameter("release_date", filter.getReleaseDate());
        }
        if (filter.getGenre() != null) {
            query.setParameter("genre", filter.getGenre());
        }

        int totalRecords = query.getResultList().size();

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<MovieModel> movies = query.getResultList();

        return new PageImpl<>(movies, pageable, totalRecords);
    }

}
