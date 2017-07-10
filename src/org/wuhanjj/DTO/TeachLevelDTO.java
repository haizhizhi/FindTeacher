package org.wuhanjj.DTO;

import java.io.Serializable;

public class TeachLevelDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String teachLevelName;
	private String belong;
	
	/**
	 * @return the belong
	 */
	public String getBelong() {
		return belong;
	}
	/**
	 * @param belong the belong to set
	 */
	public void setBelong(String belong) {
		this.belong = belong;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the teachLevelName
	 */
	public String getTeachLevelName() {
		return teachLevelName;
	}
	/**
	 * @param teachLevelName the teachLevelName to set
	 */
	public void setTeachLevelName(String teachLevelName) {
		this.teachLevelName = teachLevelName;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
