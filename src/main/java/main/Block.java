package main;

public class Block {
    private final long id;
    private final long timeStamp;
    private final String hashOfPreviousBlock;

    public Block(long id, long timeStamp, String hashOfPreviousBlock) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.hashOfPreviousBlock = hashOfPreviousBlock;
    }

    public long getId() {
        return id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", hashOfPreviousBlock='" + hashOfPreviousBlock + '\'' +
                '}';
    }
}
