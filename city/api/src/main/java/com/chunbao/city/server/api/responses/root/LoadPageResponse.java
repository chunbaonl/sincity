package com.chunbao.city.server.api.responses.root;


import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.util.Utils;

import java.util.ArrayList;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class LoadPageResponse extends MyResponse {
    public String loadText;
    public String loadImage;
    public ArrayList<Category> categoryList;
    public LoadPageResponse(){
        loadText="";
        loadImage="";
        categoryList =new ArrayList<Category>();
        Category c =new Category();
        c.nameCn ="栏目1";
        c.position = 1;
        categoryList.add(c);c =new Category();
        c.nameCn ="栏目2";
        c.position = 2;
        categoryList.add(c);
    }

    //override
    public String getReadMe(){
        StringBuffer sb = new StringBuffer();
        sb.append("首页访问地址").append(Utils.getSeparatorDot());
        sb.append("路径: /start").append(Utils.getSeparatorDot());
        sb.append("输入参数无").append(Utils.getSeparatorDot());
        return sb.toString();
    }
}
