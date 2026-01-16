import java.util.Scanner;
import java.io.File;

public class Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  public Board()
  {
    solvedPhrase = "";
    phrase = loadPhrase();
    currentLetterValue = 0;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public int getCurrentLetterValue()
  {
    return currentLetterValue;
  }

  public void setLetterValue()
  {
    int randomInt = (int)((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }
   
  // Add to use AI for this method I didn't know how to add it
  public boolean isSolved()
  {
    return !solvedPhrase.contains("_");
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    int numLines = 0;

    try
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numLines++;
      }
    }
    catch(Exception e){}

    int randomLine = (int)(Math.random() * numLines) + 1;

    try
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomLine)
          tempPhrase = temp;
      }
    }
    catch(Exception e){}

    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i,i+1).equals(" "))
        solvedPhrase += "  ";
      else
        solvedPhrase += "_ ";
    }

    return tempPhrase;
  }

  public boolean guessLetter(String guess)
  {
    boolean found = false;
    String newSolved = "";

    for (int i = 0; i < phrase.length(); i++)
    {
      String letter = phrase.substring(i,i+1);

      if (letter.equalsIgnoreCase(guess))
      {
        newSolved += letter + " ";
        found = true;
      }
      else
      {
        newSolved += solvedPhrase.substring(i*2, i*2+1) + " ";
      }
    }

    solvedPhrase = newSolved;
    return found;
  }
}
