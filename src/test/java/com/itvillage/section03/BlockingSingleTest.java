package com.itvillage.section03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * blockingSingle을 사용한 통지된 첫번째 데이터를 테스트하는 예제
 */
public class BlockingSingleTest {

    // A 지점의 월간 매출 중에 30,000,000원 이상인 매출액의 첫번째 데이터를 테스트
    @Test
    public void totalSalesOfBranchATest(){
        int actual = SampleObservable.getSalesOfBranchA()
                            .filter(sale -> sale > 30_000_000)
                            .take(1)
                            .blockingSingle();

        assertThat(actual, is(35_000_000));
    }

    // A 지점의 월간 매출 중에 30,000,000원 이상인 매출액의 첫번째 데이터를 테스트
    @Test(expected = IllegalArgumentException.class)
    public void totalSalesOfBranchATest2(){
        SampleObservable.getSalesOfBranchA()
                .filter(sale -> sale > 30_000_000)
                .take(2)
                .blockingSingle();
    }
}
