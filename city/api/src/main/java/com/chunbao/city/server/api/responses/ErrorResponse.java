package com.chunbao.city.server.api.responses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.NONE)
public class ErrorResponse {

    /**
     * The GUID id for this user.
     */
    @XmlElement(name = "code")
    private Integer code;

    @XmlElement(name = "message")
    private String message;

    @XmlElement(name = "reason")
    private String reason;

    public ErrorResponse() {

    }

    public ErrorResponse(int code) {
        this.code = code;
    }

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }


    public void setCode(final Integer code) {
        this.code = code;
    }


    public String getEssage() {
        return message;
    }


    public void setEssage(final String essage) {
        message = essage;
    }


    public String getReason() {
        return reason;
    }


    public void setReason(final String reason) {
        this.reason = reason;
    }
}
