interface Hello
{
    void greet (String name);
}

public class Main {
    public static void main (String[] args)
    {
        Hello H = new Hello(){
            public void greet(String name){
                System.out.print("Hi "+name+"! ");
            }
        };
        H.greet("Alice"); 
        H.greet("Bob");
        H.greet("Carol");
    }
}
