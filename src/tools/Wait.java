package tools;

public class Wait {

    public static void time(int milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }
        catch (InterruptedException e){}
    }

}
