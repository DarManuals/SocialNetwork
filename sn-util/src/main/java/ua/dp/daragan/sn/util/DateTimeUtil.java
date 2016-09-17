package ua.dp.daragan.sn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bogdan on 17.09.16.
 */
public class DateTimeUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static Date StrToDate(String dateIncome) throws ParseException{
        return DATE_FORMAT.parse(dateIncome);
    }

    public static String DateToStr(Date dateIncome) throws ParseException {
        return DATE_FORMAT.format(dateIncome);
    }
}
