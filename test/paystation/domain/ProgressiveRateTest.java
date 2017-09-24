package paystation.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ProgressiveRateTest {
    PayStation ps;

    @Before
    public void setup() {
        ps = new PayStationImpl(new ProgressiveRateStrategy());
    }

    @Test
    public void shouldReturn63For160Entered() throws  IllegalCoinException{
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(10);
        assertEquals(63, ps.readDisplay());

    }

    @Test
    public void shouldReturn180For650Entered() throws IllegalCoinException{
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        //1
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        //2
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        //3
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        //4, 5
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);

        assertEquals(180,ps.readDisplay());

    }

    @Test
    public void shouldReturn0AfterCancelOrBeforeAddPayment() throws IllegalCoinException{
        assertTrue(ps.readDisplay() == 0);
        ps.addPayment(5);
        ps.cancel();
        assertEquals(0,ps.readDisplay());
    }
}
