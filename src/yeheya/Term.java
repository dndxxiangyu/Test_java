package yeheya;
/**
 * 多项式的链表表示要用
 *
 */
public class Term implements Comparable<Term>{
	
	public static void main(String[] args){
		System.out.println(new Term(1,2));
		System.out.println(new Term(0,2));
		System.out.println(new Term(1,1));
		System.out.println(new Term(5,-1));
		System.out.println(new Term(4,2));
		int[][]a = {{1,2,3},{4,5,6}};
		System.out.println(a.length);
	}

	private int coef,exp;
	public Term(int coef, int exp){
		this.coef = coef;
		this.exp = exp;
	}
	
	public boolean renoveable(){
		return this.coef == 0;
	}
	
	public void add(Term t){
		if(this.compareTo(t) == 0){
			this.coef += t.coef;
		}else{
			throw new IllegalArgumentException("两项指数不同，不能相加");
		}
	}
	
	public int compareTo(Term o) {
		if(this.exp == o.exp)return 0;
		return this.exp > o.exp ? 1:-1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.coef > 0 ? "+" : "-");
		if(this.coef == 0)return "0";
		if(this.exp == 0)return sb.toString();
		if(this.exp == 1){
			sb.append("x");
			return sb.toString();
		}else{
			sb.append(coef+"x^").append(exp+"");
			return sb.toString();
		}
	}
}

class Poly<E extends Comparable<E>&Cloneable>{
	
}