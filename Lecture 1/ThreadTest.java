class PrintA implements Runnable{
    public void run(){
        int t=1;
        while(t!=0){
            System.out.println("A");
            t++;
        }
    }
}

class PrintB implements Runnable{
    public void run(){
        int f=1;
        while(f!=0){
            System.out.println("B");
            f++;
        }
    }
}


public class ThreadTest
{

    public static void main (String[] args)
    {
        Thread  A   =   new  Thread ( new PrintA());
        Thread  B   =   new  Thread ( new PrintB());

        A.start();
        B.start();
    }
}