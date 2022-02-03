package w_dofinally_doondispose;

import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        exDoFinally();
        exDoOnDispose();
    }

    //DoFinally(): is used in case that we need to do some actions or configurations after to complete subscription.
    public static void exDoFinally(){
        Observable.just(1,2,3,4,5)
                .doFinally(()->System.out.println("¡doFinally: Completed!"))
                .subscribe(System.out::println);
    }

    //DoOnDispose(): is used in case that we need to do some actions or configurations after to complete subscription.
    public static void exDoOnDispose(){
        Observable.just(1,2,3,4,5)
                .doOnDispose(()->System.out.println("¡doOnDispose: Completed!"))
                .doOnSubscribe(disposable -> disposable.dispose())
                .subscribe(System.out::println);
    }
}
