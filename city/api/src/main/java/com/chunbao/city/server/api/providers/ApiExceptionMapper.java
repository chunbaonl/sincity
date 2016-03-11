package com.chunbao.city.server.api.providers;

import com.chunbao.city.server.common.constant.HttpRequestConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger mLogger = LoggerFactory.getLogger(ApiExceptionMapper.class);

    @Override
    public final Response toResponse(final Throwable e) {
        mLogger.warn("warn. message={}",e.getMessage());
        return Response.status(403).entity(e.getMessage()).type(HttpRequestConstant.CHINESE_JSON_CHARSET).build();
    }
}
