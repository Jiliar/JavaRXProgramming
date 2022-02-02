package f_empty_and_never;

import io.reactivex.Observable;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    //This method is an additional way if we want to return null without cause error with complete
    /*USE CASE: If a user is searching data on database and query doesn't return anything instead of returning null
    * this method returns an empty observer point*/
    public static void createObservableUsingEmpty(){
        Observable<Integer> observable = Observable.empty();
        observable.subscribe(System.out::println,
                System.out::println,
                ()->System.out.println("Completed"));
    }
    //This method is very usefully if we don't want to notify to observers, observers continue waiting emissions Observable
    public static void createObservableUsingNever(){
        Observable<Integer> observable = Observable.never();
        observable.subscribe(System.out::println,
                System.out::println,
                ()->System.out.println("Completed"));
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
