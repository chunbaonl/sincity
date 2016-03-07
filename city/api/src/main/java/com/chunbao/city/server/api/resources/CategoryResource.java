package com.chunbao.city.server.api.resources;

import com.chunbao.city.server.api.responses.category.ListCategoryResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.service.CategoryService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */
@Path("/category")
public class CategoryResource extends MyResource {
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET})
    @Path("/list")
    public String getList() {
        ListCategoryResponse categoryList = new ListCategoryResponse();
        List<Category> list = CategoryService.getCategoryList();
        for(Category element : list){
            categoryList.categoryList.add(JsonFactory.makeCategoryJson(element));
        }
        return makeJson(categoryList);
    }
}
