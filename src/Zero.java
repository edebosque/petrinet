public class Zero extends Arc_out {

    Place place;
    public Zero(Place place) {
        super(place);
    }

    @Override
    public Boolean isTriggerable(){

        return false;
    }
}
