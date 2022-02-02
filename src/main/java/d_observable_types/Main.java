package d_observable_types;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import static java.lang.Thread.sleep;

public class Main {



    public static void main(String[] args) {
        createColdObservable();
        createHotandConnectableObservable();
    }

    //In this method we can watch there are two separated emissions for observers 1 and two
    public static void createColdObservable(){
        Observable<Integer> observable = Observable.just(1,2,3,4,5);

        observable.subscribe(item ->{
            System.out.println("Cold Observer 1: "+item);
        });
        pause(5000);
        observable.subscribe(item ->{
            System.out.println("Cold Observer 2: "+item);
        });
    }

    /*Converting a Cold Observable to Hot Observable
    * publish() method can convert an observable to Connectable observable*/
    public static void createHotandConnectableObservable(){
        ConnectableObservable<Integer> observable = Observable.just(1,2,3,4,5).publish();
        //This kind of Observable starts the emission when call the connection's method
        observable.subscribe(item->{System.out.println("Connectable Observer 1: "+item);});
        observable.subscribe(item->{System.out.println("Connectable Observer 2: "+item);});
        observable.connect();
    }

    public static void pause(int duration){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
