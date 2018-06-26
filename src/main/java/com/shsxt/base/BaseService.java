package com.shsxt.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

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
    /*public List<T> selectByParams(BaseQuery baseQuery) throws DataAccessException{

    }*/;


}
