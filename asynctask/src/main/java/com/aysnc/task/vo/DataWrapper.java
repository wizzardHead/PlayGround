//------------------------------------------------------------------
/**
 * Application Name : asynctask 
 *             Date : Jun 13, 2015
 *             
 */
//------------------------------------------------------------------
package com.aysnc.task.vo;

import java.util.List;


/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
public class DataWrapper {
	
	private Comments [] comments;
	private Photos [] photos;
	
	/**
	 * @return the comments
	 */
	public Comments[] getComments()
	{
		return comments;
	}
	
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Comments[] comments)
	{
		this.comments = comments;
	}
	
	/**
	 * @return the photos
	 */
	public Photos[] getPhotos()
	{
		return photos;
	}
	
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(Photos[] photos)
	{
		this.photos = photos;
	}
	
	
	
	
}
