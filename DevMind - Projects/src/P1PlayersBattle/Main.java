package P1PlayersBattle;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		
		PlayerStatus.setGameName("Survive");
		
		//setam armele si preturile acestora
		PlayerStatus.setWeapon1("sniper");
		PlayerStatus.setWeapon2("kalashnikov");
		PlayerStatus.setWeapon3("knife");
		PlayerStatus.setWeapon1Price(10000);
		PlayerStatus.setWeapon2Price(20000);
		PlayerStatus.setWeapon3Price(1000);
		//System.out.println(PlayerStatus.getWeapon1() + "  " + PlayerStatus.getWeapon2() + "  " + PlayerStatus.getWeapon3());
		
		//Introducem 2 jucatori
		PlayerStatus player1 = new PlayerStatus();
		System.out.println("\tVa rugam sa introduceti nickname-ul, urmat de tasta ENTER.");
		player1.initPlayer(sc.nextLine(), 13, 100);
		player1.setHealth(100);
		
		PlayerStatus player2 = new PlayerStatus();
		System.out.println("\tVa rugam sa introduceti nickname-ul, urmat de tasta ENTER.");		
		player2.initPlayer(sc.nextLine(), 3, 100);	
		player2.setHealth(100);
		player2.setScore(21000);
		player2.setWeaponInHand(PlayerStatus.getWeapon2());
		player2.movePlayerTo(12.3, 6.32);
