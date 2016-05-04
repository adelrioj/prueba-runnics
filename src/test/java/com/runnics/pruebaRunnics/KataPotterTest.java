package com.runnics.pruebaRunnics;

import org.junit.Test;

/**
 * Testing suite for the Kata Potter.
 *
 * @author adelrioj
 */
public class KataPotterTest {

    @Test
    public void testBasics() {
        CustomAssertion.assertEqualsBigDecimal("8", KataPotter.getPrice(0));
        CustomAssertion.assertEqualsBigDecimal("8", KataPotter.getPrice(1));
        CustomAssertion.assertEqualsBigDecimal("8", KataPotter.getPrice(2));
        CustomAssertion.assertEqualsBigDecimal("8", KataPotter.getPrice(3));
        CustomAssertion.assertEqualsBigDecimal("8", KataPotter.getPrice(4));
        CustomAssertion.assertEqualsBigDecimal("16", KataPotter.getPrice(0, 0));
        CustomAssertion.assertEqualsBigDecimal("24", KataPotter.getPrice(1, 1, 1));
    }

    @Test
    public void testSimpleDiscounts() {
        CustomAssertion.assertEqualsBigDecimal("15.2", KataPotter.getPrice(0, 1));
        CustomAssertion.assertEqualsBigDecimal("21.6", KataPotter.getPrice(0, 2, 4));
        CustomAssertion.assertEqualsBigDecimal("25.6", KataPotter.getPrice(0, 1, 2, 4));
        CustomAssertion.assertEqualsBigDecimal("30", KataPotter.getPrice(0, 1, 2, 3, 4));
    }

    @Test
    public void testSeveralDiscounts() {
        CustomAssertion.assertEqualsBigDecimal("23.2", KataPotter.getPrice(0, 0, 1));
        CustomAssertion.assertEqualsBigDecimal("30.4", KataPotter.getPrice(0, 0, 1, 1));
        CustomAssertion.assertEqualsBigDecimal("40.8", KataPotter.getPrice(0, 0, 1, 2, 2, 3));
        CustomAssertion.assertEqualsBigDecimal("38", KataPotter.getPrice(0, 1, 1, 2, 3, 4));
    }

    @Test
    public void testEdgeCases() {
        CustomAssertion.assertEqualsBigDecimal("51.2", KataPotter.getPrice(0, 0, 1, 1, 2, 2, 3, 4));
        CustomAssertion.assertEqualsBigDecimal("81.2", KataPotter.getPrice(0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4));
        CustomAssertion.assertEqualsBigDecimal("141.2", KataPotter.getPrice(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4));
        CustomAssertion.assertEqualsBigDecimal("78.8", KataPotter.getPrice(0, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4));
        CustomAssertion.assertEqualsBigDecimal("100", KataPotter.getPrice(0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4));
        CustomAssertion.assertEqualsBigDecimal("141.6", KataPotter.getPrice(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4));
        CustomAssertion.assertEqualsBigDecimal("108", KataPotter.getPrice(0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3));
    }

}
