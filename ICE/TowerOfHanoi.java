/**
 * Tower of Hanoi solution illustrating recursion.
 * @author Kenneth Ingham
 */

public class TowerOfHanoi {
    private enum Peg { LEFT, MIDDLE, RIGHT; }
    
    public static void solve(int nDisks, Peg src, Peg dst, Peg using) {
        if (nDisks <= 0) {
            System.err.println("Moving " + nDisks + "makes no sense.");
            System.exit(1);
        }
        if (nDisks == 1) {
            System.out.println("Move disk from " + src + " to " + dst);
            return;
        }
        // If we are here, n > 1
        solve(nDisks-1, src, using, dst);
        solve(1, src, dst, using);
        solve(nDisks-1, using, dst, src);
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Incorrect argument count: " + args.length);
            System.err.println("Usage: java TowerOfHanoi nDisks");
            System.exit(1);
        }
        Integer nDisks = Integer.parseInt(args[0]);
        solve(nDisks, Peg.LEFT, Peg.RIGHT, Peg.MIDDLE);
    }
}