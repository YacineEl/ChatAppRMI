public class MessageWithPhone {
    private String senderPhoneNumber;
    private String receiverPhoneNumber;
    private String content;

    public MessageWithPhone(String senderPhoneNumber, String receiverPhoneNumber, String content) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.content = content;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageWithPhone{" +
                "Sender='" + senderPhoneNumber + '\'' +
                ", Receiver='" + receiverPhoneNumber + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
