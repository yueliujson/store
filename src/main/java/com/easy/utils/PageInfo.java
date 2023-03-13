package com.easy.utils;

public class PageInfo {
    private int page;
    private int limit;

    private int start;

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", limit=" + limit +
                ", start=" + getStart() +
                '}';
    }

    public PageInfo() {
    }

    public PageInfo(int page, int limit, int start) {
        this.page = page;
        this.limit = limit;
        this.start = start;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        start=(page-1)*limit;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
