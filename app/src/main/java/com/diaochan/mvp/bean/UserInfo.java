package com.diaochan.mvp.bean;

public class UserInfo extends BaseEntity {
    private String company;
    private String name;

    public UserInfo() {
    }

    public UserInfo(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public UserInfo setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String  toString() {
        return "UserInfo{" +
                "company='" + company + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
