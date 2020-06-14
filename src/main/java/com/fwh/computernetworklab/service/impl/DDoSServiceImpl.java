package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.DDoSService;
import org.springframework.stereotype.Service;


@Service
public class DDoSServiceImpl implements DDoSService {
    @Override
    public String startDDosAttack() {
        return "DDos攻击已经启动，预计在5分钟后对之前设定好的目标产生效果";
    }
}
