package e_observable_error;

import io.reactivex.Observable;

public class Main {

    public static void main(String arg[]){
        throwException();
        throwExceptionUsingCallable();
    }

    //Observers have the same behavior because each one connects to the same Observable.
    public static void throwException(){
        System.out.println("throw Exception without Callable");
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error->System.out.println("Error 1: "+error.hashCode()));
        observable.subscribe(System.out::println, error->System.out.println("Error 2: "+error.hashCode()));
    }

    /*In this case we will get different Exceptions instances in observers, because we are using a lambda function,
    *every time passing lambda like arguments in error method Callable throw a new Exception*/
    public static void throwExceptionUsingCallable(){
        System.out.println("throw Exception using Callable");
        Observable observable = Observable.error(()->new Exception("An Exception"));
        observable.subscribe(System.out::println, error->System.out.println("Error 1: "+error.hashCode()));
        observable.subscribe(System.out::println, error->System.out.println("Error 2: "+error.hashCode()));
    }
}
