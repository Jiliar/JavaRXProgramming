package r_sorted;

import io.reactivex.Observable;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        useSorted();
        useSortedWithOwnComparator();
        useSortedOnNonComparator();
    }

    //This method returns 1,2,3,4,5 because Observable sort its elements using ascending way with sorted()
    public static void useSorted(){
        System.out.println("--- Sorted ---");
        Observable.just(3,5,2,4,1)
                .sorted()
                .subscribe(System.out::println);
    }

    //This method returns 5,4,3,2,1 because Observable sort its elements using reversed Comparator
    public static void useSortedWithOwnComparator(){
        System.out.println("--- Sorted using Comparator ---");
        Observable.just(3,5,2,4,1)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    //This method returns foo, bar, john because sorted criteria is length
    public static void useSortedOnNonComparator(){
        System.out.println("--- Sorted using Non Comparator ---");
        Observable.just("foo","john","bar")
                .sorted((first, second)->Integer.compare(first.length(), second.length()))
                .subscribe(System.out::println);
    }

}
