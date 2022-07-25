package bai4Test;

import bai4.TriangleClassifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassifierTest {
    @Test
    public void testTriangleClassifier(){
        int a=2;
        int b=2;
        int c=2;
        String expected="tam giac deu";
        String result= TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected,result);
    }
}
