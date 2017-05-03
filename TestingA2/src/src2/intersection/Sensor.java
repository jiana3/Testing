package src2.intersection;

public class Sensor
{
  //the types of input; either the car triggers the sensor or not
  final static protected char EMPTY = 'E';
  final static protected char CAR = 'C';

  //the probability of the light dropping out at each tick
  final protected static double FAILURE_PROBABILITY = 0.0D;

  //true if and only if this was activated in the previous tick
  protected boolean activated_;

  //the index of the current input
  protected int index_;

  public Sensor()
  {
    activated_ = false;
  }

  //one tick of the clock. Detect whether a signal has been received
  public void tick(char in)
  {
    detectSignal(in);
  }

  protected void detectSignal(char input)
  {
    activated_ = false;
    if (input == CAR && !Util.fail(FAILURE_PROBABILITY)) {
      activated_ = true;
    }
  }

  //return true if and only if the sensor was activated this tick
  public boolean isActivated()
  {
    boolean result = activated_;
    return result;
  }
}
