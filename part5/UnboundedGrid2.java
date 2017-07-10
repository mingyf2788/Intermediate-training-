import java.util.ArrayList;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;


public class UnboundedGrid2<E> extends AbstractGrid<E> {

	/**
	 * @param args
	 */
	private static final int FACTOR = 16;
	private Object[][] occupantArrayObjects;
	private int factor;
	
	public UnboundedGrid2() {
		factor = FACTOR;
		occupantArrayObjects = new Object[factor][factor];
	}
	
	public int getNumRows() {
		return -1;
	}
	
	public int getNumCols() {
		return -1;
	}
	
	public boolean isValid(Location loc) {
		return true;
	}
	
	public ArrayList<Location>  getOccupiedLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		for (int i = 0; i < factor; i++) {
			for (int j = 0; j < factor; j++) {
				Location loc = new Location(i, j);
				if (get(loc) != null) {
					locations.add(loc);
				}
			}
		}
		return locations;
	}
	 public E get(Location loc)
	    {
	        if (!isValid(loc))
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        if (loc.getRow() >= factor || loc.getCol() >= factor) {
	        	return null;
	        }
	        return (E) occupantArrayObjects[loc.getRow()][loc.getCol()];
	    }
	 
	 public E put(Location loc, E obj)
	    {
	        if (!isValid(loc))
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        if (obj == null)
	            throw new NullPointerException("obj == null");

	        // Add the object to the grid.
	        if (loc.getRow() >= factor || loc.getCol() >= factor) {
	        	int newsize;
	        	for (newsize = factor; ;newsize *= 2) {
	        		if (loc.getCol() < newsize && loc.getRow() < newsize)
	        			break;
	        	}
	        	Object[][] tempObjects = new Object[newsize][newsize];
	        	for (int i = 0; i < factor; i++) {
	    			for (int j = 0; j < factor; j++) {
	    				tempObjects[i][j] = occupantArrayObjects[i][j];
	    			}
	    		}
	        	occupantArrayObjects = tempObjects;
	        	factor = newsize;
	        }
	        E oldE = get(loc);
	        occupantArrayObjects[loc.getRow()][loc.getCol()] = obj;
	        return oldE;
	    }
	 
	 public E remove(Location loc)
	    {
	        if (!isValid(loc))
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        if (loc.getRow() >= factor || loc.getCol() >= factor) {
	        	return null;
	        }
	        // Remove the object from the grid.
	        E r = get(loc);
	        occupantArrayObjects[loc.getRow()][loc.getCol()] = null;
	        return r;
	    }
	 
}
