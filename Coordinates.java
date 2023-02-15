import java.util.Random;

public class Coordinates {
    public double x;
    public double y;
    public double z;
    public static final int MIN_HEIGHT=-5;
    public static final int MAX_HEIGHT=5;

    /**
     * Creates new coordinates with a random z-value
     * @param x width of the object
     * @param y lenght of the object
     */
    public Coordinates(double x, double y) {

        this.x = x;
        this.y = y;
        this.z = getRandomHeight();
    }

    /**
     * Randomizes the z-coordinate of the coordinates.
     * @return z coordinate as double
     */
    public double getRandomHeight(){
        Random random=new Random();
        double height=random.nextDouble()*(MAX_HEIGHT-MIN_HEIGHT)+MIN_HEIGHT;
        if(height<-5 || height>5){ //in case value is out of bounds set it to 0
            return 0.0;
        }
        return height/5;
    }
    @Override
    public String toString(){
        return "v "+x+" "+String.valueOf(z).substring(0,5)+" "+y+"\n";
    }
}
