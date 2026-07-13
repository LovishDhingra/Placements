import java.util.Arrays;
import java.util.Scanner;

public class check {
    public static void main(String[] args)throws Exception {
        int n;
        Scanner s= new Scanner(System.in);
        n=s.nextInt();
int[] arr=new int[n];
int[] indegree=new int[n+1];
Arrays.fill(indegree,0);
for (int i = 0; i <n; ++i)
{
   arr[i]=s.nextInt();
}

for(int i=0;i<n;i++){
	if(arr[i]==-1){
		continue;
	}
	indegree[arr[i]]++;
}


int index=0,max=0;
// int max = Arrays.stream(indegree).max().getAsInt();
for(int i=0;i<n;i++){
    if(indegree[i]>max){
        max=indegree[i];
        index=i;
    }

}
System.out.println("Max is : "+index);

for (int i = 0; i<n+1;i++)
{
System.out.println(indegree[i]);
}


}
    }

