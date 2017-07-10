package org.wuhanjj.DAOFactory;

import org.wuhanjj.DAO.JoinTeachDAO;
import org.wuhanjj.DAO.SaveTeachDAO;
import org.wuhanjj.DAO.TeachLevelDAO;
import org.wuhanjj.DAO.TeachMsgDAO;
import org.wuhanjj.DAO.TeachTypeDAO;
import org.wuhanjj.DAO.UserDAO;
import org.wuhanjj.DAO.DAOImpl.JoinTeachDAOImpl;
import org.wuhanjj.DAO.DAOImpl.SaveTeachDAOImpl;
import org.wuhanjj.DAO.DAOImpl.TeachLevelDAOImpl;
import org.wuhanjj.DAO.DAOImpl.TeachMsgDAOImpl;
import org.wuhanjj.DAO.DAOImpl.TeachTypeDAOImpl;
import org.wuhanjj.DAO.DAOImpl.UserDAOImpl;

public class DAOFactory {
	/**
	 * 鑾峰緱UserBeanDAO瀹炵幇绫诲璞�
	 * @return 杩斿洖UserBeanDAO瀹炵幇绫诲璞�
	 */
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	
	/**
	 * 鑾峰緱TeachTypeDAO瀹炵幇绫诲璞�
	 * @return 杩斿洖TeachTypeDAO瀹炵幇绫诲璞�
	 */
	public static TeachTypeDAO getTeachTypeDAO(){
		return new TeachTypeDAOImpl();
	}
	
	/**
	 * 鑾峰緱TeachLevelDAO瀹炵幇绫诲璞�
	 * @return 杩斿洖TeachLevelDAO瀹炵幇绫诲璞�
	 */
	public static TeachLevelDAO getTeachLevelDAO(){
		return new TeachLevelDAOImpl();
	}
	
	/**
	 * 鑾峰緱TeachMsgDAO瀹炵幇绫诲璞�
	 * @return 杩斿洖TeachMsgDAO瀹炵幇绫诲璞�
	 */
	public static TeachMsgDAO getTeachMsgDAO(){
		return new TeachMsgDAOImpl();
	}
	
	public static JoinTeachDAO getJoinTeachMsgDAO(){
		return new JoinTeachDAOImpl();
		
	}
	
	public static SaveTeachDAO getSaveTeachDAO(){
		return new SaveTeachDAOImpl();
		
	}
}
