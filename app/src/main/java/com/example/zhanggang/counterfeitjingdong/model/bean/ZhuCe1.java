package com.example.zhanggang.counterfeitjingdong.model.bean;

/**
 * 类作用：
 * 时  间：2017/9/12 - 17:03.
 * 创建人：张刚
 */

public class ZhuCe1 {

    /**
     * status : true
     * code : 1
     * message : 调用成功
     * data : {"mobile":"17611206633"}
     * share : {}
     */

    public boolean status;
    public int code;
    public String message;
    public DataBean data;
    public ShareBean share;

    public static class DataBean {
        /**
         * mobile : 17611206633
         */

        public String mobile;
    }

    public static class ShareBean {
    }
}
