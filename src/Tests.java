import com.deitel.datastructures.Tree;

import java.security.SecureRandom;


public class Tests {
    public static void main(String[] args) {

        //sample tree1
        Tree<Integer> tree = new Tree<Integer>();

        tree.insertNode(10);
        tree.insertNode(15);
        tree.insertNode(5);
        tree.insertNode(1);
        tree.insertNode(7);
        tree.insertNode(12);
        tree.insertNode(20);
        print(tree);

        //sample tree2
        Tree<Integer> tree2 = new Tree<Integer>();

        tree2.insertNode(50);
        tree2.insertNode(25);
        tree2.insertNode(10);
        tree2.insertNode(10);
        tree2.insertNode(9);
        tree2.insertNode(75);
        tree2.insertNode(80);
        tree2.insertNode(66);
        tree2.insertNode(51);
        tree2.insertNode(99);
        print(tree2);



        //Create 3 random trees
        SecureRandom randomNumber = new SecureRandom();

        for(int i = 0; i < 3;i++) {

            int length = randomNumber.nextInt(20) + 1;
            Tree<Integer> treeRand = new Tree<Integer>();

            for(int j = 0;j < length;j++){

                int data = randomNumber.nextInt(100) + 1;
                treeRand.insertNode(data);

            }

            print(treeRand);
        }




    }

    public static void print(Tree<Integer> tree){
        System.out.println("post:");
        tree.postorderTraversal();
        System.out.println("\npre:");
        tree.preorderTraversal();
        System.out.println("\nin:");
        tree.inorderTraversal();
        System.out.println("\n");
        tree.outputTree();
    }
}
