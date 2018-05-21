public class GameEnemyWander extends GameEnemy {
    public GameEnemyWander(String strName, String strDesc, String strTalk, int intHealth, int intDamage, int intDefence, String strSmell, int intLocation){
        super(strName,strDesc,strTalk,intHealth,intDamage,intDefence,strSmell,intLocation);

    }



    public void wanderEnemy(int roomCount){
        int intRandomLocation = (int)(Math.round(Math.random() * roomCount));
        setIntEnemyLocation(intRandomLocation) ;
    }
}
