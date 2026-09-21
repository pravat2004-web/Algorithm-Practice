class Solution {
    public static String reverseString(String s) {
        // code here
        String rev=" ";
        for(int i=0;i<s.length();i++){
            rev=s.charAt(i)+rev;
        }
        return rev;
    }
}