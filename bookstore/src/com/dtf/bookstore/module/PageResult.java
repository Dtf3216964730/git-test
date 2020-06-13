package com.dtf.bookstore.module;

import java.util.List;

public class PageResult<T> {
    List<T> list;
    long totalCount;//总条数
    int PageSize = 4;//每页显示条数
    int totalPage;//总页数
    int currentPage;//当前页数

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "totalCount=" + totalCount +
                ", PageSize=" + PageSize +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}

