package com.fwh.computernetworklab;

import com.fwh.computernetworklab.config.IgniteCfg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FwhApplicationTests {
	@Autowired
	IgniteCfg igniteCfg;

	@Test
	void contextLoads() {

	}

}
