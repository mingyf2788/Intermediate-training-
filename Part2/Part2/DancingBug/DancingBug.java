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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int steps;
    private int[] sideLength;
    private int t = 0;
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int[] times)
    {
        steps = 0;
        t = 0;
        sideLength = times.clone();
    }

    /**
     * Moves to the next location of the square.
  	*/
    
    public void act()
    {	
    	if (steps == sideLength.length)
    		steps = 0;
    	for (int i = 0; i < sideLength[steps]; i++) {
    		turn();
    	}
    	if (canMove()) {
    		move();
    	} else {
    		//if the bug cannot move,then turn;
    		//the degree of turn is the next entry of the array
    		int k = 0;
    		if (steps < sideLength.length - 1) {
    			k = steps + 1;
    		} else {
    			k = 0;
    		}
    		while (t < sideLength[k]) {
    			turn();
    			t++;
    		}
    	}
    	steps++;
    }
}
