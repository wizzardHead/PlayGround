// ------------------------------------------------------------------
/**
 * Application Name : asynctask Date : Jun 13, 2015
 * 
 */
// ------------------------------------------------------------------
package com.aysnc.task.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photos {
	
	private String	albumId;
	private String	Id;
	private String	url;
	private String	thumbnailUrl;
	
	/**
	 * @return the albumId
	 */
	public String getAlbumId()
	{
		return albumId;
	}
	
	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(String albumId)
	{
		this.albumId = albumId;
	}
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return Id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		Id = id;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl()
	{
		return thumbnailUrl;
	}
	
	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl)
	{
		this.thumbnailUrl = thumbnailUrl;
	}
	
}
