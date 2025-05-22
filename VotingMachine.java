package voting.system;

import voting.categories.*;
import voting.display.ResultDisplay;
import voting.exceptions.DoubleVoteException;

import java.util.*;

public class VotingMachine {
    private static Set<String> votedVoters = new HashSet<>();
    private static boolean votingStarted = false; // Flag to control result display

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VoteCategory president = new PresidentVote();
        VoteCategory mayor = new MayorVote();

        ResultDisplay displayPresident = new ResultDisplay(president);
        ResultDisplay displayMayor = new ResultDisplay(mayor);

        while (true) {
            System.out.print("\nEnter Voter ID (or type 'exit'): ");
            while (!sc.hasNextLine()) {} // Wait for input
            String voterID = sc.nextLine().trim();
            if (voterID.equalsIgnoreCase("exit")) break;

            try {
                if (votedVoters.contains(voterID)) {
                    throw new DoubleVoteException("You have already voted!");
                }

                // Start result display threads only after first vote
                if (!votingStarted) {
                    displayPresident.start();
                    displayMayor.start();
                    votingStarted = true;
                }

                System.out.println("Vote for President: Alice / Bob");
                while (!sc.hasNextLine()) {} // Wait for input
                String pres = sc.nextLine().trim();
                while (!pres.equalsIgnoreCase("Alice") && !pres.equalsIgnoreCase("Bob")) {
                    System.out.println("Invalid choice! Please vote for Alice or Bob:");
                    while (!sc.hasNextLine()) {} // Wait for input
                    pres = sc.nextLine().trim();
                }
                president.vote(pres); // Ensure vote is recorded

                System.out.println("Vote for Mayor: Tom / Jerry");
                while (!sc.hasNextLine()) {} // Wait for input
                String may = sc.nextLine().trim();
                while (!may.equalsIgnoreCase("Tom") && !may.equalsIgnoreCase("Jerry")) {
                    System.out.println("Invalid choice! Please vote for Tom or Jerry:");
                    while (!sc.hasNextLine()) {} // Wait for input
                    may = sc.nextLine().trim();
                }
                mayor.vote(may); // Ensure vote is recorded

                votedVoters.add(voterID);
                System.out.println("Thank you for voting!\n");

            } catch (DoubleVoteException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Voting ended.");
        displayPresident.interrupt();
        displayMayor.interrupt();
        sc.close();
    }
}