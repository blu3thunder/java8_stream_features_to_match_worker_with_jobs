package com.swipe.springboot.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.swipe.springboot.util.SwipePredicate;

@RestController
@RequestMapping("/api")
public class RestApiController2 {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController2.class);
	
	private static final String WORKER_URL = "http://test.swipejobs.com/api/workers";
	private static final String JOBS_URL="http://test.swipejobs.com/api/jobs";
	
	@Autowired
	public RestTemplate restTemplate;

	
	// -------------------Retrieve All workers---------------------------------------------

	@RequestMapping(value = "/workers/", method = RequestMethod.GET , produces = "application/json")
	public ResponseEntity<List<Worker>> listAllWorkers() {
		
		 RestTemplate restTemplate = new RestTemplate();
         List<LinkedHashMap> list = restTemplate.getForObject(WORKER_URL, List.class);

         List<Worker> l = new ArrayList<>();
         for(LinkedHashMap lm : list)
         {
        	 Worker wc = new Worker();
        	 Set<String> keys = lm.keySet();
             for(String k:keys){
            	 if (k.equals("userId"))
            		 wc.setUserId((int) lm.get(k));
            	 if(k.equals("skills"))
            	 {
            		 List<String> arr = (List<String>) lm.get(k);
            		 wc.setSkills(arr);
            	 }
            	if(k.equals("name"))
            	{
            		Map<String, String> arr = (Map<String, String>) lm.get(k);
            		 wc.setName(arr);
            	}
             }
             l.add(wc);
         }
         
         return new ResponseEntity<List<Worker>>(l, HttpStatus.OK);
	
	}
	
	
	
	@RequestMapping(value = "/jobs/", method = RequestMethod.GET)
	public ResponseEntity<List<Jobs>> listAllJobs() {
		
		 RestTemplate restTemplate = new RestTemplate();
         List<LinkedHashMap> jj = restTemplate.getForObject(JOBS_URL, List.class);

         List<Jobs> l = new ArrayList<>();
         for(LinkedHashMap lm : jj)
         {
        	 Jobs jb = new Jobs();
        	 Set<String> keys = lm.keySet();
             for(String k:keys){
            	 if (k.equals("jobTitle"))
               		 jb.setJobTitle(lm.get(k).toString());
               	 if(k.equals("billRate"))
               		 jb.setBillRate(lm.get(k).toString());
               	
               	if(k.equals("jobId"))
               		jb.setJobId((int) lm.get(k));
               	if(k.equals("company"))
               		jb.setCompany( (String) lm.get(k));
             }
             l.add(jb);
         }
         
         return new ResponseEntity<List<Jobs>>(l, HttpStatus.OK);
	
	}

	// -------------------Retrieve Single worker------------------------------------------

	@RequestMapping(value = "/workers/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findWorkerById(@PathVariable("id") int id) {
		
		 RestTemplate restTemplate = new RestTemplate();
         List<LinkedHashMap> list = restTemplate.getForObject(WORKER_URL, List.class);
         
         System.out.println("Found Worker with id " + id );
         List<Worker> l = new ArrayList<>();
         for(LinkedHashMap lm : list)
         {
        	 Worker wc = new Worker();
        	 Set<String> keys = lm.keySet();
             for(String k:keys){
            	 if (k.equals("userId"))
            		 wc.setUserId((int) lm.get(k));
            	 if(k.equals("skills"))
            	 {
            		 List<String> arr = (List<String>) lm.get(k);
            		 wc.setSkills(arr);
            	 }
            	if(k.equals("name"))
            	{
            		Map<String, String> arr = (Map<String, String>) lm.get(k);
            		wc.setName(arr);
            	}
             }
             l.add(wc);
         }
         
         System.out.println("New list formed is \n");
         l.stream().forEach(System.out::println);
         
         return new ResponseEntity<Worker>(l.stream().filter(p -> p.getUserId() == id).collect(Collectors.<Worker>toList()).get(0), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/jobsMatchingWorkerSkills/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findJobsMatchingWorkerSkills(@PathVariable("id") int id) {
		
		 System.out.println("Testing listAllWorker api.");
	        
         
         System.out.println("Worker with id " + id + "to be searched." );
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> list = restTemplate.getForObject(WORKER_URL, List.class);
        List<LinkedHashMap> jobs = restTemplate.getForObject(JOBS_URL, List.class);
       
        List<Worker> l = new ArrayList<>();
         for(LinkedHashMap lm : list)
         {
        	 Worker wc = new Worker();
        	 Set<String> keys = lm.keySet();
             for(String k:keys){
            	 if (k.equals("userId"))
            		 wc.setUserId((int) lm.get(k));
            	 if(k.equals("skills"))
            	 {
            		 List<String> arr = (List<String>) lm.get(k);
            		 wc.setSkills(arr);
            	 }
            	if(k.equals("name"))
            	{
            		Map<String, String> arr = (Map<String, String>) lm.get(k);
           		 wc.setName(arr);
            	}

             }
             l.add(wc);
         }
      
         System.out.println("New list formed is \n");
         l.stream().forEach(System.out::println);
        
        System.out.println("found the Worker details using method predicate");
     //   System.out.println(filterWorker(l, findWorkerById(id)));
        System.out.println("found the Worker details using inline predicate ");
      System.out.println(l.stream().filter(p -> p.getUserId() == id).collect(Collectors.<Worker>toList()));
         
         List<Jobs> ll = new ArrayList<>();
         for(LinkedHashMap jj : jobs)
         {
        	 Jobs jb = new Jobs();
        	 Set<String> keys = jj.keySet();
             for(String k:keys){
            	 if (k.equals("jobTitle"))
            		 jb.setJobTitle( jj.get(k).toString());
            	 if(k.equals("billRate"))
            		 jb.setBillRate(jj.get(k).toString());
            	
            	if(k.equals("jobId"))
            		jb.setJobId((int) jj.get(k));
            	if(k.equals("company"))
            		jb.setCompany( (String) jj.get(k));
            	
             }
             ll.add(jb);
         }
         
        /* System.out.println("New list of jobs is \n");
         ll.stream().forEach(System.out::println);
        
        System.out.println("found the matching job limited to 3");
        System.out.println(filteredJobs(l, ll, find3JobById(id)));*/
      //  Steram s1 = l.stream().filter(p -> p.getUserId() == id).collect(Collectors.<Worker>toList());
         List<Worker> ww = SwipePredicate.filterWorker(l, SwipePredicate.findWorkerById(id));
         
         final Worker  wce = ww.get(0);
         
         System.out.println("matching jobs are as follows \n");
      //  System.out.println(ll.stream().filter(p -> p.getJobTitle().contains(wce.getSkills().toString())).collect(Collectors.<Jobs>toList()));     
        
   //   System.out.println(ll.stream().map(Jobs::getJobTitle).filter(jobTitle -> jobTitle.contains(wce.getSkills().toString())).limit(3).collect(Collectors.toList()));
        
         return new ResponseEntity<List<Jobs>>(ll.stream().filter(jobTitle -> wce.getSkills().contains(jobTitle.getJobTitle())).limit(3).collect(Collectors.toList()), HttpStatus.OK);
     // System.out.println( ll.stream().filter(jobTitle -> wce.getSkills().contains(jobTitle.getJobTitle())).limit(3).collect(Collectors.toList()));
		
		
	}

	
	
	
}