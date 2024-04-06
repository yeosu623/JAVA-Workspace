

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

class RBNode {
    int val;
    int N;
    int aux;
    RBNode left, right;
    RBNode parent;

    public RBNode() {};
    public RBNode(int val) {
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

class RB {
    RBNode root;
    public void preorder(RBNode x) {
        if(x != null) {
            System.out.print(x.val + " ");
            preorder(x.left);
            preorder(x.right);
        }
    }

    public TreeNode copyToTreeNode(RBNode original) {
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

    protected RBNode treeSearch(int val) {
        RBNode x = root;
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
            root = new RBNode(val);
            return;
        }

        RBNode x = treeSearch(val);
        int cmp = val - x.val;

        RBNode newRBNode = new RBNode(val);
        if(cmp < 0) x.left = newRBNode;
        else x.right = newRBNode;
        newRBNode.parent = x;
        rebalanceInsert(newRBNode);
    }

    protected void rebalanceInsert(RBNode x) {
        makeRed(x);

        if (x != root && isRed(x.parent)) {
            resolveRed(x);
        }
    }



    boolean isBlack(RBNode x) {
        return (x == null) || (x.getAux() == 0);
    }

    boolean isRed(RBNode x) {
        return (x != null) && (x.getAux() == 1);
    }

    void makeBlack(RBNode x) {
        x.setAux(0);
    }

    void makeRed(RBNode x) {
        x.setAux(1);
    }

    RBNode sibling(RBNode x) {
        RBNode p = x.parent;
        if(p.left == x) return p.right;
        else return p.left;
    }

    private void resolveRed(RBNode x) {
        RBNode parent, uncle, middle, grand;

        parent = x.parent;
        if(isRed(parent)) {
            uncle = sibling(parent);
            if(uncle == null || isBlack(uncle)) {
                middle = restructure(x);
                makeBlack(middle);
                makeRed(middle.left);
                makeRed(middle.right);
            }
            else {
                makeBlack(parent);
                makeBlack(uncle);
                grand = parent.parent;
                if(grand != root) {
                    makeRed(grand);
                    resolveRed(grand);
                }
            }
        }
    }


    protected boolean isLeaf(RBNode x) {
        return x.left == null && x.right == null;
    }

    private void resetSize(RBNode x, int value) {
        for( ; x != null; x = x.parent)
            x.N += value;
    }

    protected void relink(RBNode parent, RBNode child, boolean makeLeft) {
        if(child != null) child.parent = parent;
        if(makeLeft) parent.left = child;
        else parent.right = child;
    }

    protected void rotate(RBNode x) {
        RBNode y = x.parent;
        RBNode z = y.parent;
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

    protected RBNode restructure(RBNode x) {
        RBNode y = x.parent;
        RBNode z = y.parent;
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

    private int height(RBNode x) {
        return (x == null) ? 0 : x.getAux();
    }

    private void setHeight(RBNode x, int height) {
        x.setAux(height);
    }

    private void recomputeHeight(RBNode x) {
        setHeight(x, 1 + Math.max(height(x.left), height(x.right)));
    }

    private boolean isBalanced(RBNode x) {
        return Math.abs(height(x.left) - height(x.right)) <= 1;
    }

    private RBNode tallerChild(RBNode x) {
        if(height(x.left) > height(x.right)) return x.left;
        if(height(x.left) < height(x.right)) return x.right;
        if(x == root) return x.left;
        if(x == x.parent.left) return x.left;
        else return x.right;
    }

    private void rebalance(RBNode x) {
        do {
            if(!isBalanced(x)) {
                x = restructure(tallerChild(tallerChild(x)));
                recomputeHeight(x.left);
                recomputeHeight(x.right);
                for(RBNode p = x; p != null; p = p.parent)
                    recomputeHeight(p);
            }
            x = x.parent;
        } while(x != null);
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        RB rb = new RB();

        for(ListNode listNode = head; listNode != null; listNode = listNode.next)
            rb.put(listNode.val);

        return rb.copyToTreeNode(rb.root);
    }
}
public class Main2 {
    public static void main(String[] args) {
        RB rb = new RB();
        int[] data = {1,5,7,13,15,10,12,20,16,22};

        for(int i = 0; i < data.length; i++) {
            rb.put(data[i]);
        }

        rb.preorder(rb.root);
    }
}

