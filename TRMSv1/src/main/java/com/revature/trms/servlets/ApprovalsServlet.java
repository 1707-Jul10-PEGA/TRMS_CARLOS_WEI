package com.revature.trms.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.trms.dao.DAOManager;
import com.revature.trms.pojos.Form;

/**
 * Servlet implementation class Approvals
 */
public class ApprovalsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalsServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	ArrayList<Form> formsList = DAOManager.getReimbursementDAO().getFormList();
	System.out.println(formsList);
	String jsonFormsList = objectMapper.writeValueAsString(formsList);
	response.getWriter().write(jsonFormsList);
    }

}
