package com.swipe.springboot.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.swipe.springboot.model.Worker;

public class SwipePredicate {
	
	 public static Predicate<Worker> findWorkerById(int id) {
		    return p -> p.getUserId() == id;
		}
		
		
		 public static List<Worker> filterWorker (List<Worker> ss, Predicate<Worker> predicate) {
		 
			 return  ss.stream().filter(predicate).collect(Collectors.<Worker>toList());
		 }

}
