package com.seu.structure;

public interface SString {
	
	int length();
	char charAt(int index);
	SString concat(SString str);
	SString substring(int begin,int end);
	int indexOf(SString pattern);
}
