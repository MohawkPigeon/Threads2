public class BurgerBarEmployee implements Runnable {
    private String name;
    private Burgerbar burgerbar;

    public BurgerBarEmployee(String name, Burgerbar burgerbar){
        this.name=name;
        this.burgerbar=burgerbar;
    }

    @Override
    public void run() {
        while(burgerbar.getNumberOfCustomers()>0){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            burgerbar.makeBurger(name);
        }
        System.out.println("No more customers " + name + " has left");

    }
}
