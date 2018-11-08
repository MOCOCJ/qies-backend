package moco.qiesbackend;

public class BackEnd {

    public static void main(String[] args) {
        int exitCode = 0;

        if (args.length != 4) {
            log.log(Level.SEVERE, "Incorrect number of arguments " + args.length);
            exitCode = 1;
            System.exit(exitCode);
        }

        // inputs are
        // the file name of the Merged Transaction Summary File,
        // the file name of the old Central Services File,
        // the file name of the new Central Services File, and
        // the file name of the new Valid Services File.

        // Do parsing and file stuff here

        System.exit(exitCode);
    }
}
