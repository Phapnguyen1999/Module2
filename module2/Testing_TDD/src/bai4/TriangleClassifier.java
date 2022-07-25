package bai4;

public class TriangleClassifier {
    private int edgeA;
    private int edgeB;
    private int edgeC;

    public TriangleClassifier(int edgeA, int edgeB, int edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }

    public static String checkTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c && c == a)
                return "tam giac deu";
            if ((a==b&&a==c)||(b==a&&b==c)||(c==a)&&c==b)
                return "tam giac can";
            if ((Math.pow(a,2)+Math.pow(b,2)==Math.pow(c,2))||
                    (Math.pow(a,2)+Math.pow(c,2)==Math.pow(b,2))||
                    (Math.pow(b,2)+Math.pow(c,2)==Math.pow(a,2)))
                return "tam giac vuong";
        } else {
            return "khong phai tam giac";
        }
        return "";
    }
}
