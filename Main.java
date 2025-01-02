import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Declaration
        Deck player1 = new Deck();
        Deck player2 = new Deck();
        List <Card> cardsAfterMove = new ArrayList<>(); // Cards on the table after each move
        boolean warModeFlag = false; // Flag for war mode
        boolean player1Won = false; // Flag if Player 1 has won
        boolean player2Won = false; // Flag if Player 2 has won
        String player1Name;
        String numOfCards;
        String player2Name;

        // Startup message
        JOptionPane.showMessageDialog(null,"Welcome to War Game!");

        // Get the names of the players
        player1Name = JOptionPane.showInputDialog("Please enter the name of player no. 1: ");
        player1.SetNameOfPlayer(player1Name);
        forExit(player1Name); // Check if Player 1 wants to exit the game
        player2Name = JOptionPane.showInputDialog("Please enter the name of player no. 2: ");
        player2.SetNameOfPlayer(player2Name);
        forExit(player2Name); // Check if Player 2 wants to exit the game

        // Start the game
        JOptionPane.showMessageDialog(null,"Get ready to play War :)");

        do {
            // Declaration of new cards for each move
            Card player1Card; // Card drawn by Player 1
            Card player2Card; // Card drawn by Player 2
            String winner; // Winner of the move

            // Check if the game is in war mode
            if (warModeFlag) {
                // Draw a card for each player in war mode
                player1Card = player1.WarMode();
                player2Card = player2.WarMode();

                // Get all the cards from the war mode
                cardsAfterMove.addAll(player1.getCardAfterWarMode());
                cardsAfterMove.addAll(player2.getCardAfterWarMode());

                JOptionPane.showMessageDialog(null, "War mode!");
            } else {
                // In case its not a war mode , the program will take one card from every player.
                player1Card = player1.getCard();
                player2Card = player2.getCard();

                // Add the cards to arraylist
                cardsAfterMove.add(player1Card);
                cardsAfterMove.add(player2Card);
            }

            // Show the cards of the players
            String player1CardString = "The card of " + player1Name + " is: " + player1Card.toStringCard() + ".\n";
            String player2CardString = "The card of " + player2Name + " is: " + player2Card.toStringCard()+ ".\n";
            String moveString = player1CardString + player2CardString;
            JOptionPane.showMessageDialog(null, moveString);

            // Show the number of cards each player has in total and the cards on the "table"
            numOfCards = "The number of cards for " + player1Name + " is: " + player1.getNumOfCards() + ". \n"
                    + "The number of cards for " + player2Name + " is: " + player2.getNumOfCards() + ". \n"
                    + "The number of cards on the board is : " + " " + cardsAfterMove.size();
            JOptionPane.showMessageDialog(null, numOfCards);

            // Check the result of the move
            if (player1Card.getValue() == player2Card.getValue()){
                // If both cards have the same value, it's a war
                winner = "Both of the cards are: " + player1Card.toStringCard() + "! \n" + "Get ready for war ";
                JOptionPane.showMessageDialog(null, winner);
                warModeFlag = true;
                continue;
            } else if (player1Card.getValue() > player2Card.getValue()) {
                // If Player 1's card has a higher value, Player 1 wins the move
                winner = "The winner for this move is: " + player1Name + "!";
                player2.setCardAfterWarMode(cardsAfterMove);
                JOptionPane.showMessageDialog(null, winner);
            } else if (player1Card.getValue() < player2Card.getValue()) {
                // If Player 2's card has a higher value, Player 2 wins the move
                player1.setCardAfterWarMode(cardsAfterMove);
                winner = "The winner for this move is: " + player2Name + "!";
                JOptionPane.showMessageDialog(null, winner);
                if (warModeFlag) {
                    warModeFlag = false;
                }
            }

            // Show the number of cards each player has after the move
            numOfCards = "The number of cards for " + player1Name + " is: " + player1.getNumOfCards() + ". \n"
                    + "The number of cards for " + player2Name + " is: " + player2.getNumOfCards() + ". \n";
            JOptionPane.showMessageDialog(null, numOfCards);

            // Check if a player has won the game
            if (player1.isEmpty()){
                player1Won = true;
            } else if (player2.isEmpty()){
                player2Won = true;
            }
            // Clear the table
            cardsAfterMove.clear();
            // Check if the player wants to quit
            if(-1 == nextMove()){
                endOfGame();
            }
        } while (!player1Won && !player2Won); // Continue the game until a player wins

        // Announce the winner of the game
        if (player1Won){
            JOptionPane.showMessageDialog(null, "The winner of the game is : " + player1Name +"!");
        } else if (player2Won){
            JOptionPane.showMessageDialog(null, "The winner of the game is: " + player2Name +"!");
        }
        // End the game
        endOfGame();
    }

    // Function that checks if the player wants to continue for the next move
    public static int nextMove(){
        String[] options = { "Yes", "Exit" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to continue for the next move?", "Choose an Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    // Function that ends the game
    public  static void endOfGame() {
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
        System.exit(0);
    }

    // Function that checks if an object is null and ends the game if it is
    public static void forExit(Object temp){
        if (temp == null){
            endOfGame();
        }
    }
}
