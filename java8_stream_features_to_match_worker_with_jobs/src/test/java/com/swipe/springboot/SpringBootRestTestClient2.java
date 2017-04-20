package com.swipe.springboot;
 
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

import com.swipe.springboot.model.Jobs;
import com.swipe.springboot.model.Worker;
 

public class SpringBootRestTestClient2 {
 
    public static final String REST_WORKER_URI = "http://test.swipejobs.com/api/workers";
    public static final String REST_JOBS_URI = "http://test.swipejobs.com/api/jobs";
	
    
    private static void fetchAllWorkers()
    {
    	 RestTemplate restTemplate = new RestTemplate();
         List<LinkedHashMap> list = restTemplate.getForObject(REST_WORKER_URI, List.class);
         
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
      
    }
    
    
    private static void fetchAllJobs()
    {
    	RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> jobs = restTemplate.getForObject(REST_JOBS_URI, List.class);
        
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
        
        
        System.out.println("Job list formed is \n");
        ll.stream().forEach(System.out::println);
    }
    
    
    private static void searchWorkerById()
    {
    	
    	 RestTemplate restTemplate = new RestTemplate();
         List<LinkedHashMap> list = restTemplate.getForObject(REST_WORKER_URI, List.class);
         int id=10;
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
         
         System.out.println("found the Worker details using method predicate");
         System.out.println(filterWorker(l, findWorkerById(id)));
         System.out.println("found the Worker details using inline predicate ");
         System.out.println(l.stream().filter(p -> p.getUserId() == id).collect(Collectors.<Worker>toList()));
      
    }
    
    
    
    
    private static void findUpto3JobsForWorkerId()
    {
        System.out.println("Testing listAllWorker api.");
        
         int id = 10;
         System.out.println("Worker with id " + id + "to be searched." );
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> list = restTemplate.getForObject(REST_WORKER_URI, List.class);
        List<LinkedHashMap> jobs = restTemplate.getForObject(REST_JOBS_URI, List.class);
       
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
        System.out.println(filterWorker(l, findWorkerById(id)));
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
         List<Worker> ww = filterWorker(l, findWorkerById(id));
         
         final Worker  wce = ww.get(0);
         
         System.out.println("matching jobs are as follows \n");
      //  System.out.println(ll.stream().filter(p -> p.getJobTitle().contains(wce.getSkills().toString())).collect(Collectors.<Jobs>toList()));     
        
   //   System.out.println(ll.stream().map(Jobs::getJobTitle).filter(jobTitle -> jobTitle.contains(wce.getSkills().toString())).limit(3).collect(Collectors.toList()));
        
      System.out.println( ll.stream().filter(jobTitle -> wce.getSkills().contains(jobTitle.getJobTitle())).limit(3).collect(Collectors.toList()));
    		  
    }   		  
    		  
    public static Predicate<Worker> findWorkerById(int id) {
	    return p -> p.getUserId() == id;
	}
	
	
	 public static List<Worker> filterWorker (List<Worker> ss, Predicate<Worker> predicate) {
	 
		 return  ss.stream().filter(predicate).collect(Collectors.<Worker>toList());
	 }
     
    
    /*private static void findWorkerById()
    {
        System.out.println("Testing findWorkerById api.");
        RestTemplate restTemplate = new RestTemplate();
        Worker worker = restTemplate.getForObject(REST_WORKER_URI, Worker.class);
        System.out.println("\n worker=]" + (null != worker ? worker.toString() : null) + "[");
    }*/
     
    
    
    
   /* private static void findJobsMatchingWorkerSkills()
    {
        System.out.println("Testing findJobsMatchingWorkerSkills api.");
        RestTemplate restTemplate = new RestTemplate();
        List<Jobs> matchingJobs = (List<Jobs>) restTemplate.getForObject(REST_WORKER_URI+"/api/jobsMatchingWorkerSkills/1", Jobs.class);
        if(null != matchingJobs)
        {
            for(Jobs jobs : matchingJobs)
            {
                System.out.println("\n" + " Worker [userId=" + jobs.getJobId() + "]Title=" +  jobs.getJobTitle() + "]Company=" + jobs.getCompany() + "]BillRate="  + jobs.getBillRate());
            }
        }
        else
        {
            System.out.println("No Jobs found.");
        }
    }*/
    
 
    public static void main(String args[])
    {
    	
        fetchAllWorkers();
        fetchAllJobs();
        searchWorkerById();
        findUpto3JobsForWorkerId();
      
    }
}