
public class PizzaTestDrive {

	public static void main(String[] args) {
		SimplePizzaFactory fatory=new SimplePizzaFactory();
		PizzaStore store=new PizzaStore(fatory);
		Pizza pizza=store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza);
	}

}
