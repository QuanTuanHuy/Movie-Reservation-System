package hust.project.moviereservationsystem.usecase;

import hust.project.moviereservationsystem.entity.ShowSeatEntity;
import hust.project.moviereservationsystem.port.ICinemaHallSeatPort;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import hust.project.moviereservationsystem.port.IShowPort;
import hust.project.moviereservationsystem.port.IShowSeatPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CreateShowSeatUseCase {
    private final IShowSeatPort showSeatPort;
    private final IShowPort showPort;
    private final ICinemaHallSeatPort cinemaHallSeatPort;
    private final ISeatTypePort seatTypePort;

    @Transactional(rollbackFor = Exception.class)
    public void createShowSeats(Long showId) {
        var show = showPort.getShowById(showId);
        var cinemaHallId = show.getCinemaHallId();

        var cinemaHallSeats = cinemaHallSeatPort.getByCinemaHallId(cinemaHallId);

        var mapSeatTypeToPrice = buildMapSeatTypeToPrice();

        var showSeats = cinemaHallSeats.stream().map(cinemaHallSeat -> {
            var showSeat = new ShowSeatEntity();
            showSeat.setCinemaHallSeatId(cinemaHallSeat.getId());
            showSeat.setShowId(showId);
            showSeat.setIsReserved(false);
            showSeat.setPrice(mapSeatTypeToPrice.get(cinemaHallSeat.getType()));
            return showSeat;
        }).toList();

        showSeatPort.saveAll(showSeats);
    }

    private HashMap<String, Long> buildMapSeatTypeToPrice() {
        var seatTypes = seatTypePort.getAllSeatTypes();
        var map = new HashMap<String, Long>();
        for (var seatType : seatTypes) {
            map.put(seatType.getType(), seatType.getPrice());
        }
        return map;
    }
}
