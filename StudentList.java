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

            if (str == null) return;

            String students[] = getLine(str).split(",");

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(",");

            Random random = new Random();
            int randomNum = ((random.nextInt() % students.length) + students.length) % students.length;

            System.out.println(students[randomNum]);

            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            BufferedWriter str = openFileWrite();

            String newStudent = args[0].substring(1);
            Date date = new Date();
            String df = "dd/mm/yyyy-hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(df);
            String updateTime = dateFormat.format(date);

            try {
                str.write("," + newStudent + "\nList last updated on " + updateTime);
                str.close();
            } catch (Exception E) {

            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(",");
            String tergetStudent = args[0].substring(1);

            for (int idx = 0; idx < students.length; idx++) {
                if (students[idx].equals(tergetStudent)) {
                    System.out.println("We found it!");
                    break;
                }
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(",");
            int count = students.length;
            System.out.println(count + " word(s) found");
            System.out.println("Data Loaded.");
            
        } else {
            System.out.println("Sorry! You enter wrong ot invalid Argument");
        }
    }

    private static BufferedReader openFileRead() {
        BufferedReader str = null;
        try {
            str = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
        } catch (Exception e) {
            System.out.println("Sorry! We can't Open the file");
        }
        return str;
    }

    private static BufferedWriter openFileWrite() {
        BufferedWriter str = null;
        try {
            str = new BufferedWriter(new FileWriter("students.txt", true));
        } catch (Exception e) {
            System.out.println("Sorry! We can't Open the file");
        }
        return str;
    }

    private static String getLine(BufferedReader str) {
        try {
            return str.readLine();
        } catch (Exception E) {

        }
        return "";
    }
}
