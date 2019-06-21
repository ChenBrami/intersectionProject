import java.util.Scanner;

class UserInputThread extends Thread{

    private String userEntry;
    private String firstEntry;
    private boolean isExit;
    private Intersection intersection;

    public UserInputThread(Intersection intersection){
        this.intersection=intersection;
        isExit = false;
        userEntry = "";
        firstEntry = "";
    }

    public void run(){

    /**
     This functions is the main user input algorithm.
     Once the user enters "start" the program will begin to run and with it the time frame.
     While the program is running the user can freely enter cars to lines in front of specific lights.
     The function will update the car lines of each headlight in real time thanks to separation of threads.
     If the user enters something other that start or exit at the beginning the program will exit.
     **/

        System.out.println("Welcome to the Intersection simulator!");
        System.out.println("Time will start running ounce you print 'start'");
        System.out.println("If you would like to enter a car in front of one of the headLights:");
        System.out.println("     -For the western light enter: W");
        System.out.println("     -For the eastern light enter: E");
        System.out.println("     -For the southern light enter: S");
        System.out.println("     -For the northern light enter: N");
        System.out.println("If you want to exit the program simply print 'exit'");
        Scanner scanner = new Scanner(System.in);
        firstEntry = scanner.nextLine();
        System.out.println("THE USER ENTRY IS: " + firstEntry);
        if (firstEntry.equals("exit")) {
            isExit = true;
            return;
        }
        else if (firstEntry.equals("start")){
            while (!userEntry.equals("exit")){
                userEntry = scanner.nextLine();
                if (userEntry.equals("W")){
                    intersection.addCar(intersection.getWest());
                }
                else if (userEntry.equals("E")){
                    intersection.addCar(intersection.getEast());
                }
                else if (userEntry.equals("N")){
                    intersection.addCar(intersection.getNorth());
                }
                else if (userEntry.equals("S")){
                    intersection.addCar(intersection.getSouth());
                }
            }
        }
        else {
            isExit = true;
        }
    }

    public String getFirstEntry(){
        return firstEntry;
    }

    public String getUserEntry(){
        return userEntry;
    }

    public boolean isExit() {
        if (getFirstEntry().equals("exit") | getUserEntry().equals("exit"))
            isExit = true;
        else
            isExit = false;
        return isExit;
    }
}

class RunThread extends Thread{

    private Intersection intersection;
    private UserInputThread userInputThread;

    public RunThread(Intersection intersection){
        this.intersection=intersection;
    }
    /**
     Main run function.
     It will start the program and update the intersection every one T unit - in this case every 1000 msec.
     It will also print the current state of each headlight and the amount of cars waiting to enter the intersection.
     **/
    public void run(){
        userInputThread = new UserInputThread(intersection);
        userInputThread.start();
        try {
            while (!userInputThread.getFirstEntry().equals("start")){
                Thread.sleep(1000);
            }
            while (!userInputThread.isExit()) {
                Thread.sleep(1000);
                intersection.operateLights();
                System.out.println("E:" + intersection.getEast().getCars() + " W:" + intersection.getWest().getCars() + " S:" + intersection.getSouth().getCars() + " N:" + intersection.getNorth().getCars());
                System.out.println("E: " + intersection.getEast().getColor() + " W: " + intersection.getWest().getColor() + " S: " + intersection.getSouth().getColor() + " N: " + intersection.getNorth().getColor());
            }
        } catch (java.lang.InterruptedException e){

        }
    }
}

public class Main {



    public static void main (String args[]){
        Intersection intersection = new Intersection();
        RunThread runThread = new RunThread(intersection);
        runThread.start();

    }


}
