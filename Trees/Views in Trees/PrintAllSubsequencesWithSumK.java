import java.util.*;

public class PrintAllSubsequencesWithSumK {
    static void printSumK(int index,int tempSum,int TargetSum,List<Integer> ds,int[]arr,int n){
        if(index==n){
            if(tempSum==TargetSum){
            System.out.println(ds);
        }
            return;
            }
ds.add(arr[index]);
tempSum+=arr[index];

printSumK(index+1,tempSum,TargetSum,ds,arr,n);
ds.remove(ds.size()-1);
tempSum-=arr[index];
printSumK(index+1,tempSum,TargetSum,ds,arr,n);
    }
    public static void main(String[] args) {
        int[] arr = { 3,1,2,4,5,6};
        int TargetSum=8;
        int n = 6;
        List<Integer> list = new ArrayList<>();
        printSumK(0,0,TargetSum,list,arr,n);
    }
}
