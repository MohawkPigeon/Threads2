public class Burgerbar {
    private int numberOfBurgers;
    private int maxNumberOfBurgers;
    private int numberOfCustomers=5;

    public Burgerbar(int maxNumberOfBurgers){
        numberOfBurgers=0;
        this.maxNumberOfBurgers=maxNumberOfBurgers;
    }
    public synchronized void makeBurger(String employeeName){
        if(numberOfBurgers>=maxNumberOfBurgers&&numberOfCustomers>0){
            try {
                System.out.println("Burgerbar is full of burgers");
                wait(10000);
                makeBurger(employeeName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            notify();
            numberOfBurgers++;

            System.out.println(employeeName + " just made a burger the total is now " + numberOfBurgers);
        }
    }

    public synchronized void eatBurger(String who){
        if(numberOfBurgers<=0){
            try {
                System.out.println(who + " is waiting for a burger");
                wait();
                eatBurger(who);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            notify();
            numberOfBurgers--;
            if(who!="Sebastian"){
                System.out.println(who + " just ate a burger and there is " + numberOfBurgers + " left");
            }
            else
            {
                System.out.println(who + " kunne ikke lide salaten men spiste brødet og kødet " + numberOfBurgers + " left");
            }

        }
    }

    public synchronized int getNumberOfBurgers(){
        return numberOfBurgers;
    }

    public synchronized int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    public synchronized void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

}
