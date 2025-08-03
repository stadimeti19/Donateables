package com.example.a4g_ksd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Enhanced matching algorithm for the donation app with fuzzy matching and accuracy measurement
 * 
 * @author Donateables Team
 *
 */
public class MatchingAlgorithm {

	// Data
	ArrayList<Item> UserList;
	ArrayList<Item> OrgList;
	ArrayList<String> matchItems;
	ArrayList<String> UserItemHistory;
	private boolean match;
	private int numMatches;
	private MatchingAccuracyMetrics accuracyMetrics;
	
	// Categories for semantic matching
	private Map<String, List<String>> itemCategories;

	// Constructor(s)
	/**
	 * Constructs a matching algorithm with given ArrayList parameters
	 * 
	 * @param UserItems         ArrayList
	 * @param OrganizationItems ArrayList
	 */
	public MatchingAlgorithm(ArrayList<Item> UserItems, ArrayList<Item> OrganizationItems) {
		UserList = UserItems;
		OrgList = OrganizationItems;
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
		accuracyMetrics = new MatchingAccuracyMetrics();
		initializeCategories();
	}

	/**
	 * Constructs a default matching algorithm which initializes the ArrayLists
	 */
	public MatchingAlgorithm() {
		UserList = new ArrayList<Item>();
		OrgList = new ArrayList<Item>();
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
		accuracyMetrics = new MatchingAccuracyMetrics();
		initializeCategories();
	}
	
	/**
	 * Initialize item categories for semantic matching
	 */
	private void initializeCategories() {
		itemCategories = new HashMap<>();
		
		List<String> books = new ArrayList<>();
		books.add("book"); books.add("books"); books.add("textbook"); books.add("textbooks");
		books.add("novel"); books.add("novels"); books.add("literature"); books.add("reading");
		itemCategories.put("books", books);
		
		List<String> clothing = new ArrayList<>();
		clothing.add("clothes"); clothing.add("clothing"); clothing.add("shirt"); clothing.add("shirts");
		clothing.add("pants"); clothing.add("dress"); clothing.add("dresses"); clothing.add("jacket");
		clothing.add("jackets");
		itemCategories.put("clothing", clothing);
		
		List<String> electronics = new ArrayList<>();
		electronics.add("electronic"); electronics.add("electronics"); electronics.add("phone");
		electronics.add("phones"); electronics.add("computer"); electronics.add("computers");
		electronics.add("laptop"); electronics.add("laptops");
		itemCategories.put("electronics", electronics);
		
		List<String> furniture = new ArrayList<>();
		furniture.add("furniture"); furniture.add("chair"); furniture.add("chairs");
		furniture.add("table"); furniture.add("tables"); furniture.add("desk"); furniture.add("desks");
		furniture.add("sofa"); furniture.add("sofas");
		itemCategories.put("furniture", furniture);
		
		List<String> toys = new ArrayList<>();
		toys.add("toy"); toys.add("toys"); toys.add("game"); toys.add("games");
		toys.add("puzzle"); toys.add("puzzles"); toys.add("doll"); toys.add("dolls");
		itemCategories.put("toys", toys);
		
		List<String> food = new ArrayList<>();
		food.add("food"); food.add("canned"); food.add("canned food");
		food.add("non-perishable"); food.add("groceries"); food.add("pantry");
		itemCategories.put("food", food);
		
		List<String> medical = new ArrayList<>();
		medical.add("medicine"); medical.add("medical"); medical.add("supplies");
		medical.add("bandage"); medical.add("bandages"); medical.add("first aid");
		itemCategories.put("medical", medical);
		
		List<String> school = new ArrayList<>();
		school.add("school supplies"); school.add("pencil"); school.add("pencils");
		school.add("paper"); school.add("notebook"); school.add("notebooks");
		school.add("backpack"); school.add("backpacks");
		itemCategories.put("school", school);
	}

	// Method(s)
	/**
	 * Enhanced matching algorithm with fuzzy matching and accuracy measurement
	 * 
	 * @return list of matched items with accuracy metrics
	 */
	public String matchItems() {
		accuracyMetrics.reset();

		for (int x = 0; x < UserList.size(); x++) {
			for (int y = 0; y < OrgList.size(); y++) {
				double matchScore = calculateMatchScore(UserList.get(x), OrgList.get(y));
				
				if (matchScore >= 0.8) { // 80% similarity threshold
					match = true;
					numMatches++;
					accuracyMetrics.addMatch(matchScore);
					
					int orgCount = OrgList.get(y).getCount();
					int userCount = UserList.get(x).getCount();
					
					if (userCount <= orgCount) {
						orgCount -= userCount;
						userCount -= userCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
						UserItemHistory.add(UserList.get(x).getName());
						UserList.remove(x);
						x--; // Adjust index after removal
						break;
					} else {
						System.out.println("You can donate " + orgCount + " of your items to the organization");
						userCount -= orgCount;
						orgCount -= orgCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
					}
					
					matchItems.add("Item: " + UserList.get(x).getName() + "\nAmount Donated: " + userCount + 
						"\nMatch Score: " + String.format("%.1f", matchScore * 100) + "%");
				} else {
					accuracyMetrics.addNonMatch();
				}
			}
		}

		double accuracy = accuracyMetrics.getAccuracy();
		return "MatchPage Found: " + matchItems + "\nAccuracy: " + String.format("%.1f", accuracy) + "%";
	}
	
