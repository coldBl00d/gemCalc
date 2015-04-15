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
                ***Delete constRester Read**
             */

        if ((float)i <= constTime[2])
            return (int)(((float)i - constTime[1]) / ((constTime[2] - constTime[1]) / (constGem[2] - constGem[1])) + constGem[1]);

        else
            return (int)(((float)i - constTime[2]) / ((constTime[3] - constTime[2]) / (constGem[3] - constGem[2])) + constGem[2]);
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
    public int resourceToGem ( float res )
    {
        int i=0;
        float constRes[] = {
                100F, 1000F, 10000F, 100000F, 1000000F, 10000000F
        };
        float constGem[] = {
                1.0F, 5F, 25F, 125F, 600F, 3000F
        };

        do
        {
            if (i >= -1 + constRes.length) //If the res entered is too large for the storage
            {
                if (res <= 8001000F)    // 4 gold collector maxed out storage is 8mil + 1000 from TH
                {                       // Had to be done separately since 10mil is a plateau value
                    return (int)(float)Math.round((res - constRes[4]) / ((constRes[5] - constRes[4]) / (constGem[5] - constGem[4])) + constGem[4]);
                } else
                {
                    return (int)0.0F;
                }
            }
            
            if (res <= constGem[i])
            {
                return (int)(float)Math.round((res - constGem[i - 1]) / ((constGem[i] - constGem[i - 1]) / (constRes[i] - constRes[i - 1])) + constRes[i - 1]);
            }
            i++;

           


        }while (true);


    }



}

