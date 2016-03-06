package com.chunbao.city.server.common.db.po;

import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class MyPo {
    //share
    public String id;
    public Date updateDate;
    //not share
    public Date createDate;
    public boolean isDeleted;
    public boolean isTask;
}
