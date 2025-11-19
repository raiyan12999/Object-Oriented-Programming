package InterfacesDemo;

public class Main {
    public static void main(String[] args) {

        class Test2{
            int b;

            Test2(int b){
                this.b = b;
            }
        }

        Computer computer = new Computer();
        computer.processData();
        computer.storesData();
        computer.storesTemporaryData();

        Test test = new Test(45);
        System.out.println(test.a);

        Test2 test2 = new Test2(67);
        System.out.println(test2.b);
    }


}

class Test{
    int a;

    Test(int a){
        this.a = a;
    }
}
