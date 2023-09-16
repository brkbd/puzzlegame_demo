package com.ITheima.ui;

public class User {
    private String name;
    private String password;
    //private String id;
    //private String phone;
    public User(){}
    public User(String name, String password)
    {
        //this.id=id;
        this.name=name;
        this.password=password;
        //this.phone=phone;
    }

    //public void setId(String id) {
    //    this.id = id;
    //}

    //public String getId() {
    //    return id;
    //}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    //public String getPhone() {
     //   return phone;
    //}

   // public void setPhone(String phone) {
     //   this.phone = phone;
    //}
}
