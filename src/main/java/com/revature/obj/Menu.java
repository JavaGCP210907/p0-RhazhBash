package com.revature.obj;

import java.util.List;
import java.util.Scanner;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.revature.dao.LeaderDAO;
import com.revature.dao.ChallengerDAO;

public class Menu {

	LeaderDAO LDAO=new LeaderDAO();
	ChallengerDAO CDAO=new ChallengerDAO();
	
	public void DisplayMenu() {
		
		boolean MenuToggle=true;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Welcome to the KSU PoGo league management system");
		
		while (MenuToggle) {
			
			List<Leader> leaders=LDAO.GetLeaders();
			List<Challenger> challengers=CDAO.GetChallengers();
			
			System.out.println("Enter a command, or type help for a list of commands");
			System.out.println("Placeholder text");
			
			String input=scan.nextLine();
			
			switch (input) {
			
			case "help": {
				
				System.out.println("editleader-Add a new gym leader");
				System.out.println("deleteleader-Remove a gym leader and open their spot");
				System.out.println("report-Log the result of a gym challenge");
				System.out.println("editteam-Change a leader's team");
				System.out.println("addchallenger-Add a new trainer to the database");
				System.out.println("leaderinfo-Show a leader's type, badge, team, and winrate");
				System.out.println("leaders-List all leaders and their IDs");
				System.out.println("challengerinfo-Show a challenger's winrate");
				System.out.println("challengers-List all challengers and their IDs");
				System.out.println("quit-Exit this application");
				break;
			}
			
			case "editleader": {
				
				System.out.println("Enter the ID of the leader to edit");
				
				Scanner ID=new Scanner(System.in);
				
				String temp=ID.nextLine();
				int lID=Integer.parseInt(temp);
				Leader juan=leaders.get(lID);
				
				
				System.out.println("Enter the leader's first name");
				
				Scanner firstname=new Scanner(System.in);
				
				String fname=firstname.nextLine();
				juan.setFName(fname);
				
				
				System.out.println("Enter the leader's last name");
				
				Scanner lastname=new Scanner(System.in);
				
				String lname=lastname.nextLine();
				juan.setLName(lname);
				
				
				System.out.println("What badge will the leader give out?");
				
				Scanner badge=new Scanner(System.in);
				
				String bdge=badge.nextLine();
				juan.setBadge(bdge);
				
				
				System.out.println("Enter the leader's first Pokemon");
				
				Scanner pokemon1=new Scanner(System.in);
				String p1=pokemon1.nextLine();
				juan.setPokemon_1(p1);
				
				
				System.out.println("Enter the leader's second Pokemon");
				
				Scanner pokemon2=new Scanner(System.in);
				String p2=pokemon2.nextLine();
				juan.setPokemon_2(p2);
				
				
				System.out.println("Enter the leader's third Pokemon");
				
				Scanner pokemon3=new Scanner(System.in);
				String p3=pokemon3.nextLine();
				juan.setPokemon_3(p3);
				
				
				LDAO.EditLeader(juan);
				
				ID.close();
				firstname.close();
				lastname.close();
				badge.close();
				pokemon1.close();
				pokemon2.close();
				pokemon3.close();
				
				break;
				
				
			}
			
			case "deleteleader": {
				
				System.out.println("Enter the ID of the leader to remove");
				
				Scanner ID=new Scanner(System.in);
				
				String temp=ID.nextLine();
				int lID=Integer.parseInt(temp);
				
				Leader juan=leaders.get(lID);
				
				
				System.out.println("Are you sure you want to remove this leader? y/n");
				
				Scanner conf=new Scanner(System.in);
				
				String confirmation=conf.nextLine();
				
				
				if (confirmation=="y"||confirmation=="yes") 
					juan=LDAO.DeleteLeader(juan);
					
				else if (confirmation=="n"||confirmation=="no") 
					;
				else 
					System.out.println("Invalid command");
				
				ID.close();
				conf.close();
				break;
			}
			
			case "report": {
				
				System.out.println("Enter the leader's ID");
				
				Scanner leader=new Scanner(System.in);
				
				String temp1=leader.nextLine();
				int lID=Integer.parseInt(temp1);
				
				Leader juan=leaders.get(lID);
				
				
				System.out.println("Enter the challenger's ID");
				
				Scanner challenger=new Scanner(System.in);
				
				String temp2=challenger.nextLine();
				int cID=Integer.parseInt(temp2);
				
				Challenger leaf=challengers.get(cID);
				
				
				System.out.println("Did the leader or the challenger win?");
				
				Scanner winner=new Scanner(System.in);
				
				String result=winner.nextLine();
				
				if (result=="leader") {
					
					juan=LDAO.LeaderWin(juan);
					leaf=CDAO.ChallengerLoss(leaf);

				}
				
				else if (result=="challenger") {
					
					juan=LDAO.LeaderLoss(juan);
					leaf=CDAO.ChallengerWin(leaf);
					
					if (leaf.getWins()==8)
					leaf=CDAO.ChallengerIsEligible(leaf);
					
				}
				
				else 
					System.out.println("Invalid command");
				
				leader.close();
				challenger.close();
				winner.close();
				break;

				
			}

			case "editteam": {
				
				System.out.println("Enter the ID of the leader you want to edit");
				
				Scanner ID=new Scanner(System.in);
				String lID=ID.nextLine();
				int leaderID=Integer.parseInt(lID);
				
				System.out.println("Enter the leader's first Pokemon");
				
				Scanner pokemon1=new Scanner(System.in);
				String p1=pokemon1.nextLine();
				
				System.out.println("Enter the leader's second Pokemon");
				
				Scanner pokemon2=new Scanner(System.in);
				String p2=pokemon2.nextLine();
				
				System.out.println("Enter the leader's third Pokemon");
				
				Scanner pokemon3=new Scanner(System.in);
				String p3=pokemon3.nextLine();
				
				Leader juan=leaders.get(leaderID);
				
				juan.setPokemon_1(p1);
				juan.setPokemon_2(p2);
				juan.setPokemon_3(p3);
				
				LDAO.EditTeam(juan);
				
				ID.close();
				pokemon1.close();
				pokemon2.close();
				pokemon3.close();
				break;
	
			}

			case "addchallenger": {
				
				System.out.println("Enter the challenger's first name");
				
				Scanner firstname=new Scanner(System.in);
				String fname=firstname.nextLine();
				
				System.out.println("Enter the challenger's last name");
				
				Scanner lastname=new Scanner(System.in);
				String lname=lastname.nextLine();
				
				Challenger lucas=new Challenger(fname, lname);
				
				CDAO.AddChallenger(lucas);
				
				firstname.close();
				lastname.close();
				break;
	
			}

			case "leaderinfo": {
				
				System.out.println("Enter the ID of the leader you want to view");
				
				Scanner ID=new Scanner(System.in);
				String lID=ID.nextLine();
				int leaderID=Integer.parseInt(lID);
				
				Leader juan=leaders.get(leaderID);
				
				LDAO.LeaderInfo(juan);
				
				ID.close();
				break;
	
			}

			case "leaders": {
				
				for (int i=0; i<18; i++) {
					Leader wallace=leaders.get(i);
					System.out.println(wallace.getFName()+"-"+i);
				}
				break;
	
			}
			
			case "challengerinfo": {
				
				System.out.println("Enter the challenger's ID");
				
				Scanner challenger=new Scanner(System.in);
				
				String temp=challenger.nextLine();
				int cID=Integer.parseInt(temp);
				
				Challenger hilda=challengers.get(cID);
				
				CDAO.ChallengerInfo(hilda);
				
				challenger.close();
				break;
				
			}

			case "challengers": {
				
				for (int i=0; i<challengers.size(); i++) {
					Challenger lyra=challengers.get(i);
					System.out.println(lyra.getFName()+" "+lyra.getLName()+"-"+i);
				}
				break;
	
			}
			
			case "quit": {
				
				MenuToggle=false;
				System.out.println("Exiting...");
				break;
			}
			
			default: {
				
				System.out.println("Invalid command");
				break;
			}
			}
		}
		
		System.out.println("Goodbye");
		scan.close();
	}
}
