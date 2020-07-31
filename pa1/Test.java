
public class Test {


	public static void main(String[] args){
		CompList<String> linked=new LinkedCompList<String>();


		linked.insert("F");
		linked.insert("A");
		linked.insert("B");
		linked.insert("C");
		linked.insert("D");
		linked.insert("D");
		
		linked.findFirst();
		while(!linked.last()){
			System.out.println(linked.retrieve());
		}
	}
}