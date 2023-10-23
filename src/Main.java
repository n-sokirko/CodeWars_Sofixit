import java.util.Arrays;

public class Main {
    static int material(int[] oneDspaship) {
        int[][] spaceship = convertToTwoDimensional(oneDspaship);
        int water = 0;
        for (int i = 0; i < spaceship[0].length; i++) {
            for (int j = 0; j < spaceship.length; j++) {
                if (spaceship[j][i] == 0 && checkLeft(spaceship, j, i) && checkRight(spaceship, j, i)) {
                    water++;
                }
            }
        }
        return water;
    }

    static boolean checkLeft(int[][] spaceship, int row, int col) {
        for (int i = col - 1; i >= 0; i--) {
            if (spaceship[row][i] == 1) {
                return true;
            }
        }
        return false;
    }


    static boolean checkRight(int[][] spaceship, int row, int col) {
        for (int i = col + 1; i < spaceship[0].length; i++) {
            if (spaceship[row][i] == 1) {
                return true;
            }
        }
        return false;
    }


    static int[][] convertToTwoDimensional(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[][] result = new int[maxVal][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                result[maxVal - j - 1][i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] i = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};

        System.out.println(material(i));
    }
}
