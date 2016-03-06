package com.chunbao.city.server.common.db.po;


import com.chunbao.city.server.common.util.UUIDUtil;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class Category extends MyPo {

    //share
    public String nameCn;
    public String nameNl;
    public String nameEn;
    public String description;
    public int position;
    public String photoId;
    //not share
    public boolean isActive;
    public int minUserRole;

    public Category(){
        id = UUIDUtil.generate();
        nameCn = "";
        nameNl= "";
        nameEn = "";
        position = 0;
        photoId = "";
    }
}
