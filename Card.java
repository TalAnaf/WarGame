// Class for the card for War.
public class Card {
    // Decleration
    final private String shape; //The shape of the card
    final private String rank; // the number or the name of the card
    private int value; // number value

    // Constructor
    public Card(String shape, String rank) {
        this.shape = shape;
        this.rank = rank;
        this.value = WhatIsTheValue(rank);
    }
    //Functions to get the shape , the rank and the value
    public String getShape() {
        return shape;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    //Function to print the card's value
    public String toStringCard() {
        return this.shape + " " + this.rank;
    }
    //function the returns the value of the card in numbers (for comparations)
    private int WhatIsTheValue(String check) {
        switch (check) {
            case "Ace":
                return 14;
            case "King":
                return 13;
            case "Queen":
                return 12;
            case "Jack":
                return 11;
            default:
                // In case the number on the card is from 1 to 10
                return Integer.parseInt(check);

        }
    }

}
