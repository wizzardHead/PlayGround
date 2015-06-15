package com.async.task.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.aysnc.task.vo.DataWrapper;

/**
 * Servlet implementation class ProcessDataRequests
 */
@EnableAsync
public class ProcessDataRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private AsyncManager mgr;
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
	Map<String,Future<DataWrapper>> holder = new HashMap<String,Future<DataWrapper>>();
	
	 public void init(ServletConfig config) throws ServletException {
		    super.init(config);
		    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
		      config.getServletContext());
		  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Get called ");
		//To avoid calling the method on page load
		if ("getData".equals(request.getParameter("getData")))
		{
			Future<DataWrapper> data = holder.get(request
					.getRequestedSessionId());
			if (data != null)
			{
				String jsonData = null;
				try
				{
					if (data.isDone())
					{
						jsonData = data.get().getComments()[0].toString();
						holder.remove(request.getRequestedSessionId());
					}
					else
					{
						jsonData = "{data:'Still processing'}";
					}
				} catch (InterruptedException e)
				{
					data.cancel(true);
					System.err.println("Error occurred " + e.getMessage());
					jsonData = "{error:'Error'}";
				} catch (ExecutionException e)
				{
					data.cancel(true);
					System.err.println("Error occurred " + e.getMessage());
					jsonData = "{error:'Error'}";
				} catch (Exception e)
				{
					System.err.println("Error occurred " + e.getMessage());
					jsonData = "{error:'Error'}";
				}
				finally
				{
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print(jsonData);
					out.flush();
				}
				
			}
			else
			{
				// A new request 
				String jsonData = null;
				try
				{
					
					Future<DataWrapper> newDataR = mgr.manageReqs();
					if (newDataR.isDone())
					{
						jsonData = newDataR.get().getComments()[0].toString();
					}
					else
					{
						holder.put(request.getRequestedSessionId(), newDataR);
						jsonData = "{data:'Still processing'}";
					}
					
				} catch (InterruptedException e)
				{
					jsonData = "{error:'Error'}";
					System.err.println("Error occurred " + e.getMessage());
				} catch (ExecutionException e)
				{
					jsonData = "{error:'Error'}";
					System.err.println("Error occurred " + e.getMessage());
				}
				finally
				{
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print(jsonData);
					out.flush();
				}
			}
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
		
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	

	
}
