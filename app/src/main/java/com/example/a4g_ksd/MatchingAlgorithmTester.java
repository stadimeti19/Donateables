package com.example.a4g_ksd;

import java.util.ArrayList;
import java.util.Locale;

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
        results.append("Exact Matches: ").append(String.format(Locale.US, "%.1f", exactMatchAccuracy)).append("%\n");

        // Test 2: Category matches
        double categoryMatchAccuracy = testCategoryMatches();
        results.append("Category Matches: ").append(String.format(Locale.US, "%.1f", categoryMatchAccuracy)).append("%\n");

        // Test 3: Fuzzy matches
        double fuzzyMatchAccuracy = testFuzzyMatches();
        results.append("Fuzzy Matches: ").append(String.format(Locale.US, "%.1f", fuzzyMatchAccuracy)).append("%\n");

        // Test 4: Real-world scenarios
        double realWorldAccuracy = testRealWorldScenarios();
        results.append("Real-world Scenarios: ").append(String.format(Locale.US, "%.1f", realWorldAccuracy)).append("%\n");

        double overallAccuracy = (exactMatchAccuracy + categoryMatchAccuracy + fuzzyMatchAccuracy + realWorldAccuracy) / 4.0;
        results.append("\nOverall Accuracy: ").append(String.format(Locale.US, "%.1f", overallAccuracy)).append("%\n");

        return results.toString();
    }

    /**
     * Test exact name matching
     */
    private static double testExactMatches() {
        User testUser = new User("TestUser", "TestLocation", "testuser@example.com");
        User testOrg = new User("TestOrg", "TestLocation", "testorg@example.com");

        ArrayList<Item> userItems = new ArrayList<>();
        userItems.add(new Item("Books", 5, testUser));
        userItems.add(new Item("Clothes", 3, testUser));
        userItems.add(new Item("Toys", 2, testUser));

        ArrayList<Item> orgItems = new ArrayList<>();
        orgItems.add(new Item("Books", 10, testOrg));
        orgItems.add(new Item("Clothes", 5, testOrg));
        orgItems.add(new Item("Toys", 8, testOrg));

        MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
        algorithm.matchItems();

        return algorithm.getAccuracy();
    }

    /**
     * Test category-based matching
     */
    private static double testCategoryMatches() {
        User testUser = new User("TestUser", "TestLocation", "testuser@example.com");
        User testOrg = new User("TestOrg", "TestLocation", "testorg@example.com");

        ArrayList<Item> userItems = new ArrayList<>();
        userItems.add(new Item("Textbooks", 5, testUser));
        userItems.add(new Item("Shirts", 3, testUser));
        userItems.add(new Item("Puzzles", 2, testUser));

        ArrayList<Item> orgItems = new ArrayList<>();
        orgItems.add(new Item("Books", 10, testOrg));
        orgItems.add(new Item("Clothing", 5, testOrg));
        orgItems.add(new Item("Toys", 8, testOrg));

        MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
        algorithm.matchItems();

        return algorithm.getAccuracy();
    }

    /**
     * Test fuzzy string matching
     */
    private static double testFuzzyMatches() {
        User testUser = new User("TestUser", "TestLocation", "testuser@example.com");
        User testOrg = new User("TestOrg", "TestLocation", "testorg@example.com");

        ArrayList<Item> userItems = new ArrayList<>();
        userItems.add(new Item("Book", 5, testUser));
        userItems.add(new Item("Cloth", 3, testUser));
        userItems.add(new Item("Toy", 2, testUser));

        ArrayList<Item> orgItems = new ArrayList<>();
        orgItems.add(new Item("Books", 10, testOrg));
        orgItems.add(new Item("Clothes", 5, testOrg));
        orgItems.add(new Item("Toys", 8, testOrg));

        MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
        algorithm.matchItems();

        return algorithm.getAccuracy();
    }

    /**
     * Test real-world scenarios
     */
    private static double testRealWorldScenarios() {
        User testUser = new User("TestUser", "TestLocation", "testuser@example.com");
        User testOrg = new User("TestOrg", "TestLocation", "testorg@example.com");

        ArrayList<Item> userItems = new ArrayList<>();
        userItems.add(new Item("Children's books", 5, testUser));
        userItems.add(new Item("Winter jackets", 3, testUser));
        userItems.add(new Item("Board games", 2, testUser));
        userItems.add(new Item("School supplies", 10, testUser));

        ArrayList<Item> orgItems = new ArrayList<>();
        orgItems.add(new Item("Books for kids", 10, testOrg));
        orgItems.add(new Item("Warm clothing", 5, testOrg));
        orgItems.add(new Item("Educational toys", 8, testOrg));
        orgItems.add(new Item("Pencils and paper", 20, testOrg));

        MatchingAlgorithm algorithm = new MatchingAlgorithm(userItems, orgItems);
        algorithm.matchItems();

        return algorithm.getAccuracy();
    }
}
