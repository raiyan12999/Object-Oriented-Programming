package InterfacesDemo;

public class Computer implements CPU, HardDrive, RAM{



    @Override
    public void storesData() {
        System.out.println("I store all the data");
    }

    @Override
    public void storesTemporaryData() {
        System.out.println("I store temporary data");
    }

    @Override
    public void processData() {

    }
}
