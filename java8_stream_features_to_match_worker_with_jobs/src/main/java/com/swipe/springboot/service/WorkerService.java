package com.swipe.springboot.service;


import java.util.List;

import com.swipe.springboot.model.Jobs;
import com.swipe.springboot.model.Worker;


public interface WorkerService {
	
	Worker findWorkerById(int id);
	
	
	
	List<Worker> findAllWorkers();
	List<Jobs> findAllJobs();
	
	
	
	List<Jobs> findAllMatchingJobs (List<String> skills);
	
//	List<Jobs> findAllJobs ();
	
	List<String> findSkillsByWorkerId(int id);
	
	List<Jobs> listOfMatchingJobs(int id);
	
}
