//------------------------------------------------------------------
/**
 * Application Name : asynctask 
 *             Date : Jun 14, 2015
 *             
 */
//------------------------------------------------------------------
package com.async.task.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.async.task.serivce.IDataService;
import com.aysnc.task.vo.DataWrapper;


/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
@EnableAsync
@Component
public class AsyncManager {
	@Autowired
	private IDataService dataService;
	public Future<DataWrapper> manageReqs() throws InterruptedException
	{
		System.out.println("Enter AsyncManager ");
		
		Future<DataWrapper> data =  dataService.getServiceData("type");
		return data;
	}

	
}
