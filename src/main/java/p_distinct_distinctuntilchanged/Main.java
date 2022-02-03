package p_distinct_distinctuntilchanged;

import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedSelector();
        distinctUntilChangedWithKeySelector();
    }

    //Method returns Observable elements without duplicities
    public static void distinctOperator(){
        Observable.just(1,1,2,2,3,3,4,5,1,2)
                .distinct()
                .subscribe(System.out::println);
    }

    //Method returns Observable elements with different lengths
    public static void distinctWithKeySelector(){
        Observable.just("foo","fool","super","foss","foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    //Method returns Observable elements without consecutive duplicities
    public static void distinctUntilChangedSelector(){
        Observable.just(1,1,2,2,3,3,4,5,1,2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    //Method returns Observable elements without consecutive duplicities considering length of String elements
    public static void distinctUntilChangedWithKeySelector(){
        Observable.just("foo","fool","super","foss","foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }
}
