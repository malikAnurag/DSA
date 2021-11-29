package practice.DSA.Graph.BFS;

import java.util.*;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *  Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 104]
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder_efficient(Node root) {

        List<List<Integer>> al = new ArrayList();

        if(root == null)
            return al;

        Queue<Node> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {

            List<Integer> list = new ArrayList();
            int size = q.size();

            for(int i = 0 ; i < size ; i++) {
                Node node = q.poll();
                list.add(node.val);
                q.addAll(node.children);
            }
            al.add(list);
        }
        return al;
    }


    public List<List<Integer>> levelOrder(Node root) {

        if(root == null)
            return new ArrayList();

        Queue<Pair> q = new LinkedList();
        Map<Integer, List<Integer>> hm = new HashMap();
        q.add(new Pair(root, 0));

        List<Integer> curr1 = new ArrayList();
        curr1.add(root.val);
        hm.put(0, curr1);

        while(!q.isEmpty()) {

            Pair pair = q.remove();

            Node node = pair.node;
            int l = pair.level;

            if(node.children.size() > 0) {

                for(Node child : node.children) {
                    q.add(new Pair(child, l+1));

                    List<Integer> curr = hm.get(l+1);

                    if(curr == null) {
                        curr = new ArrayList();
                        curr.add(child.val);
                        hm.put(l+1, curr);
                    }
                    else {
                        curr.add(child.val);
                    }
                }
            }
        }
        // System.out.println(hm);
        List<List<Integer>> res = new ArrayList();

        for(List<Integer> list : hm.values()) {
            res.add(list);
        }
        return res;
    }
}

class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}