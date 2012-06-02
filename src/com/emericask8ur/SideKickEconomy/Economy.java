package com.emericask8ur.SideKickEconomy;

import java.util.HashMap;

public class Economy {
	
	/**
	 * Access Economy HashMap
	 */
	public static HashMap<String, Double> economy = new HashMap<String, Double>();

	/**
	 * 
	 * @param Players name
	 * @return Money amount
	 */
	public static Double getMoney(String string) {
		if (Economy.economy.containsKey(string)) {
			return Economy.economy.get(string);
		} else {
			return (double) 0;
		}
	}
	
	/**
	 * 
	 * @param Players name
	 * @param Money amount
	 */
	public static void setMoney(String string, double amount) {
		Economy.economy.put(string, amount);

	}
	
	/**
	 * 
	 * @param Players name
	 * @param Money amount
	 */
	public static void addMoney(String string, double amount) {
		double a = Economy.getMoney(string);
		double x = a + amount;
		Economy.economy.put(string, x);
	}
	
	/**
	 * Subtracts from the users wallet.
	 * If the player does not have money left, users money cannot be subtracted.
	 * @param Players name
	 * @param Money amount
	 */
	public static void subtractMoney(String string, double amount){
		double x = Economy.getMoney(string);
		double y = x - amount;
		Economy.economy.put(string, y);
	}
	
	/**
	 * 
	 * @param Player name
	 * @return hasMoney
	 */
	public static boolean hasMoney(String playername){
		if(getMoney(playername) > 0){
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if a Player has a Account
	 * @param playername
	 * @return
	 */
	public static boolean hasAccount(String playername){
		if(Economy.economy.containsKey(playername)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Creats default account with default amount</br>
	 * $30
	 * @param playername
	 */
	public static void createDefaultAccount(String playername){
		if(!hasAccount(playername)){
			Economy.economy.put(playername, (double) 30);
		}
	}
	
	/**
	 * Removes all money from the user
	 * @param playername
	 */
	public static void removeMoney(String playername){
		if(hasAccount(playername)){
			setMoney(playername, 0);
		} else {
			System.out.println("User " + playername + " does not have a account yet!");
		}
	}

}
