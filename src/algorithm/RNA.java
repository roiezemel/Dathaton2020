package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class RNA {

    Timetable bestTimetable;

    public RNA() {}

    public RNA(Timetable timetable) {
        this.bestTimetable = timetable;
    }

    public Timetable[] perform(int minChange, int iterations, int numTimetables) {
        Timetable[] bestSolutions = new Timetable[numTimetables];
        bestSolutions[0] = bestTimetable;
        int lastFitness;
        int fitness = Predefining.fitness(bestTimetable);
        int count = 0;
        Timetable timetable = bestTimetable.copy();
        while(count < iterations) {
            lastFitness = fitness;
            timetable.doubleMove();
            fitness = Predefining.fitness(timetable);
            if (fitness - lastFitness <= minChange)
                count++;
            else
                count = 0;
            if (fitness > bestTimetable.getFitness()) {
                bestTimetable = timetable.copy();
            }
            for (int i = 0; i < bestSolutions.length; i++) {
                if (bestSolutions[0] != null && fitness > bestSolutions[i].getFitness()) {
                    if (i == bestSolutions.length - 1) {
                        insert(bestSolutions, timetable, i);
                        break;
                    }
                    else if (fitness < bestSolutions[i + 1].getFitness()) {
                        insert(bestSolutions, timetable, i);
                        break;
                    }
                }
            }
        }
        return bestSolutions;
    }

    /**
     * Insert an object into a given index in the array.
     * @param array
     * @param object
     * @param index
     */
    private void insert(Timetable[] array, Timetable object, int index) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = object;
    }

    public Timetable getBestTimetable() {
        return bestTimetable;
    }

    public void setBestTimetable(Timetable bestTimetable) {
        this.bestTimetable = bestTimetable;
    }
}
