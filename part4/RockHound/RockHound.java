import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;


public class RockHound extends Critter{

	/**
	 * @param args
	 */
	public RockHound() {
		setColor(Color.YELLOW);
		// 感觉蓝色太丑了，可以手动设置一下颜色
	}
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Rock)
                a.removeSelfFromGrid();
        }
    }
	
}
