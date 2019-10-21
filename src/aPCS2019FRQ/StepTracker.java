package aPCS2019FRQ;

public class StepTracker {
	
	private int minStepsActive;
	private double totalNumOfDays = 0;
	private int totalNumOfSteps = 0;
	private int activeDays = 0;
	private double aveSteps = 0.0;
	
	public StepTracker(int m) {
		minStepsActive = m;
		
	}
	public void addDailySteps(int s) {
		totalNumOfDays += 1;
		totalNumOfSteps += s;
		if(minStepsActive <= s) {
			activeDays += 1;
		}
	}
	public int activeDays() {
		return activeDays;
	}
	public double averageSteps() {
		if(totalNumOfSteps != 0) {
			aveSteps = totalNumOfSteps / totalNumOfDays;
		}
		return aveSteps;
	}
}
