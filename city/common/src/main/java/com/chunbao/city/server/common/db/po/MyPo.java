package com.chunbao.city.server.common.db.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class MyPo implements Serializable {

    private static final long serialVersionUID = 7863262235394607247L;
    //share
    public String id;
    //not share
    public Date updateDate;
    public Date createDate;
    public boolean isDeleted;
    public boolean isTask;
}
