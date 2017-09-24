package paystation.domain;

import java.util.Map;

public class PaystationAppManager {
    //display the menu for the paystation app
    //keep the main app a little cleaner
    public static void displayMenu(){
        System.out.println("Welcome Please Select The Task You Would Like To Perform");
        System.out.println("1) Deposit Coins\n" +
                            "2) Display Time Allotted So Far\n" +
                            "3) Complete Purchase\n"+
                            "4) Cancel Purchase\n"+
                            "5) Change Rate Strategy (Maintenance Personnel Only)");
    }

    /**
     * print the summary of coins returned when cancel is selected
     * @param payStation
     */
    public static void returnCoins(PayStationImpl payStation){
        //for each loop to iterate through the coin map in the paystation object
        for(Map.Entry<Integer,Integer> entry : payStation.getCoinMap().entrySet()){
            System.out.println(("Coin Value: "+ entry.getKey() + "   ---   Amount Returned: "+entry.getValue()));
        }
    }

}
