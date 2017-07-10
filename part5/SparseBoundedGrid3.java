import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;


public class SparseBoundedGrid3<E> extends UnboundedGrid<E> {

	/**
	 * @param args
	 */
	private int row;
	private int col;
	
	public SparseBoundedGrid3(int r, int c) {
		row = r;
		col = c;
	}
	
	public int getNumRows() {
		return row;
	}
	
	public int getNumCols() {
		return col;
	}
	public boolean isValid(Location loc) {
		 return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	 }
}
