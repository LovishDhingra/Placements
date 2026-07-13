public class countAllsubsequencesWithSumK {
    //condition not statisfied
    //stricilt done if array contains positive number;
    static int  printSumK(int index,int tempSum,int TargetSum,int[]arr,int n){
        
if(tempSum>TargetSum) return 0;
if(index==n){
         if(tempSum==TargetSum)
             return 1;
         
         else return 0;
        }
           
            

tempSum+=arr[index];

int l=printSumK(index+1,tempSum,TargetSum,arr,n);

tempSum-=arr[index];
int r=printSumK(index+1,tempSum,TargetSum,arr,n);
return l+r;
    }
    public static void main(String[] args) {
        int[] arr = { 3,1,2,4,5,6};
        int TargetSum=8;  
        int n = 6;
        System.out.println(printSumK(0,0,TargetSum,arr,n));
    }
}


//time complexity is 2^n;  
// can be optimized 