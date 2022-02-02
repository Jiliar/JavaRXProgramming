package p_repeat_scan;

import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        useRepeat();
        useScan();
        useScanWithInitialValue();
    }

    //Method returns 1,2,3,4,5,1,2,3,4,5,1,2,3,4,5 because Observable elements are repeated 3 times.
    public static void useRepeat(){
        System.out.println("---Repeat---");
        Observable.just(1,2,3,4,5)
                  .repeat(3)
                  .subscribe(System.out::println);
    }
    //Method returns 1,3,6,10,15 because Observable elements showed and accumulated (show next and right after accumulator).
    public static void useScan(){
        System.out.println("---Scan---");
        Observable.just(1,2,3,4,5)
                .scan((accumulator, next)->accumulator+next) // we can remove initialValue if using 1
                .subscribe(System.out::println);
    }

    public static void useScanWithInitialValue(){
        System.out.println("---Scan with Initial Value---");
        Observable.just(1,2,3,4,5)
                .scan(10,(accumulator, next)->accumulator+next) // we can remove initialValue if using 1
                .subscribe(System.out::println);
    }
}
