package prepared;

import java.util.List;

public class IntegerImpl implements NestedInteger {
	
	private Integer num;
	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return this.num;
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public IntegerImpl(Integer num) {
		super();
		this.num = num;
	}
	
	

}
