package P1PlayersBattle;

public class PlayerStatus {
	private String nickname;
	private int score;
	private int lives;
	private int health;//numar intreg intre 0 si 100
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private int damageDone;

	private static String gameName;
	private static String weapon1;
	private static String weapon2;
	private static String weapon3;
	private static int weapon1Price;
	private static int weapon2Price;
	private static int weapon3Price;
	
	//==============================
	//==    Getters & Setters)    ==
	//==============================
	
	public double getPositionX() {
		return positionX;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public static String getGameName() {
		return gameName;
	}
	
	static void setGameName(String newGameName) {
		gameName = newGameName;
	}
	
	static void setWeapon1(String weapon) {
		weapon1 = weapon;
	}
	
	static String getWeapon1() {
		return weapon1;
	}
	
	static void setWeapon2(String weapon) {
		weapon2 = weapon;
	}
	
	static String getWeapon2() {
		return weapon2;
	}
	
	static void setWeapon3(String weapon) {
		weapon3 = weapon;
	}
	
	static String getWeapon3() {
		return weapon3;
	}
	
	static void setWeapon1Price(int price) {
		weapon1Price = price;
	}

	static void setWeapon2Price(int price) {
		weapon2Price = price;
	}
	
	static void setWeapon3Price(int price) {
		weapon3Price = price;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
		
	//read-only nickname (it has only getter)
	public String getNickname() {
		return nickname;
	}
	
	void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	//=================================
	//==    Player initialization    ==
	//=================================
	
	public void initPlayer(String nickname) {
		this.nickname = nickname;
	}
	
	public void initPlayer(String nickname, int lives) {
		this.nickname = nickname;
		this.lives = lives;
	}
	
	public void initPlayer(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}
	
	//=============================
	//==    Find the artifact    ==
	//=============================
	
	private void modifyHealthWith(int health) {
		if(health > 100) {
			this.health = 100;
		}else if(health <= 0){
			this.lives--;
			this.health = 100;
			if(this.lives <= 0) {
				this.health = 0;
				System.out.println("  ============================ \n"
								 + "    Ati risipit toate vietile! \n"
								 + "        GAME OVER!!! \n"
								 + "  ============================ \n");
			}
		}else {
			this.health = health;
		}
	}
	
	public void findArtifact(int artifactCode) {
		if(CalculatingMethods.isPerfectNumber(artifactCode)) {
			score += 5000;
			lives++;
			modifyHealthWith(100);
			System.out.println("    Ati gasit un numar PERFECT! \n"
							 + "  - Total score  = " + score + "\n"
							 + "  - Total lives  = " + lives + "\n"
							 + "  - Health = " + health + "\n");
		}else if(CalculatingMethods.isPrimeNumber(artifactCode)) {
			score += 1000;
			lives += 2;
			modifyHealthWith(health + 25);
			
			System.out.println("    Ati gasit un numar PRIM! (artifactCode = " + artifactCode + ") \n"
					 + "  - Total score  = " + score + "\n"
					 + "  - Total lives  = " + lives + "\n"
					 + "  - Health = " + health + "\n");
		}else if(CalculatingMethods.isEvenNumber(artifactCode) && CalculatingMethods.isDivisibleBy3(CalculatingMethods.digitsSum(artifactCode))) {
			score -= 3000;
			modifyHealthWith(health - 25);
			
			System.out.println("    Ati gasit o CAPCANA! (artifactCode = " + artifactCode + ") \n"
					 + "  - Total score  = " + score + "\n"
					 + "  - Total lives  = " + lives + "\n"
					 + "  - Health = " + health + "\n");
		}else {
			score += artifactCode;
			System.out.println("    Nu ati gasit nicio putere magica! (artifactCode = " + artifactCode + ") \n"
					 + "  - Total score  = " + score + "\n"
					 + "  - Total lives  = " + lives + "\n"
					 + "  - Health = " + health + "\n");
		}
	}
	
	//================================
	//==       Weapon in hand       ==
	//================================
	
	public boolean isTheWeaponValid(String weapon) {
		if(weapon.equals(weapon1) || weapon.equals(weapon2) || weapon.equals(weapon3)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getWeaponPrice(String weapon) {
		if(weapon.equals(weapon1)) {
			return weapon1Price;
		}else if(weapon.equals(weapon2)) {
			return weapon2Price;
		}else if(weapon.equals(weapon3)) {
			return weapon3Price;
		}else {
			return 0;
		}
	}
		
	private boolean isScoreEnoughToBuyTheWeapon(String weapon) {
		if(this.score >= getWeaponPrice(weapon)){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean setWeaponInHand(String weaponInHand) {
		if(isTheWeaponValid(weaponInHand)) {
			if(isScoreEnoughToBuyTheWeapon(weaponInHand)) {
				this.weaponInHand = weaponInHand;
				score -= getWeaponPrice(weaponInHand);
				return true;
			}else {
				System.out.println("  =================================================================== \n"
								 + "    " + this.getNickname() + ", nu aveti suficiente puncte pentru a cumpara arma! \n"
								 + "  =================================================================== \n\n");
				return false;
			}
		}else {
			System.out.println("  =================================================================== \n"
							 + "    " + this.getNickname() + ", ati introdus un nume gresit de arma! \n"
							 + "  =================================================================== \n\n");
			return false;
		}
	}
	
	public String getWeaponInHand() {
		return weaponInHand;
	}
	
	//=================================
	//==       Move the player       ==
	//=================================
	
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void movePlayerTo(double position) {
		this.positionX = position;
		this.positionY = position;
	}
	
	private double distanceUpToPlayer(PlayerStatus opponent) {
		double result = Math.sqrt(Math.pow(this.positionX - opponent.positionX,2) + 
								Math.pow(this.positionY - opponent.positionY, 2));
		return result;
	}
	
	//=======================================================
	//==     Battle mode. 							       ==
	//==     1. The chance to win the battle		       ==
	//==     2. The battle - attack the opponent	       ==
	//=======================================================
	
	private int calculateProbability(PlayerStatus player) {
		return (3 * player.health + player.score / 1000) / 4;
	}
	
	private boolean isWeaponInHandEqualsWith(PlayerStatus opponent) {
		if(this.getWeaponInHand().equals(opponent.getWeaponInHand())){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ifDistanceIsGraterThan1000WonAgaint(PlayerStatus opponent) {
		if(this.weaponInHand.equals(weapon1) && (opponent.weaponInHand.equals(weapon2) || opponent.weaponInHand.equals(weapon3))) {
			return true;
		}
		if(this.weaponInHand.equals(weapon2) && opponent.weaponInHand.equals(weapon3)) {
			return true;
		}
		return false;
	}
	
	public boolean ifDistanceIsLessOrEqualsTo1000WonAgainst(PlayerStatus opponent) {
		if(this.weaponInHand.equals(weapon2) && (opponent.weaponInHand.equals(weapon1) || opponent.weaponInHand.equals(weapon3))) {
			System.out.println("111");
			return true;
		}
		if(this.weaponInHand.equals(weapon1) && opponent.weaponInHand.equals(weapon3)) {
			System.out.println("222");
			return true;
		}else {
			System.out.println("333");
			return false;
		}
	}

	public boolean shouldAttackOpponent(PlayerStatus opponent) {
		if(isWeaponInHandEqualsWith(opponent)) {
			if(calculateProbability(this) > calculateProbability(opponent)) {
				return true;
			}
		}else {
			if(distanceUpToPlayer(opponent) > 1000) {
				return ifDistanceIsGraterThan1000WonAgaint(opponent);
			}else {
				return ifDistanceIsLessOrEqualsTo1000WonAgainst(opponent);
			}
		}
		return false;
	}
	
	private int damageDoneByPlayer(PlayerStatus player) {
		//System.out.println(player.getNickname() + "  " + (calculateProbability(player) + player.lives + player.getWeaponPrice(player.getWeaponInHand())/10000));
		return calculateProbability(player) + player.lives + player.getWeaponPrice(player.getWeaponInHand())/10000; 
	}
	
	public void attackTheOpponent(PlayerStatus opponent) {
		if(isWeaponInHandEqualsWith(opponent)) {
			while(true) {   //opponent.lives != 0 || this.lives != 0) {
				if(opponent.lives == 0) {
					System.out.println("  ============================ \n"
									 + "    Felicitari " + this.getNickname() + ", ati castigat! \n"
									 + "  ============================ \n");
					break;
				} else if(this.lives == 0) {
					System.out.println("  ============================ \n"
									 + "      GAME OVER! \n"
									 + "    Ati luat bataie, " + this.getNickname() + "\n"
									 + "  ============================ \n");
					break;
				}
				
				damageDone = damageDoneByPlayer(this);
				opponent.modifyHealthWith(opponent.health - damageDone);
				System.out.println("\tDamage done by " + this.getNickname().toUpperCase() + ": " + damageDone);
				
				damageDone = damageDoneByPlayer(opponent);
				this.modifyHealthWith(this.health - damageDoneByPlayer(opponent));
				System.out.println("\tDamage done by " + opponent.getNickname().toUpperCase() + ": " + damageDone);
				
				System.out.println("  =================================================================== \n"
								 + "     	 Proprietati in urma conflictului: \n"	
								 + "			      " + this.getNickname() + "  ||  " + opponent.getNickname() + "\n" 
								 + "  - scor (puncte totale):" + CalculatingMethods.formatThePrinting(this.score) + "   ||" + CalculatingMethods.formatThePrinting(opponent.score) + "\n"
								 + "  - numarul de vieti:	 " + CalculatingMethods.formatThePrinting(this.lives) + "   ||" + CalculatingMethods.formatThePrinting(opponent.lives) + "\n"
								 + "  - status viata:	 " + CalculatingMethods.formatThePrinting(this.health) + "   ||" + CalculatingMethods.formatThePrinting(opponent.health) + "\n"
								 + "  =================================================================== \n");
			}
		}else {
			if(distanceUpToPlayer(opponent) > 1000) {
				System.out.println(">1000");
				if(ifDistanceIsGraterThan1000WonAgaint(opponent)) {
					System.out.println(">1000 opp = 0");
					opponent.lives = 0;
					opponent.modifyHealthWith(-100);
				}else {
					System.out.println(">1000 this = 0");
					this.lives = 0;
					this.modifyHealthWith(-100);
				}
			}else {
				System.out.println("<=1000");
				if(ifDistanceIsLessOrEqualsTo1000WonAgainst(opponent)) {
					System.out.println("<=1000 Opp = 0");
					opponent.lives = 0;
					opponent.modifyHealthWith(-100);
				}else {
					System.out.println("<=1000 this = 0");
					this.lives = 0;
					this.modifyHealthWith(-100);
				}
				
				if(opponent.lives <= 0) {
				System.out.println("  ============================ \n"
								 + "    Felicitari " + this.getNickname().toUpperCase() + ", ati castigat! \n"
								 + "  ============================ \n");
				} else if(this.lives <= 0) {
					System.out.println("  ============================ \n"
									 + "      GAME OVER! \n"
									 + "    Ati luat bataie, " + this.getNickname().toUpperCase() + "\n"
									 + "  ============================ \n");
				}
			}
			
		}
	}
}
