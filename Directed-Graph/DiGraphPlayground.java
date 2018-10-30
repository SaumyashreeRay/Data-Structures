package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
		// edgeTest();
		// exTest();
		//testCaseX();
		// topoTest1();
	  //delNode();
	  //delEdge();
	  //topo5();
	  numEdge();
    }
  	public static void edgeTest(){
  		//Case 2: Source
        DiGraph d = new DiGraph();
//  		d.addNode(1, "f");
//  		d.addNode(3, "s");
//  		d.addNode(7, "t");
//  		System.out.println(d.addEdge(0, "w", "s", 0, null));// == False
        
//        d.addNode(1,"f");
//        d.addNode(3, "s");
//        d.addEdge(0, "f", "s", 0, null);
//        System.out.println(d.delEdge("f","x"));//==false
//        System.out.println(d.delEdge("x","f"));//==false
//        
        
        System.out.println(d.delEdge("f", "s"));//==false
        d.addNode(1,"f");
        d.addNode(3, "s");
        d.addEdge(0, "f", "s", 0, "Edge 1");
        System.out.println(d.delEdge("f","s")); //true
        System.out.println(d.delEdge("f","s"));//==false
        System.out.println(d.addEdge(0, "f", "s", 0, null));//==true
        System.out.println(d.delEdge("f", "s"));//==true
  	}
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(0, "f", "s", 0, null);
      d.addEdge(1, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);

      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
     System.out.println("outer edges of f");
      printTOPO(d.topoSort());
      
    }
    public static void topoTest4(){
    	DiGraph d = new DiGraph();
//		Case 4(Circle)
//		addNode(1, p)
//		addNode(4, a)
//		addNode(3, g)
//		addNode(2, e)
//		addEdge(0, p, a, 0, null)
//		addEdge(1, a, g, 0, null)
//		addEdge(2, g, e, 0, null)
//		addEdge(3, e, p, 0, null)
//		toposort() == null
    	d.addNode(1, "p");
    	d.addNode(4, "a");
    	d.addNode(3, "g");
    	d.addNode(2, "e");
    	d.addEdge(0, "p", "a", 0, null);
    	d.addEdge(1, "a", "g", 0, null);
    	d.addEdge(2, "g", "e", 0, null);
    	d.addEdge(3, "e", "p", 0, null);
    	System.out.println(d.topoSort()==null);   // == null
    }
    public static void topoTest1(){
    	DiGraph d = new DiGraph();
//    	Case 0(Line):
//    		d.addNode(0, "a");
//    		d.addNode(1, "b");
//    		d.addNode(2, "c");
//    		d.addNode(3, "d");
//    		d.addEdge(0, "a", "b", 0, null);
//    		d.addEdge(1, "b", "c", 0, null);
//    		d.addEdge(2, "c", "d", 0, null);
//    		printTOPO(d.topoSort()); //toposort() == [a, b, c, d] (There's only one toposort for this case)
    	
//    		Case 1(Square):
//    		d.addNode(0, "a");
//    		d.addNode(1, "b");
//    		d.addNode(2, "c");
//    		d.addNode(3, "d");
//    		d.addEdge(0, "a", "b", 0, null);
//    		d.addEdge(1, "b", "c", 0, null);
//    		d.addEdge(2, "a", "d", 0, null);
//    		d.addEdge(1, "d", "c", 0, null);
    		//printTOPO(d.topoSort());
//    		ind(a) < ind(b) < ind(c)
//    		ind(a) < ind(d) < ind(c)
//
//    		Case 2(Islands):
//    		d.addNode(0,"0");
//    		d.addNode(1, "1");
//    		d.addNode(2, "2");
//    		d.addNode(3, "3");
//    		d.addNode(4, "4");
//    		d.addNode(5, "5");
//    		d.addNode(6, "6");
//    		d.addEdge(0, "4", "5", 0, null);
//    		d.addEdge(1, "0", "5", 0, null);
//    		d.addEdge(2, "3", "2", 0, null);
//    		d.addEdge(3, "6", "1", 0, null);
//    		d.addEdge(4, "4", "0", 0, null);

//    		ind(6) < ind(1)
//    		ind(3) < ind(2)
//    		ind(4) < ind(0) < ind(5)
//
//    		Case 3(Bridge):
//    		d.addNode(0,"0");
//    		d.addNode(1, "1");
//    		d.addNode(2, "2");
//    		d.addNode(3, "3");
//    		d.addNode(4, "4");
//    		d.addNode(5, "5");
//    		d.addEdge(0, "0", "2", 0, null);
//    		d.addEdge(1, "4", "1", 0, null);
//    		d.addEdge(2, "2", "1", 0, null);
//    		d.addEdge(3, "3", "4", 0, null);
//    		d.addEdge(4, "5", "2", 0, null);
//    		d.addEdge(5, "4", "0", 0, null);
    		//printTOPO(d.topoSort());

//    		ind(5) < ind(2) < ind(1)
//    		ind(3) < ind(4) < ind(0)
//    		ind(4) < ind(1)
//    		ind(0) < ind(2)
//
//    		Case 5(Implicit Circle, complete graph)
//    		d.addNode(1, "p");
//    		d.addNode(4, "a");
//    		d.addNode(3, "g");
//    		d.addNode(2, "e");
//    		d.addEdge(0, "p", "a", 0, null);
//    		d.addEdge(1, "a", "g", 0, null);
//    		d.addEdge(2, "g", "e", 0, null);
//    		d.addEdge(3, "e", "p", 0, null);
//    		d.addEdge(4, "p", "g", 0, null);
//    		d.addEdge(5, "a", "e", 0, null);
//    		System.out.println(d.topoSort());
    		//
//    		Case 6(Implicit Circle, Two components):
//    		d.addNode(0, "1");
//    		d.addNode(1, "2");
//    		d.addNode(2, "3");
//    		d.addNode(3, "4");
//    		d.addNode(4, "5");
//    		d.addNode(5, "6");
//    		d.addNode(6, "7");
//    		d.addNode(7, "8");
//    		d.addEdge(0, "1", "3", 0, null);
//    		d.addEdge(1, "3", "5", 0, null);
//    		d.addEdge(2, "1", "5", 0, null);
//    		d.addEdge(3, "6", "8", 0, null);
//    		d.addEdge(4, "6", "2", 0, null);
//    		d.addEdge(5, "8", "7", 0, null);
//    		d.addEdge(6, "7", "4", 0, null);
//    		d.addEdge(7, "2", "4", 0, null);
//    		d.addEdge(8, "4", "8", 0, null);
//    		System.out.println(d.topoSort());

//    		Case 7(With Del)
    		d.addNode(0, "a");
    		d.addNode(1, "b");
    		d.addNode(2, "c");
    		d.addNode(3, "d");
    		d.addEdge(0, "d", "a", 0, null);
    		d.addEdge(1, "a", "b", 0, null);
    		d.addEdge(2, "b", "c", 0, null);
    		d.delEdge("d","a");
    		d.addEdge(3,"c","d",0,null);
    		printTOPO(d.topoSort());//    		toposort() == [a, b, c,d] (There's only one toposort for this case)
    }
    public static void testCaseX(){
    	DiGraph d = new DiGraph();
    	d.addNode(0, "4");
    	d.addNode(1, "1");
    	d.addNode(2, "8");
    	d.addNode(3, "2");
    	d.addNode(4, "7");
    	d.addNode(5, "5");
    	d.addEdge(0, "2", "5", 0, null);
    	d.addEdge(1, "4", "7", 0, null);
    	d.addEdge(2, "1", "8", 0, null);
    	System.out.println(d.addEdge(3, "2", "8", 0, null));
    	d.addEdge(4, "4", "5", 0, null);
    	d.addEdge(5, "1", "2", 0, null);
    	d.addEdge(6, "1", "5", 0, null);
    	d.addEdge(7, "1", "7", 0, null);
    	d.addEdge(8, "8", "5", 0, null);
    	d.addEdge(9, "1", "4", 0, null);
    	d.addEdge(10, "5", "7", 0, null);
    	d.addEdge(11, "4", "2", 0, null);
    	d.addEdge(12, "8", "7", 0, null);
    	d.addEdge(13, "4", "8", 0, null);
    	d.addEdge(14, "2", "7", 0, null);
    	printTOPO(d.topoSort());
    	//ind(1) < ind(4) < ind(2) < ind(8) < ind(5) < ind(7)
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }
    
    public static void delEdge(){
//    	/addNode(1, f)
//    	addNode(3, s)
//    	addNode(7, t)
//    	addNode(0, fo)
//    	addEdge(0, f, s, 0, null)
//    	addEdge(2, s, t, 0, null)
//    	delEdge(f,s)
//    	delEdge(f,t) //shouldn't decrement numedges
//    	numEdges()==1
    	DiGraph d = new DiGraph();
    	d.addNode(3, "s");
    	d.addNode(7, "t");
    	d.addNode(0, "fo");
    	d.addEdge(0, "f", "s", 0, null);
    	d.addEdge(2, "s", "t", 0, null);
    	d.delEdge("f","s");
    	System.out.println(d.delEdge("f","t")); //shouldn't decrement numedges
    	System.out.println(d.numEdges());
    	
    	
    }
    public static void delNode(){
    	DiGraph d = new DiGraph();
    	//DELNODE TEST:
//    		Case0: (Simple True)
//    		addNode(1,f)
//    		addNode(3, s)
//    		delNode(f)==true
//    		d.addNode(1, "f");
//    		d.addNode(3, "s");
//    		System.out.println(d.delNode("f"));
//
//    		Case1: (Simple False)
//    		addNode(1,f)
//    		addNode(3, s)
//    		delNode(x)==false
//    	d.addNode(1, "f");
//		d.addNode(3, "s");
//		System.out.println(d.delNode("x"));
//
//    		Case2: (Add After Del)
//    		delNode(f)==false
//    		addNode(1,f)
//    		delNode(f)==true
//    		addNode(3,f)==true
//    		delNode(f)==true
//		System.out.println(d.delNode("f"));
//    	d.addNode(1, "f");
//		System.out.println(d.delNode("f"));
//		System.out.println(d.addNode(3, "f"));
//		System.out.println(d.delNode("f"));
//
//    		Case3: (Add After Del 2)
//    		addNode(1,f)
//    		addNode(2,x)
//    		numNodes==2
//    		addEdge(0,f,x,0,null)
//    		numEdges==1
//    		delNode(x)
//    		numNodes==1
//    		numEdges==0
//    		addNode(2,x)==True
//    		addEdge(0,f,x,0,null)==true
    	d.addNode(1, "f");
    	d.addNode(2, "x");
    	System.out.println(d.numNodes());
    	d.addEdge(0, "f", "x", 0, null);
    	System.out.println(d.numEdges());
    	d.delNode("x");
    	System.out.println(d.numNodes());
    	System.out.println(d.numEdges());
		System.out.println(d.addNode(2, "x"));
		System.out.println(d.addEdge(0, "f", "x", 0, null));
    }

    public static void topo5(){
    	DiGraph d = new DiGraph();
    	d.addNode(1, "p");
    	d.addNode(4, "a");
    	d.addNode(3, "g");
    	d.addNode(2, "e");
    	d.addEdge(0, "p", "a", 0, null);
    	d.addEdge(1, "a", "g", 0, null);
    	d.addEdge(2, "g", "e", 0, null);
    	d.addEdge(3, "e", "p", 0, null);
    	d.addEdge(4, "p", "g", 0, null);
    	d.addEdge(5, "a", "e", 0, null);
    	d.addEdge(6, "p", "e", 0, null);
    	System.out.println(d.numEdges());
    	d.delNode("e");
    	System.out.println(d.numEdges());
    	printTOPO(d.topoSort());
    	//ind(p)<ind(a)<ind(g)

    }
    public static void numEdge(){
    	DiGraph d = new DiGraph();
//    	addNode(1, f)
//    	addNode(3, s)
//    	addNode(7, t)
//    	addNode(0, fo)
//    	addEdge(0, f, s, 0, null)
//    	addEdge(2, s, t, 0, null)
//    	delEdge(f,s)
//    	delEdge(f,t) //shouldn't decrement numedges
//    	numEdges()==1
    	d.addNode(1, "f");
    	d.addNode(3, "s");
    	d.addNode(7, "t");
    	d.addNode(0, "fo");
    	d.addEdge(0, "f", "s", 0, null);
    	d.addEdge(2, "s", "t", 0, null);
    	d.delEdge("f","s");
    	d.delEdge("f","t"); //shouldn't decrement numedges
    	System.out.println(d.numEdges()==1);
    }
}

