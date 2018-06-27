package com.shsxt.base;

import org.springframework.dao.DataAccessException;

import java.util.List;

public interface  BaseDao<T> {

    /**
     * 添加记录
     * @return
     * @throws DataAccessException
     * @param entity
     */
    public Integer insert(T entity) throws DataAccessException;

    /**
     * 删除记录
     * @param ids
     * @return
     * @throws DataAccessException
     */
    public Integer delete(Integer[] ids) throws DataAccessException;
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

    /**
     * 更改记录
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public  Integer update(T entity) throws DataAccessException;


}
