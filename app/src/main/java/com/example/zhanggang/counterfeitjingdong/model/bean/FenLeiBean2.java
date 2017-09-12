package com.example.zhanggang.counterfeitjingdong.model.bean;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/9/12 - 14:23.
 * 创建人：张刚
 */

public class FenLeiBean2 {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"4","gc_name":"女装"},{"gc_id":"5","gc_name":"男装"},{"gc_id":"6","gc_name":"内衣"},{"gc_id":"7","gc_name":"运动"},{"gc_id":"8","gc_name":"女鞋"},{"gc_id":"9","gc_name":"男鞋"},{"gc_id":"10","gc_name":"配饰"},{"gc_id":"11","gc_name":"童装"}]}
     */

    public int code;
    public DatasBean datas;

    public static class DatasBean {
        public List<ClassListBean> class_list;

        public static class ClassListBean {
            /**
             * gc_id : 4
             * gc_name : 女装
             */
            public String gc_id;
            public String gc_name;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }
        }
    }
}
