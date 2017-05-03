import java.util.Random;


public class Changer {

	public static void main(String[] args){
		int lightNum = 3;
		int failure = 0;
		int[] previousToState = new int[9];
//		int[] state = new int[3];		
		
		//run times
		for(int k=0;k<1000;k++){
//			StateChanger changer = new ParaSeriesChanger(lightNum, 10);
			ParaSeriesChanger.changer = new ParaSeriesChanger(3,10);
			Random rnd = new Random();
			int currentState = 0;
			int previous = 0;
			//ticks
			for(int i=0;i<1000;i++){
				ParaSeriesChanger.changer.tick(rnd.nextInt(lightNum+3));
//				ParaSeriesChanger.changer.tick(rnd.nextInt(lightNum+3));
//				States paraA = ParaSeriesChanger.changer.states.get(0);
//				States paraB = ParaSeriesChanger.changer.states.get(1);
//				States series = ParaSeriesChanger.changer.states.get(2);

//				System.out.println(i+" "+paraA+" "+paraB+" "+series);
			
/*Totally 5 states: 1. Full Functional; 2. Half Functional; 3. Nonfunctional
Transition could be 1->1;1->2;1->3;2->1;2->2;2->3;3->1;3->2;3->3*/
				
				currentState = ParaSeriesChanger.currentState();
//				System.out.println(currentState);
				if(currentState == 3){
					failure++;
				}
				
//				if((paraA.equals(States.FUNCTIONAL)||paraB.equals(States.FUNCTIONAL))&&series.equals(States.FUNCTIONAL)){
////					System.out.println(" => T");
//					if(paraA.equals(States.FUNCTIONAL)&&paraB.equals(States.FUNCTIONAL)&&series.equals(States.FUNCTIONAL)){
////						state[0]++;
//						currentState = 1;
//					}else{
////						state[1]++;
//						currentState = 2;
//					}
//				}else{
////					System.out.println(" => F");
////					state[2]++;
//					currentState = 3;
//					failure++;
//				}
//				System.out.println(i+" "+paraA+" "+paraB+" "+series+" "+currentState);
				if(previous==1){
					if(currentState==1){previousToState[0]++;}else if(currentState==2){previousToState[1]++;}else if(currentState==3){previousToState[2]++;}
				}else if(previous==2){
					if(currentState==1){previousToState[3]++;}else if(currentState==2){previousToState[4]++;}else if(currentState==3){previousToState[5]++;}
				}else if(previous==3){
					if(currentState==1){previousToState[6]++;}else if(currentState==2){previousToState[7]++;}else if(currentState==3){previousToState[8]++;}
				}
				previous = currentState;
			}
			
			
			
		}
/*For Markov Model*/
		System.out.println("1->1 " + (double)previousToState[0]/(previousToState[0]+previousToState[1]+previousToState[2])*100 + "%");
		System.out.println("1->2 " + (double)previousToState[1]/(previousToState[0]+previousToState[1]+previousToState[2])*100 + "%");
		System.out.println("1->3 " + (double)previousToState[2]/(previousToState[0]+previousToState[1]+previousToState[2])*100 + "%");
		System.out.println("2->1 " + (double)previousToState[3]/(previousToState[3]+previousToState[4]+previousToState[5])*100 + "%");
		System.out.println("2->2 " + (double)previousToState[4]/(previousToState[3]+previousToState[4]+previousToState[5])*100 + "%");
		System.out.println("2->3 " + (double)previousToState[5]/(previousToState[3]+previousToState[4]+previousToState[5])*100 + "%");
		System.out.println("3->1 " + (double)previousToState[6]/(previousToState[6]+previousToState[7]+previousToState[8])*100 + "%");
		System.out.println("3->2 " + (double)previousToState[7]/(previousToState[6]+previousToState[7]+previousToState[8])*100 + "%");
		System.out.println("3->3 " + (double)previousToState[8]/(previousToState[6]+previousToState[7]+previousToState[8])*100 + "%");
		
/*For test Markov Model*/
//		System.out.println("state1 "+state[0]+" state2 "+state[1]+" state3 "+state[2]);
//		System.out.println("1->1 "+previousToState[0]+" 2->2 "+previousToState[4]+" 3->3 "+previousToState[8]);
//		System.out.println("1->2 "+previousToState[1]+" 2->3 "+previousToState[5]+" 3->2 "+previousToState[7]);
//		System.out.println("1->3 "+previousToState[2]+" 2->1 "+previousToState[3]+" 3->1 "+previousToState[6]);

/*For Random Testing*/
		System.out.println("Nonfunctional count: " + failure);
		System.out.println("Nonfunctional propability: " + (double)failure/1000000*100 + "%");
	}
}
