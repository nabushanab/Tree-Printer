// Fig. 21.17: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
package com.deitel.datastructures;

// class TreeNode definition
class TreeNode<T extends Comparable<T>>
{
    // package access members
    TreeNode<T> leftNode;
    T data; // node value
    TreeNode<T> rightNode;

    // constructor initializes data and makes this a leaf node

    public TreeNode(T nodeData)
    {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }

    // locate insertion point and insert new node; ignore duplicate values
    public void insert(T insertValue)
    {
        // insert in left subtree
        if (insertValue.compareTo(data) < 0)
        {
            // insert new TreeNode
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else // continue traversing left subtree recursively
                leftNode.insert(insertValue);
        }
        // insert in right subtree
        else if (insertValue.compareTo(data) > 0)
        {
            // insert new TreeNode
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else // continue traversing right subtree recursively
                rightNode.insert(insertValue);
        }

    }
} //end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>>
{
    private TreeNode<T> root;

    // constructor initializes an empty Tree of integers
    public Tree()
    {
        root = null;
    }

    // insert a new node in the binary search tree
    public void insertNode(T insertValue)
    {
        if(root == null)
            root = new TreeNode<T>(insertValue); // create root node
        else
            root.insert(insertValue); // call the insert method

    }

    // begin preorder traversal
    public void preorderTraversal()
    {
        preorderHelper(root);
    }

    // recursive method to perform preorder traversal
    private void preorderHelper(TreeNode<T> node)
    {
        if(node == null)
            return;

        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree

    }

    // begin inorder traversal
    public void inorderTraversal()
    {
        inorderHelper(root);
    }

    // recursive method to perform inorder traversal
    private void inorderHelper(TreeNode<T> node)
    {
        if (node == null)
            return;

        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree

    }

    //begin postorder traversal
    public void postorderTraversal()
    {
        postorderHelper(root);
    }

    // recursive method to perform postorder traversal
    private void postorderHelper(TreeNode<T> node)
    {
        if(node == null)
            return;

        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    /**
     * OutputTree : Displays a horizontal representations of the tree
     */
    //outputTree will call outputtree helper to run the recursion
    public void outputTree()
    {
        if(root == null){
            return;
        }
        else
            outputTreeHelper(root, 0);
    }

    /**
     * outputTreeHelper : Helps the outputTree method run its recursion
     * @param node : current node within the recursion
     * @param totalSpaces : Total Spaces in the current recursion
     */
    private void outputTreeHelper(TreeNode<T> node, int totalSpaces) {
        //exit once no more nodes exist
        if (node == null)
            return;

        //create the string to hold the spaces
        String s = "";
        //loop the spaces to allocate the total spaces parameter
        for(int i = 0; i < totalSpaces; i++){
            //add space
            s+= " ";
        }

        //start with right nodes as these will be printed first
        outputTreeHelper(node.rightNode, totalSpaces+=5); // traverse right subtree
        System.out.println(s + node.data); // output node data

        totalSpaces-=5;//subtract five from totalspaces to reset left Nodes
        outputTreeHelper(node.leftNode,totalSpaces+=5); // traverse left subtree

    }


}// end class Tree