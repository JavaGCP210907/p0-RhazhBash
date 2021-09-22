package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.obj.Challenger;
import com.revature.util.ConnectionUtil;

public class ChallengerDAO implements ChallengerDAOInterface {
	
	@Override
	public List<Challenger> GetChallengers() {
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		ResultSet RS=null;
		
		String Query="select * from challengers;";
		
		Statement CQuery=conn.createStatement();
		
		RS=CQuery.executeQuery(Query);
		
		List<Challenger> challengerList = new ArrayList<>();
		
		while (RS.next()) {
			Challenger may=new Challenger(
					RS.getInt("challenger_id"),
					RS.getString("challenger_fname"),
					RS.getString("challenger_lname"),
					RS.getInt("challenger_wins"),
					RS.getInt("challenger_challenges"),
					RS.getBoolean("challenger_e4_eligibility")
					);
					
			challengerList.add(may);
		}
		
		return challengerList;
	}
	
	catch (SQLException e) {
		System.out.println("Cannot connect to database");
		e.printStackTrace();
	}
	
	return null;
	}

	@Override
	public Challenger ChallengerWin(Challenger brendan) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			int wins=brendan.getWins();
			wins++;
			
			int challenges=brendan.getChallenges();
			challenges++;
			
			brendan.setWins(wins);
			brendan.setChallenges(challenges);
			
			int id=brendan.getID();
			
			String Query1="update challengers set challenger_wins="+wins+" where challenger_id="+id+";";
			String Query2="update challengers set challengers_challenges="+challenges+" where challenger_id="+id+";";
			
			Statement WinsQuery=conn.createStatement();
			
			WinsQuery.executeQuery(Query1);
			WinsQuery.executeQuery(Query2);
			
		}
		
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
		
		return brendan;
	}
	
	@Override
	public Challenger ChallengerLoss(Challenger red) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			int challenges=red.getChallenges();
			challenges++;
			
			red.setChallenges(challenges);
			
			String Query="update challengers set challengers_challenges="+challenges+" where challenger_id="+red.getID()+";";
			
			Statement ChallengesQuery=conn.createStatement();
			
			ChallengesQuery.executeQuery(Query);
		}
			catch (SQLException e) {
				System.out.println("Cannot connect to database");
				e.printStackTrace();
			}
		
		return red;
	}
	
	@Override
	public Challenger ChallengerIsEligible(Challenger rosa) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			rosa.sete4Eligibility(true);
			String Query="update challengers set challenger_e4_eligibility=true where trainer_id="+rosa.getID()+";";
			
			Statement e4Query=conn.createStatement();
			e4Query.executeQuery(Query);
		}
		
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
		
		return rosa;
		}
	
	@Override
	public void AddChallenger(Challenger dawn) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String Query="insert into challengers (challenger_fname, challengerlname, challenger_wins, challenger_challenges, challenger_e4_eligibility) values("+dawn.getFName()+", "+dawn.getLName()+", 0, 0, false);"; 
		
			Statement CQuery=conn.createStatement();
			CQuery.executeQuery(Query);
		}
		catch (SQLException e) {
			System.out.println("Cannot connect to database");
			e.printStackTrace();
		}
	}
	
	@Override
	public void ChallengerInfo(Challenger ethan) {
		System.out.println(ethan.getFName()+"won "+ethan.getWins()+" badges after "+ethan.getChallenges()+" gym battles");
		if (ethan.getWins()>7)
			System.out.println("Now he's ready to take on the elite four!");
	}
}
