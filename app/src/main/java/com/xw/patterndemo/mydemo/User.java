package com.xw.patterndemo.mydemo;

/**
 * Created by Administrator on 2017/6/28 0028.
 *
 * 仿照Person写的类
 */

public class User {

    private String id;
    private String name;
    private String address;

    //不在同一包下要用public
    public User(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.address=builder.address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //不在同一包下要加public
    public static class Builder{

        private String id;
        private String name;
        private String address;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
