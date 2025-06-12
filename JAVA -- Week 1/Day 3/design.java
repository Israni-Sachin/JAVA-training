public class design {

//    singleton pattern

//    public static class Singleton {
//        private static Singleton instance;
//        private Singleton() {
//            System.out.println("Singleton instance created");
//        }  // private constructor
//
//        public static Singleton getInstance() {
//            if (instance == null)
//                instance = new Singleton();
//            return instance;
//        }
//    }
//    public static void main(String[] args) {
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();  // Same object as s1
//        System.out.println(s1==s2);
//        System.out.println(s2);
//    }

//    factory pattern

    interface Animal {
        void speak();
    }
    static class Dog implements Animal {
        public void speak() { System.out.println("Woof!"); }
    }
    static class Cat implements Animal {
        public void speak() { System.out.println("Meow!"); }
    }
    static class AnimalFactory {
        public static Animal getAnimal(String type) {
            if ("dog".equalsIgnoreCase(type)) return new Dog();
            else if ("cat".equalsIgnoreCase(type)) return new Cat();
            else return null;
        }
    }

    public static void main(String[] args) {
        Animal a = AnimalFactory.getAnimal("cat");
        a.speak();  // Woof!
    }

}