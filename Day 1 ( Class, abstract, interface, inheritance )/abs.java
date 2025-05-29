abstract class abstractClass {
    abstract void hello();
    public void again(){
        System.out.println("Hello again!");
    }
}

class ext extends abstractClass{
    void hello(){
        System.out.println("Hello");
    }

}
class abs{
    public static void main(String[] args){
        ext obj=new ext();
        obj.hello();
        obj.again();
    }
}