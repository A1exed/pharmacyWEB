package com.pashin.pharmacyweb.model;

import javax.persistence.*;
import java.io.Serializable;

@SequenceGenerator(name = "user_id_seq", sequenceName = "user_user_id_seq", allocationSize = 1)
@Entity
@Table(name = "user", catalog = "pharmacy", schema = "public")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", length = 150, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModel roleID;

    public UserModel() {
    }

    public UserModel(String username, String password, RoleModel roleID) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getRoleID() {
        return roleID;
    }

    public void setRoleID(RoleModel roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}
