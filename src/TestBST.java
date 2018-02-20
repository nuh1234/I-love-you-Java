
import java.util.*;

public class TestBST {

    public static void main(String[] args) {
        DataBST tree = new DataBST();
        int[] numbers = new int[]{10, 3, 1, 2, 15, 11, 20, 7, 9};
        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < numbers.length; i++) {
                tree.add(new DataBST.Data(numbers[i], i + 100 * t));
            }
        }
        
        tree.printInorder();
        boolean inorder = true;
        boolean stable = true;
        System.out.println("For each tree iteration (should look the same as above):");
        System.out.print("inorder: ");
        for (DataBST.Data d : tree) {
            System.out.print(d + " ");
        }
        System.out.println();

        Iterator iterator = tree.iterator();
        DataBST.Data d = (DataBST.Data) iterator.next();
        int oldNumber1 = d.number1;
        int oldNumber2 = d.number2;
        while (iterator.hasNext()) {
            DataBST.Data dd = (DataBST.Data) iterator.next();
            if (dd.number1 < oldNumber1) {
                inorder = false;
            }
            if (dd.number1 == oldNumber1 && dd.number2 <= oldNumber2) {
                stable = false;
            }

            oldNumber1 = dd.number1;
            oldNumber2 = dd.number2;
        }
        System.out.println("in order = " + inorder);
        System.out.println("stable = " + stable);
        System.out.println("Tree sideways (without duplicates)");
        tree.printSideways();
        System.out.println("Tree sideways (with duplicates)");
        tree.printSideways(true);
    }
}

// A BST class based on code from UW CSE 143, IntTree.  This will be modified
// to handle duplicate elements in a stable way.  To do this you will have to
// change the definition of the DataTreeNode, add(), remove(), and other methods.
// The Data class has a number1 field which is the key to use when with the 
// search tree.  If you add a duplicate key then it will need to be added to
// the data structure somehow.  This should be done in a "stable" way so that
// and indorder traversal of the tree shows the keys in sorted order with duplicates
// traversed in the order of their addition.  Removal of a duplicate key should remove
// the last one added.  You get to pick exactly how you do all of this.  You may
// want to add a "middle" link to the DataTreeNode, or you could add some sort 
// of Collection to the DataTreeNode to hold the duplicate keys.  Remember that 
// there will be other fields in the Data class that can be used to assess 
// stability, but they should not be accessed at all in this code.
class DataBST implements Iterable<DataBST.Data> {

    private DataTreeNode overallRoot;

    // post: constructs an empty tree
    public DataBST() {
        overallRoot = null;
    }

    // pre : tree is a binary search tree
    // post: value is added to overall tree so as to preserve the binary search
    //       tree property
    public void add(Data value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value is added to given binary search tree so as to preserve the
    //       binary search tree property
    private DataTreeNode add(DataTreeNode root, Data value) {
        if (root == null) {
            root = new DataTreeNode(value);
        } else if (value.number1 < root.middle.get(0).number1) {
            root.left = add(root.left, value);
        } else if (value.number1 > root.middle.get(0).number1){
            root.right = add(root.right, value);
        } else {
        	root.middle.add(value);
        }

        return root;
    }



    // post: prints the tree contents using an inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(DataTreeNode root) {
    	if (root != null ) {
    		printInorder(root.left);
    		if(root.middle.size() > 1) {
    			int count = 0;
    			int len = root.middle.size();
    			while(count < len) {
    				System.out.print(" " + root.middle.get(count));
    				count++;
    			}
    		} else {
    			System.out.print(" " + root.middle.get(0));
    		}
    		printInorder(root.right);
    	}
    }


    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0, false);
    }

    public void printSideways(boolean inorder) {
        printSideways(overallRoot, 0, inorder);
    }
    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(DataTreeNode root, int level , boolean inorder) {
    	if (root != null) {
    		printSideways(root.right, level + 1, inorder);
    		for (int i = 0; i < level; i++) {
    			System.out.print("    ");
    		}
    		if(inorder && root.middle.size() > 1) {
    			int count = 0;
    			int len = root.middle.size();
    			while(count < len) {
    				System.out.print(" " + root.middle.get(count));
    				count++;
    			}
    			System.out.println();
    		} else {
    			System.out.println(root.middle.get(0));
    		}
    		printSideways(root.left, level + 1, inorder);
    	}
    }

    @Override
    public InorderIterator iterator() {
        return new InorderIterator();

    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator {
        // Store the elements in a list

        private java.util.ArrayList<Data> list
                = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(overallRoot);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(DataTreeNode root) {
        	if (root == null) {
        		return;
        	} else {
        		inorder(root.left);

        		if(root.middle.size() > 1) {
        			int count = 0;
        			int len = root.middle.size();
        			while(count < len) {
        				list.add(root.middle.get(count));
        				count++;
        			}

        		} else {
        			list.add((root.middle.get(0)));
        		}

        		inorder(root.right);
        	}
        }


        @Override
        /**
         * More elements for traversing?
         */
        public boolean hasNext() {
            if (current < list.size()) {
                return true;
            }

            return false;
        }

        @Override
        /**
         * Get the current element and move to the next
         */
        public Data next() {
            return list.get(current++);
        }

    }

// Class for storing a single node of a binary tree of ints
    static class DataTreeNode {

        public ArrayList<Data> middle;
        public DataTreeNode left;
        public DataTreeNode right;

        // constructs a leaf node with given data
        public DataTreeNode(Data data) {
            this(new ArrayList<Data>(Arrays.asList(data)), null, null);
        }

        // constructs a branch node with given data, left subtree,
        // right subtree
        public DataTreeNode(ArrayList<Data> middle, DataTreeNode left, DataTreeNode right) {
            this.middle = middle;
            this.left = left;
            this.right = right;
        }
    }

    public static class Data {

        int number1;
        int number2;

        public Data(int n1, int n2) {
            number1 = n1;
            number2 = n2;
        }

        @Override
        public String toString() {
            return "" + number1 + ":" + number2;
        }
    }
}
