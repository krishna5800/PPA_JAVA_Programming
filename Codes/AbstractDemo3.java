abstract class Base
{
    public int i,j;
    public int Addition(int A, int B)
    {
        return A+B;
    }

    abstract public int Substraction(int A, int B);
}

class Derived extends Base
{
    public int x;
    public int Substraction(int A, int B)
    {
        return A-B;
    }

    public int Multiplication(int A, int B)
    {
        return A*B;
    }
}

class AbstractDemo3
{
    public static void main(String A[])
    {
        Base bp = new Derived();   

        int iRet = 0;

        iRet = bp.Addition(10,11);
        System.out.println(iRet);

        iRet = bp.Substraction(11,10);
        System.out.println(iRet);

        // iRet = bp.Multiplication(10,11);    //ERROR
    }
} 