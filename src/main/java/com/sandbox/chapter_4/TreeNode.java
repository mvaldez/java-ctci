package com.sandbox.chapter_4;

/**
 *
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private final String data;

    public TreeNode(String data) {
        this.data = data;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }

    public static void visit(TreeNode node) {
        System.out.println(node.data);
    }
}
