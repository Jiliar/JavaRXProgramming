package t_contains;


import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        containsWithPrimitive();
        containsWithNonPrimitive();
    }

    public static void containsWithPrimitive(){
        Observable.just(1,2,3,4,5)
                .contains(3)
                .subscribe(System.out::println);
    }

    public static void containsWithNonPrimitive(){
        User u = new User("Joe Biden");
        Observable.just(new User("Joe Biden"))// Is not the same
                .contains(u)
                .subscribe(System.out::println);
    }

}

class User{
    private String name;
    public User(String name){
        this.name = name;
    }
}
