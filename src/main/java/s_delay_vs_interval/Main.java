package s_delay_vs_interval;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        delay();
        delayError();
    }

    /*Used delay operator to add a delay before the Observable start emission*/
    public static void delay(){
        Observable.just(1,2,3,4,5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        pause(5000);
    }

    /*delay operator doesn't add any delay before emitting error*/
    public static void delayError(){
        Observable.error(new Exception("Error"))
                .delay(3000, TimeUnit.MILLISECONDS, true)
                .subscribe(System.out::println,
                        error->System.out.println(error.getLocalizedMessage()),
                        ()-> System.out.println("Completed"));
    }

    public static void pause(int duration){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
