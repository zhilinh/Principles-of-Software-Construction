package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps 
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed) 
 * and exports an accessor (totalAdded) for this count.
 * 
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntList extends SortedIntList {
	// the number of attempted element insertions
	private int totalAdded = 0;
	public SortedIntList list = new SortedIntList();
	
	/**
	 * Gets the total number of attempted int insertions to the list since it
	 * was created.
	 * 
	 * @return total number of integers added to the list.
	 */
	public int getTotalAdded()
	{
		return this.totalAdded;
	}
	
	@Override
	public boolean add(int num) {
//		if (this.list.add(num)) {
//			this.totalAdded++;
//			return true;
//		} else {
//			return false;
//		}
		this.totalAdded++;
		return true;
		
	}
	
	@Override
	public boolean addAll(IntegerList list) {
//		if (this.list.addAll(list)) {
//			this.totalAdded += list.size();
//			return true;
//		} else {
//			return false;
//		}
		this.totalAdded++;
		return true;
	}

}
