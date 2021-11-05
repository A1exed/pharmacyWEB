package com.pashin.pharmacyweb.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

    private long roleID;

    private String roleName;

    public RoleDTO() {
    }

    public RoleDTO(long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
