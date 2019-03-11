public class BurgerbarMain {

    public static void main(String[] args) {
        Burgerbar burgerbar=new Burgerbar(10);

        Thread t1=new Thread(new BurgerBarEmployee("Bob", burgerbar));
        Thread t2=new Thread(new BurgerBarEmployee("Dennis", burgerbar));

        Thread t3=new Thread(new BurgerBarCustomer("Tyrone", burgerbar, 10));
        Thread t4=new Thread(new BurgerBarCustomer("Shrek", burgerbar, 15));
        Thread t5=new Thread(new BurgerBarCustomer("Sebastian", burgerbar, 2));
        Thread t6=new Thread(new BurgerBarCustomer("Stacy", burgerbar, 1));
        Thread t7=new Thread(new BurgerBarCustomer("Chad", burgerbar, 5));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }



}
