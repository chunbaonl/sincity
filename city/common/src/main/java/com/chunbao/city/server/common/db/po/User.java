package com.chunbao.city.server.common.db.po;

import java.util.Set;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class User implements java.security.Principal {
    public String username;
    public String password;
    public String deviceId;
    public String deviceLanguage;
    public String longitude;
    public String latitude;
    protected int role;

    public User(){
        setGuestRole();
    }

    public boolean hasNewMessage(){
        return false;
    }

    public void setGuestRole(){
        role=UserRoles.guestValue;
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
