class UserInputThread extends Thread{

    public void run(){
        
    }
}

class RunThread extends Thread{

    public void run(){

    }
}

public class Main {

    public static void Main (String args[]){
        System.out.println("Welcome to the Intersection simulator!");
        System.out.println("Time will start running ounce you print 'start'");
        System.out.println("If you would like to enter a car in front of one of the headLights:");
        System.out.println("     -For the western light enter: W");
        System.out.println("     -For the eastern light enter: E");
        System.out.println("     -For the southern light enter: S");
        System.out.println("     -For the northern light enter: N");
        System.out.println("At any time, if you would like to turn off the current light so it can move on to the next one, simply type 'change'");
        System.out.println("If you want to exit the program simply print 'exit'");
    }

    public static void run(Intersection inter){
        try {
            while (true) {
                //everything goes here
                Thread.sleep(1000);
                System.out.println(inter.getT());
                inter.operateLights();
            }
        }
        catch(Exception e) {
            System.out.println("Fekky fek");
        }
    }
}
