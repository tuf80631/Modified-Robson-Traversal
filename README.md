# Modified-Robson-Traversal
Modified Robson Traversal
Modified Robson’s traversal traverses a binary tree (preorder, inorder, or post order) utilizing only the nodes of a binary tree as the only data structures.It does not require the use of an Stack Array or any other type of data structure to keep track of the nodes that have finished the traversal of the left subtree and require the traversal of the right subtree.Instead of using a separate data structure to keep track of the nodes that finished the traversal of the left subtree and require the traversal of the right subtree, Modified Robson’s traversal uses the leaf nodes (nodes with both a null left subtree and a null right subtree) as a way to keep track of the nodes that have finished left subtree traversal and require right subtree traversal. These leaf nodes are connected with each using the left pointers of the leaf nodes. The right pointer of these leaf nodes than point to the nodes that finished left subtree traversal and require right subtree traversal.If you are traversing the left subtree of a node, the left pointer of this node points to its predecessor. If you are traversing the right subtree of a node, the right pointer of this node points to its predecessor. As you move back up a tree after traversing either its left subtree or right subtree, you restore the left or right pointers of the node you finished traversing back to its original successor. See below for BinaryTree class (JAVA file).This class contains methods for both the Modified Robson Preorder Traversal in (see public void robsonTraversal() ) as well as the Preorder traversal utilizing Stacks.
