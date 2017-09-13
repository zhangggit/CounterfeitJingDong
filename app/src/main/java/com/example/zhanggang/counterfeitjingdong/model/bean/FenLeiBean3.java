package com.example.zhanggang.counterfeitjingdong.model.bean;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/9/12 - 23:11.
 * 创建人：张刚
 */

public class FenLeiBean3 {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"156","gc_name":"钱包/卡包"},{"gc_id":"157","gc_name":"手拿包"},{"gc_id":"158","gc_name":"单肩包"},{"gc_id":"159","gc_name":"双肩包"},{"gc_id":"160","gc_name":"手提包"},{"gc_id":"161","gc_name":"斜挎包"}]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 156
             * gc_name : 钱包/卡包
             */

            private String gc_id;
            private String gc_name;

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
