package P2OptimizareaPerformanta;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LazyNumberDetails lnd = new LazyNumberDetails(17);
		
		System.out.println("\tIntroduceti un numar de la tastatura! \n");
		int number = sc.nextInt();
		
		boolean popUpMenu = true;
		while(popUpMenu) {
			System.out.println("\t\tVa rugam sa alegeti una din optiunile de mai jos (mentionanad numarul ei): \n\n"
							 + "\t 1 -> Numarul este prim? \n"
							 + "\t 2 -> Numarul este perfect? \n"
							 + "\t 3 -> Numarul este magic? \n"
							 + "\t 4 -> Modificati numarul! \n"
							 + "\t 0 -> EXIT GAME \n");
		
			switch(sc.next()) {
			case "1":
			case "1.":
			case "1:":
				if(lnd.getIsPrime()) {
				System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getPrimeResult() + " (cached). \n"
									 + "  ===================================== \n");
				}else {
					lnd.setPrimeResult(CalculatingMethods.isPrimeNumber(number));
					lnd.setIsPrime(true);
					System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getPrimeResult() + " (calculated). \n"
									 + "  ===================================== \n");	
				}
				popUpMenu = true;
				break;
			case "2":
			case "2.":
			case "2:":
				if(lnd.getIsPerfect()) {
					System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getPerfectResult() + " (cached). \n"
									 + "  ===================================== \n");
				}else {
					lnd.setPerfectResult(CalculatingMethods.isPerfectNumber(number));
					lnd.setIsPerfect(true);
					System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getPerfectResult() + " (calculated). \n"
									 + "  ===================================== \n");	
				}
				popUpMenu = true;
				break;
			case "3":
			case "3.":
			case "3:":
				if(lnd.getIsMagic()) {
					System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getMagicResult() + " (cached). \n"
									 + "  ===================================== \n");
				}else {
					lnd.setMagicResult(lnd.isMagicNumber(number));
					lnd.setIsMagic(true);
					System.out.println("  ===================================== \n"
									 + "\t" + number + "  ->  " + lnd.getMagicResult() + " (calculated). \n"
									 + "  ===================================== \n");	
				}
				popUpMenu = true;
				break;
			case "4":
			case "4.":
			case "4:":
				System.out.println("  ================================= \n"
								 + "\t Introduceti un numar nou! \n"
								 + "  ================================= \n");
				lnd.updateNumber(number = sc.nextInt());
				popUpMenu = true;
				break;
			case "0":
			case "0.":
			case "0:":
				System.out.println("  ===================================== \n"
								 + "\t Ati incercat destule numere! \n"
								 + "  ===================================== \n");
				popUpMenu = false;
				break;
			default:
				System.out.println("  =========================================== \n"
								 + "\tAti intodus un numar gresit! \n"
								 + "  =========================================== \n");
				popUpMenu = true;
				break;
			}
		}
	}
}
