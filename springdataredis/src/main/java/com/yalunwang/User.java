package com.yalunwang;


import java.io.Serializable;
/**
   用户实体
 */
public class User implements Serializable {
    private String userName;
    private String email;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "userName:"+this.userName+
                ",email:"+this.email+
                ",age:"+this.age;
    }
}
