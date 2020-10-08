package com.itvillage.section03.class02;

import com.itvillage.section03.RxJavaTest;
import com.itvillage.common.CarMaker;
import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertValue를 이용한 데이터 검증 예제
 */
public class AssertValueTest01 extends RxJavaTest {
    @Test
    public void assertValueTest(){
        Observable.just("a")
                .test()
                .assertValue("a");
    }

    @Test
    public void getCarMakerAssertValueTest(){
        sampleObservable.getCarMakerStream()
                .filter(carMaker -> carMaker.equals(CarMaker.SAMSUNG))
                .test()
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValue(CarMaker.SAMSUNG);
    }
}
