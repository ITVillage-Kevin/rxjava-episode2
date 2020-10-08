package com.itvillage.section00;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample01 {
    public static void main(String[] args){
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.onNext(3000);
        subject.onNext(2500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 1 : " + price));
        subject.onNext(3500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 2 : " + price));
        subject.onNext(3300);

        subject.onComplete();

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT, "# 소비자 3 : " + price));

    }
}
