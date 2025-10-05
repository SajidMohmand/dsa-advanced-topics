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


    public static void main(String[] args) {

//        char[] arr = {'h','e','l','l','o'};
//
//        for (char i: arr){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//
//        reverseString(arr);


        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));




    }
}
