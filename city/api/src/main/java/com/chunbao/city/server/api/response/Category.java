package com.chunbao.city.server.api.response;


import com.chunbao.city.server.common.db.po.ApplicationVariables;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class Category extends ChunbaoResponse {
    public Category(){
        expiration= ApplicationVariables.expirationForCategory;
    }
    public String categoryId;
    public String nameCn;
    public String nameNl;
    public String nameEn;
    public int position;
    public String photoId;
}
