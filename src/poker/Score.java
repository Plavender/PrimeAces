package poker;

/**
 * This class has lots of older code.  It has been all commented out and the new code only determines
 * the winner of the game in the method pickWinner().  There is a swap() method to facilitate a 
 * sorting routine in the pickWinner() method.
 * @author Steven Honda
 */
public class Score{
  
//	public static int playerWin (String[] pCards, String[] cCards, String[] sharedCards){
//    
//		float pScore = 0;
//		int pHighcard = 0;
//		float cScore = 0;
//		int cHighcard = 0;
//		String[] pHand = {sharedCards[0],sharedCards[1],sharedCards[2],sharedCards[3],
//                       sharedCards[4],pCards[0],pCards[1]};
//		String[] cHand = {sharedCards[0],sharedCards[1],sharedCards[2],sharedCards[3],
//                      sharedCards[4],cCards[0],cCards[1]};
//		float temp = 0;
//
//		for (int i = 0; i < 3; i++){
//			for (int j = i + 1; j < 4; j++){
//				for (int k = j + 1; k < 5; k++){
//					for (int l = k + 1; l < 6; l++){
//						for (int m = l + 1; m < 7; m++){
//							String[] hand = {pHand[i],pHand[j],pHand[k],pHand[l],pHand[m]};
//							temp = determineScore (hand);
//							if (pScore < temp)
//								pScore = temp;
//						}
//					}
//				}
//			}
//		}
//		for (int i = 0; i < 3; i++){
//			for (int j = i + 1; j < 4; j++){
//				for (int k = j + 1; k < 5; k++){
//					for (int l = k + 1; l < 6; l++){
//						for (int m = l + 1; m < 7; m++){
//							String[] hand = {cHand[i],cHand[j],cHand[k],cHand[l],cHand[m]};
//							temp = determineScore (hand);
//							if (cScore < temp)
//								cScore = temp;
//						}
//					}
//				}
//			}
//		}
//
//		for (int p = 0; p < 2; p++){
//			if (Integer.parseInt(pCards[p].substring(2)) > pHighcard)
//				pHighcard = Integer.parseInt(pCards[p].substring(2));
//		}
//
//		for (int c = 0; c < 2; c++){
//			if (Integer.parseInt(cCards[c].substring(2)) > cHighcard)
//				cHighcard = Integer.parseInt(cCards[c].substring(2));
//		}
//
////0 = Win, 1 = Lose, 2 = Tie
//
//		if (pScore > cScore)
//			return 0;
//		else if (pScore == cScore){
//			if (pHighcard > cHighcard)
//				return 0;
//			else if (pHighcard == cHighcard)
//				return 2;
//			else
//				return 1;}
//		else
//			return 1;
//	}
//  
//  private static float determineScore (String hand[]){
//    int temp = 0;
//    int card[] = {0,0,0,0,0};
//    char suit[] = {0,0,0,0,0};
//
//    for (int i = 0; i < 5; i++){
//      card[i] = Integer.parseInt(hand[i].substring(2));
//      suit[i] = hand[i].charAt(0);
//    }
//    for (int j = 0; j < 4; j++){
//      int highValue = 0;
//      for (int k = 1; k < 5; k++){
//        if (highValue < card[k])
//          highValue = k;
//      }
//      if (card[j] < card[highValue]){
//        temp = card[j]; card[j] = card[highValue]; card[highValue] = temp; temp = 0;}
//    }
//
//    float score = 0;
//
////0 = High Card, 1 = Pair, 2 = Two Pair, 3 = Three of a Kind, 4 = Straight,
////5 = Flush, 6 = Full House, 7 = Four of a Kind, 8 = Straight Flush
//
//    if (card[1] == card[0]){
//      if (card[2] == card[1]){
//        if (card[3] == card[2])
//          score = 7 + (card[0]/100);
//        else if (card[4] == card[3])
//          score = 6 + (card[0]/100);
//        else
//          score = 3 + (card[0]/100);}
//      else if (card[3] == card[2]){
//        if (card[4] == card[3])
//          score = 6 + (card[0]/100);
//        else
//          score = 2 + (card[0]/100);}
//      else if (card[4] == card[3])
//        score = 2 + (card[0]/100);
//      else
//        score = 1 + (card[0]/100);}
//    else if (card[2] == card[1]){
//      if (card[3] == card[2]){
//        if (card[4] == card[3])
//          score = 7 + (card[1]/100);
//        else
//          score = 3 + (card[1]/100);}
//      else if (card[4] == card[3])
//        score = 2 + (card[1]/100);
//      else
//        score = 1 + (card[1]/100);}
//    else if (card[3] == card[2]){
//      if (card[4] == card[3])
//        score = 3 + (card[2]/100);
//      else
//        score = 1 + (card[2]/100);}
//    else if (card[4] == card[3])
//      score = 1 + (card[3]/100);
//    else if (card[0] == card[1] + 1 || card[0] == card[1] + 9){
//      if (card[1] == card[2] + 1){
//        if (card[2] == card[3] + 1){
//          if (card[3] == card[4] + 1){
//            if (suit[0] == suit[1]){
//              if (suit[1] == suit[2]){
//                if (suit[2] == suit[3]){
//                  if (suit[3] == suit[4])
//                    score = 8 + (card[0]/100);}}}
//            else
//              score = 4 + (card[0]/100);}}}}
//    else if (suit[0] == suit[1]){
//      if (suit[1] == suit[2]){
//    	if (suit[2] == suit[3]){
//          if (suit[3] == suit[4])
//            score = 5;}}}
//    else
//      score = 0;
//
//    return score;
	/**
	 * This class will first sort the array of players by score and determine the winning
	 * player by the scores.  It will also check for high card to determine the winner.
	 * @param Array of player objects
	 * @return Winning player
	 */
	public Player pickWinner(){ // this isn't sorting god damnit
		//first sort Players by score
		int out, in;
		for(out = Player.numPlayers - 1 ; out > 1; out--){
			for(in = 0; in < out; in++)
				if(Player.players[in].getScore() < Player.players[in + 1].getScore())
					swap(in, in + 1);
		}
		return Player.players[0];
	}
	/**
	 * This method is used to swap players in the array if players for a sorting routine.
	 * @param one
	 * @param two
	 * @author Steven Honda
	 */
	public void swap(int one, int two){
		Player temp = Player.players[one];
		Player.players[one] = Player.players[two];
		Player.players[two] = temp;
	}
}