package com.chunbao.city.server.api.providers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.soap.AddressingFeature;

public class ApiException extends WebApplicationException {

    private static final long serialVersionUID = 1L;
    private final Status status;
    private final String message;

    ApiException(final Status status) {
        this.status = status;
        this.message = null;
    }

    ApiException(final Status status, final String message) {
        this.status = status;
        this.message = message;
    }

    public final Status getStatus() {
        return status;
    }

    @Override
    public final String getMessage() {
        return message;
    }
}
