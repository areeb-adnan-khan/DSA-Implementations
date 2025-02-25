package com.learn.algorithms.multiplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KaratsubaTest {

    Karatsuba karatsuba = new Karatsuba();

    @Test
    void testKaratsubaSimple(){
        int result = karatsuba.karatsubaMultiplication(1234, 5678);
        Assertions.assertEquals(7006652, result);
    }

    @Test
    void testKaratsubaSmallNumbers(){
        int result = karatsuba.karatsubaMultiplication(12, 12);
        Assertions.assertEquals(144, result);
    }
}