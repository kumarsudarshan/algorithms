# AVL Tree

AVL tree is a self-balancing binary search tree in which each node maintains extra information called a balance factor whose value is either -1, 0 or +1.

AVL tree got its name after its inventor Georgy Adelson-Velsky and Landis.

#### Balance Factor
Balance factor of a node in an AVL tree is the difference between the height of the left subtree and that of the right subtree of that node.

Balance Factor = (Height of Left Subtree - Height of Right Subtree) or (Height of Right Subtree - Height of Left Subtree)

The self balancing property of an avl tree is maintained by the balance factor. The value of balance factor should always be -1, 0 or +1.

An example of a balanced avl tree is:

![image](https://user-images.githubusercontent.com/8271393/133758587-135b036f-c217-4487-8c71-844547523f61.png)

#### Rotating the subtrees in an AVL Tree
In rotation operation, the positions of the nodes of a subtree are interchanged.

**There are two types of rotations:**

**Left Rotate**
In left-rotation, the arrangement of the nodes on the right is transformed into the arrangements on the left node.

![image](https://user-images.githubusercontent.com/8271393/133759037-2e377553-d978-4d3d-88f0-aa66a7142ffc.png)

**Right Rotate**
In left-rotation, the arrangement of the nodes on the left is transformed into the arrangements on the right node.

![image](https://user-images.githubusercontent.com/8271393/133759192-3f87aec0-5703-4042-83c0-41cba016a855.png)

**Left-Right and Right-Left Rotate**
In left-right rotation, the arrangements are first shifted to the left and then to the right.

![image](https://user-images.githubusercontent.com/8271393/133759284-3199de70-c793-47cb-af8c-d9a2157a7b18.png)

More details: [https://www.programiz.com/dsa/avl-tree]
