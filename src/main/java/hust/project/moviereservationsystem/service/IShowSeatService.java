package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;

import java.util.List;

public interface IShowSeatService {
    List<ShowSeatEntity> getAllByShowId(Long showId);

    List<ShowSeatEntity> assignShowSeatsToUser(List<Long> showSeatIds, Long userId);

    List<ShowSeatEntity> cancelShowSeatsForBookingId(Long bookingId);
}
