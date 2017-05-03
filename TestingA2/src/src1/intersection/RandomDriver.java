package src1.intersection;

import java.util.Random;

public class RandomDriver {

	public static void main(String[] args){
		char[] buf = new char []{'E', 'C', 'E', 'E', 'E'};
		char[] ten = new char[10];
		char[] hundred = new char[100];
		char[] thousand = new char[1000];
		char[] tenThousand = new char[10000];
		int c = 0;
		int e = 0;
//		System.out.println(buf[rnd]);
//		for(int i=0;i<ten.length;i++){
//			int rnd = new Random().nextInt(buf.length);
//			ten[i]=buf[rnd];
//			System.out.println(i+"=>"+ten[i]);
//		}
		for(int i=0;i<hundred.length;i++){
			int rnd = new Random().nextInt(buf.length);
			hundred[i]=buf[rnd];
			if(buf[rnd]=='E'){
				e++;
			}else if(buf[rnd]=='C'){
				c++;
			}
//			System.out.println(i+"=>"+hundred[i]);
		}
//		for(int i=0;i<thousand.length;i++){
//			int rnd = new Random().nextInt(buf.length);
//			thousand[i]=buf[rnd];
//			if(buf[rnd]=='E'){
//				e++;
//			}else if(buf[rnd]=='C'){
//				c++;
//			}
//			System.out.println(i+"=z>"+thousand[i]);
//		}
//		for(int i=0;i<tenThousand.length;i++){
//			int rnd = new Random().nextInt(buf.length);
//			tenThousand[i]=buf[rnd];
//			if(buf[rnd]=='E'){
//				e++;
//			}else if(buf[rnd]=='C'){
//				c++;
//			}
//			System.out.println(i+"=>"+tenThousand[i]);
//		}
		System.out.println("E =>" + e);
		System.out.println("C =>" + c);
//		System.out.println(2/2*100);
	}
	
}
