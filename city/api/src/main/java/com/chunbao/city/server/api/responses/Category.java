package com.chunbao.city.server.api.responses;


import com.chunbao.city.server.common.db.po.ApplicationVariables;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class Category extends MyResponse {
    public Category(){

    }
    public String categoryId;
    public String nameCn;
    public String nameNl;
    public String nameEn;
    public int position;
    public String photoId;
}
