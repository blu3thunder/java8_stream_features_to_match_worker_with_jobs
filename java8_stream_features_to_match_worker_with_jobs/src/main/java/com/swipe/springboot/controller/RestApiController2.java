package com.swipe.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.swipe.springboot.model.Jobs;
import com.swipe.springboot.model.Worker;
import com.swipe.springboot.service.WorkerService;
import com.swipe.springboot.util.ErrorDesc;

@RestController
@RequestMapping("/api")
public class RestApiController2 {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController2.class);
	
	private static final String workerUrl = "http://test.swipejobs.com/api/workers";
	
	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	WorkerService workerService; //Service which will do all data retrieval work

	// -------------------Retrieve All workers---------------------------------------------

	@RequestMapping(value = "/workers/", method = RequestMethod.GET)
	public ResponseEntity<List<Worker>> listAllWorkers() {
		
		Worker worker = restTemplate.getForObject(workerUrl, Worker.class);
		System.out.println("Response from online api.");
		System.out.println(worker.toString());
		List<Worker> workers = workerService.findAllWorkers();
		if (workers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Worker>>(workers, HttpStatus.OK);
	}

	// -------------------Retrieve Single worker------------------------------------------

	@RequestMapping(value = "/workers/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findWorkerById(@PathVariable("id") int id) {
		logger.info("Fetching worker with id {}", id);
		Worker worker = workerService.findWorkerById(id);
		if (worker == null) {
			logger.error("worker with id {} not found.", id);
			return new ResponseEntity(new ErrorDesc("worker with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Worker>(worker, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobsMatchingWorkerSkills/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findJobsMatchingWorkerSkills(@PathVariable("id") int id) {
		logger.info("Fetching worker with id {}", id);
		List<Jobs> matchingJobs = workerService.listOfMatchingJobs(id);
		if (null == matchingJobs) 
		{
			logger.error("worker with id {} not found.", id);
			return new ResponseEntity(new ErrorDesc("No jobs found for worker Skills. " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Jobs>>(matchingJobs, HttpStatus.OK);
	}

	
}