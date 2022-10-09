import java.util.Set;

public class ChatSystemProtocol {
    private static final int WAITING = 0;
    private static final int ASKUSERNAME = 1;
    private int state = WAITING;

    public String processInput(String theInput, Set<String> usernames) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Please enter a username";
            state = ASKUSERNAME;
        } else if (state == ASKUSERNAME) {
            if (usernames.contains(theInput)){
                theOutput = "Username already exists. Please provide a valid username.";
            } else {
                theOutput = "Your username is " + theInput + ". Welcome in the chat!";
            }
            state = WAITING;
        }

        return theOutput;
    }
}
