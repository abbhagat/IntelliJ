package matrix;

public class MatrixInversion {
    int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void matrixInversion() {
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        MatrixInversion m = new MatrixInversion();
        m.display();
        m.matrixInversion();
        System.out.println();
        m.display();
    }
}
