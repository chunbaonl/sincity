package com.chunbao.city.server.api.responses.comment;

import com.chunbao.city.server.api.responses.MyResponse;
import com.chunbao.city.server.common.db.json.CommentJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anchunyang on 06/03/16.
 * Description:
 */
public class ListCommentResponse extends MyResponse {
    public List<CommentJson> list;
    public ListCommentResponse(){
        list = new ArrayList<CommentJson>();
    }
}
