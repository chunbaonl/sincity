package com.chunbao.city.server.api.providers;

import com.chunbao.city.server.common.constant.Server;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;

public class Exceptions {

    private Exceptions() {
        // ignored
    }

    public static void ForbiddenIf(final boolean condition) {
        if (condition) {
            Forbidden(Server.SERVER_403_MESSAGE);
        }
    }
    public static void ForbiddenIf(final boolean condition, final String message) {
        if (condition) {
            Forbidden(message);
        }
    }

    public static void Forbidden() {
        Forbidden(Server.SERVER_403_MESSAGE);
    }

    public static void Forbidden(final String message) {
        throw new ApiException(Response.Status.FORBIDDEN,message);
    }
}
