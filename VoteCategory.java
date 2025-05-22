package voting.categories;

import java.util.HashMap;

public abstract class VoteCategory {
    protected HashMap<String, Integer> candidates = new HashMap<>();

    public VoteCategory(String[] names) {
        for (String name : names) {
            candidates.put(name, 0);
        }
    }

    public synchronized void vote(String candidate) { // Ensure thread safety
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1); // Increment vote count
            System.out.println(candidate + " received a vote."); // Debugging statement
        } else {
            System.out.println("Invalid vote! Candidate not found.");
        }
    }

    public synchronized HashMap<String, Integer> getResults() { // Ensure thread safety
        return new HashMap<>(candidates);
    }

    public abstract String getCategoryName();
}