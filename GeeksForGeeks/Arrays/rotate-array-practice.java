class Solution {
    public void rotateArr(int arr[], int d) {
        // code here
       
        int n =arr.length;
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        
    }
    public void reverse(int arr[],int low,int high){
        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            
            low++;
            high--;
        }
    }
}