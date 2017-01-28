package main.Collections;

import main.Element.FoodSupply;
import main.Mapping.Position;

import java.util.ArrayList;
import java.util.List;
public class FoodSupplyCol {

    private List<FoodSupply> supplies;

    public FoodSupplyCol() {

        //Note for Maxence : Declare a collection as a List and implement it as an ArrayList is the
        //proper way to declare ArrayLists.
        supplies = new ArrayList<FoodSupply>();
    }

    public FoodSupply getFoodSupplyIndex(int i){
        return supplies.get(i);
    }


    public void addFoodSupply(FoodSupply fs){
        supplies.add(fs);
    }
    public void addNewFoodSuuply(Position position, int quantity) {
        supplies.add(new FoodSupply(position, quantity));
    }

    public List<FoodSupply> getSupplies(){
        return supplies;
    }

    public int size(){
        return supplies.size();
    }

    public void removeFoodSupply(FoodSupply fs) {
        for(int i =0; i<supplies.size(); i++) {
            if (supplies.get(i).getPosition().getX()==fs.getPosition().getX() && supplies.get(i).getPosition().getY()==fs.getPosition().getY()) {
                supplies.remove(i);
            }
        }
    }

    public void removeFoodSupplyAt(Position position){
        for(int i =0; i<supplies.size(); i++) {
            if (supplies.get(i).getPosition().getX()==position.getX() && supplies.get(i).getPosition().getY()==position.getY()) {
                supplies.remove(i);
            }
        }
    }

    public int getFooddSupplyQuatityAt(Position position) {

        for (int i = 0; i < supplies.size(); i++) {
            if (supplies.get(i).getPosition().getX() == position.getX() && supplies.get(i).getPosition().getY() == position.getY()) {
                return supplies.get(i).getQuantity();
            }
        }
        return 0;
    }

        public FoodSupply getFoodSupplyAt(Position position) {

            for(int i =0; i<supplies.size(); i++) {
                if (supplies.get(i).getPosition().getX()==position.getX() && supplies.get(i).getPosition().getY()==position.getY()) {
                    return supplies.get(i);
                }
            }
            return null;
        }

}
