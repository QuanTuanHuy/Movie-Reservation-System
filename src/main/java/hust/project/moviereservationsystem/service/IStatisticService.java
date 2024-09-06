package hust.project.moviereservationsystem.service;

import hust.project.moviereservationsystem.entity.request.GetStatisticRequest;
import hust.project.moviereservationsystem.entity.response.StatisticResponse;

public interface IStatisticService {
    StatisticResponse getStatistic(GetStatisticRequest request);
}
