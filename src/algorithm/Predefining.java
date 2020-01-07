package algorithm;

public class Predefining {

    final public static String[] teachers = {"Reuben", "Michal"};
    final public static int numTeachers = teachers.length;
    final public static int numClasses = 6;
    final public static int numTimeSlots = 100;

    public static String getTeacherName(int teacher) {
        return teachers[teacher];
    }

    /**
     * Used to check weather the given timetable stands all hard constraints.
     * @param timetable
     * @return feasibility in terms of penalty. The smaller the penalty, the higher the feasibility.
     */
    public static int measureFeasibility(Timetable timetable) {return 0;}

    /**
     * Calculates the fitness of a timetable. The higher the value, the better the timetable.
     * Very important: the program should update the fitness value of the Timetable object.
     * @param timetable
     * @return A value between 0 and 1 determines the fitness of the given timetable.
     */
    public static int fitness(Timetable timetable) {return 1 / (1 + 0);}

}
