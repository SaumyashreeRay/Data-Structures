package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it rthoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
   
	  BST a = new BST();
	  //insertTests(a);
	  //sizeTests(a); 
	  //minMaxTests(a);
	  //heightTest(a);
	  //emptyTests(a);
	  //containTests(a);
	  //insertAfterRemoveTests(a);
	  saumyaTests(a);

  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight(tree.getRoot());
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  
   static void inOrderTraversal(BST_Node root){
	  if(root != null){
		  inOrderTraversal(root.left);
		  System.out.println(root);
		  inOrderTraversal(root.right);

	  }
  }
  
  static void sizeTests(BST a){
	//Case 0: size() == 0;
	  //System.out.println(a.size());
	  
	  //Case 1: insert(a), insert(b), size() == 2
//	  a.insert("a");
//	  a.insert("b");
//	  System.out.println(a.size());

	  //Case 2: insert(a), insert(b), remove(a), size() == 1
	  a.insert("a");
	  a.insert("b");
	  a.remove("a"); 
	  System.out.println(a.size());
  }
  
  static void insertTests(BST a){
//	  Insert:
//		  Case 0(Line): insert(C), insert(B), insert(A), in-order == (A, B, C)
//		      C
//		     /
//		    B
//		   /
//		  A
	  a.insert("C");
	  a.insert("B");
	  a.insert("A");
	 inOrderTraversal(a.getRoot());
	 printLevelOrder(a);
	  
//		  Case 1(left-insert): insert(B), insert(A), insert(D), insert(C), in-order = (A, B, C, D)
//		    B
//		   / \
//		  A  D
//		     /
//		    C
//	 a.insert("B");
//	 a.insert("A");
//	 a.insert("D");
//	 a.insert("C");
//	 inOrderTraversal(a.getRoot());

//		  Case 2(right-insert): insert(B), insert(A), insert(D), insert(C), insert(E), in-order = (A, B, C, D, E)
//		    B
//		   / \
//		  A D
//		     / \
//		    C   E
//	 a.insert("B");
//	 a.insert("A");
//	 a.insert("D");
//	 a.insert("C");
//	 a.insert("E");
//	 inOrderTraversal(a.getRoot());

  }
  
  static void minMaxTests (BST a){
//	  Case 0(One element): insert(A), findMax() == A, findMin() = A
//	  a.insert("A");
//	  System.out.println(a.findMax());
//	  System.out.println(a.findMin());
	  
//	  Case 1(Two elements): insert(A), insert(B), findMax() == B, findMin() == A
//	  a.insert("A");
//	  a.insert("B");
//	  System.out.println(a.findMax());
//	  System.out.println(a.findMin());
	  
//	  Case 2(remove): insert(A), insert(C), insert(B), remove(C), findMax() == B, findMin() == A
//	  a.insert("A");
//	  a.insert("C");
//	  a.insert("B");
//	  a.remove("C");
//	  System.out.println(a.findMax());
//	  System.out.println(a.findMin());
  }

  static void heightTest (BST a){
	  //Case0: insert(B), insert(A), insert(D), insert(C), insert(F), insert(E), height()==3
	  a.insert("B");
	  a.insert("A");
	  a.insert("D");
	  a.insert("C");
	  a.insert("F");
	  a.insert("E");
	  System.out.println(a.height());

  }
  
  static void emptyTests(BST a){
//	  Case 0: new BST, empty() = true
	  System.out.println(a.empty());
//	  Case 1: insert(B), insert(A), insert(D), insert(C), insert(E), remove(B), 
//	  remove(A), remove(D), remove(C), remove(E),empty() == true
	  a.insert("B");
	  a.insert("A");
	  a.insert("D");
	  a.insert("C");
	  a.insert("E");
	  a.remove("B");
	  a.remove("A");
	  a.remove("D");
	  a.remove("C");
	  a.remove("E");
	  System.out.println(a.empty());  
  }

  static void containTests(BST a){
//	  contains:
//		  Case 0: insert(B), insert(A), insert(D), insert(C), insert(E), contains(D) == True
//		    B
//		   / \
//		  A D
//		     / \
//		    C   E
//	  a.insert("B");
//	  a.insert("A");
//	  a.insert("D");
//	  a.insert("C");
//	  a.insert("E");
//	  System.out.println(a.contains("D"));
	  
//		  Case 1: insert(B), insert(A), insert(D), insert(C), insert(E), remove(D), 
//	      contains(D) == False, contains(C) = True, contains(E) = True
//		    B
//		   / \
//		  A d
//		     / \
//		    C   E
	  //Won't work because havent written code for 2 kids
	  a.insert("B");
	  a.insert("A");
	  a.insert("D");
	  a.insert("C");
	  a.insert("E");
	  a.remove("D");
	  System.out.println(a.contains("D"));
	  System.out.println(a.contains("C"));
	  System.out.println(a.contains("E"));	  
  }

  static void insertAfterRemoveTests(BST a){
//	  Case 0(root): insert(A), remove(A), insert(B), in-order = (B)
	  a.insert("A");
	  a.remove("A");
	  //a.insert("B");
	  inOrderTraversal(a.getRoot());
//	  Case 1(left): insert(D), insert(B), remove(B), insert(B), insert(E), in-order = (B, D, E)
//	  Case 2(internal): insert(B), insert(A), insert(D), insert(C), insert(E), remove(E), insert(F), insert(E) in-order = (A, B, C, D, E, F)
	  
  }

  static void removeTests(BST a){
//	  Remove: {The removed node is marked as lower-case in graph}
//  Case 0: insert(A), insert(B), remove(B), in-order = (A)
//  A
//   \
//    b
//  Case 1(root): insert(B), insert(A), insert(C), remove(A), in-order = (B, C)
//  Case 2(nonroot internal node): insert(B), insert(A), insert(D), insert(C), insert(E), remove(D) in-order = (A, B, C, E)
//    B
//   / \
//  A d
//     / \
//    C   E
//  Case 3(leaf): insert(B), insert(A), insert(D), insert(C), insert(E), remove(E) in-order = (A, B, C, D)
//    B
//   / \
//  A D
//     / \
//    C   e
//  Case 4(complex internal 0): insert(0), insert(C), insert(A), insert(B), remove(C) in-order = (0, A, B)
//  0
//   \
//    \
//     c
//    / 
//   /  
//  A     
//   \   
//    B 
//  Case 5(complex internal 1): insert(0), insert(C), insert(E), insert(D), remove(C) in-order = (0, D, E)
//  0
//   \
//    \
//     c
//      \
//       \
//        E
//       /
//      D
//  Case 6(complex internal 2): insert(0), insert(C), insert(A), insert(B), insert(E), insert(D), remove(C) in-order = (0, A, B, D, E)
//  0
//   \
//    \
//     c
//    / \
//   /   \
//   A     E
//   \   /
//    B D
//
//  Case 7(Multiple remove): insert(0), insert(C), insert(A), insert(B), insert(E), insert(D), remove(C), remove(A), remove(D), remove(B), remove(E), in-order = (0)
//  0
//   \
//    \
//     c
//    / \
//   /   \
//  a     E
//   \   /
//    b d
  }
  
  static void saumyaTests( BST a){
	   String matcher = "hi";
	   System.out.println(a.empty());

	   a.insert("hello");
	   a.insert("hi");
	   a.insert("apples");
	   a.insert("bananas");
	   a.insert("crepes");
	   System.out.println(a.empty());
	   System.out.println(a.size());

	   System.out.println(a.findMin());
	   System.out.println(a.findMax());

	   System.out.println(a.getRoot());
	   a.remove("bananas");
	   System.out.println(a.size());
	   System.out.println(a.contains("bananas"));
	   System.out.println(a.contains("deer"));
	   System.out.println(a.contains("hi"));
	   System.out.println(a.remove("deer"));


  }
}
