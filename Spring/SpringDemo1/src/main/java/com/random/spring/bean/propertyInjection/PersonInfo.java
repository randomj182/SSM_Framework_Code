package com.random.spring.bean.propertyInjection;

public class PersonInfo {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String showName(){
        return name;
    }
}
