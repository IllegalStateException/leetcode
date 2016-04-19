package prepared;

import java.util.List;

public class ListImpl implements NestedInteger {
	
	private List<NestedInteger> list;
	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return this.list;
	}

	public ListImpl(List<NestedInteger> list) {
		super();
		this.list = list;
	}
	
	

}
