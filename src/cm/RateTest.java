package cm;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class RateTest {
 
	@Test
    public void normalRateAboveZero() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(3.00);
		BigDecimal reducedRate = new BigDecimal(2.80);
		Period rPeriods = new Period(12, 14);
		Period nPeriods = new Period(8, 11);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
	
	@Test
	public void normalRateAboveZero2() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.20);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(1, 7);
		Period nPeriods = new Period(8, 18);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
	
	@Test
    public void normalRateLargerThanReducedRate() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(2.00);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(1, 13);
		Period nPeriods = new Period(14, 24);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
   
	@Test
    public void normalRateLargerThanReducedRate2() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(0.80);
		Period rPeriods = new Period(18, 24);
		Period nPeriods = new Period(7, 17);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
    
	@Test(expected = IllegalArgumentException.class)
    public void normalRateBelowZero() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(-1.00);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(12, 14);
		Period nPeriods = new Period(15, 24);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
    
	@Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanReducedRate() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(2.00);
		Period rPeriods = new Period(1, 13);
		Period nPeriods = new Period(14, 19);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
    
	@Test
    public void normalRateFinishedBeforeStartReducedRate() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(3.00);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(1, 12);
		Period nPeriods = new Period(13, 24);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
    
	@Test
    public void reducedRateFinishedBeforeStartNormalRate() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(2.00);
		BigDecimal reducedRate = new BigDecimal(1.80);
		Period rPeriods = new Period(21, 24);
		Period nPeriods = new Period(8, 20);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
    
	@Test(expected = IllegalArgumentException.class)
    public void reducedRateStartBeforeNormalRateEnd() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(0.50);
		Period rPeriods = new Period(8, 17);
		Period nPeriods = new Period(15, 24);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
    
	@Test(expected = IllegalArgumentException.class)
    public void normalRateStartBeforeReducedRateEnd() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(2.50);
		BigDecimal reducedRate = new BigDecimal(1.20);
		Period rPeriods = new Period(12, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
    
	@Test
    public void reducedRateAboveEqualZero() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(6.70);
		BigDecimal reducedRate = new BigDecimal(3.45);
		Period rPeriods = new Period(21, 24);
		Period nPeriods = new Period(1, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}

	@Test(expected = IllegalArgumentException.class)
    public void reducedRateBelowZero() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(-0.60);
		Period rPeriods = new Period(1, 13);
		Period nPeriods = new Period(15, 24);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void invalidPeriod() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(0.60);
		Period rPeriods = new Period(1, 13);
		Period nPeriods = new Period(15, 25);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
    }
	
	@Test
    public void reducedRateEqualZero() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(6.70);
		BigDecimal reducedRate = new BigDecimal(0.00);
		Period rPeriods = new Period(21, 24);
		Period nPeriods = new Period(1, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        assertNotNull(testRate);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
    public void nullRate() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = null;
		BigDecimal reducedRate = new BigDecimal(0.00);
		Period rPeriods = null;
		Period nPeriods = null;
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
	}

	@Test(expected = IllegalArgumentException.class)
    public void invalidPeriods() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(2.00);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(0, -1);
		Period nPeriods = new Period(4, 2);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
	}
	//TASK 3 TEST CASES
	
	@Test
    public void calculateVisitor() throws Exception {
		CarParkKind kind = CarParkKind.VISITOR;
		BigDecimal normalRate = new BigDecimal(1.00);
		BigDecimal reducedRate = new BigDecimal(0.80);
		Period rPeriods = new Period(18, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(13,21);

        BigDecimal expected = new BigDecimal(0.00);
        
        assertEquals(expected, testRate.calculate(testPeriod));
	}
	
	@Test
    public void calculateVisitor2() throws Exception {
		CarParkKind kind = CarParkKind.VISITOR;
		BigDecimal normalRate = new BigDecimal(5.00);
		BigDecimal reducedRate = new BigDecimal(2.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(1,24);
        
        BigDecimal expected = new BigDecimal(12);
        
        assertEquals(expected, testRate.calculate(testPeriod).stripTrailingZeros());
	}
	
	@Test
    public void calculateManagement() throws Exception {
		CarParkKind kind = CarParkKind.MANAGEMENT;
		BigDecimal normalRate = new BigDecimal(10.50);
		BigDecimal reducedRate = new BigDecimal(5.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(1,6);
        
        BigDecimal expected = new BigDecimal(3.00);
        
        assertEquals(expected, testRate.calculate(testPeriod));
	}
	
	@Test
    public void calculateManagement2() throws Exception {
		CarParkKind kind = CarParkKind.MANAGEMENT;
		BigDecimal normalRate = new BigDecimal(10.50);
		BigDecimal reducedRate = new BigDecimal(5.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(1,17);
        
        BigDecimal expected = new BigDecimal(63.00);
        
        assertEquals(expected, testRate.calculate(testPeriod).stripTrailingZeros());
	}
    
	@Test
    public void calculateStudent() throws Exception {
		CarParkKind kind = CarParkKind.STUDENT;
		BigDecimal normalRate = new BigDecimal(2.50);
		BigDecimal reducedRate = new BigDecimal(1.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(9,10);
        
        BigDecimal expected = new BigDecimal(2.5);
        
        assertEquals(expected, testRate.calculate(testPeriod));
	}
    
	@Test
    public void calculateStudent2() throws Exception {
		CarParkKind kind = CarParkKind.STUDENT;
		BigDecimal normalRate = new BigDecimal(4.50);
		BigDecimal reducedRate = new BigDecimal(3.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(9,11);
        
        BigDecimal expected = new BigDecimal(6.75);
        
        assertEquals(expected, testRate.calculate(testPeriod).stripTrailingZeros());
	}
    
	@Test
    public void calculateStaff() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(10.50);
		BigDecimal reducedRate = new BigDecimal(5.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(9, 10);
        
        BigDecimal expected = new BigDecimal(10.50);
        
        assertEquals(expected, testRate.calculate(testPeriod));
	}
    
	@Test
    public void calculateStaff2() throws Exception {
		CarParkKind kind = CarParkKind.STAFF;
		BigDecimal normalRate = new BigDecimal(7.50);
		BigDecimal reducedRate = new BigDecimal(5.00);
		Period rPeriods = new Period(23, 24);
		Period nPeriods = new Period(9, 15);
		ArrayList<Period> reducedPeriods = new ArrayList<Period>();
		ArrayList<Period> normalPeriods = new ArrayList<Period>();
		reducedPeriods.add(rPeriods);
		normalPeriods.add(nPeriods);
        Rate testRate = new Rate(kind, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period testPeriod = new Period(1,17);
        
        BigDecimal expected = new BigDecimal(16.00);
        
        assertEquals(expected, testRate.calculate(testPeriod));
	}
}

