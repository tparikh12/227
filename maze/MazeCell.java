package hw3;
import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Tanay Parikh
 */
import maze.Status;

/**
 * Implementation of MazeCell that has a location in a 2D plane.
 */
public class MazeCell 
{	/**
	the variable that holds time 
	*/
	private int timeStamp ;
	/**
	 * the variable that holds status
	 */
	private Status status;
	  private ArrayList<MazeCell> neighbor;
	  /**
	   * the variable that holds rows
	   */
	  private int row;
	  /**
	   *  the variable that holds columns
	   */
	  private int cols;
	  private MazeCell parent;
	  private Maze owner;
	 

	/**
	 * Constructs a maze cell whose location is specified by the given row
	 *  and column, whose status is WALL by default, and whose parent is null
	 *  . The cell initially has no neighbors. Its initial time stamp is 0.
	 * @param row
	 * @param col
	 */
	public MazeCell(int row,int col)
	{
		this.row = row;
		cols = col;
		status = status.WALL;
		parent = null;
		timeStamp = 0;
		neighbor = new ArrayList<>();
	}
	
 
  /**
   * Adds an observer for changes in this cell's status.
   * @param obs
   */
  public void setOwner(Maze maze)
  {
    owner = maze;    
  }
  /**
   * Returns this cell's location as a point, which contains its row and column.
   * @return
   */
 public java.awt.Point getLocation()
 {

	 Point x = new Point(row,cols);
	 return x;
	
 }
 
  /**
   * Adds a neighbor to this cell.
   * @param m
   */
  public void addNeighbor(MazeCell m)
  {
	  neighbor.add(m);
	 
  }
  /**
   * Returns the neighbors of the current cell. If a cell has no neighbor, 
   * the method must still return an ArrayList, which is empty.
   * @return
   */
  public java.util.ArrayList<MazeCell> getNeighbors()
  {
	  return neighbor;
  }
 
  /**
   * Update the status of this cell and notifies the owner that this current cell's status has changed 
   * @param cell
   */
  public void setStatus(Status s)
  {
    status = s;
    if (owner != null)
    {
      owner.updateStatus(this);
    }
  }

  /**
   * return the status of the current the status
   * @return status
   */
  public Status getStatus()
  {
    return status;
  }
  /**
   * Returns a string representation of this cell's row and column
   *  numbers enclosed by a pair of parenthesis, e.g., (3, 4), or (10, 0).
   * @return
   */
  
  public java.lang.String toString()
  {
	  String hold = "("+ row + "," + cols + ")";
	  return hold;
	  /**
	   * a string variable that hold row and col in string 
	   * and then return the variable 
	   */  
  }
  /**
   * 
   * @return
   */
  public MazeCell getParent()
  {
	  return parent;
  }
 
  /**
   * Sets the parent of this cell with the given parent
   * @param parent
   */
 
  public void setParent(MazeCell parent)
  {
	  this.parent= parent;
  }
  /**
   * Returns the time stamp of this cell
   * @return
   */
  public int getTimeStamp()
  {
	  return timeStamp;
  }
  
  /**
   * Sets the time stamp of this cell
   * @param time
   */
  public void setTimeStamp(int time)
  {
	  timeStamp = time ;
  }
  /**
   * Computes the Manhattan distance between this cell and other cell. 
   * The distance between two points measured along axes at right angles.
   *  In a plane with p1 at (x1, y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|
   * @param other
   * @return
   */

  public int distance(MazeCell other)
  {
	  int answer =(row - other.row )+(cols - other.cols);
	  if(answer < 0)
		  answer = answer * -1;
	return answer; 
  }
}



