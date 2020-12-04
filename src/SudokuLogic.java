
public class SudokuLogic implements SudokuSolver {
	
	private int[][] grid;
	
	public SudokuLogic() {
		this.grid = new int[9][9];
		clear();
	}
	
	
	public boolean possible (int row, int col, int val) {
		for(int i = 0; i < 9; i++) {	//check possible column
			if (getCell(row, i) == val)
				return false;
		}
		for (int j = 0; j < 9; j++) {	//check possible row
			if(getCell(j, col) == val)
				return false;
		}
		
		int rowSquare = row - row%3;
		int colSquare = col - col%3;
		for(int r = rowSquare; r < rowSquare+3; r++) {	//check possible square
			for(int c = colSquare; c < colSquare+3; c++) {
				if(getCell(r, c) == val)
					return false;
			}
		}
		return true;
	}
	
	
	public boolean solve() {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(getCell(row, col) == 0) {
					for(int val = 1; val < 10; val++) {
						if(possible(row, col, val)) {
							setCell(row, col, val);
							solve();
							setCell(row, col, 0);
						}			
					}
					return false;
				}
			}
		}
		printGrid();
		return true;
	}
	
	
	


	@Override
	public void setCell(int row, int col, int val) throws IllegalArgumentException {
		this.grid[row][col] = val;
	}


	@Override
	public int getCell(int row, int col) throws IllegalArgumentException {
		return this.grid[row][col];
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < 9; i++) {
            for(int k = 0; k < 9; k++) {
                setCell(i, k, 0);
            }
        }
	}

	//consoleTest
	public void printGrid() {
		for(int r = 0; r < 9; r++) {
			System.out.println();
			for(int c = 0; c < 9; c++) {
				System.out.print(getCell(r, c) + "   ");
			}
		}
	}
	
	//testfall 5
	public void textTest() {
		
		setCell(0, 2, 8);
		setCell(0, 5, 9);
		setCell(0, 7, 6);
		setCell(0, 8, 2);
		setCell(1, 8, 5);
		setCell(2, 0, 1);
		setCell(2, 2, 2);
		setCell(2, 3, 5);
		setCell(3, 3, 2);
		setCell(3, 4, 1);
		setCell(3, 7, 9);
		setCell(4, 1, 5);
		setCell(4, 6, 6);
		setCell(5, 0, 6);
		setCell(5, 7, 2);
		setCell(5, 8, 8);
		setCell(6, 0, 4);
		setCell(6, 1, 1);
		setCell(6, 3, 6);
		setCell(6, 5, 8);
		setCell(7, 0, 8);
		setCell(7, 1, 6);
		setCell(7, 4, 3);
		setCell(7, 6, 1);
		setCell(8, 6, 4);
		
		printGrid();
	}
	
	
}
