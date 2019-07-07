package com.lwr.form;

import java.util.Date;

import com.lwr.entity.User;

public class UserForm extends User {
    private Date start;
    private Date end;

    private int pageIndex = 1;
    private int pageSize = 5;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = 5;
        }
        this.pageSize = pageSize;
    }

}
