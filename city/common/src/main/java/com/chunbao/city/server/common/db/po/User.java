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
    public String longitude;
    public String latitude;
    public int role;

    public User(){
        role=UserRoles.guestValue;

    }
    public boolean hasNewMessage(){
        return false;
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
