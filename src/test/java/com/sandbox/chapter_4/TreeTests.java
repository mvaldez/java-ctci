package com.sandbox.chapter_4;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class TreeTests {
    /**
     *          10
     *         /  \
     *        5    20
     *       / \  /  \
     *      3  7 15   null
     */
   private static TreeNode root = null;

   @BeforeClass
   public static void setup() {
       root = new TreeNode("10");
       root.left = new TreeNode("5");
       root.right = new TreeNode("20");
       root.right.left = new TreeNode("15");
       root.left.left = new TreeNode("3");
       root.left.right = new TreeNode("7");
   }

    @Test
    public void inOrderTraversalTest() {
        System.out.println("----in order ----");
        TreeNode.inOrderTraversal(root);
    }

    @Test
    public void preOrderTraversalTest() {
        System.out.println("----pre order ----");
        TreeNode.preOrderTraversal(root);
    }

    @Test
    public void postOrderTraversalTest() {
        System.out.println("----post order ----");
        TreeNode.postOrderTraversal(root);
    }
}
