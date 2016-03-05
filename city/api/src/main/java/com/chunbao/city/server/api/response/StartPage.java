package com.chunbao.city.server.api.response;


import com.chunbao.city.server.common.db.po.ApplicationVariables;

import java.util.ArrayList;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class StartPage extends ChunbaoResponse {
    public String loadText;
    public String loadImage;
    public ArrayList<Category> categorys;
    public StartPage(){
        expiration= ApplicationVariables.expirationForStartPage;
        categorys=new ArrayList<Category>();
    }
}
