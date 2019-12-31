package tools;

public class Converter {

    public static int toInt(String str){
        try {
            return Integer.parseInt(str);
        }
        catch (Exception e) {
            System.out.println("'" + str + "'" + " isn't an integer! \n Returning 0...");
            return 0;
        }
    }

    public static int toInt(double value){
        return (int)value;
    }

    public static int toInt(float value){
        return (int)value;
    }

    /**
     * @param value
     * @return 0 if value is false, and 1 if its true.
     */
    public static int toInt(boolean value){
        if(value) return 1; return 0;
    }

    public static double toDouble(String str){
        try {
            return Double.parseDouble(str);
        }
        catch (Exception e) {
            System.out.println("'" + str + "'" + " isn't a numerical value! \n Returning 0...");
            return 0;
        }
    }

    /**
     * @param value
     * @return false if value is 0, true if its not.
     */
    public static boolean toBool(int value){
        if(value == 0) return false;
        return true;
    }

    public static String str(int value){
        return value + "";
    }

    public static String str(double value){
        return value + "";
    }

    public static String str(float value){
        return value + "";
    }

    public static String str(boolean value){
        return value + "";
    }
}
