// Online Java Compiler (Editor)
// Write and run Java online using this editor.

class Main {
    public static int CountV(String s){
        int count =0;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
           
        }
        return count;
       
    }
    public static void main(String[] args) {
        Main obj=new Main();
        System.out.println(obj.CountV("aeioujhgsduyii"));
        
        
    }
}