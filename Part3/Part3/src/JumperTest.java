import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;


public class JumperTest {
	
	public ActorWorld  world = new ActorWorld();
	@Before
	public void SetUp() throws Exception {
		world = new ActorWorld();
	};
	
	@Test
	public void testact0() {
		//add a rock to the next station of the JUMper;
		//we expect that the rock do not affect the Jumper jump 
		Jumper test0 = new Jumper();
		Rock rock = new Rock();
		world.add(new Location(3, 5), test0);
		world.add(new Location(2, 5), rock);
		test0.act();
		assertEquals((test0.getLocation()).toString(), "(1, 5)");
	}
	
	@Test
	public void testact1() {
		//add a rock to the target station of the Jumper;
		//we expect that the Jumper can't move
		Jumper test0 = new Jumper();
		Rock rock = new Rock();
		world.add(new Location(3, 5), test0);
		world.add(new Location(1, 5), rock);
		test0.canJump();
		assertEquals(test0.canJump(), false);
	}
	
	@Test
	public void testact2() {
		//set the jumper at the most left location  on the second line
		Jumper test1 = new Jumper();
		world.add(new Location(1, 9), test1);
		test1.canJump();
		assertEquals(test1.canJump(), false);
	}
	
	@Test
	public void testact3() {
		//set the jumper at a position, where it can move
		Jumper test2 = new Jumper();
		world.add(new Location(4, 4), test2);
		test2.canJump();
		assertEquals(test2.canJump(), true);
	}

	@Test
	public void testact4() {
		//set a jumper at the cell that is tow cells in front of the jumper 
		//at this situation the jumper cannot move
		Jumper test2 = new Jumper();
		world.add(new Location(6, 4), test2);
		Jumper test3 = new Jumper();
		world.add(new Location(4, 4), test3);
		test2.canJump();
		assertEquals(test2.canJump(), false);
	}
}
