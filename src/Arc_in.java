public class Arc_in extends Arc {

    private Place place;
  
    public void trigger(){
        this.place.addJetons(this.getValue());
    }

}
