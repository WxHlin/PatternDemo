package com.xw.patterndemo.observerModel;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class Weather {

    private String description;

    public Weather(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                '}';
    }
}
