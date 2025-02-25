package com.learn.algorithms.multiplication;

public class Karatsuba {

    public Karatsuba() {
    }

    public int karatsubaMultiplication(Integer x, Integer y){
        //base case, if either number is small do integer multiplication
        if (x < 10 || y < 10) {return x * y;
        }

        //compute the max number of digits between x and y
        int n = Math.max(numDigits(x), numDigits(y));

        // m is half of n
        int m = n/2;

        // 3) Split x into: a and b
        int a = x / (int) Math.pow(10, m);      // top half
        int b = x % (int) Math.pow(10, m);      // bottom half

        // 4) Split y into: c and d
        int c = y / (int) Math.pow(10, m);      // top half
        int d = y % (int) Math.pow(10, m);      // bottom half

        // recursively compute the products

        int ac = karatsubaMultiplication(a,c);
        int bd = karatsubaMultiplication(b,d);
        int abcd = karatsubaMultiplication((a+b),(c+d));

        //Gauss's trick

        int middleTerm = abcd - ac - bd;

        //Returning result *
        return (int) (ac * Math.pow(10, 2 * m) + middleTerm * Math.pow(10,m) + bd);
    }


    private static int numDigits(int value) {
        // A quick way to get digit count:
        // if value=0, we define numDigits=1 for safety
        if (value == 0) {
            return 1;
        }
        return (int) Math.floor(Math.log10(value)) + 1;
    }
}
