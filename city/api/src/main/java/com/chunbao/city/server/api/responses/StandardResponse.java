package com.chunbao.city.server.api.responses;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class StandardResponse {
    public String readMe;
    public int timeout=0;
    public boolean hasMessage;
    public MyResponse myResponse;

    public StandardResponse(int timeout,boolean hasMessage,MyResponse myResponse){
        this.readMe = myResponse.getReadMe();
        this.timeout=timeout;
        this.hasMessage=hasMessage;
        this.myResponse=myResponse;
    }
}
