package com.runnics.pruebaRunnics;

import java.math.BigDecimal;

import static org.junit.Assert.fail;

/**
 * This class provides custom assertion methods to compare objects that are not supported by standard JUnit assertion.
 *
 * @author adelrioj
 */
public class CustomAssertion {

    /**
     * Compares two BigDecimal variables, failing if expected value is different from given value.
     * <p />
     * Expected BigDecimal value is created from String values as it becomes in less precision loss
     * compared to other constructors.
     *
     * @param expectedValue String with expected value (e.g. "104453.754334566")
     * @param obtainedValue BigDecimal value that needs testing
     */
    public static void assertEqualsBigDecimal(String expectedValue, BigDecimal obtainedValue) {
        if (new BigDecimal(expectedValue).compareTo(obtainedValue) != 0) {
            fail("Expected " + expectedValue + " but was " + obtainedValue.toPlainString());
        }
    }
}
