package com.lp.uav_weixin_back_project.db.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lp.uav_weixin_back_project.db.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseDaoImpl implements BaseDao {

    @Autowired
    protected SqlSession sqlSession;


    /**
     * 调用指定sqlID执行查询返回结果List，
     *
     * @param sqlId
     * @param args
     * @param <E>   结果List泛型
     * @return 结果List
     */
    @Override
    public <E> List<E> getList(String sqlId, Object args) {
        return sqlSession.selectList(sqlId, args);

    }

    /**
     * 调用指定sqlID执行查询返回指定页的结果
     *
     * @param sqlId
     * @param args
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 结果List
     */
    @Override
    public  Page getPageList(String sqlId, Object args, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return (Page) sqlSession.selectList(sqlId, args);
    }

    /**
     * 调用指定sqlID执行查询返回结果
     *
     * @param sqlId
     * @param args
     * @param <T>   结果泛型
     * @return
     */
    @Override
    public <T> T getOneBySqlId(String sqlId, Object args) {
        return sqlSession.selectOne(sqlId, args);
    }

    /**
     * 执行更新语句，返回受影响行数
     *
     * @param sqlId sqlId
     * @param args  更新参数
     * @return 受影响行数
     */
    @Override
    public int update(String sqlId, Object args) {
        return sqlSession.update(sqlId, args);
    }

    /**
     * 执行插入语句，返回受影响行数
     *
     * @param sqlId sqlId
     * @param args  插入参数
     * @return 受影响行数
     */
    @Override
    public int insert(String sqlId, Object args) {
        return sqlSession.insert(sqlId, args);
    }

    /**
     * 执行删除语句，返回受影响行数
     *
     * @param sqlId sqlId
     * @param args  删除参数
     * @return 受影响行数
     */
    @Override
    public int delete(String sqlId, Object args) {
        return sqlSession.delete(sqlId, args);
    }
}
