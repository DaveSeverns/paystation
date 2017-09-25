package paystation.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AlternatingRateTest {
    PayStation ps;
    @Before
    public void setup(){ps = new PayStationImpl(new AlternatingRateStrategy());}
    @Test
    public void shouldBeProgressiveRateOnWeekend() throws IllegalCoinException{
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);

        assertEquals(120,ps.readDisplay());
    }
}
