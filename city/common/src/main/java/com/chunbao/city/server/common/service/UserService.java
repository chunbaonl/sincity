package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.constant.UserConstant;
import com.chunbao.city.server.common.db.dao.UserDao;
import com.chunbao.city.server.common.db.helper.MyBatisConnectionFactory;
import com.chunbao.city.server.common.db.po.User;
import com.chunbao.city.server.common.exception.ServiceException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class UserService extends MyService {

    /**
     * 读取guest用户信息
     * @return
     */
    public static User getGuest() throws ServiceException {
        return getUserById(UserConstant.GUEST_USERID);
    }


    /**
     * 读取guest用户信息
     * @return
     */
    public static User getUserById(final String userId) throws ServiceException {

        SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession(MyBatisConnectionFactory.NOT_AUTO_COMMIT)) {
            UserDao dao = session.getMapper(UserDao.class);
            User guest = dao.getUserById(userId);
            return guest;
        } catch (Exception e) {
            throw new ServiceException("Can not read user."+e.getMessage());
        }
    }
}
