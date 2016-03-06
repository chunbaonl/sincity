package com.chunbao.city.server.common.db.po;


import com.chunbao.city.server.common.util.UUIDUtil;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class Category {
    public Category(){
        categoryId = UUIDUtil.generate();
        nameCn = "";
        nameNl= "";
        nameEn = "";
        position = 0;
        photoId = "";
    }
    public String categoryId;
    public String nameCn;
    public String nameNl;
    public String nameEn;
    public int position;
    public String photoId;
}
