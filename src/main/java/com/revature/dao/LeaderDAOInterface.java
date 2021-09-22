package com.revature.dao;

import java.util.List;

import com.revature.obj.Leader;

public interface LeaderDAOInterface {
	
	public List<Leader> GetLeaders(); //Returns the leader table 

	public Leader LeaderWin(Leader flannery); //Increments the leader's win count and total challenges
	
	public Leader LeaderLoss(Leader winona); //Increments the leader's total challenges
	
	public Leader EditLeader(Leader wattson); //Fills a row with a new leader's info 
	
	public Leader DeleteLeader (Leader roxxane); //Blanks the name, badge, wins, challenges, and associated team field for a leader
	
	public void LeaderInfo(Leader brawly); //Returns info about a leader and their team from their ID
	
	public Leader EditTeam(Leader wallace); //Sets a team of 3 pokemon for a given leader
	
}
