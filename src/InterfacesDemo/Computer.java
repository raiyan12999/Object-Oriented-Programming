package InterfacesDemo;

public class Computer implements CPU, HardDrive, RAM{

    @Override
    public void processData(){
        System.out.println("I process all the data");
    }

    @Override
    public void storesData() {
        System.out.println("I store all the data");
    }

    @Override
    public void storesTemporaryData() {
        System.out.println("I store temporary data");
    }
}
