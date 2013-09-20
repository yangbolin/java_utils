/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.utils.date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

/**
 * <pre>
 * 类CommonDateUtils.java的实现描述：日期相关的工具类 
 * 注:
 * 1.时间的格式化，参考SimpleDateFormat和DateFormat这两个类中的工具方法
 * </pre>
 * @author yangbolin Sep 20, 2013 10:48:59 AM
 */
public class CommonDateUtils {
    /**
     * <pre>
     * 计算当前日期前面的日期列表
     * 注:
     * 如果传入的时间是2013.09.20，向前推2天后，返回的结果列表中有
     * 2013.09.18, 2013.09.19, 2013.09.20
     * </pre>
     * @param currentDate
     * @param days
     * @return
     */
    public static List<Date> beforeCurrentDate(Date currentDate, int days) {
        List<Date> dateList = new ArrayList<Date>();

        // 0. 入参校验
        if (currentDate == null) {
            return null;
        }
        if (days <= 0) {
            dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
            return dateList;
        }
        
        // 1. 计算开始时间
        Date startDate = DateUtils.addDays(currentDate, 0 - days);
        for (int i = 0; i < days; ++i) {
            Date date = DateUtils.addDays(startDate, i);
            // 截断时分秒
            dateList.add(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
        }
        // 2. 把当前传入的时间也加入
        dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
        
        return dateList;
    }
    
    /**
     * <pre>
     * 把当前日期向后推进指定的天数
     * 注：
     * 如果当前日期是2013.09.20,向后推进的天数是2，则返回的日期列表
     * 2013.09.20 2013.09.21 2013.09.22
     * </pre>
     * @param currentDate
     * @param days
     * @return
     */
    public static List<Date> afterCurrentDate(Date currentDate, int days) {
        List<Date> dateList = new ArrayList<Date>();
        // 0. 入参的校验
        if (currentDate == null) {
            return null;
        }
        if (days <= 0) {
            dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
            return dateList;
        }
        
        // 1. 向后计算日期，这里的计算把当前时间也加入了
        Date startDate = new Date(currentDate.getTime());
        for (int i = 0; i <= days; ++i) {
            Date date = DateUtils.addDays(startDate, i);
            dateList.add(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
        }
        
        return dateList;
    }
}
