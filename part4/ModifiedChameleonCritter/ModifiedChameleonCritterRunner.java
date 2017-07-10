import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

public class ModifiedChameleonCritterRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new Location(3, 3), new Rock(Color.YELLOW));
		world.add(new Location(4, 4), new ModifiedChameleonCritter());
		//world.add(new Location(5, 8), new ModifiedChameleonCritter());
		world.show();
	}
}

