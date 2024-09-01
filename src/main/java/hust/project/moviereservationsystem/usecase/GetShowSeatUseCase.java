package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetShowSeatUseCase {
    private final IShowSeatPort showSeatPort;

    public List<ShowSeatEntity> getAllShowSeatsByShowId(Long showId) {
        return showSeatPort.getAllShowSeatsByShowId(showId);
    }

    public ShowSeatEntity getDetailShowSeat(Long id) {
        return showSeatPort.getShowSeatById(id);
    }
}
