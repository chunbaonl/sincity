package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.db.po.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class CategoryService extends MyService {
    /**
     *
     * @return
     */
    public static List<Category> getCategoryList(){
        ArrayList<Category> categories = new ArrayList<>();
        Category c =new Category();
        c.nameCn ="栏目1";
        c.position = 1;
        c.photoId = "/pic-api-test/download.jpeg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目2";
        c.position = 2;
        c.photoId = "/pic-api-test/button-icon-go-17212255.jpg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目3";
        c.position = 3;
        c.photoId = "/pic-api-test/icon-go-10592162.jpg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目4";
        c.position = 4;
        c.photoId = "/pic-api-test/button-icon-go-17212255.jpg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目5";
        c.position = 5;
        c.photoId = "/pic-api-test/icon-go-10592162.jpg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目6";
        c.position = 6;
        c.photoId = "/pic-api-test/button-icon-go-17212255.jpg";
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目7";
        c.position = 7;
        c.photoId = "/pic-api-test/icon-go-10592162.jpg";
        categories.add(c);
        return categories;
    }
}
