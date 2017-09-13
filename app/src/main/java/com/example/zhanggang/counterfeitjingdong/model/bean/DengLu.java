package com.example.zhanggang.counterfeitjingdong.model.bean;

/**
 * 类作用：
 * 时  间：2017/9/13 - 13:00.
 * 创建人：张刚
 */

public class DengLu {

    /**
     * status : true
     * code : 1
     * message : 调用成功
     * data : {"user":{"id":280,"username":null,"auth_key":null,"password_hash":"$2y$13$szN.1Umzdul10CMJYMdoKuhWGDvR/3p6EjwNphBNhzgFeqNgxVJqK","password_reset_token":null,"email":null,"status":1,"created_at":1505277856,"updated_at":1505277856,"access_token":"8fxwHzP8fNdJGAoLJNZ5nNe8KkT9IDwx","mobile":"17611206638","password_plain":"123456","updated_by":null,"created_by":null,"avatar":"http://data.eleteam.com/uploads/public/user/default.jpg"},"app_cart_cookie_id":"2c1e737449fb53b22b0f7fffa8036637"}
     * share : {}
     */

    public boolean status;
    public int code;
    public String message;
    public DataBean data;
    public ShareBean share;

    public static class DataBean {
        /**
         * user : {"id":280,"username":null,"auth_key":null,"password_hash":"$2y$13$szN.1Umzdul10CMJYMdoKuhWGDvR/3p6EjwNphBNhzgFeqNgxVJqK","password_reset_token":null,"email":null,"status":1,"created_at":1505277856,"updated_at":1505277856,"access_token":"8fxwHzP8fNdJGAoLJNZ5nNe8KkT9IDwx","mobile":"17611206638","password_plain":"123456","updated_by":null,"created_by":null,"avatar":"http://data.eleteam.com/uploads/public/user/default.jpg"}
         * app_cart_cookie_id : 2c1e737449fb53b22b0f7fffa8036637
         */

        public UserBean user;
        public String app_cart_cookie_id;

        public static class UserBean {
            /**
             * id : 280
             * username : null
             * auth_key : null
             * password_hash : $2y$13$szN.1Umzdul10CMJYMdoKuhWGDvR/3p6EjwNphBNhzgFeqNgxVJqK
             * password_reset_token : null
             * email : null
             * status : 1
             * created_at : 1505277856
             * updated_at : 1505277856
             * access_token : 8fxwHzP8fNdJGAoLJNZ5nNe8KkT9IDwx
             * mobile : 17611206638
             * password_plain : 123456
             * updated_by : null
             * created_by : null
             * avatar : http://data.eleteam.com/uploads/public/user/default.jpg
             */

            public int id;
            public Object username;
            public Object auth_key;
            public String password_hash;
            public Object password_reset_token;
            public Object email;
            public int status;
            public int created_at;
            public int updated_at;
            public String access_token;
            public String mobile;
            public String password_plain;
            public Object updated_by;
            public Object created_by;
            public String avatar;
        }
    }

    public static class ShareBean {
    }
}
