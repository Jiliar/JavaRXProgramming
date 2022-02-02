package n_take_skip_takewhile_skipwhile;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        takeOperator();
        takeWithInterval();
        takeWhileOperator();
        skipOperator();
        skipWhileOperator();
    }

    //This method returns the two first elements from observable
    public static void takeOperator(){
        System.out.println("---Take Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.take(2)
                  .subscribe(System.out::println);
    }

    //This method returns observable elements in function to time, when passing two seconds the flow of the observable will be completed.
    public static void takeWithInterval(){
        System.out.println("---Take with Interval---");
        Observable.interval(200, TimeUnit.MILLISECONDS)
                   .take(2, TimeUnit.SECONDS)
                   .subscribe(System.out::println,
                                error -> System.out.println(error.getLocalizedMessage()),
                                ()->System.out.println("¡Completed!"));
        pause(3000);
    }

    //This method returns observable elements that are less than 4
    public static void takeWhileOperator(){
        System.out.println("---Take while Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5,1,2,3,4,5);
        observable.takeWhile(item -> item < 4)
                .subscribe(System.out::println);
    }

    //This method returns observable elements with position greater than 2
    public static void skipOperator(){
        System.out.println("---Skip Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.skip(2)
                .subscribe(System.out::println);
    }

    //This method returns observable elements that are minor than 4 considering the first found position of elements
    public static void skipWhileOperator(){
        System.out.println("---Skip While Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5,1,2,3,4,5);
        observable.skipWhile(item -> item < 4)
                .subscribe(System.out::println);
    }

    public static void pause(int duration){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
