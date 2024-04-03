// 21911981 정수열
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
    }
}

class BST {
    public Node root;

    protected Node treeSearch(int key) {
        Node x = root;

        while(true) {
            int cmp = key - x.key;

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

    public void put(int key) {
        if(root == null) {
            root = new Node(key);
            return;
        }

        Node x = treeSearch(key);
        int cmp = key - x.key;

        Node newNode = new Node(key);
        if(cmp < 0) x.left = newNode;
        else x.right = newNode;
    }

    public void postorder(Node x, ArrayList<Integer> keyList) {
        if(x != null) {
            postorder(x.left, keyList);
            postorder(x.right, keyList);
            keyList.add(x.key);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String str;
        BST bst = new BST();

        while((str = br.readLine()) != null)
        {
            st = new StringTokenizer(str, " ");
            int input = Integer.parseInt(st.nextToken());
            bst.put(input);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        bst.postorder(bst.root, answer);

        for(int i = 0; i < answer.size(); i++)
            bw.write(answer.get(i).toString() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
