package MyWorld;


public class MyWorld {

    public static void main(String[] args) {

        House house1 = new House("white", "T1", "New");
        house1.value();
        System.out.println(house1.getColour());
        System.out.println(house1.getType());
        System.out.println(house1.getTypeConstruction());
        System.out.println(house1.getValue());
        house1.proposal = 190000;
        house1.sell();

        House house2 = new House("blue", "T2", "Old");
        house2.value();
        System.out.println(house2.getColour());
        System.out.println(house2.getType());
        System.out.println(house2.getTypeConstruction());
        System.out.println(house2.getValue());
        house2.proposal = 260000;
        house2.sell();



    }


}
