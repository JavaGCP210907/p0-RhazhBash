package com.revature.dao;

import java.util.List;

import com.revature.obj.Challenger;

public interface ChallengerDAOInterface {
	
	public List<Challenger> GetChallengers(); //Outputs all challengers

	public Challenger ChallengerWin(Challenger brendan); //Increments the challenger's badge count and total challenges
	
	public Challenger ChallengerLoss(Challenger red); //Increments the challenger's total challenges
	
	public Challenger ChallengerIsEligible(Challenger rosa); //Sets challenger_e4_eligibility to true
	
	public void AddChallenger(Challenger dawn); //Adds a challenger 
		
	public void ChallengerInfo(Challenger ethan); //Shows a challenger's full name, badge count, total challenges, and e4 eligibility
}
