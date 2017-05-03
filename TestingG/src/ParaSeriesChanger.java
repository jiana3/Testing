
public class ParaSeriesChanger extends StateChanger{

	static int current = 0;
	
	public ParaSeriesChanger(int numStates, int maxticks) {
		super(numStates, maxticks);
		// TODO Auto-generated constructor stub
	}

	static ParaSeriesChanger changer= new ParaSeriesChanger(3,10);
	
	@Override
	void tick(int index) {
		// TODO Auto-generated method stub
		if(index<states.size()){
		      if(states.get(index) == States.FUNCTIONAL)
		      {
		        states.set(index, States.NONFUNCTIONAL);
		        tickcount[index] = 1;
		      }else
		      {
		        states.set(index, States.FUNCTIONAL);
		        tickcount[index] = 0;
		      }      
		}
	}
	
	public static int currentState(){
		States paraA = changer.states.get(0);
		States paraB = changer.states.get(1);
		States series = changer.states.get(2);
		if((paraA.equals(States.FUNCTIONAL)||paraB.equals(States.FUNCTIONAL))&&series.equals(States.FUNCTIONAL)){
//			System.out.println(" => T");
			if(paraA.equals(States.FUNCTIONAL)&&paraB.equals(States.FUNCTIONAL)&&series.equals(States.FUNCTIONAL)){
				current = 1;
			}else{
				current = 2;
			}
		}else{
//			System.out.println(" => F");
			current = 3;
//			failure++;
		}
		return current;
	}

}
