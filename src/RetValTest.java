import java.rmi.server.ExportException;

public class RetValTest {
    public static String sEmail = "";

    static class emptySentenceException extends Exception {
        public emptySentenceException(){
            super("Supplied string empty");
        }
    }

    static class noCamAddressException extends Exception{
        public noCamAddressException(){
            super("No @cam address in supplied string");
        }
    }

    public static void extractCamEmail(String sentence) throws emptySentenceException,noCamAddressException {
        if (sentence==null || sentence.length()==0){
            throw new emptySentenceException();
        }

        String tokens[] = sentence.split(" "); // split into tokens

        for (int i=0; i< tokens.length; i++) {
            if (tokens[i].endsWith("@cam.ac.uk")) {
                sEmail=tokens[i];
                return;
            }
        }

        throw new noCamAddressException();
    }
    public static void main(String[] args) {
        try {
            RetValTest.extractCamEmail("My email is rkh23@cam.ac.uk");
            System.out.println("Success: " + RetValTest.sEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}