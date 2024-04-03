

//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class AVLNode {
    int val;
    int N;
    int aux;
    AVLNode left, right;
    AVLNode parent;

    public AVLNode() {};
    public AVLNode(int val) {
        this.val = val;
        this.N = 1;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int value) {
        aux = value;
    }
}

class AVL {
    AVLNode root;
    public void preorder(AVLNode x) {
        if(x != null) {
            System.out.print(x.val + " ");
            preorder(x.left);
            preorder(x.right);
        }
    }

    public TreeNode copyToTreeNode(AVLNode original) {
        TreeNode copy;
        if(original != null) {
            copy = new TreeNode();
            copy.left = copyToTreeNode(original.left);
            copy.right = copyToTreeNode(original.right);
            copy.val = original.val;
            return copy;
        }
        return null;
    }

    protected AVLNode treeSearch(int val) {
        AVLNode x = root;
        while(true) {
            int cmp = val - x.val;
            if(cmp == 0) return x;
            else if(cmp < 0) {
                if(x.left == null) return x;
                else x = x.left;
            }
            else {
                if(x.right == null) return x;
                else x = x.right;
            }
        }
    }

    public void put(int val) {
        if(root == null) {
            root = new AVLNode(val);
            return;
        }

        AVLNode x = treeSearch(val);
        int cmp = val - x.val;

        AVLNode newAVLNode = new AVLNode(val);
        if(cmp < 0) x.left = newAVLNode;
        else x.right = newAVLNode;
        newAVLNode.parent = x;
        rebalanceInsert(newAVLNode);
    }

    protected void rebalanceInsert(AVLNode x) {
        if(isLeaf(x)) {
            rebalance(x);
        }
    }

    protected boolean isLeaf(AVLNode x) {
        return x.left == null && x.right == null;
    }

    private void resetSize(AVLNode x, int value) {
        for( ; x != null; x = x.parent)
            x.N += value;
    }

    protected void relink(AVLNode parent, AVLNode child, boolean makeLeft) {
        if(child != null) child.parent = parent;
        if(makeLeft) parent.left = child;
        else parent.right = child;
    }

    protected void rotate(AVLNode x) {
        AVLNode y = x.parent;
        AVLNode z = y.parent;
        if(z == null) {
            root = x;
            x.parent = null;
        }
        else relink(z, x, y == z.left);

        if(x == y.left) {
            relink(y, x.right, true);
            relink(x, y, false);
        }
        else {
            relink(y, x.left, false);
            relink(x, y, true);
        }
    }

    protected AVLNode restructure(AVLNode x) {
        AVLNode y = x.parent;
        AVLNode z = y.parent;
        if((x == y.left) == (y == z.left)) {
            rotate(y);
            return y;
        }
        else {
            rotate(x);
            rotate(x);
            return x;
        }
    }

    private int height(AVLNode x) {
        return (x == null) ? 0 : x.getAux();
    }

    private void setHeight(AVLNode x, int height) {
        x.setAux(height);
    }

    private void recomputeHeight(AVLNode x) {
        setHeight(x, 1 + Math.max(height(x.left), height(x.right)));
    }

    private boolean isBalanced(AVLNode x) {
        return Math.abs(height(x.left) - height(x.right)) <= 1;
    }

    private AVLNode tallerChild(AVLNode x) {
        if(height(x.left) > height(x.right)) return x.left;
        if(height(x.left) < height(x.right)) return x.right;
        if(x == root) return x.left;
        if(x == x.parent.left) return x.left;
        else return x.right;
    }

    private void rebalance(AVLNode x) {
        do {
            if(!isBalanced(x)) {
                x = restructure(tallerChild(tallerChild(x)));
                recomputeHeight(x.left);
                recomputeHeight(x.right);
                for(AVLNode p = x; p != null; p = p.parent)
                    recomputeHeight(p);
            }
            x = x.parent;
        } while(x != null);
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        AVL avl = new AVL();

        for(ListNode listNode = head; listNode != null; listNode = listNode.next)
            avl.put(listNode.val);

        return avl.copyToTreeNode(avl.root);
    }
}
public class Main2 {

}

