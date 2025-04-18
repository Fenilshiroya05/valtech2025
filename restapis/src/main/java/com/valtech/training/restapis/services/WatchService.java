package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.vos.WatchVO;

public interface WatchService {

	List<WatchVO> getWatches();

	WatchVO getWatch(long id);

	WatchVO updateWatch(long id, WatchVO watch);

	WatchVO createWatch(WatchVO watch);

	List<WatchVO> getWatchesByBrand(String brand);

//	Watch createWatch(Watch watch);
//
//	Watch getWatch(long id);
//	//	
//	//	public Watch deleteWatch(Watch watch) {
//	//		return watchRepo.save(watch);
//	//	}
//
//	List<Watch> getWatches();
//
//	Watch updateWatch(long id, Watch watch);

}