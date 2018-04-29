package com.rahul.hacker.ds.bst;

import java.util.ArrayList;
import java.util.List;

class  TreeNodeInfo {
    BSTNode node;
    BSTNode lastNode;

    public TreeNodeInfo(BSTNode node, BSTNode lastNode) {
        this.node = node;
        this.lastNode = lastNode;
    }

    public BSTNode getNode() {
        return node;
    }

    public BSTNode getLastNode() {
        return lastNode;
    }
}

public class IsSubTree {

    public static void main(String arg[]) {
        BSTNode root1 = new BSTNode(100);
        root1.setLeft(new BSTNode(50));
        root1.setRight(new BSTNode(150));

        BSTNode root2 = new BSTNode(150);
        BSTNode b1 = new BSTNode(100);
        BSTNode b2 = new BSTNode(200);
        root2.setLeft(b1);
        root2.setRight(b2);

        BSTNode c1 = new BSTNode(50);
        BSTNode c2 = new BSTNode(250);
        b1.setLeft(c1);
        b2.setRight(c2);

        System.out.println(isSubTree(root1, root2));
    }


    private static void traverse(BSTNode a, BSTNode[] last, List<TreeNodeInfo> nodesA) {
        if (a == null) {
            return;
        }
        last[0] = a;
        traverse(a.getLeft(), last, nodesA);
        nodesA.add(new TreeNodeInfo(a, last[0]));
        traverse(a.getRight(), last, nodesA);
    }


    private static boolean isSubTree(BSTNode a, BSTNode b) {

        List<TreeNodeInfo> nodesA = new ArrayList<>();
        List<TreeNodeInfo> nodesB = new ArrayList<>();

        traverse(a, new BSTNode[1], nodesA);
        traverse(b, new BSTNode[1], nodesB);

        int sizeA = nodesA.size();
        int sizeB = nodesB.size();

        int i = 0;
        int j = 0;

        while (i < sizeA && j < sizeB) {
            TreeNodeInfo nodeA = nodesA.get(i);
            TreeNodeInfo nodeB = nodesB.get(j);

            if (nodeA.getNode().getData() == nodeB.getNode().getData()) {
                if (j != 0) {
                    BSTNode bstNodeA = nodeA.getLastNode();
                    BSTNode bstNodeB = nodeB.getLastNode();
                    if(bstNodeA != null && bstNodeB != null && bstNodeA.getData() != bstNodeB.getData()) {
                        return false;
                    } else
                    if ((bstNodeA == null && bstNodeB != null) || (bstNodeA != null && bstNodeB == null)) {
                        return false;
                    }
                }
                j++;
            } else {
                if(j > 0) {
                    return false;
                }
            }
            i++;
        }

        return j == sizeB;
    }
}
