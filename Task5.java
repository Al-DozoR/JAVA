public class Task5 {
    public static void main(String[] args) {
        String text="D18";
        conversion(text);
    }
    static void conversion(String text){
        String[] numColumn=text.split("[0-9]");
        System.out.println("Номер строки: "+text.replaceAll("\\D","") +
                           " Номер столбца: "+(Integer.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(text.replaceAll("\\d","").toUpperCase()))+1));
    }
}
