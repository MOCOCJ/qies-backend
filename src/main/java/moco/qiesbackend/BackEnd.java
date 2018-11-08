package moco.qiesbackend;

public class BackEnd {

    public static void main(String[] args) {
        int exitCode = 0;

        if (args.length != 4) {
            log.log(Level.SEVERE, "Incorrect number of arguments " + args.length);
            exitCode = 1;
            System.exit(exitCode);
        }

        // Do parsing and file stuff here

        System.exit(exitCode);
    }
}
