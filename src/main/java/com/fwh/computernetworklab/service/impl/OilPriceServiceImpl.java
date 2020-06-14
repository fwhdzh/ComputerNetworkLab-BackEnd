package com.fwh.computernetworklab.service.impl;

import com.fwh.computernetworklab.service.OilPriceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class OilPriceServiceImpl implements OilPriceService {
    @Override
    public double getPrice() {
        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
//        return dateFormat.format(date);
        BigDecimal bg = new BigDecimal(date.getTime() /1000/60/60/24 % 100);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}
