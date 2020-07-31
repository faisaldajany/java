
public class Test {

     ///display not needed but helpping for main method to check your code
    public static void display(List<Pair<Character, TSHNode>>L)
    {
    if(L.empty()) {System.out.println("empty list"); return;}    
    L.findFirst();
    while(!L.last())
    {
        System.out.print(L.retrieve().first+" ");
        L.findNext();
    }
    System.out.println(L.retrieve().first+" ");    
    }
    public static<T> void display_list(List<T>L)
    {
    if(L.empty()) {System.out.println("empty list"); return;}    
    L.findFirst();
    while(!L.last())
    {
        System.out.print(L.retrieve()+" ");
        L.findNext();
    }
    System.out.println(L.retrieve()+" ");    
    }

	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		
		TreeSearchHistory tree = new TreeSearchHistory();
		SearchHistory l1 = new  LinkedListSearchHistory();
		SearchHistory l2 = new LinkedListSearchHistory();
		SearchHistory l3 = new TreeSearchHistory();
	
		
		
		tree.add("there"); 
        tree.add("their"); 
        tree.add("cater");
        tree.add("cat");
        tree.add("their");
        tree.add("case");
		tree.add("do");
		tree.add("dog");
		tree.add("doll");
		tree.add("dorm");
		tree.add("dad");
		
		tree.display();
	}
	
	
}
