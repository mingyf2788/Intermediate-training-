import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;


public class KingCrabRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorWorld world = new ActorWorld();
		world.add(new Location(4, 3), new Rock(Color.YELLOW));
		world.add(new Location(2, 5), new Rock(Color.YELLOW));
		world.add(new Location(4, 5), new Flower(Color.BLACK));
		world.add(new Location(4, 3), new Flower(Color.YELLOW));
		world.add(new Location(2, 6), new Rock(Color.YELLOW));
		world.add(new Location(4, 8), new Flower(Color.YELLOW));
		world.add(new Location(4, 5), new Flower(Color.YELLOW));
		world.add(new Location(3, 1), new Rock(Color.RED));
		world.add(new Location(3, 3), new KingCrab());
		world.show();
	}

}
