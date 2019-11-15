package com.productsSimilarityCalc.predicate;

import java.util.function.Predicate;

public interface TagPredicate {
	
	public static void applyTagVector(int[] numTagVector,int i,String tag, Predicate<String> predicate) { 
        if (predicate.test(tag)) { 
        	numTagVector[i] = 1;
        } 
    } 
}
