package com.chunbao.city.server.api.responses.city;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.CategoryJson;
import com.chunbao.city.server.common.db.json.CityJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */
public class ListCityResponse extends MyResponse {
    public List<CityJson> cityList;
    public ListCityResponse(){
        cityList = new ArrayList<CityJson>();
    }
}
