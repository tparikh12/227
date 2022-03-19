package hw2;

public class TennisMatch {
/**
 * Name of player 1
 */
	private String NameP1;
	/**
	 * Name of player 2
	 */
	private String NameP2;
	/**
	 * Score for player 1
	 */
	private int scoreP1 = 0;
	/**
	 * Score for player 2
	 */
	private int scoreP2 = 0;
	/**
	 * updated score for player 1
	 */
	private int gameP1;
	/**
	 * updated score for player 2
	 */
	private int gameP2;
	/**
	 * set score for player 1
	 */
	private int setP1;
	/**
	 * set score for player 2
	 */
	private int setP2;
	/**
	 * Player 1's end 
	 */
	private int endP1;
	/**
	 * Player 2's end 
	 */
	private int endP2;
	/**
	 * holds if player 1 is severing or not 
	 */
	private boolean serverP1;
	private TennisPlayer p1;
	/**
	 * holds if player 2 is severing or not 
	 */
	private boolean serverP2;
	private TennisPlayer p2;
	/**
	 * holds if the ball is in play or not 
	 */
	private boolean ballInPlay = false;
	/**
	 * holds if the match is best of three 
	 * or best of five 
	 */
	private boolean bestOfThree = false;
	/**
	 * holds if the game is over or not 
	 */
	private boolean gameOver = false;
	/**
	 * keeps track of the faults
	 */
	private int countFault = 0;
	/**
	 * holds if fault happens or not
	 */
	private boolean fault = false;
	/**
	 * holds if the ball is severing or not
	 */
	private boolean ballServed = false;
	/**
	 * holds the name of the winner else holds null
	 */
	private String Winner = null;
	/**
	 * keeps track of who hit the last ball
	 */
	private boolean lastHit;
	
