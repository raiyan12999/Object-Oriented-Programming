package InterfacesDemo;

public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.processData();
        computer.storesData();
        computer.storesTemporaryData();

        Test test = new Test(45);
        System.out.println(test.a);
    }
}

class Test{
    int a;

    Test(int a){
        this.a = a;
    }
}
