package com.chunbao.city.server.api.responses;

/**
 * Created by anchunyang on 08/03/16.
 * Description:
 */
public class MessageResponse extends MyResponse {
    public String result;
    public MessageResponse(String result){
        this.result = result;
    }
}
