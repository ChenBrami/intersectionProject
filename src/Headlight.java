public class Headlight {
    private HeadlightColor currColor;
    private boolean sensor;
    private int cars;

    public void Headlight(){
        currColor = new HeadlightColor();
        sensor = false;
        cars = 0;
    }

    public void turnOffLight(){
        currColor.turnOffLight();
    }

    public void turnOnLight(){
        currColor.turnOnLight();
    }

    public void checkSensor(){
        if (cars == 0)
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
