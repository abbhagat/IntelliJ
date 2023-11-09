public class Main {

    void printTriangle(int n) {

        int low = 0, high = n - 1;  // 5
        int mid = (low + high); //   // 2
        while(low <= mid) {   // 2 <= 2 low = [0,1,2]
            for(int i = 0; i <= low; i++) {  // low = 2
                if(low >= 2) {
                    if(i == 0 || i == low) { //  i = 0,1, 2 3
                        System.out.print("#");
                    }else {
                        System.out.print(" ");
                    }
                }else if(i == 0 || i == 1) {
                    System.out.print("#");
                }
            }
            low++;
        }
        while(high > mid) {
            for(int i = 0; i <= low; i++) {
                if(low >= 2) {
                    System.out.print("#");
                    int k = low - 1;
                    while(k != 0) {
                        System.out.print(" ");
                        k--;
                    }
                }
                else if(i == 0 || i == 1) {
                    System.out.print("#");
                }
            }
            low++;
        }
    }
}
