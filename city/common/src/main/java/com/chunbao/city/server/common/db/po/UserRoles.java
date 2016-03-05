package com.chunbao.city.server.common.db.po;

public final class UserRoles {

    public static final String Guest = "Guest";
    public static final String User = "User";
    public static final String Admin = "Admin";
    /**
     * Guest user.
     */
    public static final int guestValue = 1;

    /**
     * Regular user.
     */
    public static final int userValue = guestValue+1;

    /**
     * Administrator user.
     */
    public static final int adminValue = guestValue+1;


    public static int getValueFromRole(String roleName){
        int role=adminValue+1;
        if(Admin.equals(roleName)){
            role=adminValue;
        }
        else if(User.equals(roleName)){
            role=userValue;
        }
        else if(Guest.equals(roleName)){
            role=guestValue;
        }
        return role;
    }
}
