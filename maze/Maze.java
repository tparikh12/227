package hw3;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.text.Position;

/**
 * @author Tanay Parikh
 */
import maze.MazeObserver;
import maze.Status;

/**
 * A Maze consists of MazeCells arranged in a 2D grid.
 * 
 */
public class Maze {

	/**
	 * Observer to be notified in case of changes to cells in this maze.
	 */
	private MazeObserver observer;
	/**
	 * holds number of rows
	 */
	private int rows;
	/**
	 * holds number of columns 
	 */
	private int cols;
	/**
	 * holds the cell where it starts
	 */
	private MazeCell Start;
	/**
	 * holds the cell where the goal is 
	 */
	private MazeCell goal;
	/**
	 * The variable name of the 2d array 
	 */
	private MazeCell[][] setMaze;
	private Maze Owner;

	/**
	 * Constructs a maze based on a 2D grid. The given strings, rows, represent rows
	 * of a maze, where '#' represents a wall, a blank represents a possible path,
	 * 'S' represents the starting cell, and '$' represents the goal cell. The maze
	 * must be rectangular, which means the Strings in the given rows must have the
	 * same length. Also, there must be only one start cell and one goal cell in the
	 * maze. For each MazeCell in the maze, set its owner to be the current maze,
	 * its status as GOAL if it is the goal cell, UNVISITED if it is not the goal
	 * nor the wall. For each MazeCell that is accessible (not a wall), its
	 * accessible neighbors MUST be added in the order of top, left, bottom, right.
	 * Cells on the boundary of the maze or near a wall will have fewer accessible
	 * neighbors.
	 * 
	 * @param rows
	 */
	public Maze(java.lang.String[] rows) {
		this.rows = rows.length;
		cols = rows[0].length();
		setMaze = new MazeCell[rows.length][rows[0].length()];
		for (int i = 0; i < rows.length; i++) {
			char[] columns = rows[i].toCharArray();
			
			for (int j = 0; j < columns.length; j++) {
				setMaze[i][j] = new MazeCell(i, j);
				if (columns[j] == '#') {
		
					setMaze[i][j].setStatus(Status.WALL);
				}				
				if (columns[j] == ' ') {				
					setMaze[i][j].setStatus(Status.UNVISITED);
				}				
				if (columns[j] == '$') {					
					setMaze[i][j].setStatus(Status.GOAL);
					goal = setMaze[i][j];
				}			
				if (columns[j] == 'S')
				{				
					setMaze[i][j].setStatus(Status.UNVISITED);
					Start = setMaze[i][j];
				}

				setMaze[i][j].setOwner(this);
			}
		}

		for (int g = 0; g < rows.length; g++) {
			char[] hold = rows[g].toCharArray();
			for (int h = 0; h < hold.length; h++) {
				// top
				if ((g - 1 > 0) && (setMaze[g - 1][h].getStatus() != Status.WALL)) {
					setMaze[g][h].addNeighbor(setMaze[g - 1][h]);

				}
				// right
				if ((h - 1 > 0) && (setMaze[g][h - 1].getStatus() != Status.WALL)) {
					setMaze[g][h].addNeighbor(setMaze[g][h - 1]);
				}
				// down
				if (((g + 1) < rows.length) && (setMaze[g + 1][h].getStatus() != Status.WALL)) {
					setMaze[g][h].addNeighbor(setMaze[g + 1][h]);
				}
				// left
				if (((h + 1) < hold.length) && (setMaze[g][h + 1].getStatus() != Status.WALL)) {
					setMaze[g][h].addNeighbor(setMaze[g][h + 1]);
				}
			}
		}

		
	}

	/**
	 * Returns the cell at the given position.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public MazeCell getCell(int row, int col) {
		return setMaze[row][col];
	}

	/**
	 * Returns the number of rows in this maze.
	 * 
	 * @return
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Returns the number of columns in this maze.
	 * 
	 * @return
	 */
	public int getColumns() {
		return cols;
	}

	/**
	 * Returns the start cell for this maze.
	 * 
	 * @return
	 */

	public MazeCell getStart()

	{
		return Start;
	}

	/**
	 * Returns the goal cell for this maze.
	 * 
	 * @return
	 */
	public MazeCell getGoal()
	{
		return goal;
	}

	/**
	 * Sets the observer for the cells of this maze.
	 * 
	 * @param obs
	 */
	public void setObserver(MazeObserver obs) {
		observer = obs;
	}

	public void updateStatus(MazeCell cell) {
		if (observer != null) {
			observer.updateStatus(cell);
		}
	}

}



