package com.chunbao.city.server.api.responses;

import com.chunbao.city.server.common.constant.Server;
import com.chunbao.city.server.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class StandardResponse {

    private static final Logger mLogger = LoggerFactory.getLogger(StandardResponse.class);

    public String readMe;
    public int timeout=0;
    public boolean hasMessage;
    public boolean isZipped;
    public MyResponse data;
    public String zip;

    public StandardResponse(final boolean hasMessage,final MyResponse myResponse){
        isZipped= Server.JSON_IS_ZIPPED;
        this.readMe = GetInformation.getReadMe(myResponse);
        this.timeout=GetInformation.getTimeout(myResponse);
        //temp two type data's
        this.data=myResponse;
        if(isZipped){
            this.zip=makeZipData(myResponse);
        }
    }

    private String makeZipData(MyResponse myResponse) {
        String temp = null;
        try {
            temp = StringUtil.compress(StringUtil.toJson(myResponse));
        } catch (Exception e) {
            mLogger.warn("makeZipData error. message={}",e.getMessage());
        }
        return temp;
    }
}
