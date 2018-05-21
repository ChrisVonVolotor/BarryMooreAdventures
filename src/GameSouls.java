public abstract class GameSouls {
    private String strSoulName;
    private String strSoulDescription;
    private int intSouldHealth;
    private int intSoulDamage;
    private int intSoulDefence;

    public GameSouls(String strName, String strDesc, int intHealth, int intDamage, int intDefence){
        strSoulName = strName;
        strSoulDescription = strDesc;
        intSouldHealth = intHealth;
        intSoulDamage = intDamage;
        intSoulDefence = intDefence;
    }

    public String getStrSoulName() {
        return strSoulName;
    }

    public String getStrSoulDescription() {
        return strSoulDescription;
    }

    public int getIntSouldHealth() {
        return intSouldHealth;
    }

    public String lookSoulHealth(){
        if (intSouldHealth >= 10){
            return "Looks quite strong";
        }else if (intSouldHealth >= 8){
            return "Looks quite healthy";
        }else if (intSouldHealth >= 5){
            return "Looks a little tired";
        }else{
            return "Looks like it needs a doctor";
        }
    }

    public int QuickAttack(){
        double intHit = Math.random() * 100;
        if (intHit > 5){
            return (int)(intSoulDamage * 0.75) ;
        }else {
            return -1;
        }
    }

    public int HeavyAttack(){
        double intHit = Math.random() * 100;
        if (intHit > 30){
            return (int)(intSoulDamage * 1.5) ;
        }else {
            return -1;
        }
    }

    public int StandardAttck(){
        double intHit = Math.random() * 100;
        if (intHit > 15){
            return (int)(intSoulDamage) ;
        }else {
            return -1;
        }
    }



    public int Defence(){
        return (int)(double)((intSoulDefence/10) * 25);
    }


}
