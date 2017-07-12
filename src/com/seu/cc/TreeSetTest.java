package com.seu.cc;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<BigDecimal> tree = new TreeSet<BigDecimal>();
		tree.add(new BigDecimal("1.0"));
		tree.add(new BigDecimal("1.0"));
		HashSet<BigDecimal> hash = new HashSet<BigDecimal>();
		hash.add(new BigDecimal("1.0"));
		hash.add(new BigDecimal("1.0"));
		System.out.println("Tree:"+tree);
		System.out.println("Hash:"+hash);
		System.out.println(new BigDecimal("1.0").hashCode());
		System.out.println(new BigDecimal("1.0").hashCode());
	}

}
