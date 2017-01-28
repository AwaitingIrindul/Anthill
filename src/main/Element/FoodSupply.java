package main.Element;

import main.Mapping.Position;

/**
 * Created by Irindul on 25/12/2016.
 */
public class FoodSupply{

    private int quantity;
    private Position position;

    public FoodSupply(Position position) {
        this.position = position;
        quantity = 20;
    }

    public FoodSupply(Position position, int quantity) {
        this.position = position;
        this.quantity = quantity;
    }


    public int getQuantity(){
        return quantity;
    }

    public Position getPosition(){
        return this.position;
    }

    public void removeFood() {
        System.out.println("nourriture enlevée");
        quantity --;
    	
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
