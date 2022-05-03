import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://youtu.be/pOdFySa1Yag
 * this is the link to my Youtube Video. 
 * thank you. 
 */
public class Grid extends JFrame {
	
	//JFrame frame = new JFrame("mineSweeper");
	
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	private int safeCount;
	private JButton [][] buttons;
	
	
	//this.setVisible(true);
	
	public Grid(){
		
		//this.numRows    = 10;
		//this.numColumns = 10;
		//this.numBombs   = 25;
		//bombGrid   = new boolean[numRows][numColumns];
		//countGrid  = new int[numRows][numColumns];
		//createBombGrid();
		//createCountGrid();
		this(10,10,25);
		
		
		
	}
	
	public Grid(int rows, int columns){
		this.numRows    = rows;
		this.numColumns = columns;
		this.numBombs  = 25;
		bombGrid  = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
		
		
	}
	
	public Grid(int rows, int columns, int numBombs){
		super("MineSweeper");
		
		numRows    = rows;
		numColumns = columns;
		this.numBombs   = numBombs;
		bombGrid  = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
		
		
		safeCount = (getNumRows() * getNumColumns()) - getNumBombs();
		buttons = new JButton[getNumRows()][getNumColumns()];
		
		setLayout(new GridLayout(getNumRows(), getNumColumns()));
		for(int i = 0; i < getNumRows(); i++) {
			for(int j = 0; j < getNumColumns(); j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(new cellListener(i,j));
				
				add(buttons[i][j]);
			}
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setVisible(true);
		
	}
	
	
	public int getNumRows() {
		return numRows;
	}
	public int getNumColumns() {
		return numColumns;
	}
	public int getNumBombs() {
		return numBombs;
	}
	public boolean [][] getBombGrid(){
		boolean[][] result = new boolean[numRows][numColumns];
		for(int i = 0; i<numRows; i++) {
			System.arraycopy(bombGrid[i], 0, result[i], 0, bombGrid[i].length);
		}
		return result;
	}
	public int [][] getCountGrid(){
		int[][] result = new int[numRows][numColumns];
		for(int i = 0; i<numRows; i++) {
			System.arraycopy(countGrid[i], 0, result[i], 0, countGrid[i].length);
		}
		return result;
	}
	
	public boolean isBombAtLocation(int row, int column) {
		return (bombGrid[row][column]);
	}
	
	public int getCountAtLocation(int row, int column) {
		int count = 0;
		
		if(isBombAtLocation(row, column)){
			count++;
		}
		
		if(row +1 < numRows) {
			if(isBombAtLocation(row +1, column))
				count++;
			
			if(column +1 < numColumns) {
				if(isBombAtLocation(row +1, column +1))
					count++;
			}
			
			if(column -1 >= 0) {
				if(isBombAtLocation(row +1, column -1))
					count++;
			}
		}
		
		if(row -1 >= 0) {
			if(isBombAtLocation(row -1, column))
				count++;
			
			if(column -1 >= 0) {
				if(isBombAtLocation(row -1, column -1))
					count++;
			}
			if(column +1 < numColumns) {
				if(isBombAtLocation(row -1, column +1))
					count++;
			}
		}
		
		if(column +1 < numColumns) {
			if(isBombAtLocation(row, column +1))
				count++;
		}
		if(column -1 >= 0) {
			if(isBombAtLocation(row, column -1))
				count++;
		}
		return count;
	}
	
	private void createBombGrid() {
		bombGrid = new boolean[numRows][numColumns];
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j <numColumns; j++) {
				bombGrid[i][j] = false;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =1; i < numRows * numColumns; i++) {
			list.add(new Integer(i));
		}
		
		Collections.shuffle(list);
		for(int i = 0; i < numBombs; i++) {
			int number = (list.get(i));
			int row    = new Integer(number / numColumns);
			int column = new Integer(number % numColumns);
			
			bombGrid[row][column] = true;
		}
	}
	
	private void createCountGrid() {
		
		countGrid = new int[numRows][numColumns];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				countGrid[i][j] = getCountAtLocation(i, j);
			}
		}	
	};
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grid minesweeper = new Grid();
		System.out.println("done!");
	}

	private void reset() {
	createBombGrid();
	createCountGrid();
	
	safeCount = (getNumRows() * getNumColumns()) - getNumBombs();
	for(int i = 0; i < getNumRows(); i++) {
		for(int j = 0; j < getNumColumns(); j++) {
			buttons[i][j].setText("");
			buttons[i][j].setEnabled(true);
		}
	}
}

	private class cellListener implements ActionListener{
		int row;
		int col;
	
	public cellListener(int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {

        if (isBombAtLocation(row, col)) {

              int[][] counts = getCountGrid();

              for (int i = 0; i < getNumRows(); i++) {
                    for (int j = 0; j < getNumColumns(); j++) {

                          if (isBombAtLocation(i, j)) {
                                buttons[i][j].setText("BOMB!");

                          } 
                          else {
                                buttons[i][j].setText(String.valueOf(counts[i][j]));
                          }
                          buttons[i][j].setEnabled(false);
                    }

              }

              int status = JOptionPane.showConfirmDialog(null,

                          "You lose! :( \n" 
                          + "Do you want to play again?", "GAME OVER!",

                          JOptionPane.YES_NO_OPTION);


              if (status == JOptionPane.YES_OPTION) {
                    reset();

              } 
              else {
                    System.exit(0);
              }

        } 
        else {
              buttons[row][col].setText(String.valueOf(getCountAtLocation(row, col)));
              buttons[row][col].setEnabled(false);
              safeCount--;

              if (safeCount == 0) {

                    int status = JOptionPane.showConfirmDialog(null,

                                "You won! :) \n Do you want to play again?", "GAME OVER!",

                                JOptionPane.YES_NO_OPTION);

                    if (status == JOptionPane.YES_OPTION) {

                          reset();

                    } 
                    else {

                          System.exit(0);

                    }

              }

        	}

		}

	}
	
}