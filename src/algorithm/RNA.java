package algorithm;

public class RNA {

    Timetable bestTimetable;

    public RNA() {}

    public RNA(Timetable timetable) {
        this.bestTimetable = timetable;
    }

    public void perform(int iterations) {
        int lastFitness = Predefining.fitness(bestTimetable);
        int fitness = 0;
        int count = 0;
    }

}
