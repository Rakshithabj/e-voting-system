package voting.display;

import voting.categories.VoteCategory;

public class ResultDisplay extends Thread {
    private VoteCategory category;

    public ResultDisplay(VoteCategory category) {
        this.category = category;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) { // Allow interruption
                Thread.sleep(30000); // Increase delay to 10 seconds
                System.out.println("Live results for " + category.getCategoryName() + ":");
                category.getResults().forEach((candidate, votes) ->
                    System.out.println(candidate + ": " + votes)
                );
                System.out.println("---------------------------");
            }
        } catch (InterruptedException e) {
            System.out.println("Result display interrupted.");
        }
    }
}