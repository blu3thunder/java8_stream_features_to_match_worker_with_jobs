package com.swipe.springboot.model;

import java.util.Date;
import java.util.HashMap;

public class Jobs {
	
	/*private boolean driverLicenseRequired;
	private String [] requiredCertificates;
	private HashMap<String, String> location;*/
	private String billRate;
	/*private int workersRequired;
	private Date startDate;
	private String about;*/
	private String jobTitle;
	private String company;
	/*private long guid;*/
	private int jobId;
	
	
	
	public Jobs()
	{
		
	}
	
	public Jobs( int jobId, String jobTitle, String company, String billRate) {
		
		this.billRate = billRate;
		this.jobTitle = jobTitle;
		this.company = company;
		this.jobId = jobId;
	}
	
	@Override
	public String toString() {
		return "Jobs: [jobId=" + jobId + "]company=" + company + "]jobTitle=" + jobTitle + "]billRate="
				+ billRate + "]";
	}


	/*public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	public String[] getRequiredCertificates() {
		return requiredCertificates;
	}

	public void setRequiredCertificates(String[] requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public HashMap<String, String> getLocation() {
		return location;
	}

	public void setLocation(HashMap<String, String> location) {
		this.location = location;
	}
*/
	public String getBillRate() {
		return billRate;
	}

	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	/*public int getWorkersRequired() {
		return workersRequired;
	}

	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}*/

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/*public long getGuid() {
		return guid;
	}

	public void setGuid(long guid) {
		this.guid = guid;
	}*/

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobId ^ (jobId >>> 32));
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
		Jobs other = (Jobs) obj;
		if (jobId != other.jobId)
			return false;
		return true;
	}


}
