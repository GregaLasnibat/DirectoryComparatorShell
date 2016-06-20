import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
/**
 * Created by grega on 27/05/16.
 */
public class DirectoryComparatorShell {

    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("\t\t*************************************");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t**      DIRECTORY COMPARATOR       **");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t**         Instructions:           **");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  - Select an operation (1-7)      *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  - Provide one or more file or    *");
        System.out.println("\t\t*  folder paths as shown below:     *");
        System.out.println("\t\t*  /home/user/Folder/somefile.txt   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  - Hit enter                      *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t**          Distinction!           **");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  This is a FILE path:             *");
        System.out.println("\t\t*  /home/user/Folder/somefile.txt   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  This is a FOLDER path:           *");
        System.out.println("\t\t*  /home/user/Folder/SubFolder/     *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t**          Operations:            **");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  1 --> Prints out file info.      *");
        System.out.println("\t\t*  Requires a SINGLE file path.     *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  2 --> Compares two files         *");
        System.out.println("\t\t*  by file info.                    *");
        System.out.println("\t\t*  Requires TWO file paths.         *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  3 --> Calculates checksum        *");
        System.out.println("\t\t*  value of a file.                 *");
        System.out.println("\t\t*  Requires a SINGLE file path.     *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  4 --> Compares two files         *");
        System.out.println("\t\t*  by contents.                     *");
        System.out.println("\t\t*  Requires TWO file paths.         *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  5 --> Prints out folder contents *");
        System.out.println("\t\t*  using recursion.                 *");
        System.out.println("\t\t*  Requires a SINGLE folder path.   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  6 --> Prints out folder contents *");
        System.out.println("\t\t*  using iteration.                 *");
        System.out.println("\t\t*  Requires a SINGLE folder path.   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*  7 --> Compares two directories   *");
        System.out.println("\t\t*  and prints out where they differ *");
        System.out.println("\t\t*  and where they don't.            *");
        System.out.println("\t\t*  Requires TWO folder paths.       *");
        System.out.println("\t\t*                                   *");
        System.out.println("\t\t*************************************");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        int process = keyboard.nextInt();
        String folderPath1;
        String folderPath2;

