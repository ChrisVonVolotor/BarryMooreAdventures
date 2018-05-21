import java.util.ArrayList;

public class GamePlayer extends GameSouls{
    private ArrayList<GameItem> arlPlayerInventory = new ArrayList<GameItem>();
    private int intPlayerMaxHealth;
    private int intPlayerCurrentLocation;
    public GamePlayer(String strName, String strDesc, int intHealth, int intDamage, int intDefence, int intMaxHealth, int CurrentLocation){
        super(strName,strDesc,intHealth,intDamage,intDefence);
        intPlayerMaxHealth = intMaxHealth;
        intPlayerCurrentLocation = CurrentLocation;
    }

    public ArrayList<GameItem> getArlPlayerInventory() {
        return arlPlayerInventory;
    }

    public void addItemtoInventory(GameItem item) {
        arlPlayerInventory.add(item);
    }

    public String listInventory(){
        int intFlav = (int)(Math.random() * 10);
        String strReturnText = "";
        if (arlPlayerInventory.size() == 0){
            if (intFlav > 8){
                strReturnText = "Nothing but us Chickens";
            }else if(intFlav > 6){
                strReturnText = "A bit of lint and a few buttons";
            }else if(intFlav > 3){
                strReturnText = "$100000! Only kidding. Go on off you trot, my son";
            }else{
                strReturnText = "You don't need anything because your too cool.";
            }
        }else{
            for (GameItem item: arlPlayerInventory
                 ) {
                intFlav = (int)(Math.random() * 10);
                if (intFlav > 8){
                    strReturnText += "A lonely [" + item.getStrItemName() + "], ";
                }else if(intFlav > 6){
                    strReturnText += "A tasty looking [" + item.getStrItemName() + "] DO NOT EAT,  ";
                }else if(intFlav > 3){
                    strReturnText += "A fresh [" + item.getStrItemName() + "], ";
                }else{
                    strReturnText += "A non-refundable [" + item.getStrItemName() + "], ";
                }

            }
        }


        return strReturnText;
    }


    public String lookSoulHealth(){
        if (getIntSouldHealth() >= (intPlayerMaxHealth * 0.8)){
            return "You feel like Superman";
        }else if (getIntSouldHealth() >= (intPlayerMaxHealth * 0.5)){
            return "You really could do this all day";
        }else if (getIntSouldHealth() >= (intPlayerMaxHealth * 0.3)){
            return "oo oof owie, Your bones";
        }else{
            return "You should probably consider writing a will";
        }
    }

    public void setIntPlayerCurrentLocation(int intPlayerCurrentLocation) {
        this.intPlayerCurrentLocation = intPlayerCurrentLocation;
    }

    public int getIntPlayerCurrentLocation() {
        return intPlayerCurrentLocation;
    }
}
