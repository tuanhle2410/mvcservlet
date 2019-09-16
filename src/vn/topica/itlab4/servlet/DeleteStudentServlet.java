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
 * This servlet executes the action "delete". It gets ID from view, then delete
 * the element in the map which have that ID.
 * 
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get ID from view
		int id = Integer.parseInt(request.getParameter("hdnDelete").trim());

		//delete element from map
		StudentService studentService = StudentService.getInstance();
		ArrayList<Student> studentList = studentService.getStudentList();
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				studentService.removeStudent(i);
				studentList.remove(i);
			}
		}
		
		//send newest data to the view
		request.setAttribute("data", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
