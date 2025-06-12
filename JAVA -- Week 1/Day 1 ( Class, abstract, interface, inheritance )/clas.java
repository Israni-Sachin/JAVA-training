class clas {
	static int x=10; // static variable and methods can be called without making an object
	static void hello(){
		System.out.println("Hello");
	}
	String fname="Sachin";
	public clas(){ // construture call by itself while decalring the obj
		System.out.println("Is it right?");
	}
	public static void main(String[] args){
		clas obj = new clas();
		clas obj1 = new clas();
//		obj.x=15;
		System.out.println(x);
		hello();
		System.out.println(obj.fname);
	}

}