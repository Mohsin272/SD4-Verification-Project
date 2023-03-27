package cme;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TahirMohsinTestTask3 {
    /*******************************************
     *                                         *
     *       RATE CONSTRUCTOR TEST CASES       *
     *                                         *
     *******************************************/

    @Test
    public void testValidRateConstructor(){
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(5);
        CarParkKind kind =CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 8));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(3, 5));
        reducedPeriods.add(new Period(8, 10));
        reducedPeriods.add(new Period(22, 23));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);// checks if a constructor exists
    }
    @Test
    public void testValidRatesValue(){
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(9);
        CarParkKind kind =CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        normalPeriods.add(new Period(10, 11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(5, 9));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);// checks if a constructor exists
    }
    @Test
    public void testDecimalValues(){
        BigDecimal normalRate = BigDecimal.valueOf(7.5);
        BigDecimal reducedRate = BigDecimal.valueOf(3.5);
        CarParkKind kind =CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8,11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(15,19));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);// checks if a constructor exists
    }
    @Test
    public void testNegativeInvalidNormalRatesValue(){
        BigDecimal normalRate = BigDecimal.valueOf(-1.5);
        BigDecimal reducedRate = BigDecimal.valueOf(5);
        CarParkKind kind =CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10,11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1,2));
        reducedPeriods.add(new Period(5,9));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testNegativeInvalidReducedRatesValue(){
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(-1.1);
        CarParkKind kind =CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2,5));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1,2));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testInvalidConstructorReducedRateGreaterThanNormalRate(){
        BigDecimal normalRate = BigDecimal.valueOf(2);
        BigDecimal reducedRate = BigDecimal.valueOf(5);
        CarParkKind kind =CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10,11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1,2));
        reducedPeriods.add(new Period(5,9));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testOverlappingNormalPeriods(){
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(3);
        CarParkKind kind =CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2,5));
        normalPeriods.add(new Period(3,8));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1,2));
        reducedPeriods.add(new Period(9,12));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testOverlappingReducedPeriods(){
        BigDecimal normalRate = BigDecimal.valueOf(5.5);
        BigDecimal reducedRate = BigDecimal.valueOf(3);
        CarParkKind kind =CarParkKind.MANAGEMENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2,5));
        normalPeriods.add(new Period(10,11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(7,10));
        reducedPeriods.add(new Period(8,12));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testOverlappingPeriods() {
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(2);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(7, 10));
        normalPeriods.add(new Period(12, 15));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 12));
        reducedPeriods.add(new Period(14, 17));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testMaxDecimalValueNormalRate() {
        BigDecimal normalRate = BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal reducedRate = BigDecimal.valueOf(3);
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 8));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(1, 2));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }

    @Test
    public void testMinDecimalValueNormalRate() {
        BigDecimal normalRate = BigDecimal.valueOf(Double.MIN_VALUE);
        BigDecimal reducedRate = BigDecimal.valueOf(3);
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 8));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 16));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNullNormalRateValues() {
        BigDecimal normalRate = null;
        BigDecimal reducedRate = BigDecimal.valueOf(2);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 16));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNullReducedRateValues() {
        BigDecimal normalRate = BigDecimal.valueOf(3);
        BigDecimal reducedRate = null;
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(5, 8));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 16));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNullCarParkValues() {
        BigDecimal normalRate = BigDecimal.valueOf(8);
        BigDecimal reducedRate = BigDecimal.valueOf(4);
        CarParkKind kind = null;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        normalPeriods.add(new Period(10, 11));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(19, 20));
        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNullNormalPeriod() {
        BigDecimal normalRate = BigDecimal.valueOf(10);
        BigDecimal reducedRate = BigDecimal.valueOf(3);
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = null;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12, 16));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNullReducedPeriod() {
        BigDecimal normalRate = BigDecimal.valueOf(9.8);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        ArrayList<Period> reducedPeriods = null;
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testEmptyNormalPeriod() {
        BigDecimal normalRate = BigDecimal.valueOf(20);
        BigDecimal reducedRate = BigDecimal.valueOf(3.6);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9,13));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }

    @Test
    public void testEmptyReducedPeriod() {
        BigDecimal normalRate = BigDecimal.valueOf(12);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(12,15));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }

    @Test
    public void testZeroRateValues() {
        BigDecimal normalRate = BigDecimal.valueOf(0);
        BigDecimal reducedRate = BigDecimal.valueOf(0);
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(12, 15));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 10));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }
    @Test
    public void testNegativeWholeNumberForNormalRateValue() {
        BigDecimal normalRate = BigDecimal.valueOf(-5);
        BigDecimal reducedRate = BigDecimal.valueOf(99);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(12, 15));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 10));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }

    @Test
    public void testNegativeWholeNumberForReducedRateValue() {
        BigDecimal normalRate = BigDecimal.valueOf(6);
        BigDecimal reducedRate = BigDecimal.valueOf(-50);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(12, 15));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(9, 10));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testMaxRateValues() {
        BigDecimal normalRate = BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal reducedRate = BigDecimal.valueOf(Double.MAX_VALUE);
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(0,5));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12,18));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }
    @Test
    public void testMinRateValues() {
        BigDecimal normalRate = BigDecimal.valueOf(Double.MIN_VALUE);
        BigDecimal reducedRate = BigDecimal.valueOf(Double.MIN_VALUE);
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(0,5));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(12,18));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    @Test
    public void testMultipleInvalidPeriods() {
        BigDecimal normalRate = BigDecimal.valueOf(5);
        BigDecimal reducedRate = BigDecimal.valueOf(2);
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        normalPeriods.add(new Period(3,7));
        normalPeriods.add(new Period(4, 18));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6,9));
        reducedPeriods.add(new Period(1,3));
        reducedPeriods.add(new Period(3,4));
        assertThrows(IllegalArgumentException.class, () -> {
            new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        });
    }
    /*******************************************
     *                                         *
     *          CALCULATE TEST CASES           *
     *                                         *
     *******************************************/
