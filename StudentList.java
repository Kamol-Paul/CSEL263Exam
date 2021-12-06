import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args.length < 1) {
            System.out.println("Sorry! You don't enter any argument!");
        } else if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            BufferedReader str = openFileRead();
            if (str == NULL) return;

            string students[] = str.readLine().split(",");
            for (string student : students) {
                System.out.println(student);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            BufferedReader str = openFileRead();
            if (str == NULL) return;
            string students[] = str.readLine().split(",");
            Random random = new Random();
            int randomNum = ((random.nextInt() % 4) + 4 % 4;
            System.out.println(students[randomNum]);
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            BufferedWriter str = openFileWrite();
            string newStudent = args[0].substring(1);
            Date date = new Date();
            String df = "dd/mm/yyyy-hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(df);
            String updateTime = dateFormat.format(date);
            str.write(", " + newStudent + "\nList last updated on " + updateTime);
            str.close();
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = s.readLine();
                String i[] = r.split(",");
                boolean done = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < i.length && !done; idx++) {
                    if (i[idx].equals(t)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String D = s.readLine();
                char a[] = D.toCharArray();
                boolean in_word = true;
                int count = 0;
                for (char c : a) {
                    if (c == ',') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    } else in_word = false;
                }
                if (!in_word) count++;
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else {
            System.out.println("Sorry! You enter wrong ot invalid Argument");
        }
    }

    private static BufferedReader openFileRead() {
        BufferedReader str = NULL;
        try {
            str = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
        } catch (Exception e) {
            System.out.println("Sorry! We can't Open the file");
        }
        return str;
    }

    private static BufferedWriter openFileWrite() {
        BufferedWriter str = NULL;
        try {
            str = new BufferedWriter(new FileWriter("students.txt", true));
        } catch (Exception e) {
            System.out.println("Sorry! We can't Open the file");
        }
        return str;
    }
}
}