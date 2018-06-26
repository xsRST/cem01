package com.shsxt.base;

import org.springframework.dao.DataAccessException;

import java.util.List;

public interface  BaseDao<T> {

    /**
     * 根据主键ID查看记录
     * @param id
     * @return
     */
    public T selectById(Integer id)throws DataAccessException;


    /**
     * 根据条件查询多个记录
     * @param baseQuery
     * @return
     */
    public List<T> selectByParams(BaseQuery baseQuery)throws DataAccessException;

    public  Integer update(T entity) throws DataAccessException;
}
