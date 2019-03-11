public class BurgerBarCustomer implements Runnable{
    private int burgersToEat;
    private String name;
    private Burgerbar burgerbar;

    public BurgerBarCustomer(String name, Burgerbar burgerbar, int burgersToEat){
        this.burgersToEat=burgersToEat;
        this.name=name;
        this.burgerbar=burgerbar;

    }

    @Override
    public void run() {

        for (int i=0; i<burgersToEat; i++){
            burgerbar.eatBurger(name);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " has finished eating");
        burgerbar.setNumberOfCustomers(burgerbar.getNumberOfCustomers()-1);


    }
}
