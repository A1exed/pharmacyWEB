package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SequenceGenerator(name = "role_id_seq", sequenceName = "role_role_id_seq", allocationSize = 1)
@Entity
@Table(name = "role", catalog = "pharmacy", schema = "public")
public class RoleModel implements Serializable {

    @Id
    @GeneratedValue(generator = "role_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Long roleID;

    @Column(name = "role_name", length = 20, nullable = false)
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private List<UserModel> userList;

    public RoleModel() {
    }

    public RoleModel(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UserModel> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", userList=" + userList +
                '}';
    }
}
