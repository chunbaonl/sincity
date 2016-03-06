package com.chunbao.city.server.api.responses;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class StandardResponse {
    public String readMe;
    public int timeout=0;
    public boolean hasMessage;
    public MyResponse data;

    public StandardResponse(final boolean hasMessage,final MyResponse myResponse){
        this.readMe = GetInformation.getReadMe(myResponse);
        this.timeout=GetInformation.getTimeout(myResponse);
        this.hasMessage=hasMessage;
        this.data=myResponse;
    }
}
