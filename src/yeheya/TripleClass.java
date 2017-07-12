package yeheya;

import java.util.HashSet;
import java.util.Set;

public class TripleClass {
	public static void main(String[] args){
		Triple t1 = new Triple(1,1,2);
		Triple t2 = new Triple(1,2,2);
		Object t3 = new Triple(1,1,3);
		System.out.println(t3.getClass().getName());
		Set<Triple> set = new HashSet<Triple>();
		set.add(t1);
		set.add(t2);
		System.out.println(t1.compareTo(t2));
	}
}

/**
 * 稀疏矩阵压缩存取
 * @author ibm
 *
 */
class Triple implements Comparable<Triple>{
	int row, column,value;
	public Triple(int row, int column, int value) {
		if(row < 0 || column < 0 ){
			throw new IllegalArgumentException("please use the posotive word");
		}
		this.row = row;
		this.column = column;
		this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if(!(obj instanceof Triple))return false;
		Triple t = (Triple) obj;
		return this.row == t.row && this.column == t.column && this.value == t.value;
	}
	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return this.row+this.column+this.value;
	}
	public int compareTo(Triple o) {
		if(this.row < o.row || (this.row  == o.row && this.column < o.column)){
			return -1;
		}
		if(this.row == o.row && this.column == o.column)return 0;
		return 1;
	}
}