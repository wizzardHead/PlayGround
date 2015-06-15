//------------------------------------------------------------------
/**
 * Application Name : asynctask 
 *             Date : Jun 2, 2015
 *             
 */
//------------------------------------------------------------------
package com.aysnc.task.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




/*----------------------------------------------------------------
 * @author Rahul
 *
 *----------------------------------------------------------------*/
@JsonIgnoreProperties(ignoreUnknown=true)

public class Comments {

	private String postId;
	private String id;
	private String name;
	private String email;
	private String body;
	
	/**
	 * @return the postId
	 */
	public String getPostId()
	{
		return postId;
	}
	
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(String postId)
	{
		this.postId = postId;
	}
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * @return the body
	 */
	public String getBody()
	{
		return body;
	}
	
	/**
	 * @param body the body to set
	 */
	public void setBody(String body)
	{
		this.body = body;
	}

	//------------------------------------------------------------------
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "{Comments: [{postId:" + postId + ", id:" + id + ", name:" + name
				+ ", email:" + email + ", body:" + body + "}]}";
	}
	
	
	
}
