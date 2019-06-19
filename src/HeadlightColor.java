public class HeadlightColor  {
    private String color;
    public void HeadlightColor(){
        color = "RED";
    }

    public void turnOffLight(){
        //put in time value so that for every color it will be printed after 1 t unit
        color = "BLINKING GREEN";
        color = "YELLOW";
        color = "RED";
    }

    public void turnOnLight(){
        color = "YELLOW + GREEN";
        color = "GREEN";
    }

    public String getColor(){
        return color;
    }
}
