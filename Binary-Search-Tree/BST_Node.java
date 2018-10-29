package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){
	  this.data=data; 
	  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations


  public boolean containsNode(BST_Node root, String s){
	  if(root == null){
		  return false;
	  }
	  
	  int result = s.compareTo(root.getData()); 
	  if (result < 0){
		  return containsNode(root.left, s);
	  }else if (result > 0){
		  return containsNode(root.right, s);
	  }else
		  return true;
	    }

  public BST_Node insertNode(BST_Node root, String s){
	  if (root == null) {
			root = new BST_Node(s);
			return root;
		}
	  
	  int result = s.compareTo(root.getData()); 
	  
	  if (result < 0){
		  root.left = insertNode(root.left, s); 
	  }else if (result>0){
		  root.right = insertNode(root.right, s);
	  }else
		  ;
	  
	return root;
  }
  
  public boolean removeNode(String s){ 
	  BST_Node removing = this;
	  BST_Node parent = this;
	  
	  //finding node to remove
	  boolean notFound = true;
	  while(notFound){
		  int result = s.compareTo(removing.getData()); 
		  if(result == 0){
			  notFound = false; //Now it's found
		  }else if (result>0){
			  //moving right
			  parent = removing;
			  removing = removing.getRight();
		  }else{
			  //moving left
			  parent = removing;
			  removing = removing.getLeft();
		  }
	  }

	  //is removing left or right of parent?
	  boolean leftSide = false;
	  if(parent.getData().compareTo(removing.getData()) > 0){
		  leftSide = true;
	  }
	  //Actually Removing stuff
	  //no kids
	  if(removing.getRight() == null & removing.getLeft() == null){ 
		  	if (leftSide){
		  		parent.left = null;
		  	}else{
		  		parent.right = null;
		  	}
	  }else if (removing.getRight() == null){ //one kid on the left
		  if (leftSide){
		  		parent.left = removing.left;
		  	}else{
		  		parent.right = removing.left;
		  	}
	  }else if (removing.getLeft() == null){ //one kid on the right
		  if (leftSide){
		  		parent.left = removing.right;
		  	}else{
		  		parent.right = removing.right;
		  	}
	  }else{ 
		  String replacement = removing.getLeft().findMax().getData();
		  removeNode(replacement);
		  removing.data = replacement;
	  }
	  return true;

	    }
  
  public BST_Node findMin(){ 
	  BST_Node root = this;
	  while(true){
	  if (root.getLeft() == null){
			return root;
		}else{
			 root = root.getLeft(); 
		}
	  }
			 
  }
  
  public BST_Node findMax(){
	  BST_Node root = this;
	  while(true){
	  if (root.getRight() == null){
			return root;
		}else{
			 root = root.getRight();
		} 
	  }
  }
  
  public int getHeight(BST_Node root){
	  if (root == null){
		  return -1;
	  }
	  int leftHeight = getHeight(root.left);
	  int rightHeight = getHeight(root.right);
	  return Math.max(leftHeight, rightHeight) + 1;

  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  static void inOrderTraversal(BST_Node root){
	  if(root != null){
		  inOrderTraversal(root.left);
		  System.out.println(root);
		  inOrderTraversal(root.right);

	  }
  }
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}