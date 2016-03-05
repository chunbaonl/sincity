package com.chunbao.city.server.api.responses;


import java.util.ArrayList;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class LoadPage extends MyResponse {
    public String loadText;
    public String loadImage;
    public ArrayList<Category> categoryList;
    public LoadPage(){
        loadText="";
        loadImage="";
        categoryList =new ArrayList<Category>();
    }
}
