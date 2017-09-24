package paystation.domain;


import java.util.Scanner;

/**
 * @author davidseverns
 * a demonstration of the paystation source code
 */

public class PaystationApplication {


    public static void main (String[] args) throws  IllegalCoinException{
        PayStationImpl payStation;
        RateStrategy rateStrategy;
        Scanner keyboard = new Scanner(System.in);
        int selection;
        // set default rateStrategy to linear
        payStation = new PayStationImpl(new LinearRateStrategy());
        while (true){
            PaystationAppManager.displayMenu();
            selection = keyboard.nextInt();

            switch (selection){
                case 1:
                {
                    System.out.println("Enter a coin of the following denominations (5, 10, or 25)");
                    payStation.addPayment(keyboard.nextInt());
                    break;
                }
                case 2:
                {
                    System.out.println("Time Allotted So far (in minutes): "+ payStation.readDisplay());
                    break;
                }
                case 3:
                {
                    Receipt r = payStation.buy();
                    System.out.println("Purchase Successful! Time Bought: "+r.value()+ " minutes");
                    break;
                }
                case 4:
                {
                    PaystationAppManager.returnCoins(payStation);
                }
                default:
                    break;

            }

        }
    }
}
