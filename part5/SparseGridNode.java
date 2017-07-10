//这个类总体来说比较简单，只需要实现
//设置各个私有成员，返回各个私有成员的直就可以了
public class SparseGridNode {

	/**
	 * @param args
	 */
	private Object occupant;
	private int col;
	private SparseGridNode nextGridNode;
	
	public SparseGridNode(Object obj, int c,SparseGridNode Sp) {
		//构造函数
		occupant = obj;
		col = c;
		nextGridNode = Sp;
	}
	
	public Object getOccupant() {
		//各个私有成员的返回函数
		return occupant;
	}
	
	public int getCol() {
		return col;
	}
	
	public SparseGridNode getNextGridNode() {
		return nextGridNode;
	}
	
	public void setOccupant(Object ocu) {
		occupant = ocu;
	}
	
	public void setSparseGridNode(SparseGridNode sp) {
		nextGridNode = sp;
	}
	

}
