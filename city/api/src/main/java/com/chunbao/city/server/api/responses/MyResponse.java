package com.chunbao.city.server.api.responses;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public class MyResponse {
    public String readMe;
    public int timeout;
    public boolean hasMessage;
    public Object data;
    public MyResponse(){
    }
    public MyResponse(String readMe,int timeout,boolean hasMessage,Object data){
        this.readMe=readMe;
        this.timeout=timeout;
        this.hasMessage=hasMessage;
        this.data=data;
    }
}
