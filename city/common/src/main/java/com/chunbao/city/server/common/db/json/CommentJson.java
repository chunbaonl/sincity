package com.chunbao.city.server.common.db.json;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class CommentJson extends MyJson{
    //share
    public Date updateDate;
    public String userId;
    public String activityId;
    public int type;
    public String message;
    public boolean isRead;
}
