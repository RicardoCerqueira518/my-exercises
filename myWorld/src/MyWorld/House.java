package MyWorld;

public class House {
    private String colour;
    private String type;
    private String typeConstruction;
    private int value;
    public int proposal;

    public House(String someColour, String someType, String someTypeConstruction) {
        this.colour = someColour;
        this.type = someType;
        this.typeConstruction = someTypeConstruction;

    }

    public String getColour() {
        return this.colour;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeConstruction() {
        return this.typeConstruction;
    }

    public int getValue() {
        return this.value;
    }


    public void changeColour(String newColour) {
        if (newColour.equals("blue") || newColour.equals("green") || newColour.equals("white") || newColour.equals("black")) {
            this.colour = newColour;
        } System.out.println("Cor não aceite");
    }

    public void changeType(String someType) {
        if (someType.equals("T0") || someType.equals("T1") || someType.equals("T2")) {
            this.type = someType;
        }
        System.out.println("Tipologia não aceite");
    }

    public void changeTypeConstruction(String newTypeConstruction) {
        if (newTypeConstruction.equals("New") || newTypeConstruction.equals("Old")) {
            this.typeConstruction = newTypeConstruction;
        } 
    }

    public void value() {
        if (type.equals("T0") && typeConstruction.equals("New")) {
            value = 100000;
        } else if (type.equals("T0") && typeConstruction.equals("Old")) {
            value = 60000;
        } else if (type.equals("T1") && typeConstruction.equals("New")) {
            value = 200000;
        } else if (type.equals("T1") && typeConstruction.equals("Old")) {
            value = 150000;
        } else if (type.equals("T2") && typeConstruction.equals("New")) {
            value = 300000;
        } else if (type.equals("T2") && typeConstruction.equals("Old")) {
            value = 250000;
        } else {
            System.out.println("Value or type undefined");
        }
    }

    public void sell() {
        if (value < proposal) {
            System.out.println("Good offer, sell");
        } else {
            System.out.println("Bad offer, don't sell");
        }
    }
}
