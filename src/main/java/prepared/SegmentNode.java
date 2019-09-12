package prepared;

public class SegmentNode {
	
	public int leftIndex;
	
	public int rightIndex;
	
	public int value;
	
	public SegmentNode leftChild;
	
	public SegmentNode rightChild;
	
	public SegmentNode(int left,int right){
		this.leftIndex = left;
		this.rightIndex = right;
	}
}
