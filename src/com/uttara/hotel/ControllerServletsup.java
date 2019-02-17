package com.uttara.hotel;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ControllerServletsup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ControllerServletsup() 
    {
      super();        
      TableRefresher tr=new TableRefresher();
      Thread t=new Thread(tr);
      t.start();
      
      
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			process(request,response);		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			process(request,response);		
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		
		System.out.println(uri);
		RequestDispatcher rd=null;
		HttpSession s=null;
		ServletContext ctx=request.getServletContext();
		Model model=new Model();
		try
		{
			
		
			if(uri.contains("openCustomerView.do"))
			{
				
				List<HotelBean> l= model.getRestaurantList();

				if(!l.isEmpty())
				{
				ctx.setAttribute("HotelList", l);	
				rd=request.getRequestDispatcher("Customersup.jsp");
				rd.forward(request, response);
				}
			}
			
			
			
			
			if(uri.contains("getCustomerDetail.do"))
			{
				CustomerBean con=(CustomerBean)request.getAttribute("con");				
				String hotelslno=request.getParameter("hotelSl");
				int Hotelslno=Integer.parseInt(hotelslno);
				
				List<TableBean> t=model.getTableList(Hotelslno);
				if(t.size()!=0)
				{
					s=request.getSession();
					s.setAttribute("custBean", con);
					request.setAttribute("TableList", t);					
					request.setAttribute("msg", "");
					rd=request.getRequestDispatcher("TableList.jsp");
					rd.forward(request, response);
				}
				else
					{
						request.setAttribute("msg", "all tables are booked ");
						rd=request.getRequestDispatcher("TableList.jsp");
						rd.forward(request, response);
					}
				}
			
			
			
			
					if(uri.contains("confirm.do"))
					{
							s=request.getSession();
							CustomerBean cust=(CustomerBean) s.getAttribute("custBean");											 
							s.removeAttribute("custBean");						 
							
							int table_sl=Integer.parseInt(request.getParameter("tableSl"));
							int hotelSl=Integer.parseInt(request.getParameter("hotelSl"));
							 s.setAttribute("hotelSl", hotelSl);

							 model.saveConfirm(cust,table_sl);						 
							 List<List<FoodBean>> m=model.getFoodList();								
							request.setAttribute("list", m);
							rd=request.getRequestDispatcher("TempTable.jsp");
							rd.forward(request,response);
						
						
					}	
					
					
					
					
					if(uri.contains("orderFoodItems.do"))
					{
						String[] sls=request.getParameterValues("foodSl");
						
						long totalPrice=model.getPrice(sls);
						request.setAttribute("totalPrice", totalPrice);
						System.out.println(Arrays.toString(sls));
						rd=request.getRequestDispatcher("FeedBack.jsp");
						rd.forward(request, response);						
						
					}
					
					
					
					if(uri.contains("submitFeedback.do"))
					{
					s=request.getSession();
				
					int hotelSl= (Integer)s.getAttribute("hotelSl");
				
					 double rating=Double.parseDouble(request.getParameter("rating"));
					System.out.println(rating);
					model.setRating(hotelSl,rating);
					rd=request.getRequestDispatcher("ThankYou.jsp");
					
					rd.forward(request, response);
					}
					
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			rd=request.getRequestDispatcher("Error.jsp");
		
		}
		
		
		
	}

}
