import Marvellous.Hello;
import Marvellous.DemoX;
import Marvellous.Infosystems.LB;

class PPA
{
    public static void main(String Arr[])
    {
        Hello hobj = new Hello();
        DemoX dobj = new DemoX();

        hobj.fun();
        dobj.gun();

        LB lobj = new LB(); //object of nested package 

        lobj.sun();
    }
}