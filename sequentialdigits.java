    import java.util.*;
public class sequentialdigits {
    
    public static List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();

        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        // only single time run
        for (int len = minLen; len <= maxLen; len++) {  
            for (int i = 0; i + len <= 9; i++) {
                System.out.println("len: " + len);
            
                int num = Integer.parseInt(digits.substring(i, i + len));
                  System.out.println(num);
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        List<Integer> ans = sequentialDigits(low, high);

        System.out.println("Sequential Digits:");
        for (int num : ans) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}

