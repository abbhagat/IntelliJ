package adobe;

public class CelebrityProblem {

  public static int findCelebrity(boolean[][] M, int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {      // Phase 1: Find a possible candidate
      if (knows(candidate, i, M)) {
        candidate = i;
      }
    }
    for (int i = 0; i < n; i++) {       // Phase 2: Verify candidate
      if (i == candidate) {
        continue;
      }
      if (knows(candidate, i, M)) {    // Celebrity should know nobody
        return -1;
      }
      if (!knows(i, candidate, M)) {  // Everybody should know celebrity
        return -1;
      }
    }
    return candidate;
  }

  private static boolean knows(int i, int j, boolean[][] M) {
    return M[i][j];
  }

  public static void main(String[] args) {
    boolean[][] M = {
                      {false,  true,  true},
                      {false, false,  true},
                      {false, false, false}
                    };
    int celebrity = findCelebrity(M, M.length);
    System.out.println(celebrity == -1 ? "No celebrity found" : "Celebrity is: " + celebrity);
  }
}
