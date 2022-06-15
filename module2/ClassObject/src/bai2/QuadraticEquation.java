package bai2;

public class QuadraticEquation {
    int a,b,c;
    double r1,r2,r;
    public QuadraticEquation( ){

    }
    public QuadraticEquation(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getDenta(){
        return Math.pow(this.b,2)-4*this.a*this.c;
    }
    public double getRoot1(){
        r1=(-this.b+Math.pow(getDenta(),0.5))/2*this.a;
        return r1;
    }
    public double getRoot2(){
        r2=(-this.b-Math.pow(getDenta(),0.5))/2*this.a;
        return r2;
    }
    public double getRoot(){
        r=-this.b/2*this.a;
        return r;
    }
}
