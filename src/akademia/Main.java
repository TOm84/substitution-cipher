package akademia;

import java.util.*;
import java.lang.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    //Generating table of character / Generowanie tablicy znakow
    Map<Character, Character> charList = new HashMap<Character, Character>();
    char startA = 'a';
    char startZ = 'z';
    while (startA <= 'z') {
      while (startZ >= 'a') {
        charList.put(startA, startZ);
        startA++;
        startZ--;
      }
    }
    // Getting word/words and their converting / Pobieranie slowa/slow oraz jego/ich przetwarzanie

    Scanner scanner = new Scanner(System.in);
    System.out.println("Put words:");
    String input = scanner.nextLine();
    char[] charInput = input.toCharArray();
    StringBuilder sb = new StringBuilder();

    for (char x : charInput) {
      if (Character.isLetter(x)) {
        sb.append(charList.get(x));
      } else {
        sb.append(x);
      }
    }

    // Reverse convertng / Deszyfrowanie słów

    String sbToString = sb.toString();
    char[] backtourn = sbToString.toCharArray();
    StringBuilder outSb = new StringBuilder();

    for (char cha : backtourn) {
      for (Entry<Character, Character> entry : charList.entrySet()) {
        if (entry.getValue() == cha) {
          outSb.append(entry.getKey());
        }
      }
      if (!Character.isLetter(cha)) {
        outSb.append(cha);
      }
    }

    // displayed messages / wyświetlane komunikaty
    System.out.println("You writed word: ");
    System.out.println(input);
    System.out.println("Converted to :");
    System.out.println(sb);
    System.out.println("Generated table HashMap: ");
    System.out.println(charList);
    System.out.println("Deciphered word: ");
    System.out.println(outSb);

  }
}
