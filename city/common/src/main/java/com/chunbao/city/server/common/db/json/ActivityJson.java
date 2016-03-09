package com.chunbao.city.server.common.db.json;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ActivityJson extends MyJson {
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
    public Date updateDate;
    public float longitude;
    public float latitude;
    public String cityId;
}
