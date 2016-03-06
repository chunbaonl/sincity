package com.chunbao.city.server.common.db.json;

import com.chunbao.city.server.common.db.po.Activity;
import com.chunbao.city.server.common.db.po.Category;
import com.chunbao.city.server.common.db.po.ServerInfo;
import com.chunbao.city.server.common.db.po.User;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class JsonFactory {

    public static UserJson makeUserJson(User oldPo){
        UserJson newJson = new UserJson();
        newJson.id=oldPo.id;
        newJson.updateDate=oldPo.updateDate;
        newJson.username=oldPo.username;
        newJson.password=oldPo.password;
        newJson.wallet=oldPo.wallet;
        newJson.likes=oldPo.likes;
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
        newJson.updateDate=oldPo.updateDate;
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

        return newJson;
    }
}
