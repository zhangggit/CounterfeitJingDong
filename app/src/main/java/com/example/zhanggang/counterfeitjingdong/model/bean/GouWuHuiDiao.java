package com.example.zhanggang.counterfeitjingdong.model.bean;

/**
 * 类作用：
 * 时  间：2017/9/13 - 19:08.
 * 创建人：张刚
 */

public class GouWuHuiDiao {
    String name;
    int price;
    String imageUrl;

    public GouWuHuiDiao(String name, int price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
