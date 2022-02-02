package h_defer;

import io.reactivex.Observable;

public class Main {

    private static int start = 5, count = 2;

    //We can update count value for range method using defer() method
    public static void main(String[] args) {

        Observable<Integer> observable = Observable.defer(()->{
                        System.out.println("New Observable is created with start = "+start+" and count = "+count);
                        return Observable.range(start,count);
                    });

        observable.subscribe(item->System.out.println("Observer 1 "+item));
        count = 3;
        observable.subscribe(item->System.out.println("Observer 2 "+item));

    }

}
