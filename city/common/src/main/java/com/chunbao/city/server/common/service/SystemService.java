package com.chunbao.city.server.common.service;

import com.chunbao.city.server.common.constant.Server;
import com.chunbao.city.server.common.db.po.ServerInfo;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class SystemService extends MyService{
    public static ServerInfo getServerInfo(final String userId){
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.loadText = Server.DEFAULT_BROADCAST_MESSAGE;
        serverInfo.picServerUrl = Server.PIC_SERVER_URL;
        serverInfo.loadImage = Server.DEFAULT_LOAD_PIC_URL;
        return serverInfo;
    }
}
