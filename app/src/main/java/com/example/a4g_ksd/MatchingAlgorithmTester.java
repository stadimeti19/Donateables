package com.example.a4g_ksd;

import java.util.ArrayList;

/**
 * Testing framework for the enhanced matching algorithm
 * 
 * @author Donateables Team
 *
 */
public class MatchingAlgorithmTester {
	
	/**
	 * Run comprehensive accuracy tests
	 */
	public static String runAccuracyTests() {
		StringBuilder results = new StringBuilder();
		results.append("Matching Algorithm Accuracy Tests\n");
		results.append("=====================================\n\n");
		
		// Test 1: Exact matches
		double exactMatchAccuracy = testExactMatches();
		results.append("Exact Matches: ").append(String.format("%.1f", exactMatchAccuracy)).append("%\n");
		
		// Test 2: Category matches
		double categoryMatchAccuracy = testCategoryMatches();
		results.append("Category Matches: ").append(String.format("%.1f", categoryMatchAccuracy)).append("%\n");
		
		// Test 3: Fuzzy matches
		double fuzzyMatchAccuracy = testFuzzyMatches();
		results.append("Fuzzy Matches: ").append(String.format("%.1f", fuzzyMatchAccuracy)).append("%\n");
		
		// Test 4: Real-world scenarios
		double realWorldAccuracy = testRealWorldScenarios();
		results.append("Real-world Scenarios: ").append(String.format("%.1f", realWorldAccuracy)).append("%\n");
		
		double overallAccuracy = (exactMatchAccuracy + categoryMatchAccuracy + fuzzyMatchAccuracy + realWorldAccuracy) / 4.0;
		results.append("\nOverall Accuracy: ").append(String.format("%.1f", overallAccuracy)).append("%\n");
		
		return results.toString();
	}
	
	/**
	 * Test exact name matching
	 */
	private static double testExactMatches() {
		ArrayList<Item> userItems = new ArrayList<>();
		userItems.add(new Item("Books", 5, "User"));
		userItems.add(new Item("Clothes", 3, "User"));
		userItems.add(new Item("Toys", 2, "User"));
		
		ArrayList<Item> orgItems = new ArrayList<>();
		orgItems.add(new Item("Books", 10, "Org"));
		orgItems.add(new Item("Clothes", 5, "Org"));
		orgItems.add(new Item("Toys", 8, "Org"));
		
		MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
		algorithm.matchItems();
		
		return algorithm.getAccuracy();
	}
	
	/**
	 * Test category-based matching
	 */
	private static double testCategoryMatches() {
		ArrayList<Item> userItems = new ArrayList<>();
		userItems.add(new Item("Textbooks", 5, "User"));
		userItems.add(new Item("Shirts", 3, "User"));
		userItems.add(new Item("Puzzles", 2, "User"));
		
		ArrayList<Item> orgItems = new ArrayList<>();
		orgItems.add(new Item("Books", 10, "Org"));
		orgItems.add(new Item("Clothing", 5, "Org"));
		orgItems.add(new Item("Toys", 8, "Org"));
		
		MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
		algorithm.matchItems();
		
		return algorithm.getAccuracy();
	}
	
	/**
	 * Test fuzzy string matching
	 */
	private static double testFuzzyMatches() {
		ArrayList<Item> userItems = new ArrayList<>();
		userItems.add(new Item("Book", 5, "User"));
		userItems.add(new Item("Cloth", 3, "User"));
		userItems.add(new Item("Toy", 2, "User"));
		
		ArrayList<Item> orgItems = new ArrayList<>();
		orgItems.add(new Item("Books", 10, "Org"));
		orgItems.add(new Item("Clothes", 5, "Org"));
		orgItems.add(new Item("Toys", 8, "Org"));
		
		MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
		algorithm.matchItems();
		
		return algorithm.getAccuracy();
	}
	
	/**
	 * Test real-world scenarios
	 */
	private static double testRealWorldScenarios() {
		ArrayList<Item> userItems = new ArrayList<>();
		userItems.add(new Item("Children's books", 5, "User"));
		userItems.add(new Item("Winter jackets", 3, "User"));
		userItems.add(new Item("Board games", 2, "User"));
		userItems.add(new Item("School supplies", 10, "User"));
		
		ArrayList<Item> orgItems = new ArrayList<>();
		orgItems.add(new Item("Books for kids", 10, "Org"));
		orgItems.add(new Item("Warm clothing", 5, "Org"));
		orgItems.add(new Item("Educational toys", 8, "Org"));
		orgItems.add(new Item("Pencils and paper", 20, "Org"));
		
		MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
		algorithm.matchItems();
		
		return algorithm.getAccuracy();
	}
}