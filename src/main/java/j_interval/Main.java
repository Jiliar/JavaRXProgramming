package j_interval;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    //Observers are Cold in this case
    public static void main(String[] args) {
        /*interval needs to maintain a cron to control this behavior*/
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(item -> System.out.println("Observer 1: "+item));
        //pause() method works like a main thread stopper
        pause(2000);
        observable.subscribe(item -> System.out.println("Observer 2: "+item));
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
