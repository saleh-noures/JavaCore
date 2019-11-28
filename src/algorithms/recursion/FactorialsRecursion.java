package algorithms.recursion;

/*EG. 4! = 1*2*3*4 */
public class FactorialsRecursion {
    public static void main(String[] args) {
        System.out.println(sumNum(4));
    }

    private static int sumNum(int i) {
        if(i == 1) {return 1;}
        else{
            return  i * sumNum(i-1);
        }
    }
}
