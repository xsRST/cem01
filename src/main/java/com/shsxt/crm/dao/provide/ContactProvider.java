package com.shsxt.crm.dao.provide;


import org.apache.ibatis.jdbc.SQL;

/**
 * 测试dao层映射sql语句
 * @author 殇丶无求
 */
public class ContactProvider {

    public String test(Integer id){

        String sql=new SQL(){{
            SELECT("ID,PLAN_ITEM.PLAN_DATE,EXE_AFFECT");
            FROM("t_cus_dev_plan");
            WHERE("IS_VALID=1");
            if(null != id){
                AND().WHERE("sale_chance_id=#{id}");
            }

        }}.toString();
        System.out.println(sql);
        return sql;
    }
}
