package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements  IEngine{

    private MoveDirection[] moves;
    private IWorldMap map;
    private ArrayList<Animal> animals = new ArrayList<>();

    SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions){
        this.map = map;
        this.moves = moves;

        for(Vector2d position : initialPositions)
        {
            Animal animal = new Animal(map,position);
            if(this.map.place(animal))
            {
                animals.add(animal);
            }
        }
    }

    public void run(){
        System.out.println(map);
        TextFrame frame = new TextFrame();

        frame.setText(map.toString());
        for(int i = 0; i < moves.length; i++)
        {
            animals.get(i % animals.size()).move(moves[i]);
            System.out.println(map);
            frame.setText(map.toString());
        }

    }
}
