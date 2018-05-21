import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class GameArea{
   // private Game
    Scanner sc = new Scanner(System.in);

    private ArrayList<GameRoom> arlRoomMap = new ArrayList<GameRoom>();
    private ArrayList<GameEnemy> arlMonsterFolio = new ArrayList<GameEnemy>();
    private ArrayList<GameItem>  arlItemFolio = new ArrayList<GameItem>();
    private ArrayList<GameItem> arlCurrItemss;
    private ArrayList<GameEnemy> arlCurrEnemys;
    private GameRoom grCurrentRoom;

    private GamePlayer barry = new GamePlayer("Barry", "This is you mate", 10,5,5,10,1);


    public boolean gameOpen(){
        gameLoadMap();
        System.out.println("\"AAAAAAAAAAAAAAAAAAhh! MY HEAD!\"");
        System.out.println("That was Barry. Who is you. You see you wne out last night for your mate Joe's quarter birthday party");
        System.out.println("Now Barry, who is you, but you are not me, I am standing in the corner losing my religion");
        System.out.println("Wait... \nSorry i got distracted. You have a rip roaring hangover and you have got to get home");

        System.out.println("Also you lost your keys and you have no idea where they are...");



        System.out.println("well hit [ENTER] when you want to begin. Type Help at any point after this for controls.");
        sc.nextLine();
       return gameController();

    }

    private boolean gameController(){
        boolean booGameOn = true;
        String strCommand;
        boolean booKey = false;
        while(booGameOn){



            strCommand = currentRoomTurn();

            switch (strCommand.toLowerCase()){
                case "help":
                    System.out.println();
                    System.out.println("The possible commands are: ");
                    System.out.println("Help - Get a list of controls... well yeah");
                    System.out.println("Go - Got in an available direction: North/East/South/West]");
                    System.out.println("Pickup - Pickup and [item] and add tot he inventory");
                    System.out.println("Inventory - view you inventory");
                    System.out.println("Sniff - Smell someone (for weirdo's)");
                    System.out.println("Talk - Talk to someone (for even bigger weirdo's");
                    System.out.println("Attack - Attack someone (for more reasonable weirdos's)");
                    System.out.println();
                    break;
                case "go":
                    do {
                        System.out.println("Please select a direction:");
                        strCommand = sc.nextLine();
                    }while(!((strCommand.equalsIgnoreCase("north")) || (strCommand.equalsIgnoreCase("east")) || (strCommand.equalsIgnoreCase("south")) || (strCommand.equalsIgnoreCase("west"))));
                    if (strCommand.equalsIgnoreCase("north")){
                        changeRoom(1,grCurrentRoom.getIntRoomNorth());
                    }else if(strCommand.equalsIgnoreCase("east")){
                        changeRoom(2,grCurrentRoom.getIntRoomEast());
                    }else if (strCommand.equalsIgnoreCase("south")){
                        changeRoom(3,grCurrentRoom.getIntRoomSouth());
                    }else if (strCommand.equalsIgnoreCase("west")){
                        changeRoom(4,grCurrentRoom.getIntRoomWest());
                    }
                    break;
                case "pickup":
                    boolean booPickupLoop = true;
                    if(arlCurrItemss.size() == 0){
                        System.out.println();
                        System.out.println("There is nothing to pickup!");
                        System.out.println();
                    }
                    do {
                        System.out.println("What do you want to pickup. [cancel] to cancel");
                        strCommand = sc.nextLine();
                        for (GameItem item: arlCurrItemss
                             ) {
                            if (strCommand.equalsIgnoreCase(item.getStrItemName())){
                                pickupItem(item);
                                booPickupLoop =false;
                                break;
                            }else if(strCommand.equalsIgnoreCase(("cancel"))){
                                System.out.println();
                                System.out.println("Oh, never mind then");
                                booPickupLoop =false;

                                System.out.println();
                            }else{
                                System.out.println("I can't find this item");
                            }
                        }
                    }while (booPickupLoop);
                    break;

                case "inventory":
                    System.out.println(barry.listInventory());
                    break;
                case "sniff":
                    boolean booSniffLoop = true;
                    if(arlCurrEnemys.size() == 0){
                        System.out.println();
                        System.out.println("There is nothing to sniff!");
                        System.out.println();
                    }
                    do {
                        System.out.println("Who do you want to sniff, weirdo. [cancel] to cancel");
                        strCommand = sc.nextLine();
                        for (GameEnemy enemy: arlCurrEnemys
                                ) {
                            if (strCommand.equalsIgnoreCase(enemy.getStrSoulName())){
                                System.out.println(enemy.getStrEnemySmell());
                                booPickupLoop =false;
                                break;
                            }else if(strCommand.equalsIgnoreCase(("cancel"))){
                                System.out.println();
                                System.out.println("Oh, never mind then");
                                booPickupLoop =false;

                                System.out.println();
                            }else{
                                System.out.println("I can't find this person");
                            }
                        }
                    }while (booSniffLoop);
                    break;
                case "talk":
                    boolean booTalkLoop = true;
                    if(arlCurrEnemys.size() == 0){
                        System.out.println();
                        System.out.println("There is nothing to talk to, you could talk to yourself, I'll only judge you silently");
                        System.out.println();
                    }
                    do {
                        System.out.println("Who do you want to talk to, mr. social butterfly you. [cancel] to cancel");
                        strCommand = sc.nextLine();
                        for (GameEnemy enemy: arlCurrEnemys
                                ) {
                            if (strCommand.equalsIgnoreCase(enemy.getStrSoulName())){
                                System.out.println(enemy.getStrEnemyTalk());
                                booTalkLoop =false;
                                break;
                            }else if(strCommand.equalsIgnoreCase(("cancel"))){
                                System.out.println();
                                System.out.println("Oh, never mind then");
                                booTalkLoop =false;

                                System.out.println();
                            }else{
                                System.out.println("I can't find this person");
                            }
                        }
                    }while (booTalkLoop);
                    break;
                case "attack":
                    boolean booAttackLoop = true;
                    if(arlCurrEnemys.size() == 0){
                        System.out.println();
                        System.out.println("There is nothing to attack!");
                        System.out.println();
                    }
                    do {
                        System.out.println("Who do you want to attack Mr.Tough-guy. [cancel] to cancel");
                        strCommand = sc.nextLine();
                        for (GameEnemy enemy: arlCurrEnemys
                                ) {
                            if (strCommand.equalsIgnoreCase(enemy.getStrSoulName())){
                                fightEnemy(enemy);
                                booAttackLoop =false;
                                break;
                            }else if(strCommand.equalsIgnoreCase(("cancel"))){
                                System.out.println();
                                System.out.println("Oh, never mind then");
                                booAttackLoop =false;

                                System.out.println();
                            }else{
                                System.out.println("I can't find this person");
                            }
                        }
                    }while (booAttackLoop);
                }


            System.out.println("hit enter to continue;");
                sc.nextLine();
/*
                for (GameEnemy enemy: arlMonsterFolio){
                    System.out.println(enemy.getClass());
                    if (enemy.getClass().equals("class GameEnemyWander") ){
                        (GameEnemyWander) enemy.wanderEnemy
                    }
                }
                */

            for (GameItem item: barry.getArlPlayerInventory()
                    ) {
                if(item.isBooItemOpenDoor() == true){
                    booKey = true;
                }

            }

            if (grCurrentRoom.getIntRoomID() == 16 && booKey == true ){
                System.out.println("Well done you made it home and unlocked you door");
                System.out.println("The rest of Barry's troubles are out of you hand");
                System.out.println("Like whe the his boss calls to find out why he didn't show up for work");
                System.out.println("Or when his partner finds out what he's bee up too");
                System.out.println("but in the meantime dear player, sit back and have a pint.");
                booGameOn = false;
            }
        }

        do {
            System.out.println("Would you like to play again?");
            strCommand = sc.nextLine();
        }while(!((strCommand.equalsIgnoreCase("Y")) || (strCommand.equalsIgnoreCase("N"))));

        if (strCommand.equalsIgnoreCase("Y")){
            return true;
        }else {
            return false;
        }
    }

    private void fightEnemy(GameEnemy geEnemy){
       // return;
        boolean booFightOn = true;
        String strAttackCommand = "";
        int intPlayerHealth = barry.getIntSouldHealth();
        int intEnemyHealth = geEnemy.getIntSouldHealth();

        int intTempAtt;
        int intTempDef;
        int intAIatt;

        while (booFightOn) {
            do {
                System.out.println("please select an attack: Quick, Heavy or Normal");
                strAttackCommand = sc.nextLine();
            }
            while (!(strAttackCommand.equalsIgnoreCase("Quick") || strAttackCommand.equalsIgnoreCase("Heavy") || strAttackCommand.equalsIgnoreCase("Normal")));

            if (strAttackCommand.equalsIgnoreCase("Quick")) {
                intTempAtt = barry.QuickAttack() - geEnemy.Defence();
            } else if (strAttackCommand.equalsIgnoreCase("Heavy")) {
                intTempAtt = barry.HeavyAttack() - geEnemy.Defence();
            } else {
                intTempAtt = barry.StandardAttck() - geEnemy.Defence();
            }
            if (intTempAtt < 0) {
                intTempAtt = 0;
                System.out.println("You Miss");
            } else {
                intEnemyHealth -= intTempAtt;

                System.out.println("You hit for " + intTempAtt);
            }


            if (intEnemyHealth <= 0) {
                booFightOn = false;
                System.out.println("Congrats you breat up this poor innocent soul");
                geEnemy.setIntEnemyLocation(0);
            }


            intAIatt = (int) (Math.random() * 10);
            if (intAIatt > 7) {
                intTempAtt = geEnemy.QuickAttack() - barry.Defence();

            } else if (intAIatt > 5) {
                intTempAtt = geEnemy.HeavyAttack() - barry.Defence();

            } else {
                intTempAtt = geEnemy.StandardAttck() - barry.Defence();

            }

            if (intTempAtt < 0) {
                intTempAtt = 0;
                System.out.println("They Miss");
            } else {
                intEnemyHealth -= intTempAtt;

                System.out.println("You get hit for " + intTempAtt);
            }




            if (intPlayerHealth <= 0){
                booFightOn = false;
                System.out.println("BRO YOU JUST GOT CRUSHED!");
                System.out.println("You wake up at the beer Garden... Did that just happen. Or did it!");
                barry.setIntPlayerCurrentLocation(1);
            }


        }


    }
    private void changeRoom(int intNewRoom){
        barry.setIntPlayerCurrentLocation(intNewRoom);
    }


    private void pickupItem(GameItem giItem){
        barry.addItemtoInventory(giItem);
        for (GameItem item: arlItemFolio
             ) {
            if(giItem.getStrItemName().equals(item.getStrItemName())){
                item.setIntItemLocation(0);
                System.out.println("you picked up the " + giItem.getStrItemName());
            }

        }

    }

    private void changeRoom(int direction, int intNewRoom){
        if (intNewRoom == 0){
            System.out.println();
            System.out.println("You CANNOT go this way you plonker!");
            System.out.println();
        }else{
            if (direction == 1){
                barry.setIntPlayerCurrentLocation(intNewRoom);

            }else if (direction == 2){
                barry.setIntPlayerCurrentLocation(intNewRoom);

            }else if (direction == 3){
                barry.setIntPlayerCurrentLocation(intNewRoom);

            }else if (direction == 4){
                barry.setIntPlayerCurrentLocation(intNewRoom);

            }
        }

    }

    public String  currentRoomTurn(){
        int intCurrentRoom = barry.getIntPlayerCurrentLocation();
        String struserCommand;

        System.out.println(aboutRoom(intCurrentRoom, true));
        arlCurrEnemys = currentRoomEnemies();
        arlCurrItemss = currentRoomItems();
        grCurrentRoom = currentRoom();

        System.out.println("To the [North]:" + aboutRoom(grCurrentRoom.getIntRoomNorth()) );
        System.out.println("To the [East]:" + aboutRoom(grCurrentRoom.getIntRoomEast()) );
        System.out.println("To the [South]:" + aboutRoom(grCurrentRoom.getIntRoomSouth()) );
        System.out.println("To the [West]:" + aboutRoom(grCurrentRoom.getIntRoomWest()) );
        System.out.println();
        System.out.println();
        if (arlCurrEnemys.size() == 0){
            System.out.println("There are no people here");
        }else {
            for (GameEnemy enemy: arlCurrEnemys
                 ) {
                System.out.println("You can see [" + enemy.getStrSoulName() + "], " + enemy.getStrSoulDescription());
            }

        }

        System.out.println();
        if (arlCurrItemss.size() == 0){
            System.out.println("There are no usable junk... I mean items about");
        }else {
            for (GameItem item: arlCurrItemss
                    ) {
                System.out.println("On the floor you can see [" + item.getStrItemName() + "], " + item.getStrItemDescription());
            }

        }

        System.out.println();
        do{
            System.out.println("What would you like to do?");
            struserCommand = sc.nextLine();
            String[] arrCommand = struserCommand.split(" ");

        }while (!((struserCommand.toLowerCase().contains("help")) || (struserCommand.toLowerCase().contains("go")) ||(struserCommand.toLowerCase().contains("attack")) || (struserCommand.toLowerCase().contains("pickup")) ||
                (struserCommand.toLowerCase().contains("inventory")) || (struserCommand.toLowerCase().contains("sniff"))));

        return struserCommand;
    }


    private GameRoom currentRoom(){
        int intCurrentRoom = barry.getIntPlayerCurrentLocation();
        GameRoom grTemp;
        for(GameRoom grCurRoom: arlRoomMap){
            if (grCurRoom.getIntRoomID() == intCurrentRoom){
                grTemp = grCurRoom;
                return grCurRoom;
            }
        }
        return null;
    }

    private ArrayList<GameEnemy> currentRoomEnemies(){
        int intCurrentRoom = barry.getIntPlayerCurrentLocation();
        ArrayList<GameEnemy> arlReturnEnemy = new ArrayList<GameEnemy>();
        for (GameEnemy geCurEnemy: arlMonsterFolio
             ) {
            if (geCurEnemy.getIntEnemyLocation()==intCurrentRoom){
                arlReturnEnemy.add(geCurEnemy);


            }

        }
        return arlReturnEnemy;
    }

    private ArrayList<GameItem> currentRoomItems(){
        int intCurrentRoom = barry.getIntPlayerCurrentLocation();
        ArrayList<GameItem> arlReturnItem = new ArrayList<GameItem>();
        for (GameItem giCurItem: arlItemFolio
                ) {
            if (giCurItem.getIntItemLocation()==intCurrentRoom){
                arlReturnItem.add(giCurItem);


            }

        }
        return arlReturnItem;
    }

    private String aboutRoom(int intRoomID) {
        String strAboutRoomName ="";
        if (intRoomID == 0) {
            double intFlav = Math.random() *10;
            if (intFlav > 7){
                return "is impassable";
            }
            else if (intFlav > 5){
                return "is a no-no right now";
            }
            else if (intFlav > 2){
                return "is a wall";
            }
            else {
                return "is a giant enemy crab. That is a no-no";
            }
        } else {
            for (GameRoom grFindCurrent : arlRoomMap
                    ) {
                if (grFindCurrent.getIntRoomID() == intRoomID) {
                    strAboutRoomName = grFindCurrent.getStrRoomName();

                    break;

                }



            }
            return strAboutRoomName;
        }

    }


    private String aboutRoom(int intRoomID, boolean fullDesc) {
        String strAboutRoomName ="";
        String strAboutRoomDesc ="";
        if (intRoomID == 0) {
            double intFlav = Math.random() * 10;
            if (intFlav > 7) {
                return " is impassable";
            } else if (intFlav > 5) {
                return " is a no-no right now";
            } else if (intFlav > 2) {
                return " is a wall";
            } else {
                return " is a giant enemy crab. That is a no-no";
            }
        } else {
            for (GameRoom grFindCurrent : arlRoomMap
                    ) {
                if (grFindCurrent.getIntRoomID() == intRoomID) {
                    strAboutRoomName = grFindCurrent.getStrRoomName();
                    strAboutRoomDesc = grFindCurrent.getStrRoomDescription();
                    break;

                }


            }

            return strAboutRoomName + "\n" + strAboutRoomDesc;
        }
    }







    private void gameLoadMap(){
        arlRoomMap.add(new GameRoom(1,"Ray's Beer Garden", "A large empty garden, you can see the left overs of a party", 0, 0, 2, 0, 2));
        arlRoomMap.add(new GameRoom(2,"Hangman's Square", "The town square, it's where they hanged people on fridays way back when.\n According to legend they also had BBqs on saturdays. Hmmmm", 1, 3, 0, 7, 1));
        arlRoomMap.add(new GameRoom(3,"24/7 Two-Stop", "The worlds worst convenience store, only sells bananas", 0, 4, 5, 2, 1));
        arlRoomMap.add(new GameRoom(4,"East End", "A small ware house district. Named after the TV Soap", 0, 0, 0, 3, 1));
        arlRoomMap.add(new GameRoom(5,"Alba's Passage", "A derelict side street, Rumour has it Jessica Alba once sneered in disgust here", 3, 0, 6, 0, 1));
        arlRoomMap.add(new GameRoom(6,"Mikey's Burger Strand", "Hey it's Mikey's all you can grease burgers. Smells suspicious.\n This must be the work of an enemy stand", 5, 0, 14, 11, 1));
        arlRoomMap.add(new GameRoom(7,"Old Town Centre", "The old town centre, derelict and old", 0, 2, 8, 0, 1));
        arlRoomMap.add(new GameRoom(8,"New Town Centre", "The new town centre derelict and new", 7, 0, 9, 0, 1));
        arlRoomMap.add(new GameRoom(9,"Not-New but Not-Old Town Centre", "Funny story, its actually derelict.", 8, 11, 10, 0, 1));
        arlRoomMap.add(new GameRoom(10,"15 Park Hotel", "If you squint you can see legitimate business people", 9, 0, 12, 0, 1));
        arlRoomMap.add(new GameRoom(11,"Windy Road", "how many roads must I walk down before I become a man, the answer my friend is at the bottom of a Pint", 0, 6, 0, 9, 1));
        arlRoomMap.add(new GameRoom(12,"Queens Way", "A small relatively nice street. What expecting something negative?", 10, 13, 0, 0, 1));
        arlRoomMap.add(new GameRoom(13,"Bologna Rectory", "Not food, the town church. a sink hole for the towns money trying to repair the towns roof.", 0, 0, 15, 12, 1));
        arlRoomMap.add(new GameRoom(14,"Holdup Point Hill", "A hill overlooking the town, if you squint you can pretend its an ok place to live", 6, 0, 0, 0, 1));
        arlRoomMap.add(new GameRoom(15,"Roy's Beer Garden", "This is where we started drinking. God bless Roy he always has the best moonshine.", 13, 0, 16, 0, 1));
        arlRoomMap.add(new GameRoom(16,"Home Sweet Home", "It's not much but it's cheap, and derelict.", 15, 0, 0, 0, 3));

        arlMonsterFolio.add(new GameEnemy("Morris Morris", "The town drunk, his middle name is Morris", "I've decided to get my life together and drink more ", 7, 2,1,"Smells like booze",1));
        arlMonsterFolio.add(new GameEnemyWander("Fred the Furry", "Fred just likes to pretend he's a gerbil, good on ya Fred", "OwO What's This?", 5, 3,2,"Smells... is that after shave!?", 16));
        arlMonsterFolio.add(new GameEnemy("Betty Bologna", "The chaplains wive, always 'think of the children' this and 'you can't do that in public' that", "Not seen you at work recently Barry", 4, 1,7,"Smells annoying", 13));
        arlMonsterFolio.add(new GameEnemy("Justin Judo", "The town hero, got 2817th place at the National Judo Cup. Show off.", "And I chop, chop, chop.", 11, 5,6,"Smells like sweat and not being 2816th place.", 10));
        arlMonsterFolio.add(new GameEnemy("Mikel Wonderwall", "Can't go to a party without that bleeding guitar.", "Today's gonna be the day.", 6, 3,3,"Smells like a pretentious git", 5));
        arlMonsterFolio.add(new GameEnemy("Bandit Brenda", "An older woman who likes to pretend to be a bandit. Don't ask", "And I chop, chop, chop.", 8, 2,4,"Smells like she rolled in... something", 14));

        arlItemFolio.add(new GameItem("Door Key","Hey, its my door key. Smells like beer", 0,0,0,true,12));
        arlItemFolio.add(new GameItem("Crowbar","The tool for any legitimate business man", 3,0,0,false,1));
        arlItemFolio.add(new GameItem("Large Duster","A large duster jacket. used in legitimate business dealings", 0,3,0,false,11));
        arlItemFolio.add(new GameItem("12-Pack for beer","Numbs pain and builds confidence", 0,0,3,false,8));
        arlItemFolio.add(new GameItem("Special Sauce","Take one every turn. Hmmm, sure why not", 1,1,1,false,6));






    }


}
