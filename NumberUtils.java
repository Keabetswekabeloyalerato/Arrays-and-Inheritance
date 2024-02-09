public class NumberUtils {

    private NumberUtils() {
        // Private constructor to prevent object instantiation.
    }

    public static int[] toArray(int number){
        String numberStr = Integer.toString(number);
        int[] result = new int[numberStr.length()];

        for (int i = 0; i < numberStr.length(); i++)     {
            result[i] = Character.getNumericValue(numberStr.charAt(i))   ;
            }

        return result;
    }

    public static int countMatches(int numberA, int numberB) {
        int[] digitsA = toArray(numberA);
        int[] digitsB = toArray(numberB);

        int count = 0;
        for (int i = 0; i < digitsA.length; i++)    {
            if (digitsA[i] == digitsB[i]){
                count++;
         }
        }

        return count;
    }

    public static int countIntersect(int numberA, int numberB){
        int[] digitsA = toArray(numberA);
        int[] digitsB = toArray(numberB)  ;

        int count = 0;
        for (int digitA :digitsA) {
            for (int digitB :digitsB) {
                if (digitA == digitB) {
                    count++;
                }
            }
        }

        return count;
    }
}
