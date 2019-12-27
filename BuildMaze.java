import java.util.*;

public class BuildMaze
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions for the rows and columns: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        Maze m = new Maze(rows, columns);
        m.printMaze();
    }
}
