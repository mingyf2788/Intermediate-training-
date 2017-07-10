import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
public class BlusterCritter extends Critter {

	private static final double DARKENING_FACTOR1 = 0.05;
	private static final double DARKENING_FACTOR2 = 1.05;
	private int count;
	 
	 public BlusterCritter(int c) {
		 count = c;
		 setColor(Color.GRAY);
	 }
	 
	 public ArrayList<Actor> getActors() {
		 ArrayList<Actor> actors = new ArrayList<Actor>();
		 Grid<Actor> grid = getGrid();
		 Location location = getLocation();
		 // 获取当前的critter的位置
		 for (int i = location.getRow() - 2; i <= location.getRow() + 2; i++) {
			 for (int j = location.getCol() - 2; j <= location.getCol() + 2; j++) {
				 Location location2 = new Location(i, j);
				 if (grid.isValid(location2)) {
					 //查看位置是否合法
					 Actor a = grid.get(location2);
					 // 查看在这个位置上是否有actor
					 if (a != null)
						 actors.add(a);
				 }
			 }
		 }
		 return actors;
	 }
	 
	 public void actDarken() {
		Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR1));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR1));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR1));
        setColor(new Color(red, green, blue));
	 }
	 
	 public void actBrighten() {
		Color c = getColor();
        int red = (int) (c.getRed());
        int green = (int) (c.getGreen());
        int blue = (int) (c.getBlue());
        if (c.getRed() <= 240) {
        	red = (int) (c.getRed() * DARKENING_FACTOR2) ;
        }
        if (c.getGreen() <= 240) {
        	green = (int)(c.getGreen() * DARKENING_FACTOR2);
        }
        if (c.getBlue() <= 240) {
        	blue = (int)(c.getBlue() * DARKENING_FACTOR2);
        }
        setColor(new Color(red, green, blue));
	 }
	 
	 public void processActors(ArrayList<Actor> actors) {
		 int n = 0;
		 for ( Actor act: actors) {
			 if (act instanceof Critter)
				 n += 1;
		 }
		 if (n >= count) {
			 actDarken();
			 return;
		 } else if (n < count ) {
			 actBrighten();
			 return;
		 } 
	 }
}
