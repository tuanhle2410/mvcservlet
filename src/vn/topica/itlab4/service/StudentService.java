package vn.topica.itlab4.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import vn.topica.itlab4.dto.Student;
import vn.topica.itlab4.dto.StudentMap;
/**
 * This class contains logic methods to interact with data.
 *
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
public class StudentService {
	StudentMap studentMap = StudentMap.getInstance();
	private AtomicInteger mapKey = new AtomicInteger(-1);

	private static StudentService instance;

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
	//constructor to generate 11 elements for the Student map
	public StudentService() {
		try {
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh1", "24/10/1997", 1, "25/08/2015"));
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh2", "24/10/1998", 0, "25/08/2016"));
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh3", "24/10/1999", 2, "25/08/2017"));
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh3", "24/10/1999", 2, "25/08/2017"));
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh4", "24/10/2000", 1, "25/08/2018"));
			studentMap.put(mapKey.incrementAndGet(), new Student("tuanh5", "24/10/2001", 0, "25/08/2019"));
			studentMap.put(mapKey.incrementAndGet(), new Student("ronaldo", "24/10/1985", 1, "25/08/2017"));
			studentMap.put(mapKey.incrementAndGet(), new Student("messi", "24/10/1987", 0, "25/08/2018"));
			studentMap.put(mapKey.incrementAndGet(), new Student("alex ferguson", "24/10/1961", 1, "25/08/2019"));
			studentMap.put(mapKey.incrementAndGet(), new Student("mourinho", "24/10/1952", 2, "25/08/2015"));
			studentMap.put(mapKey.incrementAndGet(), new Student("david beckham", "24/10/1970", 1, "25/08/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method calls a function to add new Student to the map
	 * 
	 * @param name name of the Student
	 * @param strDoB date of birth of the Student
	 * @param gender gender of the Student
	 * @param strEnrollDate enroll date of the Student
	 */
	public void addStudent(String name, String strDoB, int gender, String strEnrollDate) {
		try {
			studentMap.put(mapKey.incrementAndGet(), new Student(name, strDoB, gender, strEnrollDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method calls a function to edit an element in the map
	 * 
	 * @param mapKey key of the element
	 * @param name name of the Student
	 * @param strDoB date of birth of the Student
	 * @param gender gender of the Student
	 * @param strEnrollDate enroll date of the Student
	 * 
	 * @throws ParseException Signals that an error has been reached unexpectedly while parsing
	 */
	public void editStudent(int mapKey, String name, String strDoB, int gender, String strEnrollDate) throws ParseException {
		studentMap.replace(mapKey, name, strDoB, gender, strEnrollDate);
	}

	/**
	 * This method calls a function to remove an element from the map
	 * 
	 * @param mapKey key of the element to remove
	 */
	public void removeStudent(int mapKey) {
		studentMap.remove(mapKey);
	}

	/**
	 * This method calls a function to get the list of Students
	 * 
	 * @return an ArrayList of Student
	 */
	public ArrayList<Student> getStudentList() {
		return this.studentMap.getStudentList();
	}
}
