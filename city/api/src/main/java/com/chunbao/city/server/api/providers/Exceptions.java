package com.chunbao.city.server.api.providers;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;

public class Exceptions {

    private Exceptions() {
        // ignored
    }

    // Convenience methods
    public static void BadRequestIf(final boolean condition) {
        if (condition) {
            throw new BadRequestException();
        }
    }

    // Convenience methods
    public static void BadRequestIf(final boolean condition, final String message) {
        if (condition) {
            throw new BadRequestException(message);
        }
    }

    // Convenience methods
    public static void BadRequestIfNullOrEmpty(final String param) {
        BadRequestIfNullOrEmpty(param, null);
    }

    // Convenience methods
    private static void BadRequestIfNullOrEmpty(final String param, final String message) {
        if (param == null || param.isEmpty()) {
            throw (message == null ? new BadRequestException() : new BadRequestException(message));
        }
    }

    public static void ForbiddenIf(final boolean condition, final String message) {
        if (condition) {
            throw new ForbiddenException(message);
        }
    }
}
