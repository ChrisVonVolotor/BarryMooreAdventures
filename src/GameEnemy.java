public class GameEnemy extends GameSouls{
    private String strEnemySmell;
    private String strEnemyTalk;
    private int intEnemyLocation;

    public GameEnemy(String strName, String strDesc, String strTalk, int intHealth, int intDamage, int intDefence, String strSmell, int intLocation){
        super(strName,strDesc,intHealth,intDamage,intDefence);
        strEnemySmell = strSmell;
        strEnemyTalk = strTalk;
        intEnemyLocation = intLocation;
    }

    public String getStrEnemySmell() {
        return strEnemySmell;
    }

    public String getStrEnemyTalk() {
        return strEnemyTalk;
    }


    public int getIntEnemyLocation() {
        return intEnemyLocation;
    }

    public void setIntEnemyLocation(int intEnemyLocation) {
        this.intEnemyLocation = intEnemyLocation;
    }


}
