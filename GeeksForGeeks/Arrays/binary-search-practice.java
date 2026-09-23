class Solution {
    public boolean binarySearch(int[] arr, int k) {
        // code here
        int n=arr.length-1;
        int low=0;
        int high=n;
            
            while(low<=high){
                
                int mid=low+(high-low)/2;
                if(arr[mid]==k){
                    return true;
                }else if(arr[mid]<k){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        return false;
    }
}