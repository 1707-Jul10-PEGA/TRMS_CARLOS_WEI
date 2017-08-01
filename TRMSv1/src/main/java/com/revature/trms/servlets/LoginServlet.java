package com.revature.trms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.trms.dao.DAOManager;
import com.revature.trms.pojos.Form;
import com.revature.trms.pojos.Login;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getRootLogger();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		logger.info("Processing doPost inside loginServlet");
		Login login = objectMapper.readValue(request.getParameter("login"), Login.class);
		Login correctLogin = DAOManager.getLoginDAO().getLogin(login.getUsername());
		if(correctLogin == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("Username not found");
		}
		else if(login != null && login.getPassword().equals(correctLogin.getPassword())) {
			
			request.getSession().setAttribute("userid", correctLogin.getUserid());
			String url = request.getContextPath()+"/ReimbursementForm.html?"+String.valueOf(correctLogin.getUserid());
			response.setHeader("Location", url);
		}else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("Incorrect password");
		}
	}

}
