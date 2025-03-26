package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO createOrUpdateWebSeries(WebSeriesVO vo);

	List<WebSeriesVO> getAllWebSeries();

	WebSeriesVO getWebSeriesById(long id);

	List<WebSeriesVO> getAllWebSeriesByEpisodeCount(int count);

	List<WebSeriesVO> getAllWebSeriesByEpisodeDuration(long duration);

}