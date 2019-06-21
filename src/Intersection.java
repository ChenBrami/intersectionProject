import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private int t;
    //order of lights is according to this: north -> east -> south -> west
    private Headlight north;
    private Headlight east;
    private Headlight south;
    private Headlight west;
    private Queue<Headlight> headLightsQueue;
    private Headlight currLightOn;
    private int countTimeUnits;

    public Intersection(){
        t = 0;
        east = new Headlight();
        north = new Headlight();
        west = new Headlight();
        south = new Headlight();
        headLightsQueue = new LinkedList();
        countTimeUnits = 0;
    }

    public void checkSensors(){
        east.checkSensor();
        north.checkSensor();
        west.checkSensor();
        south.checkSensor();
        if (north.getSensor() & !headLightsQueue.contains(north) & currLightOn != north)
            headLightsQueue.add(north);
        if (east.getSensor() & !headLightsQueue.contains(east) & currLightOn != east)
            headLightsQueue.add(east);
        if (south.getSensor() & !headLightsQueue.contains(south) & currLightOn != south)
            headLightsQueue.add(south);
        if (west.getSensor() & !headLightsQueue.contains(west) & currLightOn != west)
            headLightsQueue.add(west);
    }

    public void operateLights(){
        /**
         It will start by adding 1 to the time unit.
         Check and update the sensors of each of the headlights.
         And update the next stage that the headlights should be in.
         **/
        t=t+1;
        checkSensors();
        updateHeadlights();

        //If none of the lights is waiting to be turned on - that is if no sensor recognizes a car.
        if (headLightsQueue.isEmpty()) {
            //if one of the lights is on and it's sensor is off
            if (OneOfTheLightsIsOn() && !currLightOn.getSensor()) {
                    currLightOn.turnOffLight();
            }
        }
        //If there's a light in the queue
        else {
            //If all of the lights are currently red.
            if (!OneOfTheLightsIsOn()){
                currLightOn = headLightsQueue.poll();
                currLightOn.turnOnLight();
            }
            //If one of the lights *IS NOT* red
            else {
                //If the light that is currently on has its sensor "ON" - that means there is another car waiting in line
                if(currLightOn.getSensor()){
                    /**
                     To prevent cars from waiting infinitely for the light to go on, if there's a car waiting on the other light and the current
                    light has been on for over 10 time units, it will turn off and be added to the lights queue again.
                     **/
                    if (countTimeUnits<10){
                        countTimeUnits++;
                    }
                    else {
                        currLightOn.turnOffLight();
                        //To allow counting the time units for every light again- once the light turns yellow the count will reset.
                        if (currLightOn.getColor().equals("YELLOW")){
                            countTimeUnits=0;
                            return;
                        }
                        else{
                            countTimeUnits++;
                            return;
                        }
                    }
                }
                //If the light that is currently on has its sensor "OFF" - that means there are no other cars waiting in line.
                else{
                    currLightOn.turnOffLight();
                    return;
                }
            }
        }
    }

    public boolean OneOfTheLightsIsOn(){
        boolean retVal=false;
        if (!east.getColor().equals("RED") | !north.getColor().equals("RED") | !west.getColor().equals("RED") | !south.getColor().equals("RED"))
            retVal = true;
        return retVal;
    }

/**
    public int getT(){
        return t;
    }
**/

    public void addCar(Headlight direction){
        direction.addCar();
    }

    public Headlight getEast() {
        return east;
    }

    public Headlight getNorth() {
        return north;
    }

    public Headlight getSouth() {
        return south;
    }

    public Headlight getWest() {
        return west;
    }

    public void updateHeadlights(){
        east.update();
        west.update();
        north.update();
        south.update();
    }
}
