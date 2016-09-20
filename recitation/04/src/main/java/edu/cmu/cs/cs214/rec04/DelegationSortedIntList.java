package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps 
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed) 
 * and exports an accessor (totalAdded) for this count.
 * 
 * @author Nora Shoemaker
 *
 */
									  
// HINT: Take a look at the UML diagram to see what DelegationSortedIntList 
//       should implement.
public class DelegationSortedIntList { 
	// the number of attempted element insertions
	private int totalAdded;
	
	/**
	 * Gets the total number of attempted int insertions to the list since it.
	 * was created.
	 * 
	 * @return total number of integers added to the list.
	 */
	public int getTotalAdded()
	{
		return totalAdded;
	}

}
