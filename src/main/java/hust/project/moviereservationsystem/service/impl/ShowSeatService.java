package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.service.IShowSeatService;
import hust.project.moviereservationsystem.usecase.GetShowSeatUseCase;
import hust.project.moviereservationsystem.usecase.UpdateShowSeatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowSeatService implements IShowSeatService {
    private final GetShowSeatUseCase getShowSeatUseCase;
    private final UpdateShowSeatUseCase updateShowSeatUseCase;

    @Override
    public List<ShowSeatEntity> getAllByShowId(Long showId) {
        return getShowSeatUseCase.getAllShowSeatsByShowId(showId);
    }

    @Override
    public List<ShowSeatEntity> assignShowSeatsToUser(List<Long> showSeatIds, Long userId) {
        return updateShowSeatUseCase.assignShowSeatsToUser(showSeatIds, userId);
    }

    @Override
    public List<ShowSeatEntity> cancelShowSeatsForBookingId(Long bookingId) {
        return updateShowSeatUseCase.cancelShowSeatsForBookingId(bookingId);
    }

}
