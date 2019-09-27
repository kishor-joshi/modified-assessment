package com.atmecs.blogs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
public static void main(String[] args) {
	
	demo.onCreate();
	String date="March 15, 2019";
	String dateArr[]=date.replace(",", "").split("\\s+");
	for(String q:dateArr)
	System.out.println(q);
	int j=0;
	String MM="";
	String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	for(int i=0;i<monthArr.length;i++) {
		if(dateArr[0].equalsIgnoreCase(monthArr[i])) {
			j=i+1;
		break;
		}
	}
	if(j<10)
		MM="0"+j;
	System.out.println(MM);
	String blogDate=MM+"/"+dateArr[1]+"/"+dateArr[2];
	System.out.println(blogDate);
	demo d=new demo();
	d.monthDifference("March 15, 2019");
	
}
protected static void onCreate() {
	//Bundle savedInstanceState
  //  super.onCreate(savedInstanceState);
  //  setContentView(R.layout.activity_main);
    try {
        //Dates to compare
        String currentDate=  "09/24/2015";
        String blogDate=  "09/26/2018";

        Date date1;
        Date date2;

        SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

        //Setting dates
        date1 = dates.parse(currentDate);
        date2 = dates.parse(blogDate);

        //Comparing dates
        long difference = Math.abs(date1.getTime() - date2.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);
        System.out.println(differenceDates);

        //Convert long to String
        String dayDifference = Long.toString(differenceDates);

        //Log.e("HERE","HERE: " + dayDifference);
    }
    catch (Exception exception) {
      //  Log.e("DIDN'T WORK", "exception " + exception);
    }
 //   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    Date date = new Date();  
    System.out.println(formatter.format(date));  
}
public void dateformate(String date) {
	String[] arr=date.replace("\\.", "").split("\\s");
 }
public void monthToNumber(String month) {
	String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
}
public void monthDifference(String blogerDate) {
	//String blogDate=monthINFormate(blogerdate);
	 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
	    Date date = new Date();  
	  //  String currentDate=formatter.format(date); 
	    try {
	        //Dates to compare
	        String currentDate=  formatter.format(date); 
	        String blogDate= monthINFormate(blogerDate);

	        Date date1;
	        Date date2;

	        SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

	        //Setting dates
	        date1 = dates.parse(currentDate);
	        date2 = dates.parse(blogDate);

	        //Comparing dates
	        long difference = Math.abs(date1.getTime() - date2.getTime());
	        long differenceDates = difference / (24 * 60 * 60 * 1000);
	        System.out.println(differenceDates);

	        //Convert long to String
	        String dayDifference = Long.toString(differenceDates);
	        System.out.println("modified day difference is "+dayDifference);

	        //Log.e("HERE","HERE: " + dayDifference);
	    }
	    catch (Exception exception) {
	      //  Log.e("DIDN'T WORK", "exception " + exception);
	    }
	    
	
}
public String monthINFormate(String date) {
	String dateArr[]=date.replace(",", "").split("\\s+");
	int j=0;
	String MM="";
	String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	for(int i=0;i<monthArr.length;i++) {
		if(dateArr[0].equalsIgnoreCase(monthArr[i])) {
			j=i+1;
		break;
		}
	}
	if(j<10)
		MM="0"+j;
	System.out.println(MM);
	String blogDate=MM+"/"+dateArr[1]+"/"+dateArr[2];
	return blogDate;
}
}
