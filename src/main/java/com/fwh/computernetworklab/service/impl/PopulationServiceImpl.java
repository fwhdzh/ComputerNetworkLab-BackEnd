package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.PopulationService;
import org.springframework.stereotype.Service;

@Service
public class PopulationServiceImpl  implements PopulationService {
    @Override
    public long getPopulation() {
        return 328200000;
    }
}
