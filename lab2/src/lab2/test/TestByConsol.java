package lab2.test;
import lab2.model.*;
import lab2.store.ProductStore;
import lab2.store.WoodDirectory;

import java.util.Scanner;


public class TestByConsol {
    private WoodDirectory UserDirecotry = new WoodDirectory();
    private ProductStore UserStore = new ProductStore();
    Scanner scan = new Scanner (System.in);

    /////////////////////////////
    boolean doing = true;
    ////////////////////////////

    public void startAppConsole()
    {
        System.out.println();
        UserDirecotry.add(new Wood(0, "Сосна",0.4f));
        UserDirecotry.add(new Wood(1,"Соснодуб",0.3f));
        UserDirecotry.add(new Wood(1,"Ялинка",0.15f));
        
        while(doing)
        {
            System.out.println("( Add Wood )(End) ( Add Timber ( Calculate ) ( Add Cylinder ) (Add Waste )");
            switch(scan.nextLine())
            {
                case "Add Wood":
                    addWood();
                    break;
                case "Add Timber":
                    addTimber();
                    break;
                case "Calculate":
                    addCalc();
                    break;
                case "End":
                end();
                    break;
                case "Add Cylinder":
                    addCylinder();
                    break;
                case "Add Waste":
                    addWaste();
                    break;
            }

        }

    }

    private void addWaste() {
        System.out.println("Write quantity of waste");
        float weight = scan.nextFloat();
        UserStore.add(new Waste(weight));
        System.out.println(UserStore);
    }

    private void addCylinder() {
        System.out.println(UserDirecotry);
        System.out.println("Write id wood:");
            int id = scan.nextInt();
            System.out.println("Write length cylinder");
            float length = scan.nextFloat();
            System.out.println("Write diameter cylinder");
            float diameter = scan.nextFloat();
            UserStore.add(new Cylinder(UserDirecotry.get(id),length,diameter));
            System.out.println(UserStore);
            id = -1;

    }

    private void addWood()
    {
        System.out.println(" Write type wood");
        String name = scan.nextLine();
        int id = UserDirecotry.getArr().length;
        System.out.println("Write density wood");
        float density = scan.nextFloat();
        Wood newWood = new Wood ( id, name, density);
        UserDirecotry.add(newWood);

    }

    private void addTimber()
    {
        System.out.println(UserDirecotry);
        System.out.println("Write id wood ");
        int id = scan.nextInt();
        System.out.println("Write length Timber ");
        float length = scan.nextFloat();
        System.out.println("Write high Timber");
        float height = scan.nextFloat();
        System.out.println("Write width Timber");
        float width = scan.nextFloat();
        UserStore.add(new Timber(UserDirecotry.get(id),length,height,width));
        System.out.println("Timbers:");
        id =-1;
    }
    private void addCalc()
    {
     float fullWeight = 0;
     for (Object timber : UserStore.getArr())
     {
         fullWeight+=((IWeight)timber).weight();
     }
     System.out.println(fullWeight);

    }
    private void end(){
        doing = false;
    }


}
