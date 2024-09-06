package hust.project.moviereservationsystem.service.impl;

import hust.project.moviereservationsystem.entity.request.GetStatisticRequest;
import hust.project.moviereservationsystem.entity.response.StatisticResponse;
import hust.project.moviereservationsystem.service.IStatisticService;
import hust.project.moviereservationsystem.usecase.GetStatisticUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticService implements IStatisticService {
    private final GetStatisticUseCase getStatisticUseCase;

    @Override
    public StatisticResponse getStatistic(GetStatisticRequest request) {
        return getStatisticUseCase.getStatistic(request);
    }
}
