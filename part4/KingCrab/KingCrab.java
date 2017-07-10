import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class KingCrab extends CrabCritter {

	/**
	 * @param args
	 */
	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			int flag = 1;
			ArrayList<Location> loc = getGrid().getEmptyAdjacentLocations(a.getLocation());
			//get the empty location near a;
			for (Location c : loc) {
				int x = getLocation().getRow();
				int y = getLocation().getCol();
				int x1 = c.getRow();
				int y1 = c.getCol();
				double distance = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
				if (distance >= 2) {
					a.moveTo(c);
					flag = 0;
				}
			}
			if (flag == 1)
				a.removeSelfFromGrid();
		}
	}

}

