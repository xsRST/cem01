package com.shsxt.crm.controller;

import com.shsxt.crm.service.DatadicService;
import com.shsxt.crm.vo.Datadic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("datadic")
@Controller
public class DatadicController {

    @Resource
    private DatadicService datadicService;

    @RequestMapping("findValues")
    @ResponseBody
    public List<Datadic> findValues(String dataDicName){
        return datadicService.findValues(dataDicName);
    }
}
