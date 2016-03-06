package com.chunbao.city.server.api.responses.activity;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.ActivityJson;

import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class GetActivityByIdResponse extends MyResponse {
    public ActivityJson activity;
    public GetActivityByIdResponse(){

    }
}
