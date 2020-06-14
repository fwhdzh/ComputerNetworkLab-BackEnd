package com.fwh.computernetworklab.controller;

import com.fwh.computernetworklab.domain.Person;
import com.fwh.computernetworklab.domain.Role;
import com.fwh.computernetworklab.service.*;
import com.fwh.computernetworklab.util.ReqPerson;
import com.fwh.computernetworklab.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟各种微服务所做的控制器
 *
 * <p>理论上说微服务应该是各个系统提供的接口，但在本项目中就不再设置允许多个系统，而以这一个Controller来控制所有的Rest接口</p>
 * <p>对权限的控制，此项目的模拟思路是在实际情景中应该在每一个微服务所在的服务器用于自身的Filter，另一种想法是可以直接将验证过程放在微服务函数中</p>
 */
@RestController
public class MicroServiceController {

    @Autowired
    PrimaryService primaryService;

    @Autowired
    SeniorService seniorService;


    @RequestMapping(value = "/microService/primaryService", method = RequestMethod.GET)
    public String getPrimaryServiceData() throws ServletException {
        String data = primaryService.getMessage();
        return data;
    }

    @RequestMapping(value = "/microService/seniorService", method = RequestMethod.GET)
    public String getSeniorServiceData() throws ServletException {
        String data = seniorService.getMessage();
        return data;
    }

}
