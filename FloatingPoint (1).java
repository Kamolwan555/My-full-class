package th.co.cdgs;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatingPoint {
    public double plusTenTime(double number) {
 
        BigDecimal val = BigDecimal.valueOf(number);
        val = val.setScale(2 , RoundingMode.HALF_UP);
        BigDecimal sum = new BigDecimal(0);
        sum = sum.setScale(2 , RoundingMode.HALF_UP);
        for (int i = 0; i < 10; i++) {
            sum = sum.add(val);
            System.out.print(sum.intValue());
        }
 
        return sum.intValue();
    }
}
