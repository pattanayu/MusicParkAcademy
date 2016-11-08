package com.nilecon.musicparkacademy.Model;

import java.util.List;

/**
 * Created by Maximus on 5/11/2559.
 */
public class Sheets {
    /**
     * sid : 1
     * sheet_name : test1
     * sheet_detail :
     * sheet_path : http://upic.me/i/tj/bb-609x1024.jpg
     */

    private List<SheetBean> sheet;

    public List<SheetBean> getSheet() {
        return sheet;
    }

    public void setSheet(List<SheetBean> sheet) {
        this.sheet = sheet;
    }

    public static class SheetBean {
        private String sid;
        private String sheet_name;
        private String sheet_detail;
        private String sheet_path;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getSheet_name() {
            return sheet_name;
        }

        public void setSheet_name(String sheet_name) {
            this.sheet_name = sheet_name;
        }

        public String getSheet_detail() {
            return sheet_detail;
        }

        public void setSheet_detail(String sheet_detail) {
            this.sheet_detail = sheet_detail;
        }

        public String getSheet_path() {
            return sheet_path;
        }

        public void setSheet_path(String sheet_path) {
            this.sheet_path = sheet_path;
        }
    }
}
