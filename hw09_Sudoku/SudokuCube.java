/**
  * A SudokuCube represents the data for a suduko puzzle.  It is comprised of an array of 81
  * cells. Each cell contains a char value. Valid values are ' ' (EMPTY) or '1' through '9'.
  *
  * For a diagram of the cube coordinates, see: 
  * http://www.radford.edu/asbrennem/itec120/hw/HW9/description.html
  *
  * The convention for cell numbering is as follows:
  * The cells are indexed by [row][col], and both indices are 1-based.
  * The top left cell is [1][1], the cell to the right of it is [1][2].
  * The cell below [1][1] is [2][1].
  *
  * We may refer to the row and column of cube in the conventional sense, just as we would an
  * ordinary array.
  *
  * We may also refer to 9 blocks within the cube.  A block consists of nine cells in a 3x3
  * subarray.  There are three rows of three blocks.
  *
  * The convention for block numbering is as follows:
  * The top left block is 1, the one to the right of it is 2, the one to the right of it is 3.
  * The leftmost block in the middle row is 4.
  * The bottom right block is 9.
  *
  * For the sudoku cube to be in a "correct" state, each row, column, and block may not contain
  * any duplicates other than EMPTY; that is: a 1 may only occur only once, a 2 may occur
  * only once, etc.  EMPTY may occur any number of times.
  *
  * For the sudoku cube to be in a "complete" status, each row, column, and block must be
  * correct and there may be no empty cells.
  */
public class SudokuCube {
	public static final char EMPTY = ' ';

	private char[][] cell = new char[10][10];

	public SudokuCube() {
		this("                                                                                 ");
	}

	/**
	 * @param contents An 81 character string that denotes the values with which the cells
	 * will be initialized. The load sequence fills row 1 with the first nine values, row 2
	 * with the next nine values, and so on.
	 */
	public SudokuCube(String contents) {
		if (contents.length() != 81) {
			throw new RuntimeException("SudokuCube constructor called with contents intialization String \""
								+ contents + "\", which is length " + contents.length()
								+ ".  Contents must be exactly 81 characters in length.");
		}
		int contentsIndex = 0;
		for (int row = 1; row <= 9; row++) {
			for (int col = 1; col <= 9; col++) {
				// the fillCell call will validate the cell contents.
				fillCell(row, col, contents.charAt(contentsIndex));
				contentsIndex++;
			}
		}
	}

	public void fillCell(int row, int col, char value) {
		validateIndex(row);
		validateIndex(col);
		validateValue(value);
		cell[row][col] = value;
	}

	public int getCell(int row, int col) {
		validateIndex(row);
		validateIndex(col);
		return cell[row][col];
	}

	public void validateIndex(int index) throws IndexOutOfBoundsException {
		if (index < 1 || index > 9) {
			throw new IndexOutOfBoundsException("SudokuCube: Attempt to access index as " + index
												+ ".  Valid indices are 1 through 9 (inclusive).");
		}
	}

	public void validateValue(char value) throws RuntimeException {
		if (value != ' ' && (value < '1' || value > '9')) {
			throw new RuntimeException("SudokuCube: Attempt to set value of " + value
										+ ".  Valid values are empty ('" + EMPTY
										+ "'), and '1' through '9' inclusive.");
		}
	}

	public char[] getRow(int row) {
		char[] rowArray = new char[10];
		for(int i = 1; i <= 9; i++){
			rowArray[i] = this.cell[row][i];
		}
		return rowArray;
	}

	public char[] getColumn(int col) {
		char[] colArray = new char[10];
		for(int i = 1; i <= 9; i++){
			colArray[i] = this.cell[i][col];
		}
		return colArray;
	}

