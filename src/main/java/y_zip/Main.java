package y_zip;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        exZip();
        exZipWith();
        exZipIterable();
    }

    //zip(): allow to compress some observables and doing operations with these.
    public static void exZip(){
        System.out.println("---Zip---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> sixToTen = Observable.range(6,5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(Arrays.asList(11,12,13,14,15));
        Observable.zip(oneToFive, sixToTen, elevenToFifteen, (a,b,c) -> a*b*c)
                .subscribe(System.out::println);
    }

    public static void exZipWith(){
        System.out.println("---ZipWith---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> sixToTen = Observable.range(6,5);
        oneToFive.zipWith(sixToTen, Integer::sum)
                .subscribe(System.out::println);
    }

    public static void exZipIterable(){
        System.out.println("---ZipIterable---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> sixToTen = Observable.range(6,5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(Arrays.asList(11,12,13,14,15));
        List<Observable<Integer>> observableList = Arrays.asList(oneToFive, sixToTen, elevenToFifteen);
        Observable.zipIterable(observableList, Arrays::toString, true, 1)
                .subscribe(System.out::println);
    }

}
