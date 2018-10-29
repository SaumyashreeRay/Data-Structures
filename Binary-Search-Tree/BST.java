package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		if (root == null) {
			root = new BST_Node(s);
			size++;
			return true;
		}
		 if (root.containsNode(root, s)) {
		 return false;
		 }
		else {
			size++;
			root.insertNode(root, s);
			return true;
		}
	}

	@Override
	public boolean remove(String s) {
		boolean removed;
		if(empty()){
			removed = false;
		}else if (!contains(s)){
			removed = false;
		}else if (root.data.compareTo(s) == 0){ //removing root from tree
			if(root.getLeft() == null && root.getRight() == null){ //only node is root
				root = null;
			}else if (root.getRight() == null){ //no right child
				root = root.getLeft();
			}else if (root.getLeft() == null){ //no left child
				root = root.getRight();
			}else{   //2 kids
				String maxVal = root.getLeft().findMax().getData();
				remove(maxVal);
				root.data = maxVal;
			}
			removed = true;
		}else{
			removed = root.removeNode(s); //removing something other than the root
		}
		
		if(removed){
			size--;
		}
		return removed;
		
	}

	@Override
	public String findMin() {
		if (size() == 0) {
			return null;
		}
		if (root == null) {
			return null;
		}
		return root.findMin().getData();
	}

	@Override
	public String findMax() {
		if (size() == 0) {
			return null;
		}
		if (root == null) {
			return null;
		}

		return root.findMax().getData();
	}

	@Override
	public boolean empty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}	
	}

	@Override
	public boolean contains(String s) {
		if(empty()){
			return false;
		}else{
			return root.containsNode(root, s);
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (empty()) {
			return -1;
		} else {
			return root.getHeight(root);
		}
	}

}
