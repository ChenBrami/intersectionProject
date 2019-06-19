import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private int t;
    //order of lights is according to this: north -> west -> south -> east
    private Headlight north;
    private Headlight west;
    private Headlight south;
    private Headlight east;
    private Queue<Headlight> headLightsQueue;
    private Headlight currLightOn;

    public void Intersection(){
        t = 0;
        east = new Headlight();
        north = new Headlight();
        west = new Headlight();
        south = new Headlight();
        headLightsQueue = new LinkedList();
        //currLightOn = NULL;
    }

    public void checkSensors(){
        if (north.getSensor() & !headLightsQueue.contains(north))
            headLightsQueue.add(north);
        if (west.getSensor() & !headLightsQueue.contains(west))
            headLightsQueue.add(west);
        if (south.getSensor() & !headLightsQueue.contains(south))
            headLightsQueue.add(south);
        if (east.getSensor() & !headLightsQueue.contains(east))
            headLightsQueue.add(east);
    }

    public void operateLights(){
        while (!headLightsQueue.isEmpty()){
            if (OneOfTheLightsIsOn()){
                //if there has been 10 t's since the light is on than... wait until it turns of
                currLightOn.turnOffLight();
                headLightsQueue.add(currLightOn);
                currLightOn = headLightsQueue.poll();
            }
            else{
                currLightOn = headLightsQueue.poll();
                currLightOn.turnOnLight();
            }

        }
    }

    public boolean OneOfTheLightsIsOn(){
        boolean retVal=false;
        if (east.getColor()!="RED" | north.getColor()!="RED" | west.getColor()!="RED" | south.getColor()!="RED")
            retVal = true;
        return retVal;
    }
}
