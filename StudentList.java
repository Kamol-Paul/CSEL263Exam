import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static Constants constants = new Constants();

    public static void main(String[] args) {
//		Check arguments
        if (args.length < 1) {
            System.out.println(constants.NO_ARG);
        } else if (args[0].equals(constants.SHOW_ALL)) {
            System.out.println(constants.LOADING);
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(constants.SPLIT_KEY);

            for (String student : students) {
                System.out.println(student);
            }

            System.out.println(constants.LOADED);
        } else if (args[0].equals(constants.GET_RANDOM)) {
            System.out.println(constants.LOADING);
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(constants.SPLIT_KEY);

            Random random = new Random();
            int randomNum = ((random.nextInt() % students.length) + students.length) % students.length;

            System.out.println(students[randomNum]);

            System.out.println(constants.LOADED);
        } else if (args[0].contains(constants.ADD_NEW)) {
            System.out.println(constants.LOADING);
            BufferedWriter str = openFileWrite();

            String newStudent = args[0].substring(1);
            Date date = new Date();
            String df = constants.DATE_FORMAT;
            DateFormat dateFormat = new SimpleDateFormat(df);
            String updateTime = dateFormat.format(date);

            try {
                str.write(constants.SPLIT_KEY + newStudent + constants.UPDATE + updateTime);
                str.close();
            } catch (Exception E) {
                System.out.println(constants.WRONG_OPEN);
            }

            System.out.println(constants.LOADED);
        } else if (args[0].contains(constants.SEARCH)) {
            System.out.println(constants.LOADING);
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(",");
            String tergetStudent = args[0].substring(1);

            for (int idx = 0; idx < students.length; idx++) {
                if (students[idx].equals(tergetStudent)) {
                    System.out.println(constants.FOUND);
                    break;
                }
            }

            System.out.println(constants.LOADED);
        } else if (args[0].contains(constants.COUNT)) {
            System.out.println(constants.LOADING);
            BufferedReader str = openFileRead();

            if (str == null) return;

            String students[] = getLine(str).split(constants.SPLIT_KEY);
            int count = students.length;
            System.out.println(count + constants.WORD);
            System.out.println(constants.LOADED);

        } else {
            System.out.println(constants.WRONG_ARG);
        }
    }

    private static BufferedReader openFileRead() {
        BufferedReader str = null;
        try {
            str = new BufferedReader(new InputStreamReader(new FileInputStream(constants.FILE)));
        } catch (Exception e) {
            System.out.println(constants.WRONG_OPEN);
        }
        return str;
    }

    private static BufferedWriter openFileWrite() {
        BufferedWriter str = null;
        try {
            str = new BufferedWriter(new FileWriter(constants.FILE, true));
        } catch (Exception e) {
            System.out.println(constants.WRONG_OPEN);
        }
        return str;
    }

    private static String getLine(BufferedReader str) {
        try {
            return str.readLine();
        } catch (Exception E) {

        }
        return constants.EMPTY_STRING;
    }
}
