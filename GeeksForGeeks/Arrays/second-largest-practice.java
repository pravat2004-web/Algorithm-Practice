class Solution {
    public int getSecondLargest(int[] arr) {
        Arrays.sort(arr);
        int n= arr.length;
        // code here
        for(int i=n-1;i>=0;i--){
            if(arr[i]!=arr[n-1]){
                return arr[i];
            }
        }
        return -1;
    }
}