package org.wuhanjj.DTO;

import java.io.Serializable;

public class TeachScopeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String teachScopeName;
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
	 * @return the teachScopeName
	 */
	public String getTeachScopeName() {
		return teachScopeName;
	}
	/**
	 * @param teachScopeName the teachScopeName to set
	 */
	public void setTeachScopeName(String teachScopeName) {
		this.teachScopeName = teachScopeName;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
