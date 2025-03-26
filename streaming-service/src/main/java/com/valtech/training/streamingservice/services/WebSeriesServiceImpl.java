package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebSeriesRepo webServiceRepo;
	
	@Override
	public WebSeriesVO createOrUpdateWebSeries(WebSeriesVO vo) {
		return WebSeriesVO.from(webServiceRepo.save(vo.to()));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeries(){
		return WebSeriesVO.from(webServiceRepo.findAll());
	}
	
	@Override
	public WebSeriesVO getWebSeriesById(long id) {
		return WebSeriesVO.from(webServiceRepo.getReferenceById(id));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeriesByEpisodeCount(int count){
		return WebSeriesVO.from(webServiceRepo.findAllByEpisodeCount(count));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeriesByEpisodeDuration(long duration){
		return WebSeriesVO.from(webServiceRepo.findAllByEpisodeDuration(duration));
	}
}
