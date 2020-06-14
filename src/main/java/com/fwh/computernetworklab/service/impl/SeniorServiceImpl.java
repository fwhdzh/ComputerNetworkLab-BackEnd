package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.PrimaryService;
import com.fwh.computernetworklab.service.SeniorService;
import org.springframework.stereotype.Service;

@Service
public class SeniorServiceImpl implements SeniorService {
    @Override
    public String getMessage() {
        return "高级服务启动成功";
    }
}
