package info.gridworld.maze;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
        //记录下一步要走的位置
        private Location next;
        //记录最后一步的位置
        private Location last;
        private boolean isEnd = false;
        //记录树节点
        private Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
        //记录在迷宫中所走的步数
        private Integer stepCount = 0;
        //看看是否显示了最终的完成时的步数
        private boolean hasShown = false;
        private static final int TFF = 255;
        private static final int FOUR = 4;
        private static final int NINETY = 90;
        private int[] count = {0, 0, 0, 0};

        /**
         * Constructs a box bug that traces a square of a given side length
         * 
         * @param length
         *            the side length
         */
        public MazeBug() {
                setColor(Color.GREEN);
                last = new Location(0, 0);
        }

        /**
         * Moves to the next location of the square.
         */
        public void act() {
                /*
                 *Push the information of the initial location into the stack.
                 */
                if(stepCount == 0) {
                       ArrayList<Location> newLoc = new ArrayList<Location>();
                       //如果还没有开始走的话，就new一个列表用于存储
                       newLoc.add(getLocation());
                       //添加当前的位置，到列表里面
                       crossLocation.push(newLoc);
                }
                boolean willMove = canMove();
                if (isEnd) {		
                        if (!hasShown) {
                                String msg = stepCount.toString() + " steps";
                                JOptionPane.showMessageDialog(null, msg);
                                hasShown = true;
                                //在到达目的地的时候显示一下走了多少步，
                        }
                } else if (willMove) {
                        move();
                        stepCount++;
                        //如果可以继续往前走就继续往前走，
                } else {
                		//如果不能继续往前走那就倒退回去
                        goBack();
                        stepCount++;
                        //不管往前走还是往后走，步数都要加1
                }
        }

        public ArrayList<Location> getValid(Location loc) {
        		//获取想对于目前的位置而言可以继续走的所有有效位置
                Grid<Actor> gr = getGrid();
                if (gr == null) {
                        return null;
                }
                ArrayList<Location> valid = new ArrayList<Location>();
                ArrayList<Location> placeIn = crossLocation.peek();
                for(int i = 0; i < FOUR; i++){
                	  //虫子可以走的方向是东南西北，所以这里要循环4次
                      Location locs = loc.getAdjacentLocation(getDirection() + i * NINETY);
                      if(gr.isValid(locs) && !placeIn.contains(locs)) {
                    	  //要保证位置是合法的并且这个位置在并没有放置在队列中
                           Actor actor = gr.get(locs);
                           if(actor instanceof Rock && actor.getColor().getRed() == TFF) {
                                 isEnd = true;
                                 break;
                           }
                           if(actor == null || actor instanceof Flower) {
                                 valid.add(locs);
                           }
                      }
                }
                return valid;            
        }

        public boolean canMove() {
                if(getValid(getLocation()).size() > 0) {
                      return true;
                } else {
                      return false;
                }
        }
        /**
         * Moves the bug forward, putting a flower into the location it previously
         * occupied.
         */
        public void move() {
                Grid<Actor> grid = getGrid();
                if (grid == null) {
                        return;
                }
                Location location = getLocation();
                //获取在当前的位置可以移动到的所有位置
                ArrayList<Location> validLoc = getValid(location);
                int max = 0;
                int flag = 0;
                for(int i = 0; i < validLoc.size(); i++) {
                	//优化的方法是优先选择以前走过的方向最多的那个方向；
                    int sign = location.getDirectionToward(validLoc.get(i)) / NINETY;
                    if (max <= count[sign]) {
                          max = count[sign];
                          flag = i;
                    }
                }
                next = validLoc.get(flag);
                count[getDirection() / NINETY]++;
                go(next);
                //Reset the information of previously occupied location
                //重置之前走过的位置的信息
                ArrayList<Location> bugRoute = crossLocation.pop();
                bugRoute.add(next);
                crossLocation.push(bugRoute);	
                //这里使用的思想很微妙，在站里面使用arraylist，每一次的时候将栈顶元素弹出
                //将下一个位置添加到弹出的arraylist里面之后在入站，这样每次检测是否在站里时
                //只用检测是否在栈顶就可以了
				//Push the information of current location
				ArrayList<Location> temp = new ArrayList<Location>();
				temp.add(getLocation());
                temp.add(last);
                crossLocation.push(temp);
        }
        
        public void goBack() {
                Grid<Actor> gr = getGrid();
                if (gr == null) {
                    return;
                }
                //往回走弹出当前的位置
                crossLocation.pop();
                //栈顶为往回走到的上帝一个位置
                ArrayList<Location> temp = crossLocation.peek();
                next = temp.get(0);
                go(next);
                count[getDirection() / NINETY]++;               
        }

        /*
         * go to the specified location.get
         */
        public void go(Location place) {
                Grid<Actor> grid = getGrid();
                Location location = getLocation();
                if (grid.isValid(place)) {
                    setDirection(location.getDirectionToward(place));
                    moveTo(place);
                } else {
                	removeSelfFromGrid();
                }
                Flower flower = new Flower(getColor());
                flower.putSelfInGrid(grid, location);
                //Note the last step.
                last = location;
        }

        public int randomNum(int n) {
                return (int)(Math.random() * n);
        }
}


