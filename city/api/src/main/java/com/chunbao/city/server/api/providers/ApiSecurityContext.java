package com.chunbao.city.server.api.providers;

import com.chunbao.city.server.common.db.po.User;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class ApiSecurityContext implements SecurityContext {

    private final User principal;

    public ApiSecurityContext(final User user) {
        this.principal = user;
    }

    @Override
    public final String getAuthenticationScheme() {
        return SecurityContext.FORM_AUTH;
    }

    @Override
    public final Principal getUserPrincipal() {
        return principal;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public boolean isUserInRole(final String role) {
        return principal.hasRole(role);
    }
}
