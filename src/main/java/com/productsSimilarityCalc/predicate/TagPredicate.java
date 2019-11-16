package com.productsSimilarityCalc.predicate;

import java.util.function.Predicate;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Predicate created to check and apply the value to the tagsVector to show what characteristics
 * the product has towards the array
 *
 */
public interface TagPredicate {
	
	public static void applyTagVector(int[] numTagVector,int i,String tag, Predicate<String> predicate) { 
        if (predicate.test(tag)) { 
        	numTagVector[i] = 1;
        } 
    } 
}
