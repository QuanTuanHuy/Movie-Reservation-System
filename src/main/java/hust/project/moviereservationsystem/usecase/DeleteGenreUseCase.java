package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.port.IGenrePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGenreUseCase {
    private final IGenrePort genrePort;

    public void deleteGenre(Long id) {
        genrePort.deleteById(id);
    }
}
