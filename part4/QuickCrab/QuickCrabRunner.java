/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;


public class QuickCrabRunner {
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
		world.add(new Location(3, 5), new Rock(Color.RED));
		world.add(new Location(3, 3), new QuickCrab());
		world.show();
	}

}
