package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.port.IShowPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteShowUseCase {
    private final IShowPort showPort;

    public void deleteShow(Long id) {
        showPort.deleteShowById(id);
    }
}
