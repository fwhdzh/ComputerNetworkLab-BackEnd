package com.fwh.computernetworklab.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class IgniteCfgTest {
//    @Autowired
    IgniteCfg igniteCfg = new IgniteCfg();

    @Test
    void igniteInstance() {
        igniteCfg.igniteInstance();
    }
}