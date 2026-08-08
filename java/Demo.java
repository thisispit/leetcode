class A{
  public void show1(){
    System.out.println("Showing A");
  }
}

class B extends A{
  public void show2(){
    System.out.println("Showing B");
  }

}

public class Demo{
  public static void main(String[] args) {
    A obj = new B();
    obj.show1();
  }
}

