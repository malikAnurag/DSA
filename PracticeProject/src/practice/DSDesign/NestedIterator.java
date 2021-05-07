package practice.DSDesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 * Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 *
 *
 * Example 1:
 *
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next shou
 */

//FlattenNestedListIterator
public class NestedIterator implements Iterator<Integer> {

    List<Integer> al;
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {

        al = new ArrayList();

        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                al.add(ni.getInteger());
            } else {
                populateList(ni);
            }
        }
    }

    private void populateList(NestedInteger ni) {
        for(NestedInteger nested : ni.getList()) {
            if(nested.isInteger()) {
                al.add(nested.getInteger());
            } else {
                populateList(nested);
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return al.get(index++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return index < al.size();
    }
}

/** This is the interface that allows for creating nested lists.
  You should not implement it, or speculate about its implementation
 **/
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}