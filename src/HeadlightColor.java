public class HeadlightColor  {
    private String color;
    private boolean currChangeOn;
    private boolean currChangeOff;
    private int blinkCount;

    public void HeadlightColor(){
        color = "RED";
        currChangeOn = false;
        currChangeOff = false;
        blinkCount = 0;
    }

    public void turnOffLight(){
        currChangeOff = true;
        currChangeOn = false;
    }

    public void update(){
        if (currChangeOn){
            if (color == "RED")
                color = "YELLOW + GREEN";
            else if (color == "YELLOW + GREEN")
                color = "GREEN";
        }
        else if (currChangeOff){
            if (color == "GREEN") {
                color = "BLINKING GREEN";
                blinkCount = blinkCount + 1;
            }
            else if (color == "BLINKING GREEN" & blinkCount<2){
                blinkCount = blinkCount + 1;
            }
            else if (color == "BLINKING GREEN" & blinkCount==2){
                color = "YELLOW";
                blinkCount = 0;
            }
            else if (color == "YELLOW")
                color = "RED";
        }

    }

    public void turnOnLight(){
        currChangeOn = true;
        currChangeOff = false;
        color = "YELLOW + GREEN";
        color = "GREEN";
    }

    public String getColor(){
        return color;
    }
}
