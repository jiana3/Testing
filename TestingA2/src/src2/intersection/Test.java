package src2.intersection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

import src1.intersection.Intersection;
import src1.intersection.LightColour;

public class Test {

	public static void main(String [] args)throws IOException{
		
	    //create the input from a character buffer
	char[] buf = new char []{'E', 'C', 'E', 'E', 'E'};
	char[] ticks = new char[1000];
//	char[] ticks;
//	Scanner keyboard = new Scanner(System.in);
//	System.out.println("Choose the amount of tick:");
//	System.out.println("1. 100");
//	System.out.println("2. 1000");
//	System.out.println("3. 10000");
//	int chose = keyboard.nextInt();

//	switch(chose){
//	case 1: ticks = new char[100];
//	break;
//	case 2: ticks = new char[1000];
//	break;
//	case 3: ticks = new char[10000];
//	break;
//	}

	for(int i=0;i<ticks.length;i++){
		int rnd = new Random().nextInt(buf.length);
		ticks[i]=buf[rnd];
	}

	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

	String correctness = null;
	int falseTimes = 0;
	int correctTimes = 0;
	int state = 0;
	

	/*Total 5 state: 1. Fully operational; 2. South-facing degraded; 3. North-facing degraded; 4. Bidirectional degraded; 5. Failed
	So the transition could be: 1->2; 1->3; 1->4; 1->5; 2->1; 2->3; 2->4; 2->5; 3->1; 3->2; 3->4; 3->5; 4->1; 4->2; 4->3; 4->5; 5->1; 5->2; 5->3; 5->4. */
	int[] states = new int[5];
	int[] previousToState = new int[20];
	
	for(int runTimes = 1000; runTimes>0;runTimes--){
		int previous = 0;
		Intersection intersection = new Intersection();
	for (int tick = 0; tick < ticks.length; tick++) {
		
	  intersection.tick(ticks[tick]);
	
	  LightColour northLightA = intersection.getNorthLightA().getColour();
	  LightColour northLightB = intersection.getNorthLightB().getColour();
	  LightColour southLightA = intersection.getSouthLightA().getColour();
	  LightColour southLightB = intersection.getSouthLightB().getColour();
	  LightColour minorRoadLight = intersection.getMinorRoadLight().getColour();

//	  String lightsAsString = "([" + northLightA + ", " + northLightB + "], " + 
//	  "[" + southLightA + ", " + southLightB + "], " + minorRoadLight + ")";
	if((northLightA==LightColour.GREEN||northLightB==LightColour.GREEN)&&(southLightA==LightColour.GREEN||southLightB==LightColour.GREEN)&&minorRoadLight==LightColour.RED||
			(northLightA==LightColour.AMBER||northLightB==LightColour.AMBER)&&(southLightA==LightColour.AMBER||southLightB==LightColour.AMBER)&&minorRoadLight==LightColour.RED||
			(northLightA==LightColour.RED||northLightB==LightColour.RED)&&(southLightA==LightColour.RED||southLightB==LightColour.RED)&&minorRoadLight==LightColour.GREEN||
			(northLightA==LightColour.RED||northLightB==LightColour.RED)&&(southLightA==LightColour.RED||southLightB==LightColour.RED)&&minorRoadLight==LightColour.AMBER||
			(northLightA==LightColour.RED||northLightB==LightColour.RED)&&(southLightA==LightColour.RED||southLightB==LightColour.RED)&&minorRoadLight==LightColour.RED){
		if(northLightA==LightColour.NONE||northLightB==LightColour.NONE){
			if(southLightA==LightColour.NONE||southLightB==LightColour.NONE){
				state = 4;
				states[3]++;
			}else{
				state = 3;
				states[2]++;
			}
		}else if(southLightA==LightColour.NONE||southLightB==LightColour.NONE){
			state = 2;
			states[1]++;
		}else if(northLightA!=minorRoadLight){
			state = 1;
			states[0]++;
		}
		correctness = "True";
	}else{
		correctness = "False";
		state = 5;
		states[4]++;
	}
	
		if(previous==1){
			if(state==2){previousToState[0]++;}else if(state==3){previousToState[1]++;}else if(state==4){previousToState[2]++;}else if(state==5){previousToState[3]++;}
		}else if(previous==2){
			if(state==1){previousToState[4]++;}else if(state==3){previousToState[5]++;}else if(state==4){previousToState[6]++;}else if(state==5){previousToState[7]++;}
		}else if(previous==3){
			if(state==1){previousToState[8]++;}else if(state==2){previousToState[9]++;}else if(state==4){previousToState[10]++;}else if(state==5){previousToState[11]++;}
		}else if(previous==4){
			if(state==1){previousToState[12]++;}else if(state==2){previousToState[13]++;}else if(state==3){previousToState[14]++;}else if(state==5){previousToState[15]++;}
		}/*else if(previous==5){
			if(state==1){previousToState[16]++;}else if(state==2){previousToState[17]++;}else if(state==3){previousToState[18]++;}else if(state==4){previousToState[19]++;}
		}*/

	previous = state;
//	  out.print("tick(" + tick + ") = ");
//	  out.println("(" + ticks[tick] + ", " + lightsAsString + " => " + correctness + " " + state);
	
	}
	if(correctness.equals("False")){falseTimes++;}else if(correctness.equals("True")){correctTimes++;}

//		for(int i=0;i<previousToState.length;i++){
//			out.println(previousToState[i]);
//			totalTrans=totalTrans+previousToState[i];
//	}




	
	}
	out.println("1->2 " + (double)previousToState[0]/states[0]*100 + "%");
	out.println("1->3 " + (double)previousToState[1]/states[0]*100 + "%");
	out.println("1->4 " + (double)previousToState[2]/states[0]*100 + "%");
	out.println("1->5 " + (double)previousToState[3]/states[0]*100 + "%");
//	out.println("2->1 " + (double)previousToState[4]/states[1]*100 + "%");
//	out.println("2->3 " + (double)previousToState[5]/states[1]*100 + "%");
	out.println("2->4 " + (double)previousToState[6]/states[1]*100 + "%");
	out.println("2->5 " + (double)previousToState[7]/states[1]*100 + "%");
//	out.println("3->1 " + (double)previousToState[8]/states[2]*100 + "%");
//	out.println("3->2 " + (double)previousToState[9]/states[2]*100 + "%");
	out.println("3->4 " + (double)previousToState[10]/states[2]*100 + "%");
	out.println("3->5 " + (double)previousToState[11]/states[2]*100 + "%");
//	out.println("4->1 " + (double)previousToState[12]/states[3]*100 + "%");
//	out.println("4->2 " + (double)previousToState[13]/states[3]*100 + "%");
//	out.println("4->3 " + (double)previousToState[14]/states[3]*100 + "%");
	out.println("4->5 " + (double)previousToState[15]/states[3]*100 + "%");
//	out.println("5->1 " + (double)previousToState[16]/states[4]*100 + "%");
//	out.println("5->2 " + (double)previousToState[17]/states[4]*100 + "%");
//	out.println("5->3 " + (double)previousToState[18]/states[4]*100 + "%");
//	out.println("5->4 " + (double)previousToState[19]/states[4]*100 + "%");
	double falsePro = (double)falseTimes/1000;
	out.println("Correct case: " + correctTimes);
	out.println("False probability: " + falsePro*100 + "%");
	out.close();
	}
	
}
