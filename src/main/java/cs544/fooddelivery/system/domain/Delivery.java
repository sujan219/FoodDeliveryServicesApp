package cs544.fooddelivery.system.domain;

import java.util.Date;
import java.util.List;

public class Delivery {
	private int id;
	private Date date;
	private List<OrderLine> orderLines;
	
	public static void main(String[] args){
		//input from the user and other things 
		//you have the array with the subtracted value:
		int[] values = {-4, 1, -1, 3, 1};

		int[] extendedValues = new int[values.length*2-1];
		for(int i=0; i<extendedValues.length; ++i){
			extendedValues[i] = values[i%values.length];
		}

		int startIndex = 0;
		int cumulation = extendedValues[0];
		for(int i=1; i<extendedValues.length; ++i){
			if(cumulation < 0){
				cumulation = extendedValues[i];
				startIndex = i;
			}else{
				cumulation += extendedValues[i];
			}
		}

		if(startIndex < values.length){
			System.out.println(startIndex);
			//we have a solution and it is startIndex
		}else{
			System.out.println(-1);
			//we dont have any solution
		}
	}
}
