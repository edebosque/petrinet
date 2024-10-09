public class Arc {
    private int value;
    
    public Arc(){
        this.value = 1;
    }

    public Arc(int value){
        this.value = value;
    }

    public void setValue( int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
