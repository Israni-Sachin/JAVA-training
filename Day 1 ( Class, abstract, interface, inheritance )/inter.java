interface interClass {
    public void hello();
    public void again();
}

class ext implements interClass{
    public void hello(){
        System.out.println("Hello");
    }
    public void again(){
        System.out.println("Hello again!");
    }
    public void again(String a){
        System.out.println("Hello again override!");
    }
}
class inter{
    public static void main(String[] args){
        ext obj=new ext();
        obj.hello();
        obj.again("sachin");
    }
}