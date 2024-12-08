import java.util.*;

class Solution {
    
    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();
    int size;
    
    public int[][] solution(int[][] nodeinfo) {
        
        size = nodeinfo.length;
        
        List<Node> nodeList = new ArrayList<>();
        
        for(int i = 0; i < size; i++) nodeList.add(new Node(nodeinfo[i], i + 1));
        
        nodeList.sort((a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        
        int index = 0;
        
        BTree bTree = new BTree(nodeList.get(index));
        
        while (++index < size) {
            bTree.add(nodeList.get(index));
        }
        
        preorder(bTree.head, preorderList);
        postorder(bTree.head, postorderList);
        
        int[] preArr = new int[size];
        int[] postArr = new int[size];
        
        for (int i = 0; i < size; i++) {
            preArr[i] = preorderList.get(i);
            postArr[i] = postorderList.get(i);
        }
  
        return new int[][]{preArr, postArr};
    }
    
    void preorder(Node head, List<Integer> list) {
        
        if (head == null) return;
        
        list.add(head.n);
        preorder(head.left, list);
        preorder(head.right, list);
    }
    
    void postorder(Node head, List<Integer> list) {

        if (head == null) return;

        postorder(head.left, list);
        postorder(head.right, list);
        list.add(head.n);
    }
    
    class Node {
        
        Node left;
        Node right;
        int x;
        int y;
        int n;
        
        Node(int[] arr, int n) {
            x = arr[0];
            y = arr[1];
            this.n = n;
        }
        
        void addChild(Node child) {
            if(child.x < this.x) {
                if (left == null) left = child;
                else left.addChild(child);

            } else {
                if (right == null) right = child;
                else right.addChild(child);

            }
        }
    }
    
    class BTree {

        Node head;
    
        BTree(Node node) {
        
            head = node;
        }
    
        void add(Node node) {
        
            head.addChild(node);
        }
    }   
}