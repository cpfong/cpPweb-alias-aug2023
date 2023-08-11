import java.io.*;
public class FinderWithArgs {
    public static void main(String[] args){
        if (args.length != 2) {
            System.err.println("Error: 2 arguments are required.");
            System.exit(2);
        }
        else {
            FinderWithArgs aFind = new FinderWithArgs();
            aFind.doSearch(args[0], args[1]);
        }
    }

    private void doSearch(String fileName, String wanted) {

        // search the file as before...

    }
}