//    @Test
//    public void testValidCalculation() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.STAFF;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(5, 8));
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(3, 5));
//        reducedPeriods.add(new Period(8, 10));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(1, 20));
//        BigDecimal expectedValue = BigDecimal.valueOf(33);
//        assertEquals(expectedValue, actualValue);
//    }
//    @Test
//    public void testStayPeriodInNormalPeriods() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.STAFF;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(3, 5));
//        reducedPeriods.add(new Period(8, 10));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(10, 12));
//        BigDecimal expectedValue = BigDecimal.valueOf(10);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayPeriodInReducedPeriods() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.MANAGEMENT;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(5, 8));
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(8, 10));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(8, 10));
//        BigDecimal expectedValue = BigDecimal.valueOf(4);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayPeriodOverNormalAndReducedPeriods() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.STUDENT;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(5, 8));
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(3, 5));
//        reducedPeriods.add(new Period(8, 10));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(9, 12));
//        BigDecimal expectedValue = BigDecimal.valueOf(12);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayOverFreePeriod() {
//        BigDecimal normalRate = BigDecimal.valueOf(2);
//        BigDecimal reducedRate = BigDecimal.valueOf(1);
//        CarParkKind kind = CarParkKind.STAFF;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(6, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(14, 16));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(18, 22));
//        BigDecimal expectedValue = BigDecimal.valueOf(0);
//        assertEquals(expectedValue, actualValue);
//    }
//    @Test
//    public void testStayOverFreeAndNormalPeriod() {
//        BigDecimal normalRate = BigDecimal.valueOf(3);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.MANAGEMENT;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(9, 10));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(14, 16));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(9, 12));
//        BigDecimal expectedValue = BigDecimal.valueOf(3);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayOverFreeAndReducedPeriod() {
//        BigDecimal normalRate = BigDecimal.valueOf(8);
//        BigDecimal reducedRate = BigDecimal.valueOf(5);
//        CarParkKind kind = CarParkKind.STAFF;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(5, 10));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(14, 16));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(15, 22));
//        BigDecimal expectedValue = BigDecimal.valueOf(5);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayOverNormalReducedAndFreePeriod() {
//        BigDecimal normalRate = BigDecimal.valueOf(10);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.VISITOR;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(5, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(14, 18));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(6, 20));
//        BigDecimal expectedValue = BigDecimal.valueOf(68);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayAllDay() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.STUDENT;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(6, 10));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(18, 20));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(0, 24));
//        BigDecimal expectedValue = BigDecimal.valueOf(24);
//        assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testStayNullPeriod() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(2);
//        CarParkKind kind = CarParkKind.MANAGEMENT;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(15, 20));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        assertThrows(NullPointerException.class, () -> {
//            rate.calculate(null);
//        });
//    }
//    @Test
//    public void testStayPeriodOneHour() {
//        BigDecimal normalRate = BigDecimal.valueOf(5);
//        BigDecimal reducedRate = BigDecimal.valueOf(4);
//        CarParkKind kind = CarParkKind.VISITOR;
//        ArrayList<Period> normalPeriods = new ArrayList<>();
//        normalPeriods.add(new Period(10, 12));
//        ArrayList<Period> reducedPeriods = new ArrayList<>();
//        reducedPeriods.add(new Period(15, 20));
//        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
//        BigDecimal actualValue = rate.calculate(new Period(11, 12));
//        BigDecimal expectedValue = BigDecimal.valueOf(5);
//        assertEquals(expectedValue, actualValue);
//    }
    /*******************************************
     *                                         *
     *          TDD TEST CASES                 *
     *                                         *
     *******************************************/
    @Test
    public void visitorCarParkOver10() {
        BigDecimal normalRate = BigDecimal.valueOf(5);
        BigDecimal reducedRate = BigDecimal.valueOf(4);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 12));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(15, 20));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        BigDecimal actualValue = rate.calculate(new Period(9, 12));
        BigDecimal expectedValue = BigDecimal.valueOf(2.50);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void visitorCarParkUnder10() {
        BigDecimal normalRate = BigDecimal.valueOf(5);
        BigDecimal reducedRate = BigDecimal.valueOf(4);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 12));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(15, 20));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        BigDecimal actualValue = rate.calculate(new Period(10, 12));
        BigDecimal expectedValue = BigDecimal.valueOf(5);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void visitorCarParkIs10() {
        BigDecimal normalRate = BigDecimal.valueOf(5);
        BigDecimal reducedRate = BigDecimal.valueOf(4);
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(1, 12));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(15, 20));
        Rate rate = new Rate(normalRate, reducedRate, kind, reducedPeriods, normalPeriods);
        BigDecimal actualValue = rate.calculate(new Period(11, 12));
        BigDecimal expectedValue = BigDecimal.valueOf(10);
        assertEquals(expectedValue, actualValue);
    }

}