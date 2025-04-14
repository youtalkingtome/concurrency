package sealed;


sealed interface Status permits Approved, Pending, Declined {}

final class Approved implements Status {
    private final String message;

    public Approved(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

final class Pending implements Status {
    private final String pendingMessgae;

    public Pending(String pendingMessgae) {
        this.pendingMessgae = pendingMessgae;
    }

    public String getPendingMessage() {
        return pendingMessgae;
    }
}
final class Declined implements Status {
    private final String declinedMessage;

    public Declined(String declinedMessage) {
        this.declinedMessage = declinedMessage;
    }

    public String getDeclinedMessage() {
        return declinedMessage;
    }
}
