package designing.fpij;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculateNAVTest {

    @Test
    public void computeStockWorth() {
        final CalculateNAV calculateNAV =
                new CalculateNAV(ticker -> new BigDecimal("6.01"));

        BigDecimal expected = new BigDecimal("6010.00");

        Assert.assertEquals(0,
                calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected));
    }
}
