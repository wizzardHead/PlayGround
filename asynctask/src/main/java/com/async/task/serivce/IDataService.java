// ------------------------------------------------------------------
/**
 * Application Name : asynctask Date : May 31, 2015
 * 
 */
// ------------------------------------------------------------------
package com.async.task.serivce;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import com.aysnc.task.vo.Comments;
import com.aysnc.task.vo.DataWrapper;

/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
public interface IDataService {
	
	
	/**
	 *
	 * @return
	 * @throws InterruptedException 
	 */
	//------------------------------------------------------------------
	public Future<DataWrapper> getServiceData(String type) throws InterruptedException;
	
}
