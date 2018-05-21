public class GameItem {
    private String strItemName;
    //private String strItemLocation;
    private String strItemDescription;
    private int intItemAttackUp;
    private int intItemDefenceUp;
    private int intItemHealthUp;
    private boolean booItemOpenDoor;
    private int intItemLocation;

    public GameItem(String strName,String strDesc, int intAttackUp, int intDefenceUp, int intHealthUp, boolean booOpen, int intLocation ){
        strItemName = strName;
        strItemDescription = strDesc;
        intItemAttackUp = intAttackUp;
        intItemDefenceUp = intDefenceUp;
        intItemHealthUp = intHealthUp;
        intItemLocation = intLocation;
        booItemOpenDoor = booOpen;

    }

    public void setIntItemLocation(int intItemLocation) {
        this.intItemLocation = intItemLocation;
    }

    public int getIntItemAttackUp() {
        return intItemAttackUp;
    }

    public int getIntItemDefenceUp() {
        return intItemDefenceUp;
    }

    public int getIntItemHealthUp() {
        return intItemHealthUp;
    }

    public int getIntItemLocation() {
        return intItemLocation;
    }

    public boolean isBooItemOpenDoor() {
        return booItemOpenDoor;
    }

    public String getStrItemDescription() {
        return strItemDescription;
    }

    public String getStrItemName() {
        return strItemName;
    }
}
