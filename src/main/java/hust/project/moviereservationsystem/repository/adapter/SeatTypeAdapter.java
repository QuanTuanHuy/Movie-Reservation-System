package hust.project.moviereservationsystem.repository.adapter;

import hust.project.moviereservationsystem.entity.SeatTypeEntity;
import hust.project.moviereservationsystem.exception.CreateSeatTypeException;
import hust.project.moviereservationsystem.exception.DeleteSeatTypeException;
import hust.project.moviereservationsystem.exception.GetSeatTypeException;
import hust.project.moviereservationsystem.mapper.SeatTypeMapper;
import hust.project.moviereservationsystem.port.ISeatTypePort;
import hust.project.moviereservationsystem.repository.ISeatTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatTypeAdapter implements ISeatTypePort {
    private final ISeatTypeRepository seatTypeRepository;
    private final SeatTypeMapper seatTypeMapper;

    @Override
    public SeatTypeEntity save(SeatTypeEntity seatTypeEntity) {
        try {
            var seatTypeModel = seatTypeMapper.toModelFromEntity(seatTypeEntity);
            return seatTypeMapper.toEntityFromModel(seatTypeRepository.save(seatTypeModel));
        } catch (Exception e) {
            throw new CreateSeatTypeException();
        }
    }

    @Override
    public List<SeatTypeEntity> getAllSeatTypes() {
        return seatTypeMapper.toEntitiesFromModels(seatTypeRepository.findAll());
    }

    @Override
    public SeatTypeEntity getByType(String type) {
        return seatTypeMapper.toEntityFromModel(seatTypeRepository.findByType(type).orElse(null));
    }

    @Override
    public SeatTypeEntity getById(Long id) {
        return seatTypeMapper.toEntityFromModel(
                seatTypeRepository.findById(id).orElseThrow(GetSeatTypeException::new));
    }

    @Override
    public void deleteById(Long id) {
        try {
            seatTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteSeatTypeException();
        }
    }
}
