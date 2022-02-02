package g_range;


import io.reactivex.Observable;

public class Main {

    public static void main(String args[]){

        int start = 5, count = 3;
        Observable<Integer> observable = Observable.range(start,count);
        observable.subscribe(System.out::println);

    }

}
