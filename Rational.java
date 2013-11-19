// Andy Lui
// pd9
// HW27
// 2013-11-18

public class Rational {

    //Phase I
    private int num;
    private int den;
    
    public Rational() {
        num = 0;
        den = 1;
    }

    public Rational(int numer, int denom) {
	num = numer;
	den = denom;
	if (den == 0) {
	    System.out.println("The denominator cannot be 0!");
	    num = 0;
	    den = 1;
	}
    }

    public String toString() {
	String retStr = "" + num + "/" + den + "";
	return retStr;
    }
   
    public double floatValue() {
	return ((double) num)/den ;
    }

    public void multiply(Rational r) {
	num *= r.num;
	den *= r.den;
    }

    public void divide(Rational r) {
	num *= r.den;
	den *= r.num;
    }


    //Phase II
    public void add(Rational r) {
	num = num * r.den + den * r.num;
	den = den * r.den;
    }

    public void subtract(Rational r) {
	num = num * r.den - den * r.num;
	den = den * r.den;
    }

    public int gcd(int a, int b) {
	if (a % b == 0) {
	    return b;
	}
	else {
	    return gcd(b, a % b);
	}
    }

    public void reduce() {
	int gcd = gcd(num,den);
	num /= gcd;
	den /= gcd;
    }


    //Phase III
    public static int gcdStatic(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        else {
            return gcdStatic(y, x % y);
        }
    }

    public int compareTo (Object r) {
        double diff = this.floatValue() - ((Rational)r).floatValue();
	if (diff > 0)
	    diff = 1;
	else if (diff < 0)
	    diff = -1;
	else
	    diff = 0;
	return (int) diff;
    }



    
    public static void main(String[] args) {
    	
	//Default
	Rational start = new Rational();
	System.out.println("Default Rational: " + start + 
			   " or " + start.floatValue());
	
	//Multiplication
	Rational a = new Rational(2,3);
	Rational b = new Rational(1,2);
	System.out.println("a: " + a);
	System.out.println("b: " + b);
	a.multiply(b);
	System.out.println("Product: " + a + " or " + a.floatValue());

	//Division
	Rational c = new Rational(1,3);
	Rational d = new Rational(1,4);
	System.out.println("c: " + c);
	System.out.println("d: " + d);
	c.divide(d);
	System.out.println("Quotient: " + c + " or " + c.floatValue());

	//Addition
	Rational e = new Rational(1,5);
	Rational f = new Rational(1,6);
	System.out.println("e: " + e);
	System.out.println("f: " + f);
	e.add(f);
	System.out.println("Sum: " + e + " or " + e.floatValue());

	//Subtraction
	Rational g = new Rational(1,7);
	Rational h = new Rational(1,8);
	System.out.println("g: " + g);
	System.out.println("h: " + h);
	g.subtract(h);
	System.out.println("Difference: " + g + " or " + g.floatValue());

	//Reducing
	Rational i = new Rational(3,9);
	System.out.println("i: " + i);
	i.reduce();
	System.out.println("Reduced: " + i);

	//Static gcd
	System.out.println("gcd of 7 and 35: " + gcdStatic(7,35));

	//compareTo
	Rational j = new Rational(1,9);
	Rational k = new Rational(1,10);
	System.out.println("Comparing j to k: " + j.compareTo(k));
	System.out.println("Comparing k to j: " + k.compareTo(j));
	Rational m = new Rational(3,5);
	Rational n = new Rational(6,10);
	System.out.println("Comparing m to n: " + m.compareTo(n));
	
    }//end main

} //end Rational
