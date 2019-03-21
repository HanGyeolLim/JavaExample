package lambda;

public class Lambda {
	
	//@FunctionalInterface - method own
	@FunctionalInterface
	interface Func{
		public int func(int i,int j);
	}
	
	@FunctionalInterface
	interface Func2<I,J>{
		//String func2(I i,J j);
		//I func2(I i,J j);
		J func2(I i,J j);
	}

	public static void main(String[] args) throws Exception{
		
		Func func = (i,j) -> i+j;
		/*Func func = new Func() {
			@Override
			public int func(int i, int j) {
				return i+j;
			}
		};*/
		
		System.out.println(func.func(1, 2));
		
		//Func2<String,Integer> func2 = (i,j) -> i+j; - type error
		Func2<Integer,String> func2 = (i,j) -> i+j;
		/*Func2<Integer,String> func2 = new Func2<Integer,String>() {
			@Override
			public String func2(Integer i, String j) {
				return i+j;
			}
		};*/ 
		
		System.out.println(func2.func2(1,"21"));
	}
}
