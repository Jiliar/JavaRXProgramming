package o_defaultempty_switchifempty;


import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        useDefaultEmpty();
        useSwitchIfEmpty();
    }

    /*Method returns 100 because when Observable doesn't value to return anything then Observable will have a default
    value to return, in this case 100 is the value because this a defaultIfEmpty() argument*/
    public static void useDefaultEmpty(){
        Observable.just(1,2,3,4)
                .filter(item ->item > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    /*Method returns 6,7,8,9 because when Observable doesn't value to return anything then Observable will have a default
    Observable to return.*/
    public static void useSwitchIfEmpty(){
        Observable.just(1,2,3,4)
                .filter(item ->item > 10)
                .switchIfEmpty(Observable.just(6,7,8,9))
                .subscribe(System.out::println);
    }
}
