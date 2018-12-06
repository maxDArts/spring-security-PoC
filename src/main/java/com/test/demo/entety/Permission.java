package com.test.demo.entety;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Permission {
    private static String STAR = "*";
    @Id
    @Setter(PRIVATE)
    private String id;
    private String userId;

    private String network;
    private String organization;
    private PermissionType permission;

    public Permission(String userId, String network, String organization, PermissionType type) {
        this.userId = userId;
        this.network = network;
        this.organization = organization;
        this.permission = type;
    }

    public String toStringPattern() {
        return String.format("%s:%s:%s:%s",
                userId,
                (network == null) ? STAR : network,
                (organization == null) ? STAR : organization,
                permission);
    }

    public boolean checkNetwork(String toCheck) {
        return check(network, toCheck);
    }

    public boolean checkOrganization(String toCheck) {
        return check(organization, toCheck);
    }

    public boolean checkPermission(PermissionType type) {
        return permission.equals(PermissionType.ALL) || permission.equals(type);
    }

    private boolean check(String stored, String toCheck) {
        if (toCheck == null)
            return false;
        if (stored == null)
            return true;
        return stored.toUpperCase().equals(toCheck.toUpperCase());
    }
}
