package src1.intersection;

public class Intersection
{
  //the traffic lights
  protected TrafficLight northLightA_;
  protected TrafficLight northLightB_;
  protected TrafficLight southLightA_;
  protected TrafficLight southLightB_;
  protected TrafficLight minorRoadLight_;

  //the left and right car sensors respectively
  protected Sensor leftSensor_;
  protected Sensor rightSensor_;

  public Intersection()
  {
    northLightA_ = new MajorRoadTrafficLight();
    northLightB_ = new MajorRoadTrafficLight();
    southLightA_ = new MajorRoadTrafficLight();
    southLightB_ = new MajorRoadTrafficLight();
    minorRoadLight_ = new MinorRoadTrafficLight();
    leftSensor_ = new Sensor();
    rightSensor_ = new Sensor();
  }

  //one tick of the intersection. If one of the sensors is activated,
  //change the signals on the lights.
  public void tick(char input)
  {
    northLightA_.tick();
    northLightB_.tick();
    southLightA_.tick();
    southLightB_.tick();
    minorRoadLight_.tick();
    leftSensor_.tick(input);
    rightSensor_.tick(input);

    if (leftSensor_.isActivated() || rightSensor_.isActivated()) {
      northLightA_.signalChange();
      northLightB_.signalChange();
      southLightA_.signalChange();
      southLightB_.signalChange();
      minorRoadLight_.signalChange();
    }
  }

  public TrafficLight getNorthLightA()
  {
    return northLightA_;
  }

  public TrafficLight getNorthLightB()
  {
    return northLightB_;
  }

  public TrafficLight getSouthLightA()
  {
    return southLightA_;
  }

  public TrafficLight getSouthLightB()
  {
    return southLightB_;
  }

  public TrafficLight getMinorRoadLight()
  {
    return minorRoadLight_;
  }

  public String toString()
  {
    return "([" + getNorthLightA() + ", " + getNorthLightB() + "], " +
      "[" + getSouthLightA() + ", " + getSouthLightB() + "], " +
      getMinorRoadLight() + ")";
  }
}
