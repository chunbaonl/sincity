package com.chunbao.city.server.common.db.po;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class Comment extends MyPo {
    //share
    public String userId;
    public String activityId;
    public int type;
    public String message;
    public boolean isRead;
}
