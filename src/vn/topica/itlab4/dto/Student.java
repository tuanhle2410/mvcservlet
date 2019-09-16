package vn.topica.itlab4.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * This class represents an object Student.
 * It provides attributes as information of Students
 *
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 3357113065543206701L;

	private int id;
	private String name;
	private Date doB;
	private int gender;
	private Date enrollDate;
	private static AtomicInteger count = new AtomicInteger(-1);

	//constructor
	public Student(String name, String strDoB, int gender, String strEnrollDate) throws ParseException {
		this.id = count.incrementAndGet();
		this.name = name;
		this.doB = new SimpleDateFormat("dd/MM/yyyy").parse(strDoB);
		this.gender = gender;
		this.enrollDate = new SimpleDateFormat("dd/MM/yyyy").parse(strEnrollDate);
	}
	
	//constructor
	public Student(int id, String name, String strDoB, int gender, String strEnrollDate) throws ParseException {
		this.id = id;
		this.id = count.incrementAndGet();
		this.name = name;
		this.doB = new SimpleDateFormat("dd/MM/yyyy").parse(strDoB);
		this.gender = gender;
		this.enrollDate = new SimpleDateFormat("dd/MM/yyyy").parse(strEnrollDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoB() {
		return new SimpleDateFormat("dd/MM/yyyy").format(doB);
	}

	public void setDoB(Date doB) {
		this.doB = doB;
	}

	public void setDoB(String s) throws ParseException {
		this.doB = new SimpleDateFormat("dd/MM/yyyy").parse(s);
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	/**
     * This method changes gender from a number to a string
     *
     * @param i the input number
     * @return the specific string that shows which gender this number represents
     */
	public String genderToString(int i) {
		String gender;
		switch (i) {
		case 0:
			gender = "female";
			break;
		case 1:
			gender = "male";
			break;
		case 2:
			gender = "other";
			break;
		default:
			throw new IllegalStateException("Unexpected value: " + i);
		}
		return gender;
	}

	public String getEnrollDate() {
		return new SimpleDateFormat("dd/MM/yyyy").format(enrollDate);
	}

	public void setEnrollDate(Date enrolDate) {
		this.enrollDate = enrolDate;
	}

	public void setEnrollDate(String s) throws ParseException {
		this.enrollDate = new SimpleDateFormat("dd/MM/yyyy").parse(s);
	}
}
