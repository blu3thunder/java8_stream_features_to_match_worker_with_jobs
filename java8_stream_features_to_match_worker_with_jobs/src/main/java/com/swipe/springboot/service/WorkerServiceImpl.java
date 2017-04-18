package com.swipe.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.swipe.springboot.model.Jobs;
import com.swipe.springboot.model.Worker;



@Service("workerService")
public class WorkerServiceImpl implements WorkerService{
	
	public static final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);

	
	private static List<Worker> workers;
	
	private static List<Jobs> jobs;
	
	static{
		workers= populateWorker();
	}
	
	static
	{
		jobs = populateJobs();
		
	}
	
	public List<Worker> findAllWorkers() {
		return workers;
	}
	
	public Worker findWorkerById(int id) {
		logger.info("begin findWorkerById" );
		for(Worker worker : workers){
			if(worker.getUserId() == id){
				logger.info("end findWorkerById" );
				return worker;
			}
		}
		logger.info("end findWorkerById" );
		return null;
	}
	
	public void saveWorker(Worker worker) {
		
		workers.add(worker);
	}
	
	
	private static List<Worker> populateWorker(){
		List<Worker> worker = new ArrayList<Worker>();
		logger.info("begin populateWorker" );
		List<String> sill1 = new ArrayList<String>();
		sill1.add("Creator of opportunities");
			      sill1.add("Arts and Crafts Designer");
			      sill1.add("The Resinator");
		worker.add(new Worker(1, "Andrews", sill1));
		
		
		sill1 = new ArrayList<String>();
		sill1.add("Creator of opportunities");
			      sill1.add("Arts and Crafts Designer");
		worker.add(new Worker(2, "Alston", sill1));
		
		
		sill1 = new ArrayList<String>();
		sill1.add("President and TeaEO");
			      sill1.add("Head of global trends and futuring");
			      sill1.add("Arts and Crafts Designer");
		worker.add(new Worker(3, "Ruthie", sill1));
		
		
		sill1 = new ArrayList<String>();
		sill1.add("President and TeaEO");
			      sill1.add("Arts and Crafts Designer");
		worker.add(new Worker(4, "Moran", sill1));
		
		logger.info("end populateWorker" );
		return worker;
	}
	
	
	
	
	
	
	@Override
	public List<Jobs> listOfMatchingJobs(int id) {
		logger.info("begin listOfMatchingJobs" );
		List<String> skills = findSkillsByWorkerId(id);
		List<Jobs> listOfJobs = null;
		
		if (null != skills)
		{
			listOfJobs = findAllMatchingJobs(skills);
			logger.info("end listOfMatchingJobs" );
			return listOfJobs;
		}
		else
		{
			logger.info("No skills found. Please add skills.");
		}
		logger.info("end listOfMatchingJobs" );
		return null;
	}

	@Override
	public List<String> findSkillsByWorkerId(int id) {
		logger.info("begin findSkillsByWorkerId" );
		for(Worker worker : workers)
		{
			if(worker.getUserId() == id)
			{
				logger.info("end findSkillsByWorkerId" );
				logger.info("\n" + worker.toString() + " \n");
				return worker.getSkills();
			}
		}
		logger.info("end findSkillsByWorkerId.");
		return null;
	}

	@Override
	public List<Jobs> findAllMatchingJobs(List<String> skills) {
		// TODO Auto-generated method stub
		
		List<Jobs> resultingJobs = new ArrayList<Jobs>();
		logger.info("begin findAllMatchingJobs" );
		if(null != skills)
		{
			
			for(Jobs job : jobs)
			{
				if (null != job)
				{
					for (String skill : skills)
					{
						if (job.getJobTitle().contains(skill))
						{
							logger.info("Matching job found.");
							if(resultingJobs.size() < 4)
							{
								logger.info("Job Added.");
								resultingJobs.add(job);
								break;
							}
							else
								continue;
						}
						else
							logger.info("Job not matching with skill.");
					}
					
					if(resultingJobs.size() == 3)
					{
						logger.info("Required limit of 3 jobs added to list. No furhter additions.");
						break;
					}
					else
						continue;
				}
				else
					logger.info("No Jobs.");
			 }
		}
		else
		{
			logger.info("No skills found. Please add skills.");
			resultingJobs = null; 
		}
			logger.info("begin findAllMatchingJobs" );
			return resultingJobs;
	}

	
	private static List<Jobs> populateJobs(){
		List<Jobs> jobs = new ArrayList<Jobs>();
		logger.info("begin populateJobs" );
		
		
		/*jobs.add(new Jobs(1, "The Resinator", "Frenex", 6.16f));
		jobs.add(new Jobs(2, "President and TeaEO", "Orbiflex", 6.68f));
		jobs.add(new Jobs(3, "Chief Cheerleader", "Isoswitch", 5.16f));
		jobs.add(new Jobs(4, "Project Meanie", "Visalia", 8.95f));
		jobs.add(new Jobs(5, "Head of global trends and futuring", "Plasto", 5.27f));
		
		jobs.add(new Jobs(6, "The Resinator", "Duoflex", 9.98f));
		jobs.add(new Jobs(7, "The Resinator", "Perkle", 8.15f));
		jobs.add(new Jobs(8, "The Resinator", "Microluxe", 6.99f));
		jobs.add(new Jobs(9, "President and TeaEO", "Visalia", 8.95f));*/
		
			logger.info("end populateJobs" );
		return jobs;
	}

	@Override
	public List<Jobs> findAllJobs() {
		// TODO Auto-generated method stub
		return jobs;
	}
	
	/*@Override
	public List<Jobs> findAllJobs() {
			logger.info("begin findAllJobs" );
			logger.info("end findAllJobs" );
		return jobs;
	
	}*/

	
	
}
