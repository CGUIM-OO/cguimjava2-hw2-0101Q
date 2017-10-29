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
 * Description: Deck�|�إߥH"��"�����ƶq���P(�@�Ƭ�52�i�P)
 * ArrayList<Card> cards �ΨӦs�Ҧ����P
 * Deck�N�|�q�Ĥ@�ƵP���Ĥ@�Ӫ��(Clubs)���Ĥ@�ӼƦr(Ace)�}�l�إߵP�B�s�icards��
 * �s���@�Ӫ�⪺�Ҧ��j�p�~�|���U�@�Ӫ��,�s���@�ƵP�|�����|�ƪ��~�|���s�U�@�ƵP,�H������
 * printDeck()�|�L�X�ҭn�D���P
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)���F
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		//����
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
		int n=0;//n���@�ӥΨӨ�while�i�H�B�檺��,�]�ΨӨ�cards.get()�ҭn�o�쪺���e
		while(cards.size()>n)//n�b���j��|�C�]�@���N�[�@,�ҥH���X�i�P�N�|�i��X��
		{ 
			Card card=new Card(cards.get(n).getSuit(),cards.get(n).getRank());
			//�����Card,�a�J����cards�̭��Ҧs���(�H�Ʀr���)cards.get().getSuit()�P�Ʀr(�H�Ʀr���)cards.get(n).getRank()
			card.printCard();//����Card class �̪�printCard()�N�L�X���P
			n++;
		}
		
	
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description: Card�N�إ�"�P",�C�@�i�P�]�t���(suit)�P�P���j�p(rank)
 * �]���P���|�ت��P13�Ӥj�p,�@52�`�զX
 * getSuit()�i�H�o��P�����ҥN���Ʀr
 * getRank()�i�H�o��o�쪺�P�ҥN���Ʀr
 * �o�쪺�Ʀr�i�H�bprintCard()�i��������ܬ�����P�j�p�åB�L�X�P
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
		//R�O�ΨӦs�P�|����13�ؤj�p,�]���P���j�p���O�Ҧ����ѼƦr��ܩҥH��String
		if((getSuit()==1))//��getSuit()=1,���ɪ��OClubs
		{
			System.out.println("Clubs,"+R[(getRank()-1)]);//��1�O���F���T���X�P���j�p
		}
		else if(getSuit()==2)//��getSuit()=2,���ɪ��ODiamonds
		{
			System.out.println("Diamonds,"+R[(getRank()-1)]);//��1�O���F���T���X�P���j�p
		}
		else if(getSuit()==3)//��getSuit()=3,���ɪ��OHearts
		{
			System.out.println("Hearts,"+R[(getRank()-1)]);//��1�O���F���T���X�P���j�p
		}
		else//��getSuit()=4,���ɪ��OSpades
		{
			System.out.println("Spades,"+R[(getRank()-1)]);//��1�O���F���T���X�P���j�p
		}
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
