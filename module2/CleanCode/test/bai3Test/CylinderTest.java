package bai3Test;

import bai3.Cylinder;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CylinderTest {
    @Test
    public void testGetVolume0And0() {
        int radius = 0;
        int height = 0;
        double expected = 0;
        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected,result);
    }
    @Test
    public void testGetVolume1And2() {
        int radius = 1;
        int height = 2;
        double expected = 18.84955592153876;

        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected,result);
    }
}
