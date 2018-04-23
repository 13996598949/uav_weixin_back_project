package com.lp.uav_weixin_back_project.model;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果实体
 *
 * @param <T>
 */
public class ResultPage<T> implements Serializable {

    /**
     * 总记录数
     */
    private long total;
    /**
     * 结果集
     */
    private List<T> result;

    /**
     * 默认构造方法
     */
    public ResultPage() {
    }

    public ResultPage(Page<T> result) {
        this.result = result.getResult();
        this.total = result.getTotal();
    }

    /**
     * 构造方法
     *
     * @param result 结果集
     * @param total  总记录数
     */
    public ResultPage(List<T> result, long total) {
        this.result = result;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
