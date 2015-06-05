// ------------------------------------------------------------------
/**
 * Application Name : asynctask Date : May 31, 2015
 * 
 */
// ------------------------------------------------------------------
package com.async.task.serivce;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import com.aysnc.task.vo.Comments;

/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
public interface IDataService {
	
	/**
	 *
	 * @return
	 */
	//------------------------------------------------------------------
	/**
	 * @return the restTemplate
	 */
	public abstract RestTemplate getRestTemplate();
	
	/**
	 * @param restTemplate the restTemplate to set
	 */
	public abstract void setRestTemplate(RestTemplate restTemplate);
	
	/**
	 *
	 * @return
	 */
	//------------------------------------------------------------------
	public AsyncResult<Comments> getServiceData();
	
}
