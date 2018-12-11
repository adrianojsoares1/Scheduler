package Resource;

public abstract class Resource{
    private String id;
    private int startIdleTime;
    private int nextUnblockTime;
    private int activeTime, idleTime;


    public abstract int generateBlockTime();


}