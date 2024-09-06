package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.BookingEntity;
import hust.project.moviereservationsystem.entity.request.GetBookingRequest;
import hust.project.moviereservationsystem.entity.response.PageInfo;
import hust.project.moviereservationsystem.exception.CreateBookingException;
import hust.project.moviereservationsystem.exception.GetBookingException;
import hust.project.moviereservationsystem.mapper.BookingMapper;
import hust.project.moviereservationsystem.port.IBookingPort;
import hust.project.moviereservationsystem.repository.IBookingRepository;
import hust.project.moviereservationsystem.repository.specification.BookingSpecification;
import hust.project.moviereservationsystem.utils.PageInfoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingAdapter implements IBookingPort {
    private final IBookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingEntity save(BookingEntity bookingEntity) {
        try {
            var bookingModel = bookingMapper.toModelFromEntity(bookingEntity);
            return bookingMapper.toEntityFromModel(bookingRepository.save(bookingModel));
        } catch (Exception e) {
            throw new CreateBookingException();
        }
    }

    @Override
    public Pair<PageInfo, List<BookingEntity>> getAllBookings(GetBookingRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        var result = bookingRepository.findAll(BookingSpecification.getAll(filter), pageable);

        PageInfo pageInfo = PageInfoUtils.getPageInfo(result);

        return Pair.of(pageInfo, bookingMapper.toEntitiesFromModels(result.getContent()));
    }

    @Override
    public BookingEntity getBookingById(Long id) {
        return bookingMapper.toEntityFromModel(
                bookingRepository.findById(id).orElseThrow(GetBookingException::new));
    }

    @Override
    public List<BookingEntity> getBookingsByUserId(Long userId) {
        return bookingMapper.toEntitiesFromModels(bookingRepository.findByUserId(userId));
    }

    @Override
    public List<BookingEntity> getBookingsByShowIds(List<Long> showIds) {
        return bookingMapper.toEntitiesFromModels(
                bookingRepository.findByShowIdIn(showIds)
        );
    }
}
