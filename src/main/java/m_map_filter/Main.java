package m_map_filter;

import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        mapOperator();
        mapOperatorReturnsDifferentData();
        filterOperator();
        combineMapAndFilter();
    }

    //This method returns data from observable
    private static void mapOperator(){
        System.out.println("---Map Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.map(item -> item)
                .subscribe(System.out::println);
    }

    //This method returns data from observable multiplied by 2
    private static void mapOperatorReturnsDifferentData(){
        System.out.println("---Map Operator returns Different Data---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.map(item -> item*2)
                .subscribe(System.out::println);
    }

    //This method returns data from observable when data is greater than 2
    private static void filterOperator(){
        System.out.println("---Filter Operator---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.filter(x->x>2) //returns boolean
                .subscribe(System.out::println);
    }

    //This method returns data from observable multiplied by 2 and when data is greater than 4
    private static void combineMapAndFilter(){
        System.out.println("---Combine Map And Filter---");
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable
                .map(x->x*2)
                .filter(x->x>4)
                .subscribe(System.out::println);
    }
}
