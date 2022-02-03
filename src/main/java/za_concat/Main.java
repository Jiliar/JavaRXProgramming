package za_concat;

import io.reactivex.Observable;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        exConcat();
        exConcatWith();
        exConcatMap();
    }

    public static void exConcat() {
        System.out.println("---Concat---");
        Observable<Integer> observable1 = Observable.just(1,2,3,4,5);
        Observable<Integer> observable2 = Observable.just(6,7,8,9,10);
        Observable.concat(observable1,observable2)
                .subscribe(System.out::println);
    }

    public static void exConcatWith(){

        System.out.println("---ConcatWith---");
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .takeWhile(item->item<3)
                .map(item -> "Observable 1: "+item);

        Observable<String> observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(5)
                .map(item -> "Observable 2: "+item);

        observable1.concatWith(observable2)
                .subscribe(System.out::println);

        pause(10000);
    }

    //concatMap() needs a Function that extends to ObservableSource like arguments
    public static void exConcatMap(){
        System.out.println("---ConcatMap---");
        Observable<String> observable1 = Observable.just("foo","bar","jam");
        observable1.concatMap(item-> Observable.fromArray(item.split("")))
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
