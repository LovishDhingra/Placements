import java.util.*;

class PrintAllSubsequences {

    static void printF(int index, List<Integer> list, int[] arr, int n) {
        if (index == n) {
           System.out.println(list);

            // if (list.isEmpty()) {
            //     System.out.println("{}");
            // }

            return;
        }
        list.add(arr[index]);
        printF(index + 1, list, arr, n);  // take
       
        list.remove(list.size() - 1);
        printF(index + 1, list, arr, n);   // intake
        // list.remove(list.get(index));
     

    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        
        int n = 3;
        List<Integer> list = new ArrayList<>();
        printF(0, list, arr, n);
    }
}