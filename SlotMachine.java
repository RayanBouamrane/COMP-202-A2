//Name: Rayan Bouamrane
//Student Number: 260788250

public class SlotMachine{
  
  public static void main(String[] args){
    //command line arguments parsed into the double format, as those are the parameters for playMachine
    playMachine(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]));
    
  }
  public static int diceRoll(){ //1a
    //random number multiplied by 6, 1 is added as (int) rounds the number down
    return (int) ((Math.random()*6)+1); //
  }
  
  public static String getSymbol(int n){ //1b
    //symbol assigned to possible values 1 to 6
    if(n==1){return "Cherries";}
    if(n==2){return "Oranges";}
    if(n==3){return "Plums";}
    if(n==4){return "Bells";}
    if(n==5){return "Melons";}
    if(n==6){return "Bars";}
    else{return "ERROR";}
  }  
  public static int getMultiplier(String a, String b, String c){ //1c
    //if all three are "Bells" (meaning one input is "Bells" and all 3 are equal) 5 is returned
    if(a.equals("Bells") && a.equals(b) && b.equals(c)){
      return 5;}
    
    //if all three are equal to each other, 3 is returned
    else if(a.equals(b) && b.equals(c)){
      return 3;}
    
    //if any two are equal to each other, 0 is returned
    else if(a.equals(b) || a.equals(c) || b.equals(c)){
      return 2;}
    else{
      return 0;}
    
  }
  public static boolean canPlay (double money, double bet){ //1d
    //money must be larger or equal to the bet, and the bet must be larger than zero.
    //true is returned if both conditions are met
    return (money>=bet&&bet>0);   
  }
  public static boolean goalReached (double money, double goal){ //1e
    //if the player has money equal to or greater than his goal, true is returned
    return (money>=goal);
  }
  public static void displaySymbols (String a, String b, String c){ //1f
    //first, the top row of hyphens is generated
    //the number of hyphens is equal to the sum of all three string lengths + 18
    //18 is the number of other strings |*| that will be present to make patterns
    //the for loop prints one hyphen for 18 + each character
    for(int i=0; i<(a.length()+b.length()+c.length()+18); i++){
      System.out.print("-");}
    System.out.print(" (¯¯¯)"); // this is prints the top part of a slot machine wheel 
    System.out.println(); //must begin from a new line
    
    //same for loop as before, as I am printing two rows of hyphens at the top, and 4 in total
    for(int i=0; i<(a.length()+b.length()+c.length()+18); i++){
      System.out.print("-");}
    System.out.print("  |¯|");
    
    System.out.println();
    
    System.out.print("|*| ");
    
    //this for loop prints spaces equal to the string.length of the first symbol
    for(int i=0; i<(a.length());i++){
      System.out.print(" ");}
    
    //this pattern is printed between symbols 1 and 2
    System.out.print(" |*| ");
    
    //same process below for 2nd and 3rd symbols, and some patterns are printed at the end
    for(int i=0; i<(b.length());i++){
      System.out.print(" ");}
    
    System.out.print(" |*| ");
    for(int i=0; i<(c.length());i++){
      System.out.print(" ");}
    System.out.print(" |*|");
    System.out.print("  | |");
    System.out.println();
    
    //symbols are being printed here in one line
    System.out.print("|*| "+a+" |*| "+b+" |*| "+c+" |*|");  
    System.out.print("  | |");
    System.out.println();
    
    //same for loops as the one that was a row above the symbols 
    System.out.print("|*| ");
    for(int i=0; i<(a.length());i++){
      System.out.print(" ");}
    
    System.out.print(" |*| ");
    for(int i=0; i<(b.length());i++){
      System.out.print(" ");}
    
    System.out.print(" |*| ");
    for(int i=0; i<(c.length());i++){
      System.out.print(" ");}
    System.out.print(" |*|");
    System.out.print(" _/ /");
    System.out.println();
    
    //2 more rows of hyphens as the last 2 rows
    for(int i=0; i<(a.length()+b.length()+c.length()+18); i++){
      System.out.print("-");}
    
    System.out.print(" __/");
    System.out.println();
    for(int i=0; i<(a.length()+b.length()+c.length()+18); i++){
      System.out.print("-");}
    System.out.println();
    
  }
  public static String formatMoney (double liquidity){ //1g
    return String.format("$%.2f", liquidity);
  }
  
  public static void playMachine (double money, double bet, double goal){ //1h
    //welcome message printed first
    System.out.println("Welcome to the Circus of Values!");
    System.out.println();
    
    //if the player cannot play (canPlay returns false) this message is printed,
    //and as the entire method is contained in an if statement, nothing else occurs
    if(!canPlay(money, bet)){
      System.out.println("You have "+formatMoney(money)+" and the bet is "+formatMoney(bet)+
                         ". Come back when you get some money buddy!");}
    
    //if the player has already met his goal, he receives this statement
    else if(goalReached(money, goal)){
      System.out.println("Hey you've got "+formatMoney(money)+
                         ". You've reached your goal of "+formatMoney(goal)+".");}
    
    //if canPlay is true, and goalReached is false, the game begins
    else{
      
      //for loop starts at 1, as the round will need to be displayed
      //the loop breaks if canPlay is false, or the goal has been reached
      //the loop continues as long as the player can play, and has not reached his goal
      for (int r=1; canPlay(money, bet) && !goalReached(money, goal); r++){
        
        //print statements inform the player of their current round, and how much they began the round with
        System.out.println("You are playing Round "+r);
        System.out.println("At the start of the round, you have: "+formatMoney(money));
        
        //during the first round only, the player is informed of how much they are betting
        if(r==1){System.out.println("You are betting "+formatMoney(bet)+".");}
        money = (money - bet);
        
        //a random number is assigned a variable so that the specific random number can be called upon later
        int dice1 = diceRoll();
        int dice2 = diceRoll();
        int dice3 = diceRoll();
        
        //Strings are declared and assigned the value of the symbol method with a corresponding dice value as input
        String Symb1 = getSymbol(dice1);
        String Symb2 = getSymbol(dice2);
        String Symb3 = getSymbol(dice3);
        displaySymbols(Symb1, Symb2, Symb3);
        
        //the money won in a round is the multiplier times the bet,
        //and the player is informed as to how much they won this round
        double moneyWon = getMultiplier(Symb1, Symb2, Symb3)*bet;
        System.out.println("Money won this round: "+formatMoney(moneyWon));
        
        //now money is equal to the money won plus how much they had when the bet was subtracted
        //the player is informed of this
        money = money +(moneyWon);
        System.out.println("You now have this much money: "+formatMoney(money));
        System.out.println();
        
        //if canPlay is false, the player can no longer cover a bet, and is given a sad message
        if(!canPlay(money, bet)){
          System.out.println("Sorry buddy, the house always wins. You're left with: "+formatMoney(money)+".");}
        
        //if goalReached is true, the player reached their goal and is finished. They are given a happy message
        if(goalReached(money, goal)){
          System.out.println("Hey, I've got a family to feed! You reached your goal of "+formatMoney(goal)+
                             ". You've got "+formatMoney(money)+" to keep. Congratulations.");
        }
      }
    }
  }
}
