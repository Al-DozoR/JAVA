public class Task5{
    public static void main(String[] args) {
        String text="ABC110";
        short NumColumn = 0;
        for(char ch : text.replaceAll("[0-9]","").toCharArray()){
            NumColumn*=26;
            NumColumn+=ch-('A'-1);
        }
        System.out.println("Номер строки: "+text.replaceAll("\\D","") +
                " Номер столбца: "+NumColumn);
    }
}
