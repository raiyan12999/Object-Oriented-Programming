package StaticExamples;

public class Main {
    public static void main(String[] args) {
        Human Raiyan = new Human(27, "Raiyan", 25000, true);
        Human Radid = new Human(19, "Radid", 25, false);

        System.out.println(Raiyan.married);
        System.out.println(Radid.married);
    }
}
