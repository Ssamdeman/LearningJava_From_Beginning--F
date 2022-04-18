/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class LessonRecursion {
    /*
    public int getMyPosition(Person person) {
        if (person.nextInLine == null)
            return 1;
        return 1 + getMyPosition(person.nextInLine);
    }
    */
   /*

   //@test
    public String A() {
        return "hello" + B();
    }

    public String B() {
        return "my" + C();
    }

    public String C() {
        return "friends ";
    }
   */
    //-----------------------------------------------------------
    //@not Working. Trouble Shoot it later
    public static String ReverString(String input) {
        //base
        if (input.equals(""))
            return " ";

        return ReverString((input.substring(1)) + input.charAt(0));
    }

    //------------------------
    //@palindrom working:
    public static boolean isPalindrom(String input) {

        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt((input.length() - 1))) {
            return isPalindrom(input.substring(1, input.length() - 1));


        }
        return false;
    }

    //------------------------
    //@Desimal to Binary; Working
    public static String desimalToBinary(int desimal, String result) {
        if (desimal == 0) return result;

        result = desimal % 2 + result;
        return desimalToBinary(desimal / 2, result);

    }

    public static void main(String[] args) {
        //System.out.println(isPalindrom("racecar"));
        //System.out.println(desimalToBinary(233, ""));
        // System.out.println(sumNaturalNumbers(5));
    }

    //------------------------
    //SumofNatural Number;
    public static int sumNaturalNumbers(int x) {
        if (x <= 1) return x;

        return x + sumNaturalNumbers(x - 1);
    }

    //------------------------
    //@binarySearch using recursive. Binary search is search that apply to sorted array;
    public static int binarySearch(int[] A, int left, int right, int x) {
        if (left > right) return -1;
        //find the middel of the array
        int mid = (left + right) / 2;

        //special Cases: if our searhcing value is the middle return midle;
        if (x == A[mid]) return mid;

        // if our values is small then middle the then go bakc;
        if (x < A[mid]) return binarySearch(A, left, mid - 1, x);

        return binarySearch(A, mid + 1, right, x);


    }

    //------------------------
    //find fibonnaci
    public static long fib(long n) {
        if (n == 0 || n == 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    //------------------------
    //Merger Sort is sorting for unsorted array
    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end); /// another funciton that merger two arrays
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        //temp array;
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j < +end) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
                k++;
            }
            else {
                temp[k] = data[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = data[i];
            k++;
            i++;
        }
        while (j <= end) {
            temp[k] = data[j];
            k++;
            j++;
        }
        for (int g = start; g < end; g++) {
            data[g] = temp[g - start];

        }
    }

    //------------------------
    public static void listNOde() {


    }

    //@linkedList// This is double likned list. So I cannot make it here;

   /* public static listNOde reversList(listNOde node) {
        if (head == null || head.next) return head;

    }
*/
}


//------------------------


//------------------------

