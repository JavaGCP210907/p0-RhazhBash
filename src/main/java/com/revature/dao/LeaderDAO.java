package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.obj.Leader;
import com.revature.util.ConnectionUtil;

public class LeaderDAO implements LeaderDAOInterface {
	
	@Override
	public List<Leader> GetLeaders() {
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		ResultSet leaderRS=null;
		ResultSet teamRS=null;
		
		String LeaderQuery="select * from leaders;";
		String TeamQuery="select * from teams;";
		
		Statement LQuery=conn.createStatement();
		Statement TQuery=conn.createStatement();
		
		leaderRS=LQuery.executeQuery(LeaderQuery);
		teamRS=TQuery.executeQuery(TeamQuery);
		
		List<Leader> leaderList = new ArrayList<>();
		
		while (leaderRS.next()) {
			Leader norman=new Leader(
					leaderRS.getInt("leader_id"),
					leaderRS.getString("leader_fname"),
					leaderRS.getString("leader_lname"),
					leaderRS.getString("leader_type"),
					leaderRS.getString("leader_badge"),
					teamRS.getString("pokemon_1"),
					teamRS.getString("pokemon_2"),
					teamRS.getString("pokemon_3"),
					leaderRS.getInt("leader_wins"),
					leaderRS.getInt("leader_challenges")
					);
					
			leaderList.add(norman);
		}
		
		return leaderList;
	}
	
	catch (SQLException e) {
		System.out.println("Cannot connect to database");
		e.printStackTrace();
	}
	
	return null;
	}

	@Override
	public Leader LeaderWin(Leader flannery) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			int wins=flannery.getWins();
			wins++;
			
			int challenges=flannery.getChallenges();
			challenges++;
			
			flannery.setWins(wins);
			flannery.setChallenges(challenges);
			
			int id=flannery.getID();
			
			String Query1="update leaders set leader_wins="+wins+" where leader_id="+id+";";
			String Query2="update leaders set leader_challenges="+challenges+" where leader_id="+id+";";
			
			Statement WinsQuery=conn.createStatement();
			
			WinsQuery.executeQuery(Query1);
			WinsQuery.executeQuery(Query2);
			
		}
		
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
		
		return flannery;
	}
	
	@Override
	public Leader LeaderLoss(Leader winona) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
		int challenges=winona.getChallenges();
		challenges++;
		
		winona.setChallenges(challenges);
		
		String Query="update leaders set leader_challenges="+challenges+" where leader_id="+winona.getID()+";";
		
		Statement ChallengesQuery=conn.createStatement();
		
		ChallengesQuery.executeQuery(Query);
	}
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
		
		return winona;
	}
	
	@Override
	public Leader EditLeader(Leader wattson) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
		String Query="{update leaders set leader_fname="+wattson.getFName()+" where leader_id="+wattson.getID()+
				   " update leaders set leader_lname="+wattson.getLName()+" where leader_id="+wattson.getID()+
				   " update leaders set leader_badge="+wattson.getBadge()+" where leader_id="+wattson.getID()+
				   " update teams set pokemon_1="+wattson.getPokemon_1()+" where team_id="+wattson.getID()+
				   " update teams set pokemon_2="+wattson.getPokemon_2()+" where team_id="+wattson.getID()+
				   " update teams set pokemon_3="+wattson.getPokemon_3()+" where team_id="+wattson.getID()+
				   " update leaders set leader_wins=0 where team_id="+wattson.getID()+
				   " update leaders set leader_challenges=0 where team_id="+wattson.getID()+"};";
		
		Statement LeaderEdit=conn.createStatement();
		
		LeaderEdit.executeQuery(Query);
		
		System.out.println("Leader "+wattson.getFName()+" successfully updated");
		}
		
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
		
		return wattson;
	}
	
	@Override
	public Leader DeleteLeader(Leader roxxane) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			roxxane.setFName("OPEN");
			roxxane.setLName("OPEN");
			roxxane.setBadge("NULL");
			roxxane.setChallenges(0);
			roxxane.setWins(0);
			roxxane.setPokemon_1("N/A");
			roxxane.setPokemon_2("N/A");
			roxxane.setPokemon_3("N/A");
			
			String Query="{update leaders set leader_fname=Open where leader_id="+roxxane.getID()+
					   " update leaders set leader_lname=Open where leader_id="+roxxane.getID()+
					   " update leaders set leader_badge=N/A where leader_id="+roxxane.getID()+
					   " update teams set pokemon_1=N/A where team_id="+roxxane.getID()+
					   " update teams set pokemon_2=N/A where team_id="+roxxane.getID()+
					   " update teams set pokemon_3=N/A where team_id="+roxxane.getID()+
					   " update leaders set leader_wins=0 where team_id="+roxxane.getID()+
					   " update leaders set leader_challenges=0 where team_id="+roxxane.getID()+"};";
			
			Statement LeaderDelete=conn.createStatement();
			
			LeaderDelete.executeQuery(Query);
			}
			
			catch (SQLException e) {
				System.out.println("Cannot connect to database");
				e.printStackTrace();
			}
		
		return roxxane;
	}
	
	@Override
	public void LeaderInfo(Leader brawly) {
		System.out.println("Challenge "+brawly.getFName()+" "+brawly.getLName()+"'s "+brawly.getType()+" type gym to earn the "+brawly.getBadge()+" badge!");
		System.out.println("He uses a team of "+brawly.getPokemon_1()+", "+brawly.getPokemon_2()+", and "+brawly.getPokemon_3());
		System.out.println("He beat "+brawly.getWins()+" of his "+brawly.getChallenges()+" challengers");
	}
	
	@Override
	public Leader EditTeam(Leader wallace) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String Query="{update teams set pokemon_1="+wallace.getPokemon_1()+" where team_id="+wallace.getID()+
					   " update teams set pokemon_1="+wallace.getPokemon_2()+" where team_id="+wallace.getID()+
					   " update teams set pokemon_1="+wallace.getPokemon_3()+" where team_id="+wallace.getID()+
					   "};";
			
			Statement LeaderTeamEdit=conn.createStatement();
			
			LeaderTeamEdit.executeQuery(Query);
			}
			
			catch (SQLException e) {
				System.out.println("Cannot connect to database");
				e.printStackTrace();
			}
		
		return wallace;
	}
}
