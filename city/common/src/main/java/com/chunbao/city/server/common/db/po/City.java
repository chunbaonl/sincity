package com.chunbao.city.server.common.db.po;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */
public class City extends MyPo {
    //share
    public String nameCn;
    public String nameNl;
    public String nameEn;
    public int position;
    //not share
    public String description;
    public String photoId;
    public boolean isActive;
    public int minUserRole;
}
