import java.util.ArrayList;
import java.util.List;



public class CominationWithSumK{

    private  static void findCombinationsWithSumK(int index,int [] givenArr,int target,List<List<Integer>>ans,List<Integer>ds ){
        if(index == givenArr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));

            }
            return;
        }
        if(givenArr[index]<=target){
            ds.add(givenArr[index]);
            findCombinationsWithSumK(index, givenArr, target- givenArr[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinationsWithSumK(index+1, givenArr, target,ans,ds);
    }
    public static  List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> ans=new ArrayList<>();
        findCombinationsWithSumK(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
    public static void main(String[] args) {
        int arr[]={2,3,5,7};
        int target=7;
        List<List<Integer>> result=new ArrayList<>();
       result=  combinationSum(arr,target);
       System.out.println(result);
    }
}