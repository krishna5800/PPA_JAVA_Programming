class Demo
{
    public int Division(int No1, int No2) throws ArithmeticException
    {
        int iAns = 0;
        iAns = No1 / No2;
        return iAns;
    }
}

class ThrowsDemo 
{
    public static void main(String A[]) 
    {
        Demo obj = new Demo();
        int Ret = 0;

        try
        {
            Ret = obj.Division(11, 0);
        }
        catch(ArithmeticException aobj)
        {
            System.out.println("Inside catch " + aobj);
        }
        
        System.out.println("Division is : " + Ret);
    }    
}
