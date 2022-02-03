package z_map_vs_flatmap;

import io.reactivex.Observable;

import java.util.Locale;

public class Main {


    /*The difference between flatMap and map method is that the flatMap needs a Function that extends to ObservableSource
    like arguments and map receive only function*/
    public static void main(String[] args) {
        exFlatMap();
        exFlatMapBiFunction();
        exMap();
        exMapWithObservable();
    }

    public static void exFlatMap(){
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable
                .flatMap((string)->Observable.fromArray(string.toUpperCase().split("")))
                .subscribe(System.out::println);
    }

    //This method returns characters that compound each String element
    public static void exFlatMapBiFunction(){
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable
                .flatMap(string->Observable.fromArray(string.toUpperCase().split("")),
                (actual, second)->actual +" "+second)
                .subscribe(System.out::println);
    }

    //This method returns element's lengths
    public static void exMap(){
        Observable<String> observable = Observable.just("foo", "bard", "james");
        observable
                .map(item ->item.length())
                .subscribe(System.out::println);
    }

    //This method can't return element on this way only returns references
    public static void exMapWithObservable(){
        Observable<String> observable = Observable.just("foo", "bard", "james");
        observable.map(item ->
            Observable.fromArray(item.toUpperCase().split(""))
        ).subscribe(System.out::println);
    }
}

