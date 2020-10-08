package com.itvillage.section03.class02;

import com.itvillage.section03.RxJavaTest;
import com.itvillage.utils.TimeUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertComplete를 이용하여 A 지점과 B 지점의 매출 합계 처리가 지정된 시간안에 끝나는지 검증하는 예제
 */
public class AssertCompleteTest extends RxJavaTest {
    @Test
    public void assertCompleteTest() {
        sampleObservable.getSalesOfBranchA()
                .zipWith(
                        sampleObservable.getSalesOfBranchB(),
                        (a, b) -> {
                            TimeUtil.sleep(100L);
                            return a + b;
                        }
                )
                .test()
                .awaitDone(3000L, TimeUnit.MILLISECONDS)
                .assertComplete();
    }
}
