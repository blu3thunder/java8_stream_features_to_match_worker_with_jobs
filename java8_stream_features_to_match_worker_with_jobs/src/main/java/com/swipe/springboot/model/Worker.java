package com.swipe.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {

	
	 /*private String rating;
	 private boolean isActive;
	 private String [] certificates;*/
	 private List<String> skills;
	/* private HashMap<String, String> jobSearchAddresses;
	 private String transportation;
	 private boolean hasDriverLicense;
	 private HashMap<String, String> availability;
	 private String phone;
	 private String email;*/
	 private String name;
	/* private int age;
	 private String guid;*/
	 private int userId;
	 
	public Worker(int userId, String name,  List<String> skills) {
		
		this.skills = skills;
		this.name = name;
		this.userId = userId;
	}
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Worker [userId=" + userId + "]name=" +  name + "]skills=" + (null != skills ? skills.toString() : null + "]");
	}



	/*public String getRating() {
			return rating;
		}


		public void setRating(String rating) {
			this.rating = rating;
		}


		public boolean isActive() {
			return isActive;
		}


		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}


		public String[] getCertificates() {
			return certificates;
		}


		public void setCertificates(String[] certificates) {
			this.certificates = certificates;
		}
*/

		/*public List<String> getSkills() {
			return skills;
		}


		public void setSkills(Strin skills) {
			this.skills = skills;
		}*/


		/*public HashMap<String, String> getJobSearchAddresses() {
			return jobSearchAddresses;
		}


		public void setJobSearchAddresses(HashMap<String, String> jobSearchAddresses) {
			this.jobSearchAddresses = jobSearchAddresses;
		}


		public String getTransportation() {
			return transportation;
		}


		public void setTransportation(String transportation) {
			this.transportation = transportation;
		}


		public boolean isHasDriverLicense() {
			return hasDriverLicense;
		}


		public void setHasDriverLicense(boolean hasDriverLicense) {
			this.hasDriverLicense = hasDriverLicense;
		}


		public HashMap<String, String> getAvailability() {
			return availability;
		}


		public void setAvailability(HashMap<String, String> availability) {
			this.availability = availability;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}*/


		public String getName() {
			return name;
		}


		public List<String> getSkills() {
			return skills;
		}


		public void setSkills(List<String> skills) {
			this.skills = skills;
		}


		public void setName(String name) {
			this.name = name;
		}


		/*public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public String getGuid() {
			return guid;
		}


		public void setGuid(String guid) {
			this.guid = guid;
		}*/


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	

}
