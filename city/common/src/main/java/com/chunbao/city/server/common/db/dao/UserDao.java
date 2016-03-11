package com.chunbao.city.server.common.db.dao;

import com.chunbao.city.server.common.db.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by anchunyang on 10/03/16.
 * Description:
 */
public interface UserDao {
    public User getUserById(@Param("userId")final String userId);
}
