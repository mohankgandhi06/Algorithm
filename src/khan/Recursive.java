package khan;

public class Recursive {

    private static int total=1;
    private static boolean isPalindrome = true;
    private static double powerTotal=1;

    public static void main(String[] args) {
        //System.out.println(factorial(-30));
        //System.out.println(palindrome(new char[]{'m', 'a', 'd', 'd', 'a', 'm'}, 0 , 5));
        //System.out.println(palindrome(new char[]{''}, 0 , 0));
        //System.out.println(palindrome(new char[]{'m'}, 0 , 0));
        //System.out.println(palindrome("maddam"));
        System.out.println(power(2,6));
    }

    public static int factorial(int data){
        if (data>0) {
            total = total * data;
            factorial(data - 1);
        } else if(data<0) {
            return -1;
        }
        return total;
    }

    public static boolean palindrome(char[] data, int initialIndex, int finalIndex){
        if(initialIndex<finalIndex){
            if (data[initialIndex] == data[finalIndex]) {
                palindrome(data, initialIndex+1,finalIndex-1);
            } else {
                return isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    public static boolean palindrome(String data){
        if(data.length()>1){
            if (data.charAt(0)==data.charAt(data.length()-1)) {
                palindrome(data.substring(1,data.length()-1));
            } else {
                return isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    public static double power(double data, int power){
        if(power==0){
            return powerTotal;
        } else if(power>0){
            powerTotal = powerTotal*data;
            power(data, power-1);
        } else if(power<0) {
            powerTotal = (double) powerTotal*(1/data);
            power(data, power+1);
        }
        return powerTotal;
    }
}