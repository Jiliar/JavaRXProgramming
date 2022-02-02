package k_single_maybe_completable;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class Main {

    public static void main(String[] args) {
        createSingle();
        createMaybe();
        createCompletable();
    }

    public static void createSingle(){
        /*
        * public interface SingleObserver<T>{
        * void onSubscribe(@NonNull Disposable d);
        * void onSuccess(@NonNull T t);
        * void onError(@NonNull Throwable e);
        * }
        * */
         Single.just(new User("Joe", "Biden"))
                .subscribe(System.out::println);
    }

    public static void createMaybe(){
        /*
         * public interface MaybeObserver<T>{
         * void onSubscribe(@NonNull Disposable d);
         * void onSuccess(@NonNull T t);
         * void onError(@NonNull Throwable e);
         * void onComplete();
         * }
         * */
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Object o) {

            }


            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
    public static void createCompletable(){
        /*
         * public interface CompletableObserver<T>{
         * void onSubscribe(@NonNull Disposable d);
         * void onComplete(@NonNull T t);
         * void onError(@NonNull Throwable e);
         * }
         * */
        Completable.fromSingle(Single.just(new User("Joe", "Biden")))
                .subscribe(()->System.out.println("Done"));
    }
}
