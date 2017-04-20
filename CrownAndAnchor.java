class CrownAndAnchor {
	static int numberOfThrows = 100000;
	static int result = 0;
	static int wins = 0;
	public static void main(String args[]){
		for(int i = 0; i < numberOfThrows; i++){
			int score = -1;
			score = throwDice(score);
			score = throwDice(score);
			score = throwDice(score);
			if (score > 0){
				wins += 1;
			}
			result += score;
		}

		double winRatio = Math.floor((double)wins/(double)numberOfThrows * 10000) / 100;
		String favoredString = "";
		if(winRatio < 50){
			favoredString = "The House";
		} else if(winRatio > 50){
			favoredString  = "The Player";
		}

		String resultString = "";
		if(result < 0){resultString += "-$"; result = Math.abs(result);
		}else{resultString += "$";}
		resultString += result;


		System.out.println("final score: " + resultString + " profit in " + numberOfThrows + " games, resulting in a ratio of: " + winRatio + "% wins, meaning that Crowns and Anchors favors " + favoredString);
	}

	static int throwDice(int score){
		int roll = (int)Math.floor(Math.random() * 6);
		if(roll == 0){
			score += (score < 0) ? 2 : 1;
		}
		return score;
	}
}
