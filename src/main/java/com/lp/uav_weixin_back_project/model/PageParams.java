package com.lp.uav_weixin_back_project.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页参数信息
 */
public class PageParams {
    /**
     * 当前页码
     * <p>
     * 默认第1页
     */
    @Min(value = 1, message = "页码不能小于1")
    private int pageNum = 1;
    /**
     * 每页记录数
     * <p>
     * 默认1，1-1000
     */
    @Min(value = 1, message = "页大小不能小于1")
    @Max(value = 50, message = "pageSize 不能大于50")
    private int pageSize = 1;

    /**
     * 默认构造方法
     */
    public PageParams() {
    }

    /**
     * 构造方法
     *
     * @param pageNum  当前页码
     * @param pageSize 每页记录数
     */
    public PageParams(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    /**
     * 当前页
     * <p>
     * 最小1
     *
     * @param pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 每页记录数
     * <p>
     * 最大1000，最小1
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
