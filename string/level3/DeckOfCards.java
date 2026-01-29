package level3;

// Question: Create deck of cards, shuffle and distribute to players.

import java.util.Scanner;

class DeckOfCards {

    static String[] initializeDeck(String[] suits,String[] ranks){
        int n = suits.length * ranks.length;
        String[] deck = new String[n];
        int idx = 0;

        for(String suit : suits){
            for(String rank : ranks){
                deck[idx++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static String[] shuffleDeck(String[] deck){
        int n = deck.length;

        for(int i=0;i<n;i++){
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    static String[][] distribute(String[] deck,int players,int cards){
        if(players * cards > deck.length){
            System.out.println("Not enough cards to distribute!");
            return null;
        }

        String[][] table = new String[players][cards];
        int idx = 0;

        for(int i=0;i<players;i++){
            for(int j=0;j<cards;j++){
                table[i][j] = deck[idx++];
            }
        }
        return table;
    }

    static void display(String[][] players){
        for(int i=0;i<players.length;i++){
            System.out.println("\nPlayer " + (i+1) + " Cards:");
            for(int j=0;j<players[i].length;j++){
                System.out.println("  " + players[i][j]);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck = initializeDeck(suits,ranks);
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter cards per player: ");
        int cards = sc.nextInt();

        String[][] distributed = distribute(deck,players,cards);

        if(distributed!=null){
            display(distributed);
        }
    }
}


