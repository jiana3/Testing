import java.util.*;

/*  Created by Charles Talbot
*   Used to test state changes for Software Testing and Reliability's group assignment
*/
abstract class StateChanger
{
    public ArrayList<States> states;
    public int[] tickcount;
    public int maxticks;

    public StateChanger(int numStates, int maxticks){
      states = new ArrayList<States>();
      this.maxticks = maxticks;
      tickcount = new int[numStates];
      for(int i = 0 ; i < numStates ; i++ )
      {
        States state;
        state = States.FUNCTIONAL;
        states.add(state);
      }
    }    

    abstract void tick(int index);
}