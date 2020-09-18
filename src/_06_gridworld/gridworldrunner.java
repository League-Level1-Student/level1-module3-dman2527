package _06_gridworld;

import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class gridworldrunner {
public static void main(String[] args) {
World world = new World();	
Bug bug = new Bug(Color.red);
Location location = new Location(3,3);
world.add(location, bug);
world.show();
Random random = new Random();
int x1 = random.nextInt(10);
int y1 = random.nextInt(10);
Location location1 = new Location(x1,y1);
Bug bug1 = new Bug(Color.BLUE);
world.add(location1, bug1);
bug1.turn();
bug1.turn();
Flower flowerleft = new Flower(Color.blue);
Flower flowerright = new Flower(Color.red);
Location locationleft = new Location(x1, y1-1);
Location locationright = new Location(x1,y1+1);
world.add(locationleft, flowerleft);
world.add(locationright, flowerright);
for(int i = 0;i<99;i++) {
	Flower flowerempty = new Flower(Color.CYAN);
	world.add(world.getRandomEmptyLocation(), flowerempty);
}

}
}
