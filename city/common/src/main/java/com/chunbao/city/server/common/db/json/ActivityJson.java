package com.chunbao.city.server.common.db.json;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ActivityJson extends MyJson {
    public String userId;
    public String name;
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
    //是否喜欢
    public boolean isLiked;
    //是否收藏
    public boolean isSaved;
    //是否参加
    public boolean isAttended;
}
