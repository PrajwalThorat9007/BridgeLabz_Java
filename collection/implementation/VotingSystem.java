package collection.implementation;

/*
 * Question 3: Design a Voting System
 *
 * Description: Design a system where:
 * - Votes are stored in a HashMap (Candidate -> Votes)
 * - TreeMap is used to display the results in sorted order
 * - LinkedHashMap is used to maintain the order of votes
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VotingSystem {

    // Candidate class representing a candidate in the election
    static class Candidate {
        private String candidateId;
        private String name;
        private String party;
        private String manifesto;

        public Candidate(String candidateId, String name, String party, String manifesto) {
            this.candidateId = candidateId;
            this.name = name;
            this.party = party;
            this.manifesto = manifesto;
        }

        public String getCandidateId() {
            return candidateId;
        }

        public String getName() {
            return name;
        }

        public String getParty() {
            return party;
        }

        public String getManifesto() {
            return manifesto;
        }

        @Override
        public String toString() {
            return name + " (" + party + ")";
        }
    }

    // Vote class to track individual votes with timestamp
    static class Vote {
        private String voterId;
        private String candidateId;
        private LocalDateTime timestamp;

        public Vote(String voterId, String candidateId) {
            this.voterId = voterId;
            this.candidateId = candidateId;
            this.timestamp = LocalDateTime.now();
        }

        public String getVoterId() {
            return voterId;
        }

        public String getCandidateId() {
            return candidateId;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
            return "Vote[Voter: " + voterId + ", Candidate: " + candidateId +
                    ", Time: " + timestamp.format(formatter) + "]";
        }
    }

    // Election Manager class
    static class ElectionManager {
        private Map<String, Candidate> candidates;
        private Map<String, Integer> voteCount; // HashMap: Candidate ID -> Vote Count
        private Map<String, Integer> voteOrderMap; // LinkedHashMap: Maintains vote casting order
        private Set<String> votedVoters; // Track who has voted
        private List<Vote> voteHistory; // Complete vote history

        public ElectionManager() {
            candidates = new HashMap<>();
            voteCount = new HashMap<>();
            voteOrderMap = new LinkedHashMap<>();
            votedVoters = new HashSet<>();
            voteHistory = new ArrayList<>();
        }

        // Register a candidate
        public void registerCandidate(Candidate candidate) {
            candidates.put(candidate.getCandidateId(), candidate);
            voteCount.put(candidate.getCandidateId(), 0);
            System.out.println("Registered: " + candidate);
        }

        // Cast a vote
        public boolean castVote(String voterId, String candidateId) {
            // Check if voter has already voted
            if (votedVoters.contains(voterId)) {
                System.out.println("Error: Voter " + voterId + " has already voted!");
                return false;
            }

            // Check if candidate exists
            if (!candidates.containsKey(candidateId)) {
                System.out.println("Error: Candidate " + candidateId + " not found!");
                return false;
            }

            // Record the vote
            Vote vote = new Vote(voterId, candidateId);
            voteHistory.add(vote);
            votedVoters.add(voterId);

            // Update vote counts in HashMap
            voteCount.put(candidateId, voteCount.get(candidateId) + 1);

            // Update LinkedHashMap to maintain order
            voteOrderMap.put(candidateId, voteCount.get(candidateId));

            System.out.println("Vote cast successfully: " + voterId + " -> " +
                    candidates.get(candidateId).getName());
            return true;
        }

        // Display results using HashMap (unsorted)
        public void displayResultsHashMap() {
            System.out.println("=== Election Results (HashMap - Unsorted) ===");

            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                Candidate candidate = candidates.get(entry.getKey());
                System.out.println(candidate.getName() + " (" + candidate.getParty() + "): " +
                        entry.getValue() + " votes");
            }
        }

        // Display results using TreeMap (sorted by candidate name)
        public void displayResultsTreeMapByCandidateName() {
            System.out.println("=== Election Results (TreeMap - Sorted by Candidate Name) ===");

            // Create TreeMap from HashMap
            TreeMap<String, Integer> sortedByName = new TreeMap<>();

            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                String candidateName = candidates.get(entry.getKey()).getName();
                sortedByName.put(candidateName, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : sortedByName.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
            }
        }

        // Display results sorted by vote count (descending)
        public void displayResultsSortedByVoteCount() {
            System.out.println("=== Election Results (Sorted by Vote Count - Descending) ===");

            // Create list from map entries
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteCount.entrySet());

            // Sort by vote count (descending)
            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            int rank = 1;
            for (Map.Entry<String, Integer> entry : sortedList) {
                Candidate candidate = candidates.get(entry.getKey());
                System.out.println(rank + ". " + candidate.getName() + " (" + candidate.getParty() +
                        "): " + entry.getValue() + " votes");
                rank++;
            }
        }

        // Display results using LinkedHashMap (maintains order of vote casting)
        public void displayResultsLinkedHashMap() {
            System.out.println("=== Election Results (LinkedHashMap - Order of First Vote Cast) ===");

            for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
                Candidate candidate = candidates.get(entry.getKey());
                System.out.println(candidate.getName() + " (" + candidate.getParty() + "): " +
                        entry.getValue() + " votes");
            }
        }

        // Get winner(s)
        public List<Candidate> getWinners() {
            int maxVotes = Collections.max(voteCount.values());
            List<Candidate> winners = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                if (entry.getValue() == maxVotes) {
                    winners.add(candidates.get(entry.getKey()));
                }
            }

            return winners;
        }

        // Display winner
        public void announceWinner() {
            List<Candidate> winners = getWinners();

            if (winners.isEmpty()) {
                System.out.println("No votes cast yet!");
                return;
            }

            int maxVotes = voteCount.get(winners.get(0).getCandidateId());

            if (winners.size() == 1) {
                Candidate winner = winners.get(0);
                System.out.println("\n*** WINNER ***");
                System.out.println(winner.getName() + " (" + winner.getParty() + ")");
                System.out.println("Total Votes: " + maxVotes);
                System.out.println("Vote Percentage: " + String.format("%.2f%%",
                        (maxVotes * 100.0 / getTotalVotes())));
            } else {
                System.out.println("\n*** TIE - Multiple Winners ***");
                for (Candidate winner : winners) {
                    System.out.println("- " + winner.getName() + " (" + winner.getParty() + "): " +
                            maxVotes + " votes");
                }
            }
        }

        // Get total votes cast
        public int getTotalVotes() {
            return votedVoters.size();
        }

        // Get voting statistics
        public void displayStatistics() {
            System.out.println("=== Voting Statistics ===");
            System.out.println("Total Candidates: " + candidates.size());
            System.out.println("Total Votes Cast: " + getTotalVotes());
            System.out.println("Voter Turnout: " + getTotalVotes() + " voters");

            // Calculate vote percentage for each candidate
            System.out.println("\nVote Distribution:");
            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                Candidate candidate = candidates.get(entry.getKey());
                double percentage = (entry.getValue() * 100.0) / getTotalVotes();
                System.out.printf("%s: %d votes (%.2f%%)%n",
                        candidate.getName(), entry.getValue(), percentage);
            }
        }

        // Display vote history
        public void displayVoteHistory() {
            System.out.println("=== Vote History (Chronological Order) ===");

            if (voteHistory.isEmpty()) {
                System.out.println("No votes cast yet.");
                return;
            }

            for (int i = 0; i < voteHistory.size(); i++) {
                Vote vote = voteHistory.get(i);
                Candidate candidate = candidates.get(vote.getCandidateId());
                System.out.println((i + 1) + ". " + vote.getVoterId() + " voted for " +
                        candidate.getName() + " at " +
                        vote.getTimestamp().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        }

        // Get candidate by ID
        public Candidate getCandidate(String candidateId) {
            return candidates.get(candidateId);
        }

        // Display all candidates
        public void displayAllCandidates() {
            System.out.println("=== Registered Candidates ===");

            for (Candidate candidate : candidates.values()) {
                System.out.println("ID: " + candidate.getCandidateId());
                System.out.println("Name: " + candidate.getName());
                System.out.println("Party: " + candidate.getParty());
                System.out.println("Manifesto: " + candidate.getManifesto());
                System.out.println("Current Votes: " + voteCount.get(candidate.getCandidateId()));
                System.out.println("---");
            }
        }

        // Check if voter has voted
        public boolean hasVoted(String voterId) {
            return votedVoters.contains(voterId);
        }

        // Get results by party
        public Map<String, Integer> getResultsByParty() {
            Map<String, Integer> partyVotes = new HashMap<>();

            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                Candidate candidate = candidates.get(entry.getKey());
                String party = candidate.getParty();
                partyVotes.put(party, partyVotes.getOrDefault(party, 0) + entry.getValue());
            }

            return partyVotes;
        }

        // Display results by party
        public void displayResultsByParty() {
            System.out.println("=== Results by Party ===");
            Map<String, Integer> partyVotes = getResultsByParty();

            // Sort by votes descending
            List<Map.Entry<String, Integer>> sortedParties = new ArrayList<>(partyVotes.entrySet());
            sortedParties.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            for (Map.Entry<String, Integer> entry : sortedParties) {
                double percentage = (entry.getValue() * 100.0) / getTotalVotes();
                System.out.printf("%s: %d votes (%.2f%%)%n",
                        entry.getKey(), entry.getValue(), percentage);
            }
        }
    }

    public static void main(String[] args) {
        ElectionManager election = new ElectionManager();

        System.out.println("=== NATIONAL ELECTION VOTING SYSTEM ===\n");

        // Register candidates
        System.out.println("--- Registering Candidates ---");
        election.registerCandidate(new Candidate("C001", "Alice Johnson", "Progressive Party",
                "Education and Healthcare Reform"));
        election.registerCandidate(new Candidate("C002", "Bob Williams", "Conservative Party",
                "Economic Growth and Security"));
        election.registerCandidate(new Candidate("C003", "Carol Davis", "Liberal Party",
                "Environmental Protection"));
        election.registerCandidate(new Candidate("C004", "David Brown", "Progressive Party",
                "Social Justice and Equality"));
        election.registerCandidate(new Candidate("C005", "Eve Martinez", "Independent",
                "Community Development"));

        System.out.println();

        // Display all candidates
        election.displayAllCandidates();
        System.out.println();

        // Cast votes
        System.out.println("--- Casting Votes ---");
        election.castVote("V001", "C001");
        election.castVote("V002", "C002");
        election.castVote("V003", "C001");
        election.castVote("V004", "C003");
        election.castVote("V005", "C001");
        election.castVote("V006", "C002");
        election.castVote("V007", "C004");
        election.castVote("V008", "C001");
        election.castVote("V009", "C002");
        election.castVote("V010", "C003");
        election.castVote("V011", "C005");
        election.castVote("V012", "C001");
        election.castVote("V013", "C002");
        election.castVote("V014", "C001");
        election.castVote("V015", "C003");

        // Try to vote twice
        System.out.println();
        election.castVote("V001", "C002"); // Should fail

        System.out.println();

        // Display results using HashMap (unsorted)
        election.displayResultsHashMap();
        System.out.println();

        // Display results using TreeMap (sorted by name)
        election.displayResultsTreeMapByCandidateName();
        System.out.println();

        // Display results sorted by vote count
        election.displayResultsSortedByVoteCount();
        System.out.println();

        // Display results using LinkedHashMap (order of first vote)
        election.displayResultsLinkedHashMap();
        System.out.println();

        // Display statistics
        election.displayStatistics();
        System.out.println();

        // Display results by party
        election.displayResultsByParty();
        System.out.println();

        // Announce winner
        election.announceWinner();
        System.out.println();

        // Display vote history
        election.displayVoteHistory();

        System.out.println("\n=== Election Complete ===");
    }
}