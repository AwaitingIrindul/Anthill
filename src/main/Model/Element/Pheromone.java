package main.Model.Element;

import main.Model.Mapping.Direction;
import main.Model.Mapping.Position;


public class Pheromone{

    private int lifeTime;
    private Position pos;
    private int quantity;
    private Direction direction;
    public static int MAXLIFE;

    public Pheromone(Position position, int lifeTime, Direction direction, int quantity) {
        this.lifeTime = lifeTime;
        pos = position;
        this.direction = direction;
        this.quantity = quantity;
    }


    public Position getPos() {
        return pos;
    }

    public void add(int quantity){
        this.quantity += quantity;
    }
    public Direction getDirection() {
        return direction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void actualize(){
        this.lifeTime -= 5; //Each iteration, a pheromone loses 5 of life time.
    }


    //GET_SET for lifeTime
    public int getLifeTime() {
        return lifeTime;
    }
    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
        if(this.lifeTime  > MAXLIFE) //If the new lifetime is greater than the maximum
            this.lifeTime = MAXLIFE; //We set the maximum
    }

}