//		player1.setScore(31000);
//		player1.setWeaponInHand(PlayerStatus.getWeapon2());
//		player1.movePlayerTo(23, 66.32);
			
		System.out.println("  =================================================================== \n"
						 + "\tBine ati venit, " + player1.getNickname().toUpperCase() + "! \n"
						 + "\tAveti urmatoarele proprietati: \n\n"
						 + "  - scor (puncte totale):          " + player1.getScore() + "\n"
						 + "  - numarul de vieti:  		   " + player1.getLives() + "\n"
						 + "  - status viata (de la 0 la 100):  " + player1.getHealth() + "\n"
						 + "  =================================================================== \n"); 
		
		boolean popUpMenu = true; // arata meniul principal dupa fiecare alegere
		while(popUpMenu) {
			System.out.println("\t\tVa rugam sa alegeti una din optiunile de mai jos (mentionanad numarul ei): \n\n"
							 + "\t1 -> Afisare proprietati \n"
							 + "\t2 -> Cumparare arma \n"
							 + "\t3 -> Cautare artefacte \n"
							 + "\t4 -> Avansare \"x\" patratele \n"
							 + "\t5 -> Simulare batalie \n"
							 + "\t6 -> Bataliee! \n"
							 + "\t0 -> EXIT GAME \n");
			
			switch(sc.nextLine()) {
				case "1":
				case "1.":
				case "1:":
					System.out.println("  =================================================================== \n"
									 + "\tAveti urmatoarele proprietati: \n"
									 + "  - scor (puncte totale):	" + player1.getScore() + "\n"
									 + "  - numarul de vieti:	 	" + player1.getLives() + "\n"
									 + "  - status viata:		" + player1.getHealth() + "\n"
									 + "  - arma detinuta:		" + player1.getWeaponInHand() + "\n"
									 + "  - pozitie (x, y):		(" + player1.getPositionX() + ", " + player1.getPositionY() + ") \n"
									 + "  =================================================================== \n");
					break;
				case "2":
				case "2.":
				case "2:":
					System.out.println("  =================================================================== \n"
									 + "\tDoriti sa achizitionati una din armele de mai jos? \n"
									 + "  - " + PlayerStatus.getWeapon1() + ": " + player1.getWeaponPrice(PlayerStatus.getWeapon1()) + " puncte; \n"
									 + "  - " + PlayerStatus.getWeapon2() + ": " + player1.getWeaponPrice(PlayerStatus.getWeapon2()) + " puncte; \n"
									 + "  - " + PlayerStatus.getWeapon3() + ": " + player1.getWeaponPrice(PlayerStatus.getWeapon3()) + " puncte; \n"
									 + "  =================================================================== \n");
			
					System.out.println("\tVa rugam sa tastati numele armei dorite, urmat de ENTER.");
					String requestedWeapon = sc.nextLine();
			
					while(!player1.isTheWeaponValid(requestedWeapon)) {
						System.out.println("\tVa rugam sa introduceti un nume corect de arma!");
						requestedWeapon = sc.nextLine();
					}
					
					if(player1.setWeaponInHand(requestedWeapon)) {
						System.out.println("  =================================================================== \n"
										 + "\tFelicitari! Ati achizitionat arma: " + player1.getWeaponInHand() + "\n"
										 + "\tMai aveti " + player1.getScore() + " puncte! \n"
										 + "  =================================================================== \n");
					}else {
						System.out.println("  =================================================================== \n"
										 + "\tNu aveti suficiente puncte pentru a achizitiona arma respectiva! \n"
										 + "  =================================================================== \n");
					}		
					popUpMenu = true;
					break;
				case "3":
				case "3.":
				case "3:":
					player1.findArtifact(rn.nextInt(3000));
//					System.out.println("    Aveti urmatoarele proprietati: \n"
//							+ "  - scor (puncte totale):          " + player1.getScore() + "\n"
//							+ "  - numarul de vieti:  		      " + player1.getLives() + "\n"
//							+ "  - status viata (de la 0 la 100): " + player1.getHealth() + "\n");			
//					System.out.println();
					if(player1.getLives() == 0) {
						popUpMenu = false;
					}else {
						popUpMenu = true;
					}
					break;
				case "4":
				case "4.":
				case "4:":
					System.out.println("\tMomentan sunteti la pozitia: (" + player1.getPositionX() + ", " + player1.getPositionY() + "). \n"
									 + "\tCate patratele doriti sa avansati? Introduceti doua numere reale si apasati ENTER. \n");
					player1.movePlayerTo(sc.nextDouble(),sc.nextDouble());
					System.out.println("  =================================================================== \n"
									 + "\tAti avansat la pozitia: (" + player1.getPositionX() + ", " + player1.getPositionY() + "). \n"
									 + "  =================================================================== \n");
					popUpMenu = true;
					break;
				case "5":
				case "5.":
				case "5:": 
					if(player1.getWeaponInHand() == null) {
						System.out.println("  ============================================================= \n"
										 + "\t" + player1.getNickname().toUpperCase() + ", nu aveti setata arma! \n"
										 + "\tVa rugam sa alegeti o arma pentru a participa la batalie! \n"
										 + "  ============================================================= \n\n");
						popUpMenu = true;
						break;
					}else if(player2.getWeaponInHand() == null) {
						System.out.println("  ============================================================= \n"
								 + "\t" + player2.getNickname().toUpperCase() + ", nu aveti setata arma! \n"
								 + "\tVa rugam sa alegeti o arma pentru a participa la batalie! \n"
								 + "  ============================================================= \n\n");
						popUpMenu = true;
						break;
					}
					
					if(player1.shouldAttackOpponent(player2)) {
						System.out.println("  =================================================================== \n"
										 + "\tAveti sanse sa castigati batalia daca atacati acum. \n"
										 + "  =================================================================== \n\n");
					}else {
						System.out.println("  =================================================================== \n"
										 + "\tNu aveti sanse sa castigati batalia daca atacati acum. \n"
										 + "\tIncercati sa schimbati arma sau pozitia! \n"
										 + "  =================================================================== \n\n");
					}
					popUpMenu = true;
					break;
				case "6":
				case "6.":
				case "6:": 
					if(player1.getWeaponInHand() == null) {
						System.out.println("  ============================================================= \n"
										 + "\t" + player1.getNickname().toUpperCase() + ", nu aveti setata arma! \n"
										 + "\tVa rugam sa alegeti o arma pentru a participa la batalie! \n"
										 + "  ============================================================= \n\n");
						popUpMenu = true;
						break;
					}else if(player2.getWeaponInHand() == null) {
						System.out.println("  ============================================================= \n"
								 + "\t" + player2.getNickname().toUpperCase() + ", nu aveti setata arma! \n"
								 + "\tVa rugam sa alegeti o arma pentru a participa la batalie! \n"
								 + "  ============================================================= \n\n");
						popUpMenu = true;
						break;
					}
					
					player1.attackTheOpponent(player2);
					popUpMenu = true;
					break;
				case "0":
				case "0.":
				case "0:":
				case "0 -":
					System.out.println("  =================================================================== \n"
									 + "\tAti parasit jocul: " + PlayerStatus.getGameName().toUpperCase() + "\n"
									 + "  =================================================================== \n");
					popUpMenu = false;
					break;
				default:
					System.out.println("  =================================================================== \n"
									 + "\tAti intodus un numar gresit! \n"
									 + "  =================================================================== \n");
					popUpMenu = true;
					break;
			}
		}		
	sc.close();			
	}
}
