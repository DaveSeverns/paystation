package paystation.domain;

/**
 * This interface will be used to abstact and compose different rate strategy objects for each paystation implemetnation
 * The goal is to avoid reusing and changing existing code
 * @author davidseverns
 */

public interface RateStrategy {

    /**
     * will need to be used by each strategy object calc time based on the rate strategy
     * @param amount
     * @return
     */
    public int calculateTime(int amount);

}
