//------------------------------------------------------------------
/**
 * Application Name : AsyncTaskViewer 
 *             Date : May 17, 2015
 *             
 */
//------------------------------------------------------------------
package com.async.task.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aysnc.task.vo.Comments;
import com.aysnc.task.vo.DataWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;


/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
@Service
public class DataService implements IDataService {
	
	@Autowired
	private RestTemplate restTemplate;
	//------------------------------------------------------------------
	/* 
	 * @see com.async.task.serivce.IDataService#getMockData()
	 */
	//------------------------------------------------------------------
	
	/**
	 *
	 */
	//------------------------------------------------------------------
	@PostConstruct
	protected void init(){
		List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
	    for (HttpMessageConverter<?> converter : converters) {
	        if (converter instanceof MappingJackson2HttpMessageConverter) {
	            MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
	            jsonConverter.setObjectMapper(new ObjectMapper());
	            MediaType type = new MediaType("application", "json",MappingJackson2HttpMessageConverter.DEFAULT_CHARSET);
	            ArrayList<MediaType> list = new ArrayList<MediaType>();
	            list.add(type);
	            jsonConverter.setSupportedMediaTypes(list);
	            jsonConverter.setPrettyPrint(true);
	        }
	    }
		
	}
	
	@Async
	public Future<DataWrapper> getServiceData(String type) throws InterruptedException
	{
		System.out.println("Enter DataService ");
		DataWrapper dataWrapper = new DataWrapper();
		Comments comments[] = restTemplate.getForObject("http://jsonplaceholder.typicode.com/comments", Comments[].class);
		dataWrapper.setComments(comments);
		System.out.println("Thread sleeing for 2, simulate processing time");
		Thread.sleep(10000);
		System.out.println("Exit DataService ");
		return new AsyncResult<DataWrapper>(dataWrapper);
	}
	
	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}
	
	public void setRestTemplate(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}


	

}
