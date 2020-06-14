package com.fwh.computernetworklab.util;

import com.fwh.computernetworklab.domain.Role;

import java.util.List;

/**
 * 对前端发来的Person相关请求的封装
 *
 * <p>暴露Person的部分字段给前端</p>
 */
public class ReqPerson {
    /** Request username */
    private String username;

    /** Request password */
    private String password;



    /** Request Roles */
    private List<Role> roles;

    public ReqPerson() {
    }

    public ReqPerson(String username, String password) {
        this.username = username;
        this.password = password;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
