import java.awt.Color;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Actor
{
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public Jumper()
    {
    	setColor(Color.RED);
    }
    
    public Jumper(Color color) {
    	//set the color of the jumper when construct it;
    	setColor(color);
    }
    
    public void act()
    {	
    	if (canJump()) {
    		jump();
    	} else {
    		turn();
    	}
    }
    
    public void turn() {
    	setDirection(getDirection() + Location.HALF_RIGHT);
    	// set the new direction of the Jumper
    }
    
    public void jump() {
    	Grid<Actor> grid_ = getGrid();
    	if (grid_ == null)
    		return;  // if there is no grid on the Grid
    	Location location = getLocation();
    	Location next = location.getAdjacentLocation(getDirection());
    	Location nextnext = next.getAdjacentLocation(getDirection());
    	if (grid_.isValid(nextnext)) {
    		moveTo(nextnext);
    		//if the next of the next location is valid move to it 
    	} else {
    		removeSelfFromGrid();
    		// if the location is not valid, remove it
    	}
    	
    }
    
    public boolean canJump() {
    	Grid<Actor> grid_ = getGrid();
    	if (grid_ == null)
    		return false;  // if there is no grid on the Grid
    	Location location = getLocation();
    	Location next = location.getAdjacentLocation(getDirection());
    	Location nextnext = next.getAdjacentLocation(getDirection());
    	if (!grid_.isValid(nextnext))
    		return false;
    	Actor flag = grid_.get(nextnext);
    	return (flag == null);
    	//if the next of the next place is empty then return true
    	//else return false
    }
}





























