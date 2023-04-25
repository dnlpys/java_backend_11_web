package test.com;

public class Test01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "kim";
		System.out.println(name);
		
		//jdk 10 이상부터 타입추론 변수변수언(javascript,python)
		var name2 = "lee";
		System.out.println(name2);
		
		
		//동일타입 인자들에대해서 탄력적으로 매개변수로 처리가능하도록하는 ...연산자 사용가능.
		test01(11); // new int[]{11};
		test01(11,22,33); // new int[]{11,22,33};
		test01(new int[]{11});
		
		
	}//end main

	private static void test01(int ...sus) {
		// TODO Auto-generated method stub
		System.out.println(sus);
	}


}
