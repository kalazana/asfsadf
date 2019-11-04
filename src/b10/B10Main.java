package b10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10Main {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println("Autokorrektur");

        do {
            System.out.println("Bitte geben Sie eine Testzeile an:");
            input = consoleInput.readLine();
            convertString(input);

            System.out.println("Noch eine Umwandlung? (j|n):");
        } while (!consoleInput.readLine().equals("n"));
    }

    private static void convertString(String original) {
        String converted = original;
        StringBuilder tmp;

        int replacedCount = 0;
        int removedCount = 0;
        int addedCount = 0;

        // remove double tab or space
        tmp = new StringBuilder();
        for (int i = 0; i < converted.length(); i++) {
            if (converted.charAt(i) == ' ' || converted.charAt(i) == '\t') {
                if (converted.length() > i + 1 && converted.charAt(i + 1) == converted.charAt(i)) {
                    removedCount++;
                } else {
                    tmp.append(converted.charAt(i));
                }
            } else {
                tmp.append(converted.charAt(i));
            }
        }
        converted = tmp.toString();

        // remove tabs/spaces at the beginning/end of string
        tmp = new StringBuilder();
        boolean removeBeginning = converted.charAt(0) == ' ' || converted.charAt(0) == '\t';
        boolean removeEnd = converted.charAt(converted.length() - 1) == ' ' || converted.charAt(converted.length() - 1) == '\t';
        tmp.append(
                converted,
                removeBeginning ? 1 : 0,
                converted.length() - (removeEnd ? 1 : 0)
        );
        converted = tmp.toString();

        // remove tabs/spaces before punctuation
        tmp = new StringBuilder();
        for (int i = 0; i < converted.length(); i++) {
            if (converted.charAt(i) == ' ' || converted.charAt(i) == '\t') {
                if (isPunctuationCharacter(converted.charAt(i + 1)))  {
                    removedCount++;
                } else {
                    tmp.append(converted.charAt(i));
                }
            } else {
                tmp.append(converted.charAt(i));
            }
        }
        converted = tmp.toString();

        // insert space after punctuation (if not there already)
        tmp = new StringBuilder();
        for (int i = 0; i < converted.length(); i++) {
            tmp.append(converted.charAt(i));
            if (isPunctuationCharacter(converted.charAt(i)) && converted.length() > i + 1 && converted.charAt(i + 1) != ' ') {
                tmp.append(' ');
                addedCount++;
            }
        }
        converted = tmp.toString();

        // convert beginnings of string/sentences to uppercase
        tmp = new StringBuilder();
        for (int i = 0; i < converted.length(); i++) {
            if (i == 0 && !Character.isUpperCase(converted.charAt(i))) {
                tmp.append(Character.toUpperCase(converted.charAt(i)));
                replacedCount++;
            } else if (i >= 2 && isPunctuationCharacter(converted.charAt(i - 2)) && !Character.isUpperCase(converted.charAt(i))) {
                tmp.append(Character.toUpperCase(converted.charAt(i)));
                replacedCount++;
            } else {
                tmp.append(converted.charAt(i));
            }
        }
        converted = tmp.toString();

        System.out.println(converted);
        System.out.printf("%d gelesen, %d ausgegeben, %d wegkomprimiert, %d konvertiert, %d hinzugefügt", original.length(), converted.length(), removedCount, replacedCount, addedCount);
        System.out.println();
    }

    private static boolean isPunctuationCharacter(char c) {
        switch (c) {
            case '.':
            case '!':
            case '?':
            case ';':
            case ':':
                return true;
            default:
                return false;
        }
    }
}
