import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;


public class ChameleonKidRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(4, 3), new Rock(Color.YELLOW));
		world.add(new Location(5, 3), new ChameleonKid());
		world.show();
	}

}