package util;

import java.util.Date;

public class DateUtil {
    public static Date getNextDate(){
        Date date=new Date();
        long addTime=1*24*60*60*1000;
        return new Date(date.getTime()+addTime);
    }
}
