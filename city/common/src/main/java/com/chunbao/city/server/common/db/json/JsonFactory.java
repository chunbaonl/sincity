package com.chunbao.city.server.common.db.json;

import com.chunbao.city.server.common.db.po.*;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class JsonFactory {

    public final static int INFO_SIMPLE = 0;
    public final static int INFO_BASIC = 1;
    public final static int INFO_FULL = 2;
    public static UserJson makeUserJson(User oldPo, final int level){
        UserJson newJson = new UserJson();
        newJson.id=oldPo.id;
        newJson.username=oldPo.username;
        newJson.photoUrl=oldPo.photoUrl;
        if(level > INFO_SIMPLE){
            //
            newJson.wallet=oldPo.wallet;
            newJson.likes=oldPo.likes;
            newJson.totalActivity=oldPo.totalActivity;
            newJson.description=oldPo.description;
            newJson.hasNewMessage=oldPo.hasNewMessage;
            if(level > INFO_BASIC){
                newJson.email=oldPo.email;
                newJson.password=oldPo.password;
            }
        }
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
        newJson.title=oldPo.title;
        newJson.description=oldPo.description;
        newJson.startDate=oldPo.startDate;
        newJson.stopDate=oldPo.stopDate;
        newJson.isExpired=oldPo.isExpired;
        newJson.costPerDay=oldPo.costPerDay;
        newJson.totalComments=oldPo.totalComments;
        newJson.totalLikes=oldPo.totalLikes;
        newJson.totalAttenders =oldPo.totalAttenders;
        newJson.cityId=oldPo.cityId;
        for(Category c : oldPo.mCategoryList){
            newJson.mCategoryJsonList.add(makeCategoryJson(c));
        }
        for(Picture c : oldPo.mPictureList){
            newJson.mPictureJsonList.add(makePictureJson(c));
        }
        newJson.owner=makeUserJson(oldPo.owner,INFO_SIMPLE);
        //newJson.longitude=oldPo.longitude;
        //newJson.latitude=oldPo.latitude;
        return newJson;
    }

    public static CommentJson makeCommentJson(Comment oldPo){
        CommentJson newJson = new CommentJson();
        newJson.id=oldPo.id;
        newJson.updateDate=oldPo.updateDate;
        newJson.user=makeUserJson(oldPo.user,INFO_SIMPLE);
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

    public static PictureJson makePictureJson(Picture oldPo){
        PictureJson newJson = new PictureJson();
        newJson.id=oldPo.id;
        newJson.activityId=oldPo.activityId;
        newJson.url=oldPo.url;
        newJson.position=oldPo.position;
        return newJson;
    }

}
