//------------------------------------------------------------------
/**
 * Application Name : AsyncTaskViewer 
 *             Date : May 17, 2015
 *             
 */
//------------------------------------------------------------------
package com.async.task.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.scheduling.annotation.EnableAsync;

import com.async.task.serivce.IDataService;


/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
@ViewScoped
@ManagedBean(name="asyncCont")
@EnableAsync
public class AsyncController {
	
	@ManagedProperty(value="#{dataService}")
	private IDataService dataService;
	
	public String testMethod()
	{
		System.out.println("DataService is "+dataService);
		dataService.getServiceData();
		return null;
	}

	
	/**
	 * @return the dataService
	 */
	public IDataService getDataService()
	{
		return dataService;
	}

	
	/**
	 * @param dataService the dataService to set
	 */
	public void setDataService(IDataService dataService)
	{
		this.dataService = dataService;
	}
	
	
}
