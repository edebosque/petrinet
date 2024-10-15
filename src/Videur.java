public class Videur extends Arc_out {

    @Override
    public Boolean isTriggerable(){
        return (this.place.nbJetons == 0);
    }

}
