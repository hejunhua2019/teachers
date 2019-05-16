package cn.com.yajiaotong.wface.common.page;
/**
 * 分页专用类
 * @author hejunhua
 *
 */
public class Page {
	private int showCount = 10; // 每页显示记录数
	
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	protected int currentPage = 1; // 当前页
	private int currentResult; // 当前记录起始索引
	// true:需要分页的地方，传入的参数就是Page实体
	//false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private boolean entityOrField; 
	
	public Page(){
	}
	
	public Page(int currentPage) {
		super();
		this.currentPage = currentPage;
	}
	
	public Page(int currentResult,int showCount) {
		super();
		this.showCount = showCount;
		this.currentResult = currentResult;
	}
	/*public Page(int totalResult,int currentPage) {
		super();
		this.currentPage = currentPage;
		this.totalResult = totalResult;
	}*/
	
	public int getTotalPage() {
		totalPage = totalResult % showCount == 0 ? totalResult / showCount : totalResult / showCount + 1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getShowCount();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	public boolean isEntityOrField() {
		return entityOrField;
	}
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}
}