package com.cosmic.datetimehelpers;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeHelpers {

    private static final String TAG = "DateTimeHelpers";

    public static class BasicOperations{

        public static String getCurrent24HourTime(){
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        }

        public static String getCurrent12HourTime(){
            return new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());
        }

        public static String getCurrentMonthShort(){
            return new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
        }

        public static String getCurrentMonthLong(){
            return new SimpleDateFormat("MMMM", Locale.getDefault()).format(new Date());
        }

    }

    public static class TimestampHelper{

        public static long getCurrentTimeStamp(){
            return new Date(DateHelper.getCurrentDate_MMddYY()).getTime();
        }

        public static long getTimestampOfSelectedDate(String selectDate){
            Date date = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try{
                date = simpleDateFormat.parse(selectDate);
            }catch (ParseException e){
                e.printStackTrace();
            }
            return date.getTime();
        }

    }

    public static class DateHelper{

        public static String getCurrentDate_MMddYY(){
            return new SimpleDateFormat("MM/dd/yy", Locale.getDefault()).format(new Date());
        }

        public static String getCurrentDate_MMddYYYY(){
            return new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());
        }

        public static String getCurrentDate_ddMMYY(){
            return new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        }

        public static String getCurrentDate_ddMMYYYY(){
            return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        }

    }

    public static class WeekdayHelper{

        public static String getTextualDayOfWeekFull(){
            return new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        }

        public static String getTextualDayOfWeekShort(){
            return new SimpleDateFormat("EEE", Locale.getDefault()).format(new Date());
        }

    }

    public static class CalendarHelper{

        public static int getCurrentMonthNumber(){
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.MONDAY);
        }

        public static String getTextOfCurrentMonth(int month){
            switch (month){
                case 0:
                    return "January";
                case 1:
                    return "February";
                case 2:
                    return "March";
                case 3:
                    return "April";
                case 4:
                    return "May";
                case 5:
                    return "June";
                case 6:
                    return "July";
                case 7:
                    return "August";
                case 8:
                    return "September";
                case 9:
                    return "October";
                case 10:
                    return "November";
                case 11:
                    return "December";
            }
            return "";
        }

        public static int getCurrentYear(){
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.YEAR);
        }

        public static int getCurrentWeekNumber(){
            Calendar calendar = Calendar.getInstance();
            return calendar.get(Calendar.WEEK_OF_YEAR);
        }

        public static StringBuilder getRangeOfDatesInCurrentWeek(){
            Calendar calendar = Calendar.getInstance();
            int difference = 0;
            int endDifference = 0;
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            endDifference = 7 - currentDayOfWeek;
            difference = currentDayOfWeek - firstDayOfWeek;
            Calendar c = Calendar.getInstance();
            int currentDay = c.get(Calendar.DAY_OF_MONTH);
            c.set(Calendar.DAY_OF_MONTH, currentDay - difference);
            Date startDateValue = c.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
            String startDate = simpleDateFormat.format(startDateValue);
            Calendar d1 = Calendar.getInstance();
            d1.set(Calendar.DAY_OF_MONTH, currentDay + endDifference);
            Date endDateValue = d1.getTime();
            String endDay = simpleDateFormat.format(endDateValue);
            return new StringBuilder("Sun. ").append(startDate).append(" -- ").append("Sat. ").append(endDay);
        }

        public static StringBuilder getRangeOfDatesFromSelectedWeek(int weekNumber){
            Calendar c = Calendar.getInstance();
            c.set(Calendar.WEEK_OF_YEAR, weekNumber);
            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
            Date firstDate = c.getTime();
            String firstDay = simpleDateFormat.format(firstDate);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
            calendar.set(Calendar.DAY_OF_WEEK, 7);
            Date lastDate = calendar.getTime();
            String lastDay = simpleDateFormat.format(lastDate);
            return new StringBuilder().append(firstDay).append(" -- ").append(lastDay);
        }

    }

    public static class AM_PM_Helper{

        public static String deliverCurrentAM_PM_Time(){
            String time = BasicOperations.getCurrent24HourTime();
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
                Date dt = sdf.parse(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh", Locale.getDefault());
                Date date = simpleDateFormat.parse(time);
                String clockTime = simpleDateFormat.format(date);
                if (clockTime.equals("12")){
                    SimpleDateFormat noonFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
                    String noonTime = noonFormat.format(dt);
                    return noonTime + " P<";
                }else{
                    SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                    return sdfs.format(dt);
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
            return "";
        }

        public static String deliverAM_PM_TimeFromSelectTime(String time){
            Log.d(TAG, "deliverAM_PM_TimeFromSelectTime: passed time : "  + time);
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                Date dt = sdf.parse(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", Locale.getDefault());
                Date date = simpleDateFormat.parse(time);
                String clockTime = simpleDateFormat.format(date);
                Log.d(TAG, "deliverAM_PM_TimeFromSelectTime: clock time : " + clockTime);
                if (clockTime.equals("12")){
                    SimpleDateFormat noonFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
                    String noonTime = noonFormat.format(dt);
                    return noonTime + " PM";
                }else{
                    SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                    return sdfs.format(dt);
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
            return "";
        }

    }

}
