package com.akhilraj.clashofclangemcalculator;

/**
 * Created by Akhil on 14-04-2015.
 */
public class GemCalc {


    public int timeToGem ( int i ) // Passing Seconds
    {
        float constTime[]= {
                60F,3600F,86400F,604800F
        };

        float constGem[] ={
                1F,20F,260F,1000F
        };


        if (i==0)
            return 0;

        if ((float)i <= constTime[0])
            return 1;

        if ((float)i <= constTime[1])
            return (int)(((float)i - constTime[0]) / ((constTime[1] - constTime[0]) / (constGem[1] - constGem[0])) + constTime[0]);

            /*
               @Adithya Same stuff that you said but doing the multiplication (timeinSec-plateauTime) I was not getting the result (brackets scene aayi kaanum)
                So used overall division
                ***Delete After Read**
             */

        if ((float)i <= constTime[2])
            return (int)(((float)i - constTime[1]) / ((constTime[2] - constTime[1]) / (constGem[2] - constGem[1])) + constGem[1]);

        else
            return (int)(((float)i - constTime[2]) / ((constTime[3] - constTime[2]) / (constGem[3] - constGem[2])) + constGem[2]);
    }

}

/*Test Class
   Guys test if wrong

public class Test {


	public static void main (String [] a)
	{
		GemCalc cal = new GemCalc();

		System.out.println(cal.timeToGem(14400));
		System.out.println(cal.timeToGem(1));
		System.out.println(cal.timeToGem(7*24*3600));
	}

}

Output
51
1
1000

Correct
 */