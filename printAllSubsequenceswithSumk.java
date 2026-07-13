import java.util.*;

class printAllSubsequenceswithSumk {
//   s contains temp sum 
    static void printF(int index, int s,int sum,List<Integer> list, int[] arr, int n) {
        if (index == n) {
            if(s==sum){
                System.out.println(list);
            }
           

            // if (list.isEmpty()) {
            //     System.out.println("{}");
            // }

            return;
        }
        list.add(arr[index]);
        s+=arr[index];
        printF(index + 1,s,sum, list, arr, n);
       s-=arr[index];
        list.remove(list.size() - 1);
        printF(index + 1,s,sum, list, arr, n);
        // list.remove(list.get(index));
     

    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        int sum=3; // target sum
        int n = 3;
        List<Integer> list = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        printF(0,0,sum,list, arr, n);
    }
}