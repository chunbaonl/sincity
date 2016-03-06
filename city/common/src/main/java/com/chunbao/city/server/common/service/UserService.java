package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.constant.UserConstant;
import com.chunbao.city.server.common.db.po.User;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class UserService extends MyService {

    /**
     * 读取guest用户信息
     * @return
     */
    public static User getGuest(){
        User guest = new User();
        guest.setGuestRole();
        guest.username= UserConstant.GUEST_USERNAME;
        guest.password= UserConstant.GUEST_PASSWORD;
        return guest;
    }
}
