package com.chunbao.city.server.common.db.json;

import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.db.po.Picture;
import com.chunbao.city.server.common.db.po.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ActivityJson extends MyJson {
    public UserJson owner;
    public String title;
    public String description;
    public Date startDate;
    public Date stopDate;
    public boolean isExpired;
    public int costPerDay;
    public int totalComments;
    public int totalLikes;
    public int totalAttenders;
    public Date updateDate;
    public float longitude;
    public float latitude;
    public String cityId;
    public List<CategoryJson> mCategoryJsonList;
    public List<PictureJson> mPictureJsonList;
    public ActivityJson(){
        mCategoryJsonList = new ArrayList<CategoryJson>();
        mPictureJsonList = new ArrayList<PictureJson>();
    }
}
