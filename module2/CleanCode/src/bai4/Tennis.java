package bai4;

public class Tennis {
    public static String deuce(int player1score){
        switch (player1score)
        {
            case 0:
                return  "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    public static String getScore( int player1score, int player2score) {
        String score="";
        int tempScore=0;
        if (player1score==player2score)
            deuce(player1score);
        if (player1score>=4 || player2score>=4)
        {
            int minusResult = player1score-player2score;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1score;
                else { score+="-"; tempScore = player2score;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
