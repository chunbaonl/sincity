package com.chunbao.city.server.common.exception;


public class ServiceException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ServiceException(final Exception e) {
        super(e);
    }

    public ServiceException(final String text) {
        super(text);
    }

}