//        OLD CODE
//        // check if there are at least 2 arguments and shut down if there are not.
//        if (args.length < 2) {
//            System.out.printf("Insufficient number of arguments. At least two arguments needed.\n" +
//                    "%s\n%s\n", "- number of the process", "- one or more file paths");
//            System.exit(1);
//        }

        // deciding which operation to perform, default being an error message.
        switch (process) {
            case 1:
                System.out.println("Insert a file path and press enter");
                folderPath1 = keyboard.next();
                printFileInfo(folderPath1);
                break;
            case 2:
                System.out.println("Insert the first file path and press enter");
                folderPath1 = keyboard.next();
                System.out.println("Insert the second file path and press enter");
                folderPath2 = keyboard.next();
                compareTwoFiles(folderPath1, folderPath2);
                break;
            case 3:
                System.out.println("Insert a file path and press enter");
                folderPath1 = keyboard.next();
                printCheckSum(folderPath1);
                break;
            case 4:
                System.out.println("Insert the first file path and press enter");
                folderPath1 = keyboard.next();
                System.out.println("Insert the second file path and press enter");
                folderPath2 = keyboard.next();
                compareFilesByContents(folderPath1, folderPath2);
                break;
            case 5:
                System.out.println("Insert a file path and press enter");
                folderPath1 = keyboard.next();
                printFolderContents(folderPath1, true);
                break;
            case 6:
                System.out.println("Insert a file path and press enter");
                folderPath1 = keyboard.next();
                printFolderContents(folderPath1, false);
                break;
            case 7:
                System.out.println("Insert the first folder path and press enter");
                folderPath1 = keyboard.next();
                System.out.println("Insert the second folder path and press enter");
                folderPath2 = keyboard.next();
                compareTwoFolders(folderPath1, folderPath2);
                break;
//            default:
//                System.out.println("Error: wrong arguments.");
        }
        keyboard.close();
    }

    /** Prints out file info (name, path, size, date of last change).
     *
     * @param arg String
     * @throws FileNotFoundException
     */
    private static void printFileInfo(String arg) throws FileNotFoundException {
        File f = new File(arg);
        if (f.exists() && f.isFile()) {
            String name = f.getName();
            String path = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf(File.separator));
            long size = f.length();
            String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(f.lastModified()));
            System.out.printf("File name: %s\nFile path: %s\nFile size: %d bytes\nLast changed on: %s\n",
                    name, path, size, date);
            return;
        }
        System.out.printf("Error: File %s does not exist.\n", f.toString());
    }

    /** Compares two files and prints out where they differ.
     *
     * @param arg1 String
     * @param arg2 String
     * @throws FileNotFoundException
     */
    private static void compareTwoFiles(String arg1, String arg2) throws FileNotFoundException {
        File f1 = new File(arg1);
        File f2 = new File(arg2);
        if (f1.exists() && f2.exists() && f1.isFile() && f2.isFile()) {
            String result = compare(f1, f2);
            if (result.isEmpty()) {
                System.out.printf("Files are the same:\n(1) %s\n(2) %s\n", f1.getAbsolutePath(), f2.getAbsolutePath());
            }
            else {
                System.out.print(result);
            }
        }
        else {
            System.out.printf("Error: Files %s or %s do not exist.\n", f1.toString(), f2.toString());
        }
    }

    /** Prints out a checksum value of a file.
     *
     * @param arg String
     * @throws FileNotFoundException
     */
    private static void printCheckSum(String arg) throws FileNotFoundException {
        File f = new File(arg);
        if (f.exists() && f.isFile()) {
            System.out.printf("Checksum value of file %s is: %d\n", arg, checkSum(f));
        }
    }

    /** Compares two files' contents and prints out where they differ.
     *
     * @param arg1 String
     * @param arg2 String
     * @throws FileNotFoundException
     */
    private static void compareFilesByContents(String arg1, String arg2) throws FileNotFoundException {
        File f1 = new File(arg1);
        File f2 = new File(arg2);

        if (f1.exists() && f2.exists() && f1.isFile() && f2.isFile()) {
            int position = compareContents(f1, f2);
            if (position >= 0) {
                System.out.printf("Files' contents differ at character in position: %d\n", position);
            }
            else {
                System.out.printf("Files %s and %s have the same contents.\n", f1.toString(), f2.toString());
            }
        }
        else {
            System.out.printf("Error: File %s or %s does not exist.\n",f1.toString(), f2.toString());
        }
    }

    /** Prints out all the subfolders and contents of a folder using either a recursive or iterative method.
     *
     * @param dir String
     * @param recursively boolean
     * @throws FileNotFoundException
     */
    private static void printFolderContents(String dir, boolean recursively) throws FileNotFoundException {
        File f = new File(dir);
        if (f.exists() && f.isDirectory()) {
            System.out.printf("Folder %s contents:\n", f.toString());
            if (recursively) {
                printFolderRec(f);
            }
            else {
                printFolderIter(f);
            }
        }
        else {
            System.out.printf("Error: %s is not a folder.\n", f.toString());
        }
    }

    /** Compares two folder structures and prints out differences between them in the following fashion:
     * OK means that two folders or files are identical.
     * + means that the file or folder doesn't exist in the first folder but exists in the second folder.
     * - means that the file or folder exists in the first folder but doesn't exist in the second folder.
     * ! means an altered file or folder. Its name is the same in both parent folders but its contents aren't.
     * @param arg1 String
     * @param arg2 String
     * @throws FileNotFoundException
     */
    private static void compareTwoFolders(String arg1, String arg2) throws FileNotFoundException {

        File f1 = new File(arg1);
        File f2 = new File(arg2);

        if (f1.exists() && f2.exists() && f1.isDirectory() && f2.isDirectory()) {
            File[] contents1 = returnAllContents(f1);
            File[] contents2 = returnAllContents(f2);
            int n1 = 0;
            int n2 = 0;
            while (n1 < contents1.length && n2 < contents2.length) {
                System.out.printf("\n---> NOW COMPARING: %s AND %s\n",
                        contents1[n1].getParentFile(), contents2[n2].getParentFile());

                String fileOne = contents1[n1].getPath().substring(arg1.length());
                String fileTwo = contents2[n2].getPath().substring(arg2.length());

                // check if they both have the same name
                if (fileOne.equals(fileTwo)) {
                    // check if they're files and not directories
                    if (contents1[n1].isFile() && contents2[n2].isFile()) {
                        String fileCompAnswr = compare(contents1[n1], contents2[n2]);
                        int position = compareContents(contents1[n1], contents2[n2]);
                        // if the two files differ somewhere
                        if (!fileCompAnswr.isEmpty()) {
                            System.out.printf("Both have a file %s that differs in:\n%s", fileOne, fileCompAnswr);
                            // if they differ in content
                            if (position > 0) {
                                System.out.printf("Files differ in content at character in position: %d\n", position);
                            }
                        }
                        // else, two files are the same
                        else {
                            System.out.printf("Both have an identical file: %s\n", fileOne);
                        }
                    }
                    // if they're not files, they're directories
                    else {
                        System.out.printf("Both contain directory: %s and %s\n", fileOne, fileTwo);
                    }
                    n1++;
                    n2++;
                }
                // compares fileTwo to baseline fileOne and returns -1 if they're not the same. Means fileOne is missing
                else if (fileOne.compareTo(fileTwo) < 0) {
                    System.out.printf("Missing in second folder structure: %s\n", fileOne);

                    n1++;
                }
                // and vice versa
                else {
                    System.out.printf("Missing in first folder structure: %s\n", fileTwo);
                    n2++;
                }
            }
            // if we went through all the tokens of contents2 and there are still tokens left in contents1, then they
            // have to be missing in contents2
            while (n1 < contents1.length) {
                System.out.printf("Missing in second folder structure: %s\n",
                        contents1[n1].getPath().substring(arg1.length()));
                n1++;
            }
            // and the other way around
            while (n2 < contents2.length) {
                System.out.printf("Missing in first folder structure: %s\n",
                        contents2[n2].getPath().substring(arg2.length()));
                n2++;
            }
        }
        else {
            System.out.printf("Error: %s or %s does not exist.\n", f1.toString(), f2.toString());
        }
    }

    // HELPER METHODS
    /** Iteratively goes through a folder and all subfolders and returns a list of all contents.
     *
     * @param f File
     * @return File[]
     * @throws FileNotFoundException
     */
    private static File[] returnAllContents(File f) throws FileNotFoundException {
        File[] allContents = f.listFiles();
        assert allContents != null;
        Arrays.sort(allContents);
        int i = 0;
        while (i < allContents.length) {
            if (allContents[i].isDirectory()) {
                File[] subContents = allContents[i].listFiles();
                assert subContents != null;
                Arrays.sort(subContents);
                allContents = add(allContents, i, subContents); //inserts subfolders in position i of the parent folder
            }
            i++;
        }
        return allContents;
    }

    /** Inserts addition list after the pos element in the original list.
     *
     * @param original File[]
     * @param pos int
     * @param addition File[]
     * @return File[]
     * @throws FileNotFoundException
     */
    private static File[] add(File[] original, int pos, File[] addition) throws FileNotFoundException {
        int len = original.length + addition.length;
        File[] tmp = new File[len];
        int n = 0;
        for (int i = 0; i <= pos; i++) {
            tmp[n++] = original[i];
        }
        for (File anAddition : addition) {
            tmp[n++] = anAddition;
        }
        for (int i = pos+1; i < original.length; i++) {
            tmp[n++] = original[i];
        }
        return tmp;
    }

    /** Reads the file char by char, sums their values according to modulo 1024 and outputs the result.
     *
     * @param f File
     * @return int
     * @throws FileNotFoundException
     */
    private static int checkSum(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        sc.useDelimiter("");
        int sum = 0;
        while(sc.hasNext()){
            char chr = sc.next().charAt(0);
            sum = (sum + (int)chr) % 1024;
        }
        sc.close();
        return sum;
    }

    /** Uses recursion to print out all the subfolders of a folder.
     *
     * @param f File
     * @throws FileNotFoundException
     */
    private static void printFolderRec(File f) throws FileNotFoundException {
        File[] contents = f.listFiles();
        assert contents != null;
        Arrays.sort(contents);
        for (File subF : contents) {
            System.out.printf("%s\n", subF.getAbsolutePath());
            if (subF.isDirectory()) {
                printFolderRec(subF);
            }
        }
    }

    /** Iteratively prints out all the subfolders of a folder with the use of a helper method.
     *
     * @param f File
     * @throws FileNotFoundException
     */
    private static void printFolderIter(File f) throws FileNotFoundException{
        File[] contents = returnAllContents(f);
        for (File subF : contents) {
            System.out.printf("%s\n", subF.getAbsolutePath());
        }
    }

    /** Compares two files (size, name and time of last modification) and returns a String result.
     *
     * @param f1 File
     * @param f2 File
     * @return String
     * @throws FileNotFoundException
     */
    private static String compare(File f1, File f2) throws FileNotFoundException{
        String answer = "";
        if (!f1.getName().equals(f2.getName())) {
            answer += String.format("Files differ in their name:\n(1) %s\n(2) %s\n", f1.getName(), f2.getName());
        }
        if (f1.length() != f2.length()) {
            answer += String.format("Files differ in their size:\n(1) %d bytes\n(2) %s bytes\n", f1.length(), f2.length());
        }
        if (f1.lastModified() != f2.lastModified()) {
            String date1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(f1.lastModified()));
            String date2 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(f2.lastModified()));
            answer += String.format("Files differ in their last date of modification:\n" +
                    "(1) %s\n(2) %s\n", date1, date2);
        }
        return answer;
    }

    /** Compares the contents of two files and returns the count position (int) where they differ,
     *  -1 if the files are the same and 0 if it's a binary file (hasNext() returns false).
     * @param f1 File
     * @param f2 File
     * @return int
     * @throws FileNotFoundException
     */
    private static int compareContents(File f1, File f2) throws FileNotFoundException {
        Scanner sc1 = new Scanner(f1);
        Scanner sc2 = new Scanner(f2);
        sc1.useDelimiter("");
        sc2.useDelimiter("");
        if (!sc1.hasNext() || !sc2.hasNext()) {
            return 0;
        }
        int count = 1; //count the characters from 1 onward
        while (sc1.hasNext() && sc2.hasNext()) {
            char chr1 = sc1.next().charAt(0);
            char chr2 = sc2.next().charAt(0);
            if (chr1 != chr2) {
                break;
            }
            count++;
        }
        if (!sc1.hasNext() && !sc2.hasNext()) {
            count = -1;
        }
        sc1.close();
        sc2.close();
        return count;
    }
}