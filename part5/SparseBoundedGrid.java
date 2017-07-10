import java.util.ArrayList;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
//这个类的实现模仿着boundedgrid就可以了
public class SparseBoundedGrid<E> extends AbstractGrid<E> {

	/**
	 * @param args
	 */
	private SparseGridNode[] occupantArray;
	private int numRows;
	private int numCols;
	
	public SparseBoundedGrid(int rows, int cols) {
		// 构造函数要在初始化不合理时抛出异常
		if (rows <= 0)
		    throw new IllegalArgumentException("rows <= 0");
		if (cols <= 0)
		    throw new IllegalArgumentException("cols <= 0");
		numRows = rows;
		numCols = cols;
		occupantArray = new SparseGridNode[rows];
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public boolean isValid(Location loc) {
		return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}
	
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < getNumRows(); i++) {
			SparseGridNode sparseGridNode = occupantArray[i];
			while (!(sparseGridNode == null)) {
				//在这个稀疏数组中凡是在列表中的位置就是被占用了的位置
				Location location = new Location(i, sparseGridNode.getCol());
				locations.add(location);
				sparseGridNode = sparseGridNode.getNextGridNode();
			}
		}
		return locations;
	}
	
	public E get(Location loc) {
		//如果位置不合法那么就应该该抛出异常
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
		SparseGridNode sp = occupantArray[loc.getRow()];
		while (sp != null) {
			if (sp.getCol() == loc.getCol())
				return (E) sp.getOccupant();
			sp = sp.getNextGridNode();
		}
		return null;
	}
	
	public E put(Location loc, E obj) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");
        E oldOccupant = remove(loc);
        SparseGridNode sparseGridNode = occupantArray[loc.getRow()];
        //将新建的这个替换掉原来的
        occupantArray[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), sparseGridNode);
        return oldOccupant;
	}
	
	public E remove(Location loc) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
		E ret = get(loc);
		if (ret == null)
			return null;
		SparseGridNode sp = occupantArray[loc.getRow()];
		if (sp != null) {
			if (sp.getCol() == loc.getCol()) {
				occupantArray[loc.getRow()] = sp.getNextGridNode();
			} else {
				for (SparseGridNode next = sp.getNextGridNode(); 
						next != null; next = next.getNextGridNode()) {
					if (next.getCol() == loc.getCol()) {
						sp.setSparseGridNode(sp.getNextGridNode());
						break;
					}
					sp = sp.getNextGridNode();
				}
			}
		}
		return ret;
	}
	
}
