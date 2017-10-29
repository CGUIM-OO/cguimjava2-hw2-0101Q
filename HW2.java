import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID: B0544145
 * Name: CaoJeiNi
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/*
 * Description: Deck會建立以"副"為單位數量的牌(一副為52張牌)
 * ArrayList<Card> cards 用來存所有的牌
 * Deck將會從第一副牌的第一個花色(Clubs)的第一個數字(Ace)開始建立牌且存進cards裡
 * 存完一個花色的所有大小才會換下一個花色,存完一副牌會有的四副花色才會換存下一副牌,以此類推
 * printDeck()會印出所要求的牌
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)做了
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		//嘗試
		for(int deck=1;deck<=nDeck;deck++)
		{
			for(int suit=1;suit<=4;suit++)
			{
				for(int Rank=1;Rank<=13;Rank++)
				{
					Card card=new Card(suit,Rank);
					cards.add(card);
				}
			}
		}
		
	}	//
	//TODO: Please implement the method to print all cards on screen (10 points)
	public  void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int n=0;//n為一個用來使while可以運行的數,也用來取cards.get()所要得到的內容
		while(cards.size()>n)//n在此迴圈會每跑一次就加一,所以有幾張牌就會進行幾次
		{ 
			Card card=new Card(cards.get(n).getSuit(),cards.get(n).getRank());
			//實體化Card,帶入的為cards裡面所存花色(以數字表示)cards.get().getSuit()與數字(以數字表示)cards.get(n).getRank()
			card.printCard();//執行Card class 裡的printCard()將印出此牌
			n++;
		}
		
	
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description: Card將建立"牌",每一張牌包含花色(suit)與牌的大小(rank)
 * 因為牌有四種花色與13個大小,共52總組合
 * getSuit()可以得到牌的花色所代表的數字
 * getRank()可以得到得到的牌所代表的數字
 * 得到的數字可以在printCard()進行對應轉變為其花色與大小並且印出牌
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
		suit=s;
		rank=r;
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		String []R={"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//R是用來存牌會有的13種大小,因為牌的大小不是所有都由數字表示所以用String
		if((getSuit()==1))//當getSuit()=1,此時花色是Clubs
		{
			System.out.println("Clubs,"+R[(getRank()-1)]);//減1是為了正確取出牌的大小
		}
		else if(getSuit()==2)//當getSuit()=2,此時花色是Diamonds
		{
			System.out.println("Diamonds,"+R[(getRank()-1)]);//減1是為了正確取出牌的大小
		}
		else if(getSuit()==3)//當getSuit()=3,此時花色是Hearts
		{
			System.out.println("Hearts,"+R[(getRank()-1)]);//減1是為了正確取出牌的大小
		}
		else//當getSuit()=4,此時花色是Spades
		{
			System.out.println("Spades,"+R[(getRank()-1)]);//減1是為了正確取出牌的大小
		}
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
