package com.chunbao.city.server.api.responses.category;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.CategoryJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ListCategoryResponse extends MyResponse {
    public List<CategoryJson> categoryList;
    public LoadPageResponse(){
        categoryList = new ArrayList<CategoryJson>();
    }
}
