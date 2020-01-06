package algorithm;

public class Timetable {

    /*
    A single timetable will be represented by a 3d array where the dimensions are:
    1. Classroom
    2. Time slot
    3. Teacher
     */

    int[][][] timetable;

    public Timetable(int[][][] timetable) {
        this.timetable = timetable;
    }

    public Timetable(int numClasses, int numTimeSlots, int numTeachers) {
        this.timetable = new int[numClasses][numTimeSlots][numTeachers];
    }

    public Timetable() {
        for (int i = 0; i < Predefining.numClasses; i++) {
            for (int j = 0; j < Predefining.numTimeSlots; j++) {
                for (int k = 0; k < Predefining.numTeachers; k++) {

                }
            }
        }
    }



}