	/**
	 * Calculate match score between two items
	 */
	private double calculateMatchScore(Item userItem, Item orgItem) {
		String userName = userItem.getName().toLowerCase().trim();
		String orgName = orgItem.getName().toLowerCase().trim();
		
		// Exact match
		if (userName.equals(orgName)) {
			return 1.0;
		}
		
		// Category-based matching
		double categoryScore = getCategoryMatchScore(userName, orgName);
		if (categoryScore > 0.8) {
			return categoryScore;
		}
		
		// Fuzzy string matching
		double fuzzyScore = calculateFuzzyMatch(userName, orgName);
		
		// Return the higher score
		return Math.max(categoryScore, fuzzyScore);
	}
	
	/**
	 * Get category-based match score
	 */
	private double getCategoryMatchScore(String userName, String orgName) {
		for (Map.Entry<String, List<String>> entry : itemCategories.entrySet()) {
			List<String> keywords = entry.getValue();
			boolean userInCategory = false;
			boolean orgInCategory = false;
			
			for (String keyword : keywords) {
				if (userName.contains(keyword)) {
					userInCategory = true;
				}
				if (orgName.contains(keyword)) {
					orgInCategory = true;
				}
			}
			
			if (userInCategory && orgInCategory) {
				return 0.9; // High score for category matches
			}
		}
		return 0.0;
	}
	
	/**
	 * Calculate fuzzy match using Levenshtein distance
	 */
	private double calculateFuzzyMatch(String s1, String s2) {
		int distance = levenshteinDistance(s1, s2);
		int maxLength = Math.max(s1.length(), s2.length());
		
		if (maxLength == 0) return 1.0;
		
		double similarity = 1.0 - ((double) distance / maxLength);
		return similarity;
	}
	
	/**
	 * Calculate Levenshtein distance between two strings
	 */
	private int levenshteinDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] matrix = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++) {
			matrix[i][0] = i;
		}
		
		for (int j = 0; j <= n; j++) {
			matrix[0][j] = j;
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
				matrix[i][j] = Math.min(
					Math.min(matrix[i - 1][j] + 1,      // deletion
					matrix[i][j - 1] + 1),              // insertion
					matrix[i - 1][j - 1] + cost         // substitution
				);
			}
		}
		
		return matrix[m][n];
	}
	
	/**
	 * Get accuracy metrics
	 */
	public MatchingAccuracyMetrics getAccuracyMetrics() {
		return accuracyMetrics;
	}
	
	/**
	 * Get current accuracy
	 */
	public double getAccuracy() {
		return accuracyMetrics.getAccuracy();
	}
	
	//Setters
	public void setUserList(ArrayList<Item> userList) {
		UserList = userList;
	}

	public void setOrgList(ArrayList<Item> orgList) {
		OrgList = orgList;
	}

	public void setMatchItems(ArrayList<String> matchItems) {
		this.matchItems = matchItems;
	}

	public void setUserItemHistory(ArrayList<String> userItemHistory) {
		UserItemHistory = userItemHistory;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}
	
	//Getters
	public ArrayList<Item> getUserList() {
		return UserList;
	}

	public ArrayList<Item> getOrgList() {
		return OrgList;
	}

	public ArrayList<String> getMatchItems() {
		return matchItems;
	}

	public ArrayList<String> getUserItemHistory() {
		return UserItemHistory;
	}
	
	public boolean getMatch() {
		return match;
	}
	
	public int getNumMatches() {
		return numMatches;
	}
	
	/**
	 * Clear all matches and reset metrics
	 */
	public void clearMatches() {
		matchItems.clear();
		UserItemHistory.clear();
		match = false;
		numMatches = 0;
		accuracyMetrics.reset();
	}
	
	/**
	 * Reset the entire algorithm
	 */
	public void reset() {
		UserList.clear();
		OrgList.clear();
		matchItems.clear();
		UserItemHistory.clear();
		match = false;
		numMatches = 0;
		accuracyMetrics.reset();
	}
}

/**
 * Accuracy metrics class for tracking matching performance
 */
class MatchingAccuracyMetrics {
	private int totalComparisons;
	private int successfulMatches;
	private ArrayList<Double> matchScores;
	
	public MatchingAccuracyMetrics() {
		reset();
	}
	
	public void addMatch(double score) {
		successfulMatches++;
		totalComparisons++;
		matchScores.add(score);
	}
	
	public void addNonMatch() {
		totalComparisons++;
	}
	
	public double getAccuracy() {
		if (totalComparisons == 0) return 0.0;
		return ((double) successfulMatches / totalComparisons) * 100.0;
	}
	
	public double getAverageMatchScore() {
		if (matchScores.isEmpty()) return 0.0;
		double sum = 0.0;
		for (Double score : matchScores) {
			sum += score;
		}
		return sum / matchScores.size();
	}
	
	public int getMatchCount() {
		return successfulMatches;
	}
	
	public int getTotalComparisons() {
		return totalComparisons;
	}
	
	public void reset() {
		totalComparisons = 0;
		successfulMatches = 0;
		matchScores = new ArrayList<>();
	}
}
