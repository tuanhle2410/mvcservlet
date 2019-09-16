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
 * This servlet show the list of Students to the view.
 * It gets data from map, then show them to the view.
 * 
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
@WebServlet(urlPatterns="/")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get data from map
		StudentService studentService = StudentService.getInstance();
		ArrayList<Student> studentList = studentService.getStudentList();
		
		//send newest data to the view
		request.setAttribute("data", studentList);
		RequestDispatcher rd =  
	             request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
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
