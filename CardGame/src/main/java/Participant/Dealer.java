package Participant;

public class Dealer extends Participant {

    public Dealer(String name){
        super(name);

    }



    public int firstCard(){
        return this.getHand().get(0).getValueFromEnum();
    }



    public boolean wantsToHit(){
        boolean result = false;

            if (handTotal() < 17) {
                result = true;

        }
        return result;

    }



}