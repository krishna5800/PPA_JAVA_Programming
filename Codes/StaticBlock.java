class Demo
{
    public int i;       //Instance variable
    static public int j;       //Class variable
    
    static
    {
        j = 21;
    }
    public Demo()
    {
        this.i = 11;
    }

    public void fun()       //Instance-Method
    {
        System.out.println("fun() i : " + this.i);
        System.out.println("fun() j : " + Demo.j);
    }

    public static void gun()       //Class-Method
    {
        // System.out.println("gun() i : " + this.i);  //NOT-ALLOWED.....ERROR
        System.out.println("gun() j : " + Demo.j);
    }
}

class StaticBlock
{
    public static void main(String A[])
    {
        Demo.gun();
        System.out.println(Demo.j);

        Demo dobj = new Demo();

        System.out.println(dobj.i);
        dobj.fun();

    }
}