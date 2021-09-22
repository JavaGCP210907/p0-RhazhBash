package com.revature.obj;

public class Leader {
	private int leader_id;
	private String leader_fname;
	private String leader_lname;
	private String leader_type;
	private String leader_badge;
	private String pokemon_1;
	private String pokemon_2;
	private String pokemon_3;
	private int leader_wins;
	private int leader_challenges;
	
	public Leader() {
		super();
	}
	
	public Leader(int leader_id, String leader_fname, String leader_lname, String leader_type, String leader_badge, String pokemon_1, String pokemon_2, String pokemon_3, int leader_wins, int leader_challenges) {
		super();
		this.leader_id=leader_id;
		this.leader_fname=leader_fname;
		this.leader_lname=leader_lname;
		this.leader_type=leader_type;
		this.leader_badge=leader_badge;
		this.pokemon_1=pokemon_1;
		this.pokemon_2=pokemon_2;
		this.pokemon_3=pokemon_3;
		this.leader_wins=leader_wins;
		this.leader_challenges=leader_challenges;
	}
	
	public Leader(String leader_fname, String leader_lname, String leader_badge, String pokemon_1, String pokemon_2, String pokemon_3) {
		super();
		this.leader_fname=leader_fname;
		this.leader_lname=leader_lname;
		this.leader_badge=leader_badge;
		this.pokemon_1=pokemon_1;
		this.pokemon_2=pokemon_2;
		this.pokemon_3=pokemon_3;
	}
	
	public void setID(int leader_id) {
		this.leader_id=leader_id;
	}
	
	public int getID() {
		return leader_id;
	}
	
	public void setFName(String leader_fname) {
		this.leader_fname=leader_fname;
	}
	
	public String getFName() {
		return leader_fname;
	}
	
	public void setLName(String leader_lname) {
		this.leader_lname=leader_lname;
	}
	
	public String getLName() {
		return leader_lname;
	}
	
	public void setType(String leader_type) {
		this.leader_type=leader_type;
	}
	
	public String getType() {
		return leader_type;
	}
	
	public void setBadge(String leader_badge) {
		this.leader_badge=leader_badge;
	}
	
	public String getBadge() {
		return leader_badge;
	}
	
	public void setPokemon_1(String pokemon_1) {
		this.pokemon_1=pokemon_1;
	}
	
	public String getPokemon_1() {
		return pokemon_1;
	}
	
	public void setPokemon_2(String pokemon_2) {
		this.pokemon_2=pokemon_2;
	}
	
	public String getPokemon_2() {
		return pokemon_2;
	}
	
	public void setPokemon_3(String pokemon_3) {
		this.pokemon_3=pokemon_3;
	}
	
	public String getPokemon_3() {
		return pokemon_3;
	}
	
	public void setWins(int leader_wins) {
		this.leader_wins=leader_wins;
	}
	
	public int getWins() {
		return leader_wins;
	}
	
	public void setChallenges(int leader_challenges) {
		this.leader_challenges=leader_challenges;
	}
	
	public int getChallenges() {
		return leader_challenges;
	}
	
}
