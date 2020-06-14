package com.fwh.computernetworklab.domain;

public enum Role {
    MEMBER,ADMIN;

    public String authority(){
        return "ROLE_" + this.name();
    }

    @Override
    public String toString(){
        return this.name();
    }
}
