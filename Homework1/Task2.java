import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args){
        String text="Программирование это хорошо, но есть что-то лучше";
        String newtext="";
        String[] arrText;

        arrText=text.split(" ");
        for(int i = arrText.length-1 ; i > -1; i--){
            if (Pattern.matches(".*[,:;.!].*",arrText[i])){
                newtext = newtext + arrText[i].charAt(arrText[i].length()-1) + " " + arrText[i].substring(0,arrText[i].length()-1);
            }
            else {
                newtext = newtext + " " + arrText[i];
            }
        }

        System.out.println(newtext);
    }
}
