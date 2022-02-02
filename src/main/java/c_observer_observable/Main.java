package c_observer_observable;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();
    }

    //Sequences
    private static void createObservableWithJust(){
        System.out.println("Observable using Just - Sequences");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(System.out::println);
    }

    //Lists
    private static void createObservableFromIterable(){
        System.out.println("Observable from Iterable - Lists");
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
    }

    private static void createObservableUsingCreate(){
        System.out.println("Observable using Create - Real time creation");
        Observable<Integer> observable = Observable.create(emitter-> {
            for(int i = 1; i <= 5; i++ ) {
                emitter.onNext(i);
            }
            //emitter.onNext(null); //Causing an error
            emitter.onComplete();
        });
        /*If Observable is completed then subscribers could show data,
          if observable is not completed subscribers will be waiting for it!
          For this reason developers need to validate process.*/
        observable.subscribe(item-> System.out.println(item),
                             error-> System.out.println("There was error: "+error.getLocalizedMessage()),
                             ()->System.out.println("Completed"));
    }

}
