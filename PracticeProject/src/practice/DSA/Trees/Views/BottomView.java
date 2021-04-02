package practice.DSA.Trees.Views;

import practice.DSA.Trees.TreeNode;

import java.util.*;
import java.util.Map.Entry;

public class BottomView{
	
	/*
	 * 	  1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
	 * 
	 * 
	 * 
	 * In this problem, we have made use of an additional node property i.e. horizontal distance(hd) from the root node!!
	 * */
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6); 
        root.right.right = new TreeNode(7); 
        root.right.left.right = new TreeNode(8); 
        root.right.right.right = new TreeNode(9); 
        bottomView(root);
	}
	
	
	public static void bottomView(TreeNode root) 
    { 
        if (root == null) 
            return; 
  
        int hd = 0; 
  
        Map<Integer, Integer> map = new TreeMap<>(); 
  
        Queue<TreeNode> queue = new LinkedList<>();
  
        root.hd = hd; 
        queue.add(root); 
  
        while (!queue.isEmpty()) 
        { 
            TreeNode temp = queue.remove();
  
            hd = temp.hd; 
  
            map.put(hd, temp.key); 
  
            if (temp.left != null) 
            { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            } 
            if (temp.right != null) 
            { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            } 
        } 
  
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
    } 
	
}