	/**
	 * Creates a new match
	 * @param p1Name
	 * @param p2Name
	 * @param playBestOfThree
	 * @param initialServer
	 * @param initialServerEnd
	 */
	public TennisMatch(java.lang.String p1Name, java.lang.String p2Name, boolean playBestOfThree, int initialServer, int initialServerEnd)
	{
		this.NameP1 = p1Name;
		this.NameP2 = p2Name;
		bestOfThree = playBestOfThree;
		if (initialServer == 1)
		{
			serverP1 = true;
			serverP2 = false;
		} 
		else
		{
			serverP1 = false;
			serverP2 = true;
		}
		if (serverP1 == true)
		{
			if (initialServerEnd == 1)
			{
				endP1 = 1;
				endP2 = 2;
			} 
			else
			{
				endP1 = 2;
				endP2 = 1;
			}
		} 
		else
		{
			if (initialServerEnd == 1)
			{
				endP1 = 2;
				endP2 = 1;
			} 
			else if(initialServerEnd == 2)
			{
				endP1 = 1;
				endP2 = 2;
			}
		}
		
		this.p1 = new TennisPlayer(p1Name, endP1);
		this.p2 = new TennisPlayer(p2Name, endP1);
	}
	/**
	 * Serves the ball. Does nothing if the game is over
	 */
	public void serve() 
	{
		if (gameOver == false)
		{
			
		}
		else 
		{
		ballInPlay = true;
		ballServed = true;
		if (serverP1 == true)
		{
			lastHit = true;
		}
		else
		{
			lastHit = false;
		}
		}
	}
	/**
	 * Registers a serve fault. 
	 * Does nothing if the ball is not being served.
	 *  Two serve faults yield a game point for the receiver.
	 */
	public void fault() 
	{
		if (ballServed == true)
		{
			countFault += 1;
			fault= true;
		}
		if (countFault == 2)
		{
			if (serverP1 == true)
			{
				incrementGamePoints(p1, p2);
				countFault = 0;
			} 
		}
		else
			{
				incrementGamePoints(p1, p2);
				countFault = 0;
			}
		}	
	/**
	 * Reverses the direction of the ball.
	 *  Ball is no longer being served.
	 *   Does nothing if the ball is not in play.
	 */
	public void returnBall()
	{
		ballServed = false;
		if (lastHit == true)
		{
			lastHit = false;
		}
		else
		{
			lastHit = true;
		}
	}
	/**
	 * Takes the ball out of play.
	 *  The player who last served or 
	 *  returned the ball scores a game point.
	 */
	public void failedReturn()
	{
		ballInPlay = false;
		if (serverP1 == true)
		{
			incrementGamePoints(p1, p2);
		}
	}
	/**
	 * Ends the current point early without a point being scored.
	 */
	public void let()
	{
		ballInPlay = false;
		ballServed = false;
	}
	/**
	 * returns the match score
	 * @return
	 */
	public java.lang.String getMatchScore()
	{
		return "Match Score:" + setP1 + "-" + setP2;
	}
	/**
	 * returns the set score
	 * @return
	 */
	public java.lang.String getSetScore()
	{
		
		return "Set score: "+ gameP1 + "-" + gameP2;
		
	}
	/**
	 * returns the Game score
	 * @return
	 */
	public java.lang.String getGameScore()//mostly wrong this should just return the score should happens somewhere else 
	{	
		
		
			return "Game Score:" + scoreP1 + "-" + scoreP2 + ",";
		
	}
	/**
	 * Set the game, set, and match scores
	 * @param p1Game
	 * @param p2Game
	 * @param p1Set
	 * @param p2Set
	 * @param p1Match
	 * @param p2Match
	 */
	public void setScore(int p1Game, int p2Game, int p1Set, int p2Set, int p1Match, int p2Match)
	{
		scoreP1 = p1Game;
		scoreP2 = p2Game;
		gameP1 = p1Set;
		gameP2 = p2Set;
		setP1 = p1Match;
		setP2 = p2Match;
	}
	/**
	 * returns all the score 
	 * @return
	 */
	public java.lang.String getScore()// this needs changing 
	{
		
		return "Game Score:" + scoreP1 + "-" + scoreP2 + "\n" + "Set Score :" + gameP1 + "-" + gameP2 + "\n" + "Match Score:" + setP1 + "-" + setP2;
	}
	/**
	 * sets the game score 
	 * @param p1Game
	 * @param p2Game
	 */
	public void setGameScore(int p1Game, int p2Game)
	{
		scoreP1 = p1Game;
		scoreP2 = p2Game;
	}
	/**
	 * sets the match score 
	 * @param p1Match
	 * @param p2Match
	 */
	public void setMatchScore(int p1Match, int p2Match)
	{
		setP1 = p1Match;
		setP2 = p2Match;
	}
	/**
	 * sets set score 
	 * @param p1Set
	 * @param p2Set
	 */
	public void setSetScore(int p1Set, int p2Set)
	{
		gameP1 = p1Set;
		gameP2 = p2Set;
	}
	/**
	 * sets the serve
	 * @param player
	 */
	public void setServe(int player)
	{
		if (player == 1)
		{
			serverP1 = true;
			serverP2 = false;
		}
		else 
		{
			serverP1 = false;
			serverP2 = true;
		}
	}
	/**
	 * Sets the server's end
	 * @param end
	 */
	public void setServerEnd(int end)
	{
		if (end == 1)
		{
		  if(serverP1 == true)
		  {
			  endP1 = 1;
			  endP2 = 2;
		  } else {
			  endP1 = 2;
			  endP2 = 1;
		  }
		}
		else 
		{
			 if(serverP1 == true)
			  {
				 endP1 = 2;
				 endP2 = 1;
				 
			  } else {
				  
				  endP1 = 1;
				  endP2 = 2;
			  }	
		}
	}
	/**
	 * Returns the winner's name, or
	 *  an error message if the game is not over.
	 * @return
	 */
	public java.lang.String getWinner()
	{
		if (gameOver == false)
		{
			return "error";
		} 
		else
		{
			return Winner;
		}
	}
	/**
	 * Swaps the ends of the two players
	 */
	public void changeEnds()// mostly wrong 
	{
		int endHolder = endP1;
		endP1 = endP2;
		endP2 = endHolder;
	}
	/**
	 * Swaps the server and receiver
	 */
	public void changeServer()//wrong 
	{
		boolean serverHolder = serverP1;
		serverP1 = serverP2;
		serverP2 = serverHolder;
	}
	/**
	 * Adds one game point to addTo's game total.
	 *  Zeros game score and increments set score if game has ended.
	 *   Removes ball from play. Clears faults.
	 * @param addTo
	 * @param noAdd
	 */
	public void incrementGamePoints(TennisPlayer addTo, TennisPlayer noAdd)
	{
		 if (addTo.getName().contentEquals(NameP1))
		 {
		  if (scoreP1 == 0 || scoreP1 == 15)
		  {
			  scoreP1 += 15;
		  }
		  else
		  {
			  scoreP1 += 10;
		  }
		 }
		 else
		 {
		  if (scoreP2 == 0 || scoreP2 == 15)
		  {
			  scoreP2 += 15;
		  }
		  else
		  {
			  scoreP2 += 10;
		  }
		 }
		 if ((scoreP1 == 50) && scoreP2 < 40)
		 {
			 incrementSetPoints(p1, p2);
		 }
			 
		 else if ((scoreP1 >= 50) && scoreP1 - 20 >= scoreP2) 
		 {
			 incrementSetPoints(p1, p2);
		 }
		  else if ((scoreP2 >= 50) && scoreP2 < 40)
		  {
			  incrementSetPoints(p2, p1);
		  }
		  else if ((scoreP2 >= 50) && scoreP2 - 20 >= scoreP1) 
		 {
			  incrementSetPoints(p2, p1);
		 }
		}
	/**
	 * Adds one set point to addTo's total.
	 *  Zeros set score and increments match score if set has ended.
	 *   Changes server. Changes ends after odd numbered sets.
	 * @param addTo
	 * @param noAdd
	 */
	public void incrementSetPoints(TennisPlayer addTo, TennisPlayer noAdd)
	{//was game  insted of set
		scoreP1 = 0;
		scoreP2 = 0;
		 if ((gameP1 + gameP2) % 2 == 0)
		 {
			 changeEnds();
		 }
		 if (addTo.getName().contentEquals(NameP1))
		 {
			 gameP1 ++;
		 }
		 else
		 {
			 gameP2 ++;
		 }
		 if (gameP1 >= 6 && gameP1 - 2 >= gameP2)// was or needed adds 
		 {
		  incrementMatchPoints(p1, p2);
		  gameP1 = 0;
		  gameP2 = 0;
		 }
		 else if (gameP2 >= 6 &&  gameP2 - 2 >= gameP1)
		 {
			 incrementMatchPoints(p2, p1);
			 gameP1 = 0;
			 gameP2 = 0;
		 }
	}
	/**
	 * Adds one match point to addTo's total. 
	 * Sets game over if match has ended.
	 * @param addTo
	 * @param noAdd
	 */
	public void incrementMatchPoints(TennisPlayer addTo, TennisPlayer noAdd)
	{

		  if(addTo.getName().contentEquals(NameP1))
		  {
			  setP1 ++;
		  }
		  else
		  {
			  setP2 ++;
		  }
		  if (bestOfThree == true)
		  {
			  if (setP1 == 2)
			  {
		        gameOver = true;
		        Winner = NameP1;
		      }
			  else if (setP2 == 2)
		      {
		        gameOver = true;
		        Winner = NameP2;
		      }
		  }
		  else if (bestOfThree == false)
		  {
			  if (setP1 == 3)
			  {
			    gameOver = true;
		        Winner = NameP1;
		   }
			  else if (setP2 == 3)
			  {
				gameOver = true;
		        Winner = NameP2;
			  }
		  }
	}
	/**
	 * Returns p1's end
	 * @return
	 */
	public int getP1End()
	{
		return endP1;
	}
	/**
	 * Returns p2's end
	 * @return
	 */
	public int getP2End()
	{
		return endP2;
	}
	/**
	 * Returns serve fault status
	 * @return
	 */
	public boolean getServeFault()
	{
		return fault;
	}
	/**
	 * Returns the server's name or "No server"
	 * @return
	 */
	public java.lang.String getServer()//change needed 
	{
		if (serverP1 == true)
		{
			return NameP1;
		}
		else if (serverP1 == false)
		{
			return NameP2;
		}
		else
		{
			return "No Server";
		}
	}
	/**
	 * Returns the reveiver's name or "No receiver"
	 * @return
	 */
	public java.lang.String getReceiver()
	{
		if (serverP1 == true)
		{
			return NameP2;
		}
		else if (serverP1 == false)
		{
			return NameP1;
		}
		else
		{
			return "No Reveiver";
		}
	}
	/**
	 * Returns the name of the player whom the ball is heading toward or
	 *  "Ball not in play"
	 * @return
	 */
	public java.lang.String getBallTo() //assuming not server
	{
		if (ballInPlay == false)
		{
			return "Ball not in play";
		}
		else 
		{
			if (serverP1 == true)
			{
				return NameP2;
			}
			else
			{
				return NameP1;
			}
		}
	}
	/**
	 * Returns the name of the player who last successfully served or
	 *  returned the ball or "Ball not in play"
	 * @return
	 */
	public java.lang.String getBallFrom()
	{
		if (ballInPlay == false)
		{
			return "Ball Not in play";
		}
		else
		{
			if ((serverP1 == true) && (ballServed == true))
			{
				return NameP1;
			}
			else if (((serverP1 == false) && (ballServed == true)))
			{
				return NameP2;
			}
			else if (((serverP1 == true) && (ballServed == false)))
			{
				return NameP2;
			}
			else
			{
				return NameP1;
			}
		}
	}
	/**
	 * Returns ballInPlay
	 * @return
	 */
	public boolean getBallInPlay()
	{
		return ballInPlay;
	}
	/**
	 * Returns ballServed
	 * @return
	 */
	public boolean getBallServed()
	{
		return ballServed;
	}
	/**
	 * returns bestOfThree
	 * @return
	 */
	public boolean getBestOfThree()
	{
		return bestOfThree;
	}
	/**
	 * Returns gameOver
	 * @return
	 */
	public boolean getGameOver()
	{
		return gameOver;
	}
	
	/**
	 * Returns player's name
	 * @param player
	 * @return
	 */
	public java.lang.String getName(int player)
	{
		if (player == 1)
		{
			return NameP1;
		} 
		else
		{
			return NameP2;
		}
	}
}
