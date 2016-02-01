package com.jh.app_food.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jh.app_food.dao.DishDao;
import com.jh.app_food.dao.UserDao;
import com.jh.app_food.dao.impl.DishDaoImpl;
import com.jh.app_food.entity.Dish;

/**
 * Servlet implementation class DishControlServlet
 */
@WebServlet("/DishControlServlet")
public class DishControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String status=request.getParameter("status");
		DishDao dishDao=new DishDaoImpl();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");				
		PrintWriter out = null;				
		JSONObject jsonObject=new JSONObject();
		switch (status) {
		case "insert":
			Dish dish=new Dish();
			dish.setDish_no(request.getParameter("dish_no"));
			dish.setDish_name(request.getParameter("dish_name"));
			dish.setDish_price(request.getIntHeader("dish_price"));
			dish.setDish_class(request.getIntHeader("dish_class"));
			dish.setDish_discount(request.getIntHeader("dish_discount"));
			
			boolean inSuccess=dishDao.insertDish(dish);
			
			jsonObject.put("control", "insert");
			if (inSuccess) {
				jsonObject.put("status", "success");
			}else {
				jsonObject.put("status", "error");
			}
			try {
			    out = response.getWriter();
			    out.write(jsonObject.toString());
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}
			break;
		case "delete":
			String dish_no=request.getParameter("dish_no");
			boolean deSuccess=dishDao.deleteDish(dish_no);
			jsonObject.put("control", "delete");
			if (deSuccess) {
				jsonObject.put("status", "success");		    
			}else {
				jsonObject.put("status", "error");
			}
			try {
			    out = response.getWriter();
			    out.write(jsonObject.toString());
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    if (out != null) {
			        out.close();
			    }
			}		
			break;
		case "change":
	
			break;
		case "find":
	
			break;
		default:
			break;
		}
		
		
		
	}

}
