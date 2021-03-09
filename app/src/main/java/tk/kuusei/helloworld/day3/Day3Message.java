package tk.kuusei.helloworld.day3;

public class Day3Message {
    private int id;
    private String message;
    private int picture;

    public Day3Message(int id, String message, int picture) {
        this.id = id;
        this.message = message;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public int getPicture() {
        return picture;
    }

}
