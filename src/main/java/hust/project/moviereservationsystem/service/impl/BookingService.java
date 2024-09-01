package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.request.CreateBookingRequest;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.service.IBookingService;
import hust.project.moviereservationsystem.usecase.CreateBookingUseCase;
import hust.project.moviereservationsystem.usecase.GetBookingUserCase;
import hust.project.moviereservationsystem.usecase.UpdateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {
    private final CreateBookingUseCase createBookingUseCase;
    private final GetBookingUserCase getBookingUserCase;
    private final UpdateBookingUseCase updateBookingUseCase;

    @Override
    public BookingEntity createBooking(CreateBookingRequest request, Long userId) {
        return createBookingUseCase.createBooking(request, userId);
    }

    @Override
    public Pair<PageInfo, List<BookingEntity>> getAllBookings(GetBookingRequest filter) {
        return getBookingUserCase.getAllBookings(filter);
    }

    @Override
    public List<BookingEntity> getBookingsByUserId(Long userId) {
        return getBookingUserCase.getBookingsByUserId(userId);
    }

    @Override
    public BookingEntity confirmBooking(Long bookingId) {
        return updateBookingUseCase.confirmBooking(bookingId);
    }

    @Override
    public BookingEntity cancelBooking(Long bookingId, Long userId) {
        return updateBookingUseCase.cancelBooking(bookingId, userId);
    }

}
