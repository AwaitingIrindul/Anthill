package main.Anthill;

import main.Ant.Ant;
import main.Ant.BrainyAnt;
import main.Collections.FoodSupplyCol;
import main.Collections.PheromoneCol;
import main.Element.Cell;
import main.Element.FoodSupply;
import main.Mapping.Direction;
import main.Mapping.Map;
import main.Mapping.Position;
/**
 * Created by Irindul on 25/12/2016.
 */
public class Colony {

    private FoodSupplyCol foodSupplies;
    private PheromoneCol pheromones;
    private Anthill anthill;
    private Map map;

    public void addFoodSupply(FoodSupply fs){

    }

    public void addObstacle(int x, int y){

    }

    public void nextCycle(){

    }

    public int getPheromoneQuantityAt(Position p){
        return 0;
    }

    public void detectFood(){
        for(Ant ant : anthill.ants){

            if(ant.getSensor().detectFood(ant.getPosition(),foodSupplies)) {
                ant.takeFood(ant.getPosition(), foodSupplies);
            }

        }
    }

    public void dropPheromone(){
        for(Ant ant : anthill.ants){
            if(ant.getHasFood()){
                pheromones.add(ant.dropPheromone());
            }
        }
    }

    public void move(){
        for(Ant ant : anthill.ants){
            ((BrainyAnt)ant).processProba(); //We upcast ant to a BrainyAnt so we are able to call processProba and executeProba.
            ((BrainyAnt)ant).executeProba();
        }
    }

    public void detectPheromone(){
        for(Ant ant : anthill.ants){

            ant.getSensor().detectPheromones(ant.getPosition(), pheromones);

        }
    }

    public void detectObstacle(){
        Cell[] cells = new Cell[8];
        for(Ant ant : anthill.ants){
            Position pos = ant.getPosition(); //TODO May be refactored inside EvolvedSensor
            int x = pos.getX();
            int y = pos.getY();

            Position north = new Position(x, y-1);
            Position northeast = new Position(x+1, y-1);
            Position east = new Position(x+1, y);
            Position southeast = new Position(x+1, y+1);
            Position south = new Position(x, y+1);
            Position southwest = new Position(x-1, y+1);
            Position west = new Position(x-1, y);
            Position northwest = new Position(x-1, y-1);

            cells[Direction.NORTH.ordinal()] = map.getCell(north.getX(), north.getY());
            cells[Direction.NORTHEAST.ordinal()] = map.getCell(northeast.getX(), northeast.getY());
            cells[Direction.EAST.ordinal()] = map.getCell(east.getX(), east.getY());
            cells[Direction.SOUTHEAST.ordinal()] = map.getCell(southeast.getX(), southeast.getY());
            cells[Direction.SOUTH.ordinal()] = map.getCell(south.getX(), south.getY());
            cells[Direction.SOUTHWEST.ordinal()] = map.getCell(southwest.getX(), southwest.getY());
            cells[Direction.WEST.ordinal()] = map.getCell(west.getX(), west.getY());
            cells[Direction.NORTHWEST.ordinal()] = map.getCell(northwest.getX(), northwest.getY());
            ant.getSensor().detectObstacles(ant.getPosition(), cells);

        }
    }


}
