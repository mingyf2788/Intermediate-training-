import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;


public class ChameleonKid extends ModifiedChameleonCritter {

	/**
	 * @param args
	 */
	//这个类是ModifiedChameleonCritter的扩展，要实现将颜色改变为前面或者后面的actor的颜色
	//只需要将Getctors设置为返回前面或者后面的actor就可以了
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = new ArrayList<Actor>();
		int[] dis = {
				Location.AHEAD, Location.HALF_CIRCLE
		};
		for (Location location : getLocationInDirections(dis)) {
			Actor a = getGrid().get(location);
			//获取grid的位置
			if (a != null)
				actors.add(a);
			// 如果此处不为空那么证明在这个方位有一个Actor
		}
		return actors;
	}
	
	public ArrayList<Location> getLocationInDirections(int[] Direction) {
		ArrayList<Location> locations = new ArrayList<Location>();
		// 初始化一个新的位置列表
		Grid<Actor> grid = getGrid();
		Location loc = getLocation();  //获取当前critter的位置
		for (int direction : Direction) {
			Location lo = loc.getAdjacentLocation(direction + getDirection());
			//目标位置等于在当前位置下，某一个方向的临近直；
			if (grid.isValid(lo))
				locations.add(lo);
		}
		return locations;
	}
}
