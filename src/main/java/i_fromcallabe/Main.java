package i_fromcallabe;

import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        Observable<Integer> observable1 = Observable.just(getNumber1());
        observable1.subscribe(System.out::println,
                            error->System.out.println("An exception Ocurred "+error.getLocalizedMessage()));

        /*If I use getNumber2() method the next sentence cause an Exception if creating observable using just() method,
        but if we use fromCallable() we can give you another treatment without throw Exception but controlling data flow.*/
        Observable<Integer> observable2 = Observable.fromCallable(()->{
            System.out.println("Calling Method");
            return getNumber2();
        });
        observable2.subscribe(System.out::println,
                error->System.out.println("An exception Ocurred "+error.getLocalizedMessage()));
    }
    public static int getNumber1(){
        System.out.println("¡Generating Value!");
        return 3 * 5;
    }

    public static int getNumber2(){
        System.out.println("¡Generating Value!");
        return 1 / 0;
    }

}
