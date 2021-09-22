package com.revature.obj;

public class Challenger {
	private int challenger_id;
	private String challenger_fname;
	private String challenger_lname;
	private int challenger_wins;
	private int challenger_challenges;
	private boolean challenger_e4_eligibility;
	
	public Challenger() {
		super();
	}
	
	public Challenger(int challenger_id, String challenger_fname, String challenger_lname, int challenger_wins, int challenger_challenges, boolean challenger_e4_eligibility) {
		super();
		this.challenger_id=challenger_id;
		this.challenger_fname=challenger_fname;
		this.challenger_lname=challenger_lname;
		this.challenger_wins=challenger_wins;
		this.challenger_challenges=challenger_challenges;
		this.challenger_e4_eligibility=challenger_e4_eligibility;
	}
	
	public Challenger(String challenger_fname, String challenger_lname) {
		super();
		this.challenger_fname=challenger_fname;
		this.challenger_lname=challenger_lname;
		this.challenger_wins=0;
		this.challenger_challenges=0;
		this.challenger_e4_eligibility=false;
	}
	
	public void setID(int challenger_id) {
		this.challenger_id=challenger_id;
	}
	
	public int getID() {
		return challenger_id;
	}
	
	public void setFName(String challenger_fname) {
		this.challenger_fname=challenger_fname;
	}
	
	public String getFName() {
		return challenger_fname;
	}
	
	public void setLName(String challenger_lname) {
		this.challenger_lname=challenger_lname;
	}
	
	public String getLName() {
		return challenger_lname;
	}

	public void setWins(int challenger_wins) {
		this.challenger_wins=challenger_wins;
	}
	
	public int getWins() {
		return challenger_wins;
	}
	
	public void setChallenges(int challenger_challenges) {
		this.challenger_challenges=challenger_challenges;
	}
	
	public int getChallenges() {
		return challenger_challenges;
	}
	
	public void sete4Eligibility(boolean eligibility) {
		this.challenger_e4_eligibility=eligibility;
	}
	
	public boolean gete4Eligibility() {
		return challenger_e4_eligibility;
	}
}
