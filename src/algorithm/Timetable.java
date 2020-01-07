package algorithm;

public class Timetable {

    /*
    A single timetable will be represented by a 3d array where the dimensions are:
    1. Classroom
    2. Time slot
    3. Teacher
     */

    private int fitness;
    private int[][][] timetable;

    /**
     *
     * @param timetable
     */
    public Timetable(int[][][] timetable) {
        this.timetable = timetable;
    }

    /**
     *
     * @param numClasses
     * @param numTimeSlots
     * @param numTeachers
     * @param ensureFeasibility If true, the method will use simple moves to ensure the creation of feasible timetable.
     */
    public Timetable(int numClasses, int numTimeSlots, int numTeachers, boolean ensureFeasibility) {
        this.timetable = new int[numClasses][numTimeSlots][numTeachers];
        initiateRandom(ensureFeasibility);
    }

    /**
     * Calls to initiateRandom().
     * @param ensureFeasibility If true, the method will use simple moves to ensure the creation of feasible timetable.
     */
    public Timetable(boolean ensureFeasibility) {
        timetable = new int[Predefining.numClasses][Predefining.numTimeSlots][Predefining.numTeachers];
        initiateRandom(ensureFeasibility);
    }

    /**
     * Initiates a random timetable.
     * Also ensures that the same class would not have two different classes in the same time.
     * @param ensureFeasibility If true, the method will use simple moves to ensure the creation of feasible timetable.
     */
    public void initiateRandom(boolean ensureFeasibility) {
        for (int i = 0; i < Predefining.numClasses; i++) {
            for (int j = 0; j < Predefining.numTimeSlots; j++) {
                int teacher = Util.randInt(0, Predefining.numTeachers);
                timetable[i][j][teacher] = 1;
            }
        }
        while (ensureFeasibility && Predefining.measureFeasibility(this) != 0)
            simpleMove();
    }

    /**
     * Swaps two random time slots in the timetable.
     */
    public void simpleMove() {
        int c1 = Util.randInt(0, timetable.length);
        int t1 = Util.randInt(0, timetable[c1].length);
        int[] timeSlot = timetable[c1][t1];
        int c2 = Util.randInt(0, timetable.length);
        int t2 = Util.randInt(0, timetable[c2].length);
        timetable[c1][t1] = timetable[c2][t2];
        timetable[c2][t2] = timeSlot;
    }

    /**
     * A combination of two simple moves when the first move leads to a higher infeasibility.
     * This method does not ensure feasibility at all!
     */
    public void doubleMove() {
        int f = Predefining.measureFeasibility(this);
        simpleMove();
        if (Predefining.measureFeasibility(this) > f)
            simpleMove();
    }

    /**
     * @return
     */
    public int[][][] getTimetable() {
        return timetable;
    }

    /**
     * @param timetable
     */
    public void setTimetable(int[][][] timetable) {
        this.timetable = timetable;
    }

    /**
     * @return
     */
    public int getFitness() {
        return fitness;
    }

    /**
     * @param fitness
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public Timetable copy() {
        Timetable timetable = new Timetable(this.timetable);
        timetable.setFitness(this.fitness);
        return timetable;
    }
}
