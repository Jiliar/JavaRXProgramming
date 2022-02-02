package a_introduction;

import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .subscribe(System.out::println);
        Observable.just(1,2,3,4,5)
                .subscribe(integer -> {
                    System.out.println(integer);
                });
    }
}
