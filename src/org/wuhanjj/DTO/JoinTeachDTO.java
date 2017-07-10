package org.wuhanjj.DTO;

import java.io.Serializable;

public class JoinTeachDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int joinTeachId;
	private int userId;
	private String teachMsgId;
	/**
	 * @return the joinTeachId
	 */
	public int getJoinTeachId() {
		return joinTeachId;
	}
	/**
	 * @param joinTeachId the joinTeachId to set
	 */
	public void setJoinTeachId(int joinTeachId) {
		this.joinTeachId = joinTeachId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the teachMsgId
	 */
	public String getTeachMsgId() {
		return teachMsgId;
	}
	/**
	 * @param teachMsgId the teachMsgId to set
	 */
	public void setTeachMsgId(String teachMsgId) {
		this.teachMsgId = teachMsgId;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
