package sealed;

public class SealedMain {

    public static void main(String[] args) {
        Status status = new Approved("You are Approved");

        String result = switch (status) {
            case Approved approved -> "Approved: " + approved.getMessage();
            case Pending pending -> "Pending: " + pending.getPendingMessage();
            case Declined declined -> "Decline..." + declined.getDeclinedMessage();
        };

        System.out.println(result);
    }
}

