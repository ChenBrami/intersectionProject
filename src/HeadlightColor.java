public class HeadlightColor  {
    private String color;
    private boolean currChangeOn;
    private boolean currChangeOff;
    private int blinkCount;

    public HeadlightColor(){
        color = "RED";
        currChangeOn = false;
        currChangeOff = false;
        blinkCount = 0;
    }

    public void turnOffLight(){
        currChangeOff = true;
        currChangeOn = false;
        //update();
    }

    public void update(){
        if (currChangeOn){
            if (color.equals("RED"))
                color = "YELLOW + GREEN";
            else if (color.equals("YELLOW + GREEN")) {
                color = "GREEN";
                currChangeOn = false;
            }
        }
        else if (currChangeOff){
            if (color.equals("GREEN")) {
                color = "BLINKING GREEN";
                blinkCount = blinkCount + 1;
            }
            else if (color.equals("BLINKING GREEN") & blinkCount<2){
                blinkCount = blinkCount + 1;
            }
            else if (color.equals("BLINKING GREEN") & blinkCount==2){
                color = "YELLOW";
                blinkCount = 0;
            }
            else if (color.equals("YELLOW")) {
                color = "RED";
                currChangeOff = false;
            }
        }

    }

    public void turnOnLight(){
        currChangeOn = true;
        currChangeOff = false;
        //update();
    }

    public String getColor(){
        return color;
    }
}
