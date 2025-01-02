import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
//Class that represent deck of cards
public class Deck {
    //Declaration
    private String nameOfPlayer; // String of the name of the players of this deck
    //Strings to define the values of the cards in the deck
    final private String[] deckShape = {"Hearts", "Diamonds", "Clubs", "Spades"};
    final private String[] deckRank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // Array for cards including "Ace" "King" "Queen" "Jack"
    //Array list for the deck of cards
    private List<Card> cards;

    private List<Card> CardAfterWarMode =  new ArrayList<>();

    public Deck() {
        cards = new ArrayList<>();
        for (String shape : deckShape) {
            for (String rank : deckRank) {
                // Create a new Card and add it to the list
                cards.add(new Card(shape, rank));
            }
        }
        // Shuffle the deck
        Collections.shuffle(cards);
    }
    //Function to set the name of the player
    public void SetNameOfPlayer (String name){
        this.nameOfPlayer = name;
    }

    //Function to get the card on the top of the deck and deletes it from the deck. The function will return the card
    public Card getCard(){
        Card cardOneMove = cards.get(0);
        cards.remove(0);
        return cardOneMove;
    }

    //Function for War mode
    public Card WarMode(){
        //Definding the numbers of moves for the warmode
        int endOfWarMode = 3;
        Card result = null;
        for (int i = 1; i<=endOfWarMode;i++){
            if (!isEmpty()) {
                result = getCard();
                CardAfterWarMode.add(result);
            }
            else break;
        }
        return result;
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public void setCardAfterWarMode(List<Card> temp){
        cards.addAll(temp);
    }
    public List getCardAfterWarMode(){
        List<Card> temp = new ArrayList<>();
        temp.addAll(CardAfterWarMode);
        CardAfterWarMode.clear();
        return temp;
    }
    public int getNumOfCards(){
        return cards.size();
    }

}