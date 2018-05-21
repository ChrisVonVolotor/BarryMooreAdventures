public class GameRoom {
    private int intRoomID;
    private String strRoomName;
    private String strRoomDescription;
    private int intRoomNorth;
    private int intRoomEast;
    private int intRoomSouth;
    private int intRoomWest;
    //0=wall, 1=standard, 2=start, 3 = exit
    private int intRoomState;


    public GameRoom(int intID, String strName, String strDesc, int intNorth, int intEast, int intSouth, int intWest, int strRoomState ){
        intRoomID = intID;
        strRoomName = strName;
        strRoomDescription = strDesc;
        intRoomNorth = intNorth;
        intRoomSouth = intSouth;
        intRoomWest = intWest;
        intRoomEast = intEast;
    }



    public int getIntRoomID() {
        return intRoomID;
    }



    public String AboutRoom(){
        int intFlav = (int)(Math.random() * 10);
        if(intRoomState == 1){
            if (intFlav > 7) {
                return "It's really nothing special";
            }
            else if (intFlav > 5){
                return "Could be a good date spot";
            }
            else if (intFlav > 4){
                return "The council has really let this place go";
            }else if(intFlav > 2){
                return "Hardly prime real estate";
            }else {
                return "I'm on the road to nowhere, so get in and ride. Wait are those the right lyrics?";
            }
        }else if(intRoomState == 2){
            return "Wait, is this really where you started!";
        }else if(intRoomState == 3){
            return "Looks like your in the clear";
        }
        return "Am I supposed to be seeing this?";
    }

    public String getStrRoomName() {
        return strRoomName;
    }

    public int getIntRoomEast() {
        return intRoomEast;
    }

    public int getIntRoomNorth() {
        return intRoomNorth;
    }

    public int getIntRoomSouth() {
        return intRoomSouth;
    }

    public int getIntRoomState() {
        return intRoomState;
    }

    public int getIntRoomWest() {
        return intRoomWest;
    }

    public String getStrRoomDescription() {
        return strRoomDescription;
    }
}
