package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.db.po.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 07/03/16.
 * Description:
 */
public class CityService extends MyService {
    /**
     *
     * @return
     */
    public static List<City> getList(){
        List<City> list = new ArrayList<>();
        City c =new City();
        c.id = "1";
        c.nameCn ="阿姆斯特丹";
        c.position = 1;
        list.add(c);
        c =new City();
        c.id = "2";
        c.nameCn ="北京";
        c.position = 2;
        list.add(c);
        c =new City();
        c.id = "3";
        c.nameCn ="SAN FRANSISCO LONG";
        c.position = 3;
        list.add(c);
        return list;
    }
}
