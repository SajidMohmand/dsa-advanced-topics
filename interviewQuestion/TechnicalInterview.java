package interviewQuestion;

public class TechnicalInterview {


    public static void reverseString(char[] s) {

        for(int i=0,j=s.length-1; i<s.length; i++,j--){

            if (i==j) break;
            char a = s[i];
            char b = s[j];

            s[j] = a;
            s[i] = b;
        }

        for (char i: s){
            System.out.print(i+" ");
        }
        System.out.println();
    }





    public static boolean isPalindrome(String s) {

        int left = 0,right = s.length()-1;

        while (left < right){

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

//    public static int findMaxSubarray(int[] arr) {
//        int n = arr.length;
//        int[] prefix = new int[n];
//        prefix[0] = arr[0];
//
//        // Step 1: Create prefix sum array
//        for (int i = 1; i < n; i++) {
//            prefix[i] = prefix[i - 1] + arr[i];
//        }
//
//        // Step 2: Find max subarray sum using prefix differences
//        int minPrefix = 0;
//        int maxSum = Integer.MIN_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            // subarray sum ending at i = prefix[i] - minPrefixSoFar
//            maxSum = Math.max(maxSum, prefix[i] - minPrefix);
//
//            // update minimum prefix sum
//            minPrefix = Math.min(minPrefix, prefix[i]);
//        }
//
//        return maxSum;
//    }



    public static void findMaxSubarray(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        // Step 1: Create prefix sum array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        // Step 2: Find max subarray using prefix pattern
        int minPrefix = 0;           // minimum prefix value so far
        int minIndex = -1;           // index of that minimum prefix
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;          // to store result start
        int endIndex = 0;            // to store result end

        for (int i = 0; i < n; i++) {
            int currentSum = prefix[i] - minPrefix;

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = minIndex + 1; // subarray starts after minPrefix index
                endIndex = i;              // ends at current index
            }

            // update minimum prefix
            if (prefix[i] < minPrefix) {
                minPrefix = prefix[i];
                minIndex = i;
            }
        }

        System.out.println("Prefix array: ");
        for (int p : prefix) System.out.print(p + " ");
        System.out.println("\n\nMaximum Subarray Sum = " + maxSum);
        System.out.println("Start Index = " + startIndex);
        System.out.println("End Index = " + endIndex);
    }

    public static void main(String[] args) {

//        char[] arr = {'h','e','l','l','o'};
//
//        for (char i: arr){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//
//        reverseString(arr);


//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));


        int[] arr = {7, 8, -2, 13, 3, 1, 4, -11};
        findMaxSubarray(arr);



    }
}
