import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;


public class BlusterCritterRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		ActorWorld world = new ActorWorld();
		world.add(new Location(4, 3), new Rock(Color.YELLOW));
		world.add(new Location(5, 4), new Rock(Color.RED));
		world.add(new Location(1, 7), new ChameleonCritter());
		world.add(new Location(3, 5), new ChameleonCritter());
		world.add(new Location(2, 6), new Rock(Color.YELLOW));
		world.add(new Location(0, 3), new Rock(Color.RED));
		world.add(new Location(2, 6), new Rock(Color.YELLOW));
		world.add(new Location(3, 9), new Rock(Color.RED));
		world.add(new Location(4, 4), new BlusterCritter(1));
		world.add(new Location(7, 3), new BlusterCritter(2));
		world.show();
	}

}
