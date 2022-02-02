package l_disposable_compositedisposable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        handleDisposable();
        handleDisposableInObserver();
        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    public static void handleDisposable(){
        /*
        * public interface Disposable{
        * void dispose();
        * boolean isDisposed();
        * }
        * */
        System.out.println("--- Disposable ---");
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        pause(3000);
        disposable.dispose();
        pause(3000);
    }
    public static void handleDisposableInObserver(){
        System.out.println("--- Disposable In Observer ---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        Observer<Integer> observer = new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                if(integer == 3){
                    disposable.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
    public static void handleDisposableOutsideObserver() {
        System.out.println("--- Disposable Outside Observer ---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>() {

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {}

            @Override
            public void onComplete() {}
        };
        Disposable d = observable.subscribeWith(observer);
    }
    public static void compositeDisposable(){
        System.out.println("--- Composite Disposable ---");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item-> System.out.println("Observer 1: "+item));
        Disposable disposable2 = observable.subscribe(item-> System.out.println("Observer 2: "+item));
        compositeDisposable.addAll(disposable1, disposable2);
        pause(3000);
        compositeDisposable.delete(disposable1);
        compositeDisposable.delete(disposable2);
        pause(3000);
    }

    public static void pause(int duration){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
