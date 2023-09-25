package com.um.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.um.dao.UserDao;
import com.um.model.User;

@WebServlet("/")
// multiple urls iam handling with this servlet . so i am changing url name to slash here(/).
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/add":
			newUser(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			selectUserById(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		case "/list":
			if (request.getParameter("keyword") != null) {
				searchUsers(request, response);
			} else {
				userList(request, response);
			}
			break;
		case "/validate":
			adminValidate(request, response);
			break;
		default:
			adminPage(request, response);
			// in default startup page is present. adminPage is the method here.it will go
			// to adminPage function and there iam forwarding the page to AdminLogin.jsp
			// automatically this jsp page called and given to browser
			break;
		}

	}

	private void searchUsers(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		ArrayList<User> searchResults = UserDao.searchUsers(keyword);
		request.setAttribute("display", searchResults);
		// Forward the request to userlist.jsp to display search results
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		User u = new User(id, name, email, city);
		UserDao.updateUser(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void selectUserById(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		User u = UserDao.SelectUserById(id);
		request.setAttribute("list", u);
		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void userList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<User> al = UserDao.display();
		request.setAttribute("display", al);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		User u = new User(name, email, city);
		UserDao.insert(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void newUser(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void adminValidate(HttpServletRequest request, HttpServletResponse response) {
		String aname = request.getParameter("username");
		String apassword = request.getParameter("password");
		String status = UserDao.checkLogin(aname, apassword);

		if (status.equals("sucess")) {
			try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("AdminLogin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void adminPage(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
