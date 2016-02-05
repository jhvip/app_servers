package com.jh.app_food.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jh.app_food.dao.DishDao;
import com.jh.app_food.dao.DishMenuDao;
import com.jh.app_food.dao.impl.DishDaoImpl;
import com.jh.app_food.dao.impl.DishMenuDaoImpl;
import com.jh.app_food.entity.Dish;
import com.jh.app_food.entity.DishMenu;
import com.jh.app_food.utils.Token;

/**
 * Servlet implementation class DishMenuServlet
 */
@WebServlet("/DishMenuServlet")
public class DishMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status=request.getParameter("status");
		String token=request.getParameter("token");
		DishMenuDao dishMenuDao=new DishMenuDaoImpl();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");				
		PrintWriter out = null;				
		JSONObject jsonObject=new JSONObject();
		
		switch (status) {
		case "insert":
			Token token2=new Token();
			int guest_id=token2.verifyToken(token);
			if (guest_id!=0) {
				DishMenu dishMenu=new DishMenu();
				dishMenu.setGuest_id(guest_id);
				dishMenu.setRoom_no(request.getParameter("room_no"));
				dishMenu.setTable_no(request.getParameter("table_no"));
				String jsString=request.getParameter("info");
				JSONArray menuInfo=new JSONArray(jsString);
				
				boolean inSuccess=dishMenuDao.insertDish(dishMenu,menuInfo);
				
				if (inSuccess) {
					jsonObject.put("status", "success");
				}else {
					jsonObject.put("status", "error");
					jsonObject.put("message", "提交订单失败");
				}
			}else {
				jsonObject.put("status", "error");
				jsonObject.put("message", "登陆失败，重新登录");
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
		
		
		
		}
	}

}
