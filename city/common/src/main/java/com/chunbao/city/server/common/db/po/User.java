package com.chunbao.city.server.common.db.po;

import com.chunbao.city.server.common.constant.UserRoles;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class User extends MyPo implements java.security.Principal {

    private static final long serialVersionUID = 7863262235394607245L;

    //share
    public String username;
    public String password;
    public int wallet;
    public int likes;
    public int totalActivity;
    public String description;
    public String photoUrl;
    public String email;
    public boolean hasNewMessage;
    //not share
    public String deviceId;
    public String deviceLanguage;
    public float longitude;
    public float latitude;
    public String appVersion;
    public int role;
    public int isActive;
    public String lastIp;

    public User(){
        username = "guest";
        setGuestRole();
    }

    public boolean hasNewMessage(){
        return false;
    }

    public void setGuestRole(){
        role= UserRoles.guestValue;
    }
    public void setUserRole(){
        role=UserRoles.userValue;
    }
    public void setAdminRole(){
        role=UserRoles.adminValue;
    }
    public boolean hasRole(String roleName){
        return role >= UserRoles.getValueFromRole(roleName);
    }
    /**
     * Returns the name of this principal.
     *
     * @return the name of this principal.
     */
    @Override
    public String getName() {
        return username;
    }
}
