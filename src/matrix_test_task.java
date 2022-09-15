import java.util.*;

public class matrix_test_task {

    public static void main(String[] args) {

        System.out.print("Please, Entry two numbers (n - rows, m - cols) = ");

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        System.out.println();
        int[][] matrix = new int[cols][rows];
        fillCycleMatrix(matrix);
        printMatrix(matrix);

    }

    //заполняет массив спирально
    private static void fillCycleMatrix(int[][] matrix) {

        int cols = matrix.length;
        int rows = matrix[0].length;
        int size = rows * cols;

        //"курсор" на элемент матрицы
        int col = 0;
        int row = 0;

        //отступы
        int rowBeg = 0;
        int rowFin = 0;
        int colBeg = 0;
        int colFin = 0;

        for (int currentValue = 1; currentValue <= size; currentValue++) {

            matrix[col][row] = currentValue;

            if (row == rowBeg && col < cols - colFin - 1)
                col++;
            else if (col == cols - colFin - 1 && row < rows - rowFin - 1)
                row++;
            else if (row == rows - rowFin - 1 && col > colBeg)
                col--;
            else
                row--;

            if ((row == rowBeg + 1) && (col == colBeg) && (colBeg != cols - colFin - 1)){
                rowBeg++;
                rowFin++;
                colBeg++;
                colFin++;
            }

        }

    }

    //выводит матрицу
    private static void printMatrix(int[][] matrix) {

        //для красивого вывода
        int n = ((Integer) (matrix[0].length * matrix.length)).toString().length() ;

        for (int row = 0; row < matrix[0].length; row++) {
            for (int[] ints : matrix) {

                //для красивого вывода
                int m = ((Integer) (ints[row])).toString().length();
                char[] chars = new char[n - m];
                Arrays.fill(chars, '0');

                System.out.print(new String(chars) + ints[row] + " ");
            }
            System.out.println();
        }

    }


}

