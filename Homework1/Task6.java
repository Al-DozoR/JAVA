public class Task6 {
    public static void main(String[] args) {
        String str1="abdc", str2="ckke";
        oneStr(str1,str2);
    }
    static void oneStr(String str1,String str2){
        char [] arrCharStr=(str1+str2).toCharArray();
        StringBuilder Str=new StringBuilder("");

        for(char ch : arrCharStr){
            if (Str.indexOf(Character.toString(ch))==-1){
                Str.append(ch);
            }
        }
        System.out.println(Str);
    }
}
