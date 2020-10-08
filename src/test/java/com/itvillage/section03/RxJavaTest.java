package com.itvillage.section03;

import org.junit.BeforeClass;

public class RxJavaTest {
    protected static SampleObservable sampleObservable;

    @BeforeClass
    public static void setup(){
        sampleObservable = new SampleObservable();
    }
}
