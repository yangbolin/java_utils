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
 * ��CommonDateUtils.java��ʵ��������������صĹ����� 
 * ע:
 * 1.ʱ��ĸ�ʽ�����ο�SimpleDateFormat��DateFormat���������еĹ��߷���
 * </pre>
 * @author yangbolin Sep 20, 2013 10:48:59 AM
 */
public class CommonDateUtils {
    /**
     * <pre>
     * ���㵱ǰ����ǰ��������б�
     * ע:
     * ��������ʱ����2013.09.20����ǰ��2��󣬷��صĽ���б�����
     * 2013.09.18, 2013.09.19, 2013.09.20
     * </pre>
     * @param currentDate
     * @param days
     * @return
     */
    public static List<Date> beforeCurrentDate(Date currentDate, int days) {
        List<Date> dateList = new ArrayList<Date>();

        // 0. ���У��
        if (currentDate == null) {
            return null;
        }
        if (days <= 0) {
            dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
            return dateList;
        }
        
        // 1. ���㿪ʼʱ��
        Date startDate = DateUtils.addDays(currentDate, 0 - days);
        for (int i = 0; i < days; ++i) {
            Date date = DateUtils.addDays(startDate, i);
            // �ض�ʱ����
            dateList.add(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
        }
        // 2. �ѵ�ǰ�����ʱ��Ҳ����
        dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
        
        return dateList;
    }
    
    /**
     * <pre>
     * �ѵ�ǰ��������ƽ�ָ��������
     * ע��
     * �����ǰ������2013.09.20,����ƽ���������2���򷵻ص������б�
     * 2013.09.20 2013.09.21 2013.09.22
     * </pre>
     * @param currentDate
     * @param days
     * @return
     */
    public static List<Date> afterCurrentDate(Date currentDate, int days) {
        List<Date> dateList = new ArrayList<Date>();
        // 0. ��ε�У��
        if (currentDate == null) {
            return null;
        }
        if (days <= 0) {
            dateList.add(DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH));
            return dateList;
        }
        
        // 1. ���������ڣ�����ļ���ѵ�ǰʱ��Ҳ������
        Date startDate = new Date(currentDate.getTime());
        for (int i = 0; i <= days; ++i) {
            Date date = DateUtils.addDays(startDate, i);
            dateList.add(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
        }
        
        return dateList;
    }
}
