import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;


public class RockHoundRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(4, 3), new Rock(Color.YELLOW));
		world.add(new Location(1, 3), new Rock(Color.YELLOW));
		world.add(new Location(4, 3), new Flower(Color.YELLOW));
		world.add(new Location(4, 3), new Flower(Color.YELLOW));
		world.add(new Location(2, 9), new Bug(Color.LIGHT_GRAY));
		world.add(new Location(0, 3), new Rock(Color.YELLOW));
		world.add(new Location(7, 3), new Rock(Color.YELLOW));
		world.add(new Location(4, 8), new Flower(Color.YELLOW));
		world.add(new Location(4, 5), new Flower(Color.YELLOW));
		world.add(new Location(5, 3), new RockHound());
		world.show();
	}

}
