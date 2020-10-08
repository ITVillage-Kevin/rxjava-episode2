package com.itvillage.section02;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * onError 이벤트 발생 전에 호출되는 doOnError 의 사용 예제
 */
public class DoOnErrorExample {
    public static void main(String[] args) {
        Observable.just(3, 6, 9, 12, 15, 20)
                .zipWith(Observable.just(1, 2, 3, 4, 0, 5), (a, b) -> a / b)
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR, "# 생산자: 에러 발생 - " + error.getMessage()))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
    }
}
