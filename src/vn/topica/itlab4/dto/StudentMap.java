package vn.topica.itlab4.dto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class represents map of Student.
 *
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
public class StudentMap {
	private HashMap<Integer,Student> studentMap = new HashMap<Integer,Student>();
	private static StudentMap instance;
	
	public static StudentMap getInstance() {
        if (instance == null) {
            instance = new StudentMap();
        }
        return instance;
    }
	
	/**
	 * This method adds new Student to the map
	 * 
	 * @param key the key of the element in the map
	 * @param value the object Student to add
	 */
	public void put(Integer key, Student value){
		this.studentMap.put(key, value);
	}
	
	/**
	 * This method edits the old Student with new attributes
	 * 
	 * @param key the key of the element in the map
	 * @param name new name
	 * @param strDoB new date of bitrh
	 * @param gender new gender
	 * @param strEnrollDate new enroll date
	 * 
	 * @throws ParseException Signals that an error has been reached unexpectedly while parsing
	 */
	public void replace(Integer key, String name, String strDoB, int gender, String strEnrollDate) throws ParseException{
		this.studentMap.get(key).setName(name);
		this.studentMap.get(key).setDoB(strDoB);
		this.studentMap.get(key).setGender(gender);
		this.studentMap.get(key).setEnrollDate(strEnrollDate);
	}
	
	/**
	 * This method removes a Student from the map
	 * 
	 * @param key the key of the element in the map
	 */
	public void remove(Integer key){
		this.studentMap.remove(key);
	}
	
	/**
	 * This method gets a list of Students from the map as an ArrayList
	 * 
	 * @return an ArrayList of Students
	 */
	public ArrayList<Student> getStudentList(){
		return new ArrayList<Student>(this.studentMap.values());
	}
}
