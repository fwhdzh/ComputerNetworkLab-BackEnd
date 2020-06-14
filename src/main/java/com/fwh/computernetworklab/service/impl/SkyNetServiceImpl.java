package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.SkyNetService;
import org.springframework.stereotype.Service;

@Service
public class SkyNetServiceImpl implements SkyNetService {
    @Override
    public String startSkyNetService() {
        return "天网系统已经启动，预计20分钟后部署完成";
    }
}
