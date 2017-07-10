import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.*;

public class SparseBoundedGrid2<E> extends AbstractGrid<E>{
	 private int rows;
	 private int cols;
	 private Map<Location, E> occupationMap;
	 
	 public SparseBoundedGrid2(int row, int col) {
		 rows = row;
		 cols = col;
		 occupationMap = new HashMap<Location, E>();
	 }
	 
	 public int getNumRows() {
		 return rows;
	 }
	 
	 public int getNumCols() {
		 return cols;
	 }
	 
	 public boolean isValid(Location loc) {
		 return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	 }
	 
	 public ArrayList<Location> getOccupiedLocations() {
		 ArrayList<Location> list = new ArrayList<Location>();
		 for (Location loc : occupationMap.keySet()) {
			 list.add(loc);
		 }
		 return list;
	 }
	 
	 public E get(Location loc) {
		 if (loc == null)
	            throw new IllegalArgumentException("loc == null ");
		 return occupationMap.get(loc);
	 }
	 
	 public E put(Location loc, E obj) {
		 if (loc == null) {
			 throw new IllegalArgumentException("loc == null ");
		 }
		 if (obj == null)
			 throw new IllegalArgumentException("obj == null ");
		 return occupationMap.put(loc, obj);
	 }
	 
	 public E remove(Location loc) {
		 if (loc == null)
			 throw new IllegalArgumentException("loc == null ");
		 return occupationMap.remove(loc);
	 }
	 
}
