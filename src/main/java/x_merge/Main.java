package x_merge;

import io.reactivex.Observable;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        exMerge();
        exMergeArray();
        exMergeIterable();
        exMergeWith();
        exMergeInfinite();
    }

    public static void exMerge(){
        System.out.println("---Merge---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> sixToTen = Observable.just(6,7,8,9,10);
        Observable.merge(oneToFive, sixToTen)
                 .subscribe(System.out::println);
    }
    public static void exMergeArray(){
        System.out.println("---MergeArray---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> sixToTen = Observable.just(6,7,8,9,10);
        Observable<Integer> elevenToFifteen = Observable.just(11,12,13,14,15);
        Observable<Integer> sixteenToTwenty = Observable.just(16,17,18,19,20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21,22,23,24,25);
        Observable.mergeArray(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive)
                .subscribe(System.out::println);
    }

    public static void exMergeIterable(){
        System.out.println("---MergeIterable---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> oneToTen = Observable.just(6,7,8,9,10);
        Observable<Integer> elevenToFifteen = Observable.just(11,12,13,14,15);
        Observable<Integer> sixteenToTwenty = Observable.just(16,17,18,19,20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21,22,23,24,25);
        List<Observable<Integer>> observableList = Arrays.asList(oneToFive, oneToTen, elevenToFifteen,
                                                                sixteenToTwenty, twentyOneToTwentyFive);
        Observable.merge(observableList)
                .subscribe(System.out::println);
    }

    public static void exMergeWith(){
        System.out.println("---MergeWith---");
        Observable<Integer> oneToFive = Observable.just(1,2,3,4,5);
        Observable<Integer> oneToTen = Observable.just(6,7,8,9,10);
        oneToFive.mergeWith(oneToTen)
                .subscribe(System.out::println);
    }

    public static void exMergeInfinite(){
        System.out.println("---MergeInfinite---");
        Observable<String> infinite1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item->"From infinite 1: "+item);
        Observable<String> infinite2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item->"From infinite 2: "+item);
        infinite1.mergeWith(infinite2)
                        .subscribe(System.out::println);
        pause(6000);
    }

    public static void pause(int duration){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
