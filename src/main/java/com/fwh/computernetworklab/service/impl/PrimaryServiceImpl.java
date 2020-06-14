package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.PrimaryService;
import org.springframework.stereotype.Service;

@Service
public class PrimaryServiceImpl implements PrimaryService {
    @Override
    public String getMessage() {
        return "初级服务启动成功";
    }
}
