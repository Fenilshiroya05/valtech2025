package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webseries")
public class WebSeriesController {

	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO addWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.createOrUpdateWebSeries(vo);
	}
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebSeries(){
		return webSeriesService.getAllWebSeries();
	}
	@GetMapping("/episodeCount/{count}")
	public List<WebSeriesVO> getWebSeriesByEpisodeCount(@PathVariable("count") int count){
		return webSeriesService.getAllWebSeriesByEpisodeCount(count);
	}
	@GetMapping("/duration/{duration}")
	public List<WebSeriesVO> getWebSeriesByEpisodeDuration(@PathVariable("duration") long duration){
		return webSeriesService.getAllWebSeriesByEpisodeDuration(duration);
	}
	@GetMapping("/{id}")
	public WebSeriesVO getWebSeriesById(@PathVariable("id") long id) {
		return webSeriesService.getWebSeriesById(id);
	}
}
