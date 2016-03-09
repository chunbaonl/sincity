package com.chunbao.city.server.common.db.json;

import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.ActivityOpinion;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.db.po.City;
import com.chunbao.city.server.common.db.po.Comment;
import com.chunbao.city.server.common.db.po.ServerInfo;
import com.chunbao.city.server.common.db.po.User;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class JsonFactory {

    public static UserJson makeUserJson(User oldPo){
        UserJson newJson = new UserJson();
        newJson.id=oldPo.id;
        newJson.username=oldPo.username;
        newJson.password=oldPo.password;
        newJson.wallet=oldPo.wallet;
        newJson.likes=oldPo.likes;
        newJson.totalActivity=oldPo.totalActivity;
        newJson.description=oldPo.description;
        newJson.smallPotoId=oldPo.smallPotoId;
        newJson.bigPotoId=oldPo.bigPotoId;
        newJson.email=oldPo.email;
        newJson.hasNewMessage=oldPo.hasNewMessage;
        return newJson;
    }

    public static CategoryJson makeCategoryJson(Category oldPo){
        CategoryJson newJson = new CategoryJson();
        newJson.id=oldPo.id;
        newJson.nameCn=oldPo.nameCn;
        newJson.nameNl=oldPo.nameNl;
        newJson.nameEn=oldPo.nameEn;
        newJson.description=oldPo.description;
        newJson.position=oldPo.position;
        newJson.photoId=oldPo.photoId;
        newJson.nameCn=oldPo.nameCn;
        return newJson;
    }

    public static ServerInfoJson makeServerInfoJson(ServerInfo oldPo){
        ServerInfoJson newJson = new ServerInfoJson();
        newJson.picServerUrl=oldPo.picServerUrl;
        newJson.loadText=oldPo.loadText;
        newJson.loadImage=oldPo.loadImage;
        return newJson;
    }

    public static ActivityJson makeActivityJson(Activity oldPo){
        ActivityJson newJson = new ActivityJson();
        newJson.id=oldPo.id;
        newJson.updateDate=oldPo.updateDate;
        newJson.userId=oldPo.userId;
        newJson.username=oldPo.username;
        newJson.title=oldPo.title;
        newJson.description=oldPo.description;
        newJson.smallPotoId=oldPo.smallPotoId;
        newJson.bigPotoId=oldPo.bigPotoId;
        newJson.startDate=oldPo.startDate;
        newJson.stopDate=oldPo.stopDate;
        newJson.isExpired=oldPo.isExpired;
        newJson.costPerDay=oldPo.costPerDay;
        newJson.totalComments=oldPo.totalComments;
        newJson.totalLikes=oldPo.totalLikes;
        newJson.totalVisitors=oldPo.totalVisitors;
        newJson.longitude=oldPo.longitude;
        newJson.latitude=oldPo.latitude;
        newJson.cityId=oldPo.cityId;
        return newJson;
    }

    public static CommentJson makeCommentJson(Comment oldPo){
        CommentJson newJson = new CommentJson();
        newJson.id=oldPo.id;
        newJson.updateDate=oldPo.updateDate;
        newJson.userId=oldPo.userId;
        newJson.activityId=oldPo.activityId;
        newJson.type=oldPo.type;
        newJson.message=oldPo.message;
        newJson.isRead=oldPo.isRead;
        return newJson;
    }

    public static CityJson makeCityJson(City oldPo){
        CityJson newJson = new CityJson();
        newJson.id=oldPo.id;
        newJson.nameCn=oldPo.nameCn;
        newJson.nameNl=oldPo.nameNl;
        newJson.nameEn=oldPo.nameEn;
        newJson.position=oldPo.position;
        return newJson;
    }
    public static ActivityOpinionJson makeActivityOpinionJson(ActivityOpinion oldPo){
        ActivityOpinionJson newJson = new ActivityOpinionJson();
        newJson.id=oldPo.id;
        newJson.isAttended=oldPo.isAttended;
        newJson.isLiked=oldPo.isLiked;
        newJson.isSaved=oldPo.isSaved;
        return newJson;
    }

}
