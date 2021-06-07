# DateTimeLibrary

This Java library assists in quickly getting a variety of dates and times for your project.

The class main is ```DateTimeHelpers``` and includes six subclasses: ```BasicOperations```, ```TimestampHelper```, ```DateHelper```, ```WeekdayHelper```, ```CalendarHelper```, and ```AM_PM_Helper```.

Begin by adding the following to your PROJECT level build.gradle file:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

Then add this to the MODULE level build.gradle file:

	dependencies {
	        implementation 'com.github.adamsawyer391:DateTimeLibrary:1.0.0'
	}

A simple example of an operation might look like this:

        String time = DateTimeHelpers.BasicOperations.getCurrent12HourTime();
        TextView textView = findViewById(R.id.tv1);
        textView.setText(time);

The ```BasicOperations``` class includes four methods: ```getCurrent24HourTime()```, ```getCurrent12HourTime()```, ```getCurrentMonthShort()```, and ```getCurrentMonthLong()```. The ```getCurrentMonthShort()``` method returns the "MMM" pattern for a SimpleDateFormat and provides ```Mar```, ```Nov```, and so on.

The ```TimestampHelper``` class includes two methods: ```getCurrentTimstamp()``` and ```getTimestampFromDate()``` which takes a string date as a parameter. If you were using a Date Picker or drop down menus and you had a date but wanted a timestamp from it, you could write something like this:

        String time = "04/01/78";
        long timestamp = DateTimeHelpers.TimestampHelper.getTimestampOfSelectedDate(time);
        TextView textView = findViewById(R.id.tv1);
        textView.setText(String.valueOf(timestamp));

The ``DateTimeHelper`` class contains four methods: `getCurrentDate_MMddYY()`, ```getCurrentDate_MMddYYYY()```, ```getCurrentDate_ddMMYY()```, and ```getCurrentDate_ddMMYYYY()```. This gives you the option of an American or European style formatting for your date. An example might look like this:

        TextView textView = findViewById(R.id.tv1);
        textView.setText(new StringBuilder().append("Today's Date: ").append(DateTimeHelpers.DateHelper.getCurrentDate_MMddYY()));
	
The ```WeekdayHelper``` provides two methods: ```getTextualDayOfWeekFull()``` and ```getTextualDayOfWeekShort()```. You could write:

        TextView textView = findViewById(R.id.tv1);
        textView.setText(new StringBuilder("Today's Date")
            .append(DateTimeHelpers.WeekdayHelper.getTextualDayOfWeekFull())
            .append(", ")
            .append(DateTimeHelpers.DateHelper.getCurrentDate_MMddYY()));

The ```CalendarHelper``` class provides five methods including: ```getCurrentMonthNumber()```, ```getTextOfCurrentMonth()``` which takes an ```int``` parameter, ```getCurrentYear()```, ```getCurrentWeekNumber()```, ```getRangeOfDatesInCurrentWeek()```, and ```getRangeOfDatesFromSelectedWeek()``` which takes an ```int``` as a parameter. Building on a previous example, we could write something like this:

        TextView textView = findViewById(R.id.tv1);
        textView.setText(new StringBuilder("Current Month: ")
                .append(DateTimeHelpers.CalendarHelper.getTextOfCurrentMonth(DateTimeHelpers.CalendarHelper.getCurrentMonthNumber())));

The ```AM_PM_Helper``` class provides two methods: ```deliverCurrentAM_PM_Time()``` and ```deliverAM_PM_TimeFromSelectTime()``` which takes a string as a parameter in the form of a time. So if you were using a time picker you could do something like this:

        TextView textView = findViewById(R.id.tv1);
        String time = "13:04:00";
        textView.setText(DateTimeHelpers.AM_PM_Helper.deliverAM_PM_TimeFromSelectTime(time));
	




