package algorithm;

public class Predefining {

    final public static String[] teachers = {"Reuben", "Michal"};
    final public static int numTeachers = teachers.length;
    final public static int numClasses = 6;
    final public static int numTimeSlots = 100;

    public static String getTeacherName(int teacher) {
        return teachers[teacher];
    }

}
