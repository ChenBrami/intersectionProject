import java.util.LinkedList;
import java.util.Queue;

public class Headlight {
    private static HeadlightColor currColor;
    private static boolean sensor;
    private static Queue<HeadlightColor> cars;

    public void Headlight(){
        currColor = new HeadlightColor();
        sensor = false;
        cars = new LinkedList();
    }

    public void turnOffLight(){
        currColor.turnOffLight();
    }

    public void turnOnLight(){
        currColor.turnOnLight();
    }

    public void checkSensor(){
        if (cars.isEmpty())
            sensor = false;
        else
            sensor = true;
    }

    public boolean getSensor(){
        return sensor;
    }

    public String getColor(){
        return currColor.getColor();
    }
}
