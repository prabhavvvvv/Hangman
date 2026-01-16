import java.util.Scanner;

public class Player
{
  private String name;
  private int points;

  public Player()
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter player name: ");
    name = sc.nextLine();
    points = 0;
    System.out.println("Welcome " + name + "!");
  }

  public String getName()
  {
    return name;
  }

  public int getPoints()
  {
    return points;
  }

  public void setPoints(int p)
  {
    points = p;
  }
}
