package com.chunbao.city.server.common.db.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class Activity extends MyPo {
    //share
    public User owner;
    public String title;
    public String description;
    public Date startDate;
    public Date stopDate;
    public boolean isExpired;
    public int costPerDay;
    public int totalComments;
    public int totalLikes;
    public int totalAttenders;
    public String longitude;
    public String latitude;
    public String cityId;
    public List<Category> mCategoryList;
    public List<Picture> mPictureList;
    public Activity(){
        mCategoryList = new ArrayList<Category>();
        mPictureList = new ArrayList<Picture>();
    }
}
