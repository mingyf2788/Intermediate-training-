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

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


public class QuickCrab extends CrabCritter {
	public QuickCrab() {
		setColor(Color.YELLOW);
	}
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		Location loc = getLocation();
		
		//左边的部分
		Location left = loc.getAdjacentLocation(Location.LEFT);
		if (getGrid().isValid(left) && getGrid().get(left) == null) {
			//当前位置在网格内，且该位置为空
			Location nextleft = left.getAdjacentLocation(Location.LEFT);
			if (getGrid().isValid(nextleft) && getGrid().get(nextleft) == null) {
				locs.add(nextleft);
			}
		}
		
		//右边的部分
		Location right = loc.getAdjacentLocation(Location.RIGHT);
		if (getGrid().isValid(right) && getGrid().get(right) == null) {
			//当前位置在网格内，且该位置为空
			Location nextright= right.getAdjacentLocation(Location.RIGHT);
			if (getGrid().isValid(nextright) && getGrid().get(nextright) == null) {
				locs.add(nextright);
			}
		}
		return locs;
	}
	
}
