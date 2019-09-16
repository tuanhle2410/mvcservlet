package vn.topica.itlab4.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.topica.itlab4.dto.Student;
import vn.topica.itlab4.service.StudentService;

/**
 * This servlet executes the action "add".
 * It gets data from view, then add them to the map.
 * 
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get data from view
		String name, strDoB, strEnrollDate;
		int gender;
		name = request.getParameter("name");
		strDoB = request.getParameter("doB");
		gender = Integer.parseInt(request.getParameter("gender"));
		strEnrollDate = request.getParameter("enrollDate");
		
		//add to the map
		StudentService studentService = StudentService.getInstance();
		studentService.addStudent(name, strDoB, gender, strEnrollDate);
		
		//send newest data to the view
		ArrayList<Student> studentList = studentService.getStudentList();
		request.setAttribute("data", studentList);
		RequestDispatcher rd =  
	             request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

}