	public char[][] getBlock(int block) {
		char[][] blockArray = new char[4][4];
		int startRow = 1;
		int startCol = 1;
		char[] rowArray = new char[10];
		char[] colArray = new char[10];
		
		if(block == 1){
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 1;
				startRow++;
			}
		}
		if(block == 2){
			startRow = 1;
			startCol = 4;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 4;
				startRow++;
			}
		}
		if(block == 3){
			startRow = 1;
			startCol = 7;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 7;
				startRow++;
			}
		}
		if(block == 4){
			startRow = 4;
			startCol = 1;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 1;
				startRow++;
			}
		}
		if(block == 5){
			startRow = 4;
			startCol = 4;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 4;
				startRow++;
			}
		}
		if(block == 6){
			startRow = 4;
			startCol = 7;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 7;
				startRow++;
			}
		}
		if(block == 7){
			startRow = 7;
			startCol = 1;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 1;
				startRow++;
			}
		}
		if(block == 8){
			startRow = 7;
			startCol = 4;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 4;
				startRow++;
			}
		}
		if(block == 9){
			startRow = 7;
			startCol = 7;
			colArray = this.getColumn(startCol);
			for(int a = 1; a <= 3; a++){
				rowArray = this.getRow(startRow);
				for(int b = 1; b <= 3; b++){
					blockArray[a][b] = rowArray[startCol];
					startCol++;
				}
				startCol = 7;
				startRow++;
			}
		}
		return blockArray;
	}

	public boolean isRowCorrect(int row) {
		boolean result = false;
		char[] correctRowArray = this.getRow(row);
		for(int a = 1; a <= 9; a++){
			for(int b = 1; b <= 9; b++){
				if(a != b){
					if(correctRowArray[a] != EMPTY){
						if(correctRowArray[a] == correctRowArray[b]){
							result = false;
							return result;
						}
						else{
							result = true;
						}
					}
				}
			}
		}
		return result;
	}

	public boolean isColumnCorrect(int col) {
		boolean result = false;
		char[] correctColArray = this.getColumn(col);
		for(int a = 1; a <= 9; a++){
			for(int b = 1; b <=9; b++){
				if(a != b){
					if(correctColArray[a] != EMPTY){
						if(correctColArray[a] == correctColArray[b]){
							result = false;
							return result;
						}
						else{
							result = true;
						}
					}
				}
			}
		}
		return result;
	}

	public boolean isBlockCorrect(int block) {
		boolean result = false;
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0;
		int fiveCount = 0;
		int sixCount = 0;
		int sevenCount = 0;
		int eightCount = 0;
		int nineCount = 0;
		
		char[][] blockArray = this.getBlock(block);
		for(int a = 1; a <= 3; a++){
			for(int b = 1; b <= 3; b++){
				if(blockArray[a][b] == '1'){
					oneCount++;
				}
				if(blockArray[a][b] == '2'){
					twoCount++;
				}
				if(blockArray[a][b] == '3'){
					threeCount++;
				}
				if(blockArray[a][b] == '4'){
					fourCount++;
				}
				if(blockArray[a][b] == '5'){
					fiveCount++;
				}
				if(blockArray[a][b] == '6'){
					sixCount++;
				}
				if(blockArray[a][b] == '7'){
					sevenCount++;
				}
				if(blockArray[a][b] == '8'){
					eightCount++;
				}
				if(blockArray[a][b] == '9'){
					nineCount++;
				}
			}
		}
		if(oneCount > 1 || twoCount > 1 || threeCount > 1 || fourCount > 1 || fiveCount > 1 || sixCount > 1 || sevenCount > 1 || eightCount > 1 || nineCount > 1){
			result = false;
		}
		else{
			result = true;
		}
		return result;
	}

	public boolean isRowComplete(int row) {
		boolean result = false;
		char[] completeRowArray = this.getRow(row);
		for(int a = 1; a <= 9; a++){
				if(completeRowArray[a] == EMPTY){
					result = false;
					return result;
				}
				else{
					result = true;
				}
			}
		return result;
	}

	public boolean isColumnComplete(int col) {
		boolean result = false;
		char[] completeColArray = this.getColumn(col);
		for(int a = 1; a <= 9; a++){
				if(completeColArray[a] == EMPTY){
					result = false;
					return result;
				}
				else{
					result = true;
				}
			}
		return result;
	}

	public boolean isBlockComplete(int block) {
		boolean result = false;
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		int fourCount = 0;
		int fiveCount = 0;
		int sixCount = 0;
		int sevenCount = 0;
		int eightCount = 0;
		int nineCount = 0;
		
		char[][] blockArray = this.getBlock(block);
		for(int a = 1; a <= 3; a++){
			for(int b = 1; b <= 3; b++){
				if(blockArray[a][b] == '1'){
					oneCount++;
				}
				if(blockArray[a][b] == '2'){
					twoCount++;
				}
				if(blockArray[a][b] == '3'){
					threeCount++;
				}
				if(blockArray[a][b] == '4'){
					fourCount++;
				}
				if(blockArray[a][b] == '5'){
					fiveCount++;
				}
				if(blockArray[a][b] == '6'){
					sixCount++;
				}
				if(blockArray[a][b] == '7'){
					sevenCount++;
				}
				if(blockArray[a][b] == '8'){
					eightCount++;
				}
				if(blockArray[a][b] == '9'){
					nineCount++;
				}
			}
		}
		if(oneCount == 1 || twoCount == 1 || threeCount == 1 || fourCount == 1 || fiveCount == 1 || sixCount == 1 || sevenCount == 1 || eightCount == 1 || nineCount == 1){
			result = true;
		}
		else{
			result = false;
		}
		return result;
	}

	public boolean isCubeComplete() {
		boolean result = false;
		for(int row = 1; row <= 9; row++){
			if(this.isRowComplete(row) == true && this.isRowCorrect(row) == true){
				result = true;
			}
			else{
				result = false;
				return result;
			}
			
		}
		for(int col = 1; col <= 9; col++){
			if(this.isColumnComplete(col) == true && this.isColumnCorrect(col) == true){
				result = true;
			}
			else{
				result = false;
				return result;
				}
		}
		for(int block = 1; block <= 9; block++){
			if(this.isBlockComplete(block) == true && this.isBlockCorrect(block) == true){
				result = true;
			}
			else{
				result = false;
				return result;
			}
		}
		return result;
	}
	
	public String toString(){
		String result = " --------------------------\n";
		char[] rowArray = new char[10];
		for(int a = 1; a <= 9; a++){
			rowArray = this.getRow(a);
			for(int b = 1; b <= 9; b++){
				result = result + "|" + rowArray[b] + " ";
			}
			if(a == 9){
				result = result + "|\n --------------------------\n";
			}
			else if(a%3 == 0){
				result = result + "|\n|--------------------------|\n";
			}
			else{
				result = result + "|\n|--------|--------|--------|\n";
			}
		}
		return result;
	}
}
