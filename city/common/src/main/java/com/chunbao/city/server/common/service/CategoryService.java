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
     * read category by userId, the role of the user should be bigger than min role of the category.
     * @return
     */
    public static List<Category> getCategoryListById(final String userId){
        ArrayList<Category> categories = new ArrayList<>();
        Category c =new Category();
        c.nameCn ="栏目1";
        c.position = 1;
        categories.add(c);
        c =new Category();
        c.nameCn ="栏目2";
        c.position = 2;
        c =new Category();
        c.nameCn ="栏目3";
        c.position = 3;
        categories.add(c);
        return categories;
    }
}
