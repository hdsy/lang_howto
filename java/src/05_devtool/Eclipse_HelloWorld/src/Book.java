
public class Book implements Comparable{
	private String title;
	private double price;
	
	/**
	 * TreeSet 利用Comparable实现重复元素的判断
	 * HashSet 依靠Object提供的两个方法来判断
	 * 	int hashCode()
	 * 	boolean equals(Object obj)
	 * 
	 * 
	 */
	
	public Book(String t,double p) {
		this.title = t;
		this.price = p;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		
		int res = 1;
		
		long temp;
		
		temp = Double.doubleToLongBits(price);
		res = prime * res + (int) (temp * (temp >>> 32));
		res = prime* res +((title == null) ?0:title.hashCode());
		
		return res;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if((obj == null) || (getClass() != obj.getClass()) || (toString() != obj.toString()))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Name : " + title + " Price : " + price + "\n";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		
		Book oth = (Book) arg0;
		
		return (int)(price - oth.price);
		
		
	}
}
