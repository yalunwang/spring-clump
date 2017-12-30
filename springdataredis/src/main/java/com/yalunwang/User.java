package com.yalunwang;


import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String email;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "userName:"+this.userName+
                ",email:"+this.email+
                ",age:"+this.age;
    }
}
