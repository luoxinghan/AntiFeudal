package top.antifeudal.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deal the time.
 * @describe 处理时间的工具
 * @author luoxinghan
 * @date 2018.12.08
 *
 */
public class DateUtil {
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Date changeToSqlDate(java.util.Date utilDate){
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	/**
	 * 将java.sql.Date转换为java.util.Date
	 * @param sqlDate
	 * @return
	 */
	public static java.util.Date changeToUtilDate(java.sql.Date sqlDate){
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	
	/**
	 * 将string类型的转换为date类型
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将date转换为string
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format0.format(date.getTime());
        return time;
	}
	
	/**
	 * 将java.util.Date转换为java.sql.Timestamp
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Timestamp changeToTimestampDate(java.util.Date utilDate){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		java.util.Date date;
		try {
			date = sdf.parse(dateFormat(utilDate));
			java.sql.Timestamp ts= new java.sql.Timestamp(date.getTime());
			return ts;
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 将timestamp转换为date类型
	 * @param timestamp
	 * @return
	 */
	public static java.util.Date timestampChangeToDate(java.sql.Timestamp timestamp) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        Date date = new Date();   
        try {   
            date = ts;   
            return date;
        } catch (Exception e) {   
            e.printStackTrace();   
        }
        return null;
	}
	
	/**
	 * 将string转换为java.sql.Timestamp
	 * @param str
	 * @return
	 */
	public static java.sql.Timestamp stringChangeToTimeStamp(String str){
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try {   
            ts = Timestamp.valueOf(str);   
            System.out.println(ts);  
            return ts;
        } catch (Exception e) {   
            e.printStackTrace();   
        }
        return null;
	}
	
	/**
	 * 将java.sql.Timestamp转换为string类型
	 * @param ts
	 * @return
	 */
	public static String timestampChangeToString(java.sql.Timestamp ts) {
        String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
        try {   
            //方法一   
            tsStr = sdf.format(ts);   
            return tsStr;
        } catch (Exception e) {   
            e.printStackTrace();   
        }
        return null;
	}
}
