package u_error_handling;

import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        exDoOnError();
        exOnErrorResumeNext();
        exOnErrorReturn();
        exOnErrorReturnItem();
        //exRetryWithPredicate();
        exRetry();
        exRetryUntil();
    }

    public static void exDoOnError() {
        System.out.println("\n ---DoOnError----");
        Observable.error(new Exception("This is an example error"))
                .doOnError(error-> System.out.println("DoOnError: "+error.getLocalizedMessage()))
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exOnErrorResumeNext(){
        System.out.println("\n ---OnErrorResumeNext----");
        Observable.error(new Exception("This is an example error"))
                .onErrorResumeNext(Observable.just(1,2,3,4,5))
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exOnErrorReturn(){
        System.out.println("\n ---OnErrorReturn----");
        Observable.error(new Exception("¡This is an example error!"))
                .onErrorReturn(error->{
                    if (error instanceof IOException) return 0;
                    else throw new Exception("¡This is a different Exception to IOException!");
                })
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exOnErrorReturnItem(){
        System.out.println("\n ---OnErrorReturnItem----");
        Observable.error(new Exception("This is an example error"))
                .onErrorReturnItem(new User("Joe", "Biden"))
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exRetryWithPredicate(){
        System.out.println("\n ---RetryWithPredicate----");
        Observable.error(new IOException("This is an example error"))
                .retry(error->{
                    if (error instanceof IOException){
                        System.out.println("retrying");
                        return true;
                    }else{
                        return false;
                    }
                })
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exRetry(){
        System.out.println("\n ---Retry----");
        Observable.error(new Exception("This is an example error"))
                .retry(3)
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }

    public static void exRetryUntil(){
        System.out.println("\n ---RetryUntil----");
        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.error(new Exception("This is an example error"))
                .doOnError(error ->{
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(()->{
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(System.out::println,
                        error->System.out.println("Subscribed Error: "+error.getLocalizedMessage()),
                        ()->System.out.println("¡Completed!"));
    }
}
