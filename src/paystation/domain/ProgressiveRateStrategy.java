package paystation.domain;

public class ProgressiveRateStrategy implements RateStrategy {
    @Override
    public int calculateTime(int amount) {
        int time = 0;
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
        return time;
    }
}
