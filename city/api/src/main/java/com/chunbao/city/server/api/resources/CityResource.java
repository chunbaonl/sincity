package com.chunbao.city.server.api.resources;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */

import com.chunbao.city.server.api.responses.city.ListCityResponse;
import com.chunbao.city.server.common.constant.HttpRequestConstant;
import com.chunbao.city.server.common.constant.UserRoles;
import com.chunbao.city.server.common.db.json.JsonFactory;
import com.chunbao.city.server.common.db.po.City;
import com.chunbao.city.server.common.service.CityService;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/city")
public class CityResource extends MyResource {
    @GET
    @RolesAllowed(UserRoles.Guest)
    @Produces({ HttpRequestConstant.CHINESE_JSON_CHARSET})
    @Path("/list")
    public String getList() {
        ListCityResponse cities = new ListCityResponse();
        List<City> list = CityService.getList();
        for(City element : list){
            cities.cityList.add(JsonFactory.makeCityJson(element));
        }
        return makeJson(cities);
    }
}
