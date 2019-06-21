public class Headlight {
    private HeadlightColor currColor;
    private boolean sensor;
    private int cars;
    private int timeUnitsForCars;

    public Headlight(){
        currColor = new HeadlightColor();
        sensor = false;
        cars = 0;
        timeUnitsForCars = 0;
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

    public void addCar(){
        cars++;
    }

    public int getCars(){
        return cars;
    }

    /**
     The update function will initiate the HeadlightColor update, and will update the cars as they pass the intersection.
     Every car takes two time units to go through the intersection, hence the timeUnitsForCars variable.
    **/

    public void update(){
        currColor.update();
        if (currColor.getColor().equals("GREEN")){
            timeUnitsForCars++;
            if (cars != 0 & timeUnitsForCars==2){
                cars--;
                timeUnitsForCars=0;
            }
        }
    }
}
