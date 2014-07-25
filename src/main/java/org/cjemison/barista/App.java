package org.cjemison.barista;

import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.factory.DrinkFactorySingleton;
import org.cjemison.barista.util.DrinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class App {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DrinkFactorySingleton drinkFactory = DrinkFactorySingleton.getInstance();

    public App() {

    }

    public static void main(String[] args) {
        App app = new App();
        app.run();

    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        String response = "";
        while(!response.equals("q")) {
            this.drinkFactory.printInventory();
            List<String> list = this.drinkFactory.printMenu();
            System.out.println("\nMenu:\n");
            for(int i=0; i<list.size(); i++)
            {
                System.out.println(String.format("%d,%s", (i+1),list.get(i)));
            }
            int intResponse=0;

            while(intResponse ==0)
            {
                try
                {
                    System.out.print("Choose Drink: ");
                    String tmp = scanner.nextLine();
                    if(tmp!=null && tmp.equalsIgnoreCase("q"))
                    {
                        System.exit(0);
                    }
                    intResponse = Integer.parseInt(tmp.trim());
                    if(intResponse < 0 || intResponse > list.size())
                    {
                        throw new Exception("Error: Invalid choice.");
                    }
                    System.out.println("");
                    break;
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                    this.logger.error("### ERROR ###", e);
                }
            }

            int cnt =1;
            DrinkType drinkType = null;
            for(DrinkType tmp : DrinkType.values())
            {
                if (cnt == intResponse)
                {
                    drinkType = tmp;
                    break;
                }
                cnt++;
            }

            if(drinkFactory.canDispense(drinkType))
            {
                //get the drink and make it.
                Drink drink = drinkFactory.createDrink(drinkType);
            }
        }
    }
}
