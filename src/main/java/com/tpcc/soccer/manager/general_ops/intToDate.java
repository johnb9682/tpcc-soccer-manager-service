package com.tpcc.soccer.manager.general_ops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Need to add ParseException when using this
 */
public class intToDate {
    Date toDate (int date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date result = format.parse(Integer.toString(date));
        return result;
    }
}