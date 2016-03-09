package com.chunbao.city.server.common.db.po;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class Activity extends MyPo {
    //share
    public String userId;
    public String username;
    public String title;
    public String description;
    public String smallPotoId;
    public String bigPotoId;
    public Date startDate;
    public Date stopDate;
    public boolean isExpired;
    public int costPerDay;
    public int totalComments;
    public int totalLikes;
    public int totalVisitors;
    public float longitude;
    public float latitude;
    public String cityId;
}
