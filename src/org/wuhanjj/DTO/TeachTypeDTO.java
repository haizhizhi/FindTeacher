package org.wuhanjj.DTO;

import java.io.Serializable;

public class TeachTypeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String teachType;
	private int belong_G;
	private int belong_C;
	private int belong_X;
	
	/**
	 * @return the belong_G
	 */
	public int getBelong_G() {
		return belong_G;
	}
	/**
	 * @param belong_G the belong_G to set
	 */
	public void setBelong_G(int belong_G) {
		this.belong_G = belong_G;
	}
	/**
	 * @return the belong_C
	 */
	public int getBelong_C() {
		return belong_C;
	}
	/**
	 * @param belong_C the belong_C to set
	 */
	public void setBelong_C(int belong_C) {
		this.belong_C = belong_C;
	}
	/**
	 * @return the belong_X
	 */
	public int getBelong_X() {
		return belong_X;
	}
	/**
	 * @param belong_X the belong_X to set
	 */
	public void setBelong_X(int belong_X) {
		this.belong_X = belong_X;
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
	 * @return the teachType
	 */
	public String getTeachType() {
		return teachType;
	}
	/**
	 * @param teachType the teachType to set
	 */
	public void setTeachType(String teachType) {
		this.teachType = teachType;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
