package practice.DSDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *  Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */
    List<Integer> listNums;
    Integer min;

    public MinStack() {
        listNums = new ArrayList();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {

        if(listNums != null) {
            if(x < min) {
                min = x;
            }
            listNums.add(x);
        }
    }

    public void pop() {

        int num = top();
        listNums.remove(listNums.size() - 1);

        if(num == min) {
            int n = Integer.MAX_VALUE;

            for(int i : listNums) {
                if(i < n)
                    n = i;
            }
            min = n;
        }
    }

    public int top() {

        if(!listNums.isEmpty())
            return listNums.get(listNums.size() - 1);
        return -1;
    }

    public int getMin() {
        return min;
    }
}
