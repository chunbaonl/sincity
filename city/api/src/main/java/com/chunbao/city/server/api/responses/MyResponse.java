package com.chunbao.city.server.api.responses;

/**
 * Created by anchunyang on 03/03/16.
 * Description:
 */
public abstract class MyResponse {
    public Object data;
    public MyResponse(){
    }
    public MyResponse(int timeout,boolean hasMessage,Object data){
        this.data=data;
    }
    //override me
    public abstract String getReadMe();
    //override me
    public int getTimeout();
}
