package com.jh.app_food.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.app_food.dao.DishDao;
import com.jh.app_food.dao.DishDetailDao;
import com.jh.app_food.dao.impl.DishDaoImpl;
import com.jh.app_food.dao.impl.DishDetailImpl;

/**
 * Servlet implementation class DishCommentServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/DishCommentServlet" })
public class DishCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");				
		PrintWriter out = null;	
		String dish_no =request.getParameter("dish_no");
		
		DishDao dishCommentDao=new DishDaoImpl();
		
		try {
		    out = response.getWriter();
		    out.write(dishCommentDao.findComment(dish_no).toString());
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (out != null) {
		        out.close();
		    }
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
