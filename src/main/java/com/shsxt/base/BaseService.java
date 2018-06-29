package com.shsxt.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

public abstract class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    /**
     * 根据主键ID查看记录
     * @param id
     * @return
     */
    public T selectById(Integer id)throws DataAccessException{

        return baseDao.selectById(id);
    };




    /**
     * 根据条件查询多个记录
     * @param baseQuery
     * @return
     */
    public PageInfo<T> queryForPage(BaseQuery baseQuery) throws DataAccessException{

        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        List<T> list=baseDao.selectByParams(baseQuery);
        return new PageInfo<>(list);
    };




}
