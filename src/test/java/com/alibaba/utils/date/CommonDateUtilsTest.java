/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.utils.date;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author yangbolin Sep 20, 2013 12:14:29 PM
 */
public class CommonDateUtilsTest {

    @Test
    public void test_beforeCurrentDate() {
        List<Date> dateList = CommonDateUtils.beforeCurrentDate(new Date(), 8);
        assertEquals(dateList.size(), 9);
        Iterator<Date> it = dateList.iterator();
        while(it.hasNext()) {
            Date date = it.next();
            System.out.println(DateFormat.getDateInstance(DateFormat.DEFAULT).format(date));
        }
    }
    
    @Test
    public void test_afterCurrentDate() {
        List<Date> dateList = CommonDateUtils.afterCurrentDate(new Date(), 8);
        assertEquals(dateList.size(), 9);
        Iterator<Date> it = dateList.iterator();
        while(it.hasNext()) {
            Date date = it.next();
            System.out.println(DateFormat.getDateInstance(DateFormat.DEFAULT).format(date));
        }
    }
}
