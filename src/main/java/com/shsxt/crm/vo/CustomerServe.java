package com.shsxt.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 客户服务
 * @author 殇丶无求
 */
public class CustomerServe extends BaseModel {
    /**服务类型**/
    private String serveType;
    /**概要**/
    private String overview;
    /**客户名称**/
    private String customer;
    /**客户服务状态**/
    private Integer state;
    /**客户服务请求**/
    private String serviceRequest;
    /**创建人**/
    private String createPeople;
    /**分配人**/
    private String assigner;
    /**分配时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT"+8)
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date assignTime;
    /**服务处理内容**/
    private String serviceProce;
    /**服务处理人**/
    private String serviceProcePeople;
    /**服务处理时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date serviceProceTime;
    /**处理结果**/
    private String serviceProceResult;
    /**满意度**/
    private String myd;

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(String serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getServiceProce() {
        return serviceProce;
    }

    public void setServiceProce(String serviceProce) {
        this.serviceProce = serviceProce;
    }

    public String getServiceProcePeople() {
        return serviceProcePeople;
    }

    public void setServiceProcePeople(String serviceProcePeople) {
        this.serviceProcePeople = serviceProcePeople;
    }

    public Date getServiceProceTime() {
        return serviceProceTime;
    }

    public void setServiceProceTime(Date serviceProceTime) {
        this.serviceProceTime = serviceProceTime;
    }

    public String getServiceProceResult() {
        return serviceProceResult;
    }

    public void setServiceProceResult(String serviceProceResult) {
        this.serviceProceResult = serviceProceResult;
    }

    public String getMyd() {
        return myd;
    }

    public void setMyd(String myd) {
        this.myd = myd;
    }
}
