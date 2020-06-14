package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.TimeService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

@Service
public class TimeServiceImpl implements TimeService {
    @Override
    public String getDate() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        return dateFormat.format(date);
    }
}
