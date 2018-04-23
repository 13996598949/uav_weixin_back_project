package com.lp.uav_weixin_back_project.db;

import java.util.List;

public interface BaseDao {

    public <E> List<E> getList(String sqlId, Object args);

    public <T> T getPageList(String sqlId, Object args, int pageNum, int pageSize);

    public <T> T getOneBySqlId(String sqlId, Object args);

    public int update(String sqlId, Object args);

    public int insert(String sqlId, Object args);

    public int delete(String sqlId, Object args);
}
