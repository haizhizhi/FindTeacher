package org.wuhanjj.DTO;

import java.io.Serializable;
import java.util.Date;

public class TeachMsgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String teacher;
	private String title;
	private String position;
	private String teachTypeId;
	private String teachLevelId;
	private String phone;
	private int aimNumber;
	private int joinNumber;
	private String openDate;
	private int price;
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * @return the teachTypeId
	 */
	public String getTeachTypeId() {
		return teachTypeId;
	}
	/**
	 * @param teachTypeId the teachTypeId to set
	 */
	public void setTeachTypeId(String teachTypeId) {
		this.teachTypeId = teachTypeId;
	}
	/**
	 * @return the teachLevelId
	 */
	public String getTeachLevelId() {
		return teachLevelId;
	}
	/**
	 * @param teachLevelId the teachLevelId to set
	 */
	public void setTeachLevelId(String teachLevelId) {
		this.teachLevelId = teachLevelId;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the aimNumber
	 */
	public int getAimNumber() {
		return aimNumber;
	}
	/**
	 * @param aimNumber the aimNumber to set
	 */
	public void setAimNumber(int aimNumber) {
		this.aimNumber = aimNumber;
	}
	/**
	 * @return the joinNumber
	 */
	public int getJoinNumber() {
		return joinNumber;
	}
	/**
	 * @param joinNumber the joinNumber to set
	 */
	public void setJoinNumber(int joinNumber) {
		this.joinNumber = joinNumber;
	}
	/**
	 * @return the openDate
	 */
	public String getOpenDate() {
		return openDate;
	}
	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
		
}
