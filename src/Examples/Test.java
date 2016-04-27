package Examples;

class ThreadDemo extends Thread{ 
 public static void main(String[] args) { 
 try 
 {ThreadDemo A = new ThreadDemo();
A.start();
A.run();
A.wait(); 
}catch(Exception e)
{
System.out.println(e);
}
} 
public void start(){
System.out.println("inside start");
}

public void run()
{
System.out.println("inside run");
for(int i=0; i<5; i++)
{
System.out.println(i);
}
}

}