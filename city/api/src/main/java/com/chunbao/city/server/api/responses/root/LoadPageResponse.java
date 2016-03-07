package com.chunbao.city.server.api.responses.root;


import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.CategoryJson;
import com.chunbao.city.server.common.db.json.CityJson;
import com.chunbao.city.server.common.db.json.ServerInfoJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class LoadPageResponse extends MyResponse {
    public ServerInfoJson serverInfoJson;

    public LoadPageResponse(){
    }
}
