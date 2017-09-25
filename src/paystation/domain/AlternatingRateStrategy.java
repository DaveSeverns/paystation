package paystation.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AlternatingRateStrategy extends LinearRateStrategy{
    @Override
    public int calculateTime(int amount){
        int time;
        if(isWeekend()){
           time = 0;
            //for the first hour
            if(amount <=150){
                time = amount* 2/5;
            }
            //1 hour to two hours
            else if(amount > 150 && amount <= 350){
                time = 60 + ((amount-150)* 3/ 10);
            }
            //3 hours or more.
            else if(amount > 350)
            {
                time = 120 + ((amount - 350) * 5/25);
            }
        }
        else
        {
            time = super.calculateTime(amount);
        }
        return time;
    }

    private boolean isWeekend(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);

    }

}
