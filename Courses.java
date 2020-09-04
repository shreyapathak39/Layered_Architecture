package beans;

import java.io.Serializable;

public class courses implements Serializable,Comparable<courses>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseName;
	private String category;
	private int duration;
	private int numberOfTests;
	public courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public courses(String courseName, String category, int duration, int numberOfTests) {
		super();
		this.courseName = courseName;
		this.category = category;
		this.duration = duration;
		this.numberOfTests = numberOfTests;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNumberOfTests() {
		return numberOfTests;
	}
	public void setNumberOfTests(int numberOfTests) {
		this.numberOfTests = numberOfTests;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		courses other = (courses) obj;
		if (courseName != other.courseName)
			return false;
		if (category != other.courseName)
			return false;
		if (duration != other.duration)
			return false;
		if (numberOfTests != other.numberOfTests)
			return false;
		return true;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + duration;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + numberOfTests;
		return result;
	}
	
	@Override
	public String toString() {
		return "Courses [courseName=" + courseName + ", category=" + category + ", duration=" + duration
				+ ", numberOfTests=" + numberOfTests + "]";
	}
	@Override
	public int compareTo(courses course) {
		// TODO Auto-generated method stub
		return this.duration - course.duration;
	}

}
