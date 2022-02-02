package b_threads;

public class Main {
    public static void main(String args[]){
        Thread thread = new Thread(Main::runIt);
        thread.start();
    }

    public static void runIt(){
        System.out.println("Hello World!");
    }
}
