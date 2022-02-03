package v_do_action;


import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        exDoOnSubscribe();
        exDoOnNext();
        exDoOnCompleted();
    }

    //doOnSubscribe(): is used in case that we need to do something before will be to cancel de subscription.
    public static void exDoOnSubscribe(){
        System.out.println("\n---doOnSubscribe---");
        Observable.just(1,2,3,4,5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: ¡Subscribed!"))
                .subscribe(System.out::println);
    }

    //OnNext(): is used in case that we need to do some actions or configurations before to complete subscription.
    public static void exDoOnNext(){
        System.out.println("\n---doOnNext---");
        Observable.just(64,65,65,67,68)
                .doOnNext(item -> {
                    char c = (char) item.intValue();
                    System.out.println("doOnNext: Casting to char before show data: "+c);
                })
                .subscribe(System.out::println);
    }

    /*doOnComplete(): is used in case that we need to do some actions or configurations
     before to complete subscription. It's similar to onNext() but if we define both methods first will run onNext()
     */
    public static void exDoOnCompleted(){
        System.out.println("\n---doOnCompleted---");
        Observable.just(1,2,3,4,5)
                .doOnComplete(()->System.out.println("doOnCompleted : Casting to char before show data: "))
                .subscribe(System.out::println, System.out::println, ()->{System.out.println("¡Subscription is Completed!");});
    }
}
