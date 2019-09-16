package vn.topica.itlab4.servlet;

import java.io.IOException;
import java.text.ParseException;
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
 * This servlet executes the action "edit". It gets data from view, then edit
 * the existed element in the map with new attributes.
 * 
 * @author AnhLT14 (anhlt14@topica.edu.vn)
 */
@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from view
		int id;
		String name, strDoB, strEnrollDate;
		int gender;
		id = Integer.parseInt(request.getParameter("id"));
		name = request.getParameter("name");
		strDoB = request.getParameter("doB");
		gender = Integer.parseInt(request.getParameter("gender"));
		strEnrollDate = request.getParameter("enrollDate");

		// edit data in the map
		try {
			StudentService studentService = StudentService.getInstance();

			ArrayList<Student> studentList = studentService.getStudentList();
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getId() == id) {
					studentService.editStudent(i, name, strDoB, gender, strEnrollDate);
				}
			}
			//send newest data to the view
			request.setAttribute("data", studentList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
