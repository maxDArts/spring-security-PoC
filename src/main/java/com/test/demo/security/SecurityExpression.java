package com.test.demo.security;

import com.test.demo.entety.PermissionType;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

public class SecurityExpression extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {
    private Object filterObject;
    private Object returnObject;

    public SecurityExpression(Authentication authentication) {
        super(authentication);
    }

    public boolean hasAccess(String network, String organization, String permissionStr) {
        PermissionType permission = PermissionType.valueOf(permissionStr.toUpperCase());
        UserPrincipal principal = ((UserPrincipal) this.getPrincipal());
        return principal.getPermissions().stream()
                .anyMatch(p -> p.checkNetwork(network) && p.checkOrganization(organization) && p.checkPermission(permission));
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
