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
    //The entire turning off and on the lights function is managed by the update function and it relies on the boolean variable currChangeOff and currChangeOn.
    public void turnOffLight(){
        currChangeOff = true;
        currChangeOn = false;
    }

    public void turnOnLight(){
        currChangeOn = true;
        currChangeOff = false;
    }

    public void update(){
        /**
         If the light is set to turn on the light - it means that it is in the process of turning on the light.
         If the light is RED it will change it to YELLOW + GREEN, and if its YELLOW + GREEN it will change if to GREEN and
         inform the class that the process of turning on the light has ended.
        **/
        if (currChangeOn){
            if (color.equals("RED"))
                color = "YELLOW + GREEN";
            else if (color.equals("YELLOW + GREEN")) {
                color = "GREEN";
                currChangeOn = false;
            }
        }

        /**
         If the light is set to turn off the light - it means that it is in the process of turning off the light.
         if the light is GREEN it will change to BLINKING GREEN on which point you may chose to change the amount of
         time units it stays on BLINKING GREEN by changing the parameter compared to the blinkCount variable.
         Once the light has been blinking for --at this point 2 time units-- it will change to YELLOW, and from YELLOW
         to RED- on which point it will inform the class that the process of turning off the light has ended.
         **/
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

    public String getColor(){
        return color;
    }
}
