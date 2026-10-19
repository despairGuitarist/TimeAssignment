package TA;
import java.util.*;
import java.time.*;

/**
 * TimeAssignment assigns a random 30-minute time block for a student and faculty between 8am-6pm (08:00-18:00), from start to end times.
 * 
 * @author Benjamin Huynh
 * @version 10/14/2026
 */
public class TimeAssignment 
{
	static Random rand = new Random();
	
	/**
	 * Generates a random start time from 8am-5:30pm (08:00-17:30)
	 * @return the generated start time
	 */
	public static LocalTime randomStartTime() 
	{
		int startHr = 8, endHr = 17;
		int hour = rand.nextInt(endHr - startHr + 1) + startHr;
        int minute = rand.nextInt(0, 2) * 30;
        return LocalTime.of(hour, minute);
    }
	
	/**
	 * Generates a random end time up to 6:00pm based off the start time
	 * @param startTime the time to use to randomly generate an end time
	 * @return the generated end time
	 */
	public static LocalTime randomEndTime(LocalTime startTime)
	{
		int endHr2 = 18;
		int minute2;
		int hour2 = rand.nextInt(startTime.getHour(), endHr2 + 1);
		
		if (startTime.getHour() == hour2)
		{
			if (startTime.getMinute() == 30)
			{
				hour2++;
				minute2 = 0;
			}
			else
			{
				minute2 = 30;
			}
		}
		else
		{
			if (hour2 == 18)
			{
				minute2 = 0;
			}
			else
			{
				minute2 = rand.nextInt(0, 2) * 30;
			}
		}
        return LocalTime.of(hour2, minute2);
	}
	
	/**
	 * Prints out a randomly generated start time as well as a randomly generated end time based on the start time
	 */
	public static void main(String[] args)
	{
		int reps = 500;
		
		for (int i = 0; i < reps; i++)
		{
			LocalTime start = randomStartTime();
			System.out.println(start.toString() + ", " + randomEndTime(start).toString());
		}
		
	}
}
