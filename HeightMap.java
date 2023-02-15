import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class HeightMap {

    private ArrayList<Coordinates> coordinates;
    private ArrayList<Polygon> polygons;
    private int width;
    private int height;

    /**
     * Creates a new heightmap and populates it's coordinates
     * and creates polygons based on the coordinates.
     * @param width of the heightmap
     * @param height of the heightmap
     */
    public HeightMap(int width, int height) {
        this.coordinates = new ArrayList<>();
        this.polygons=new ArrayList<>();
        this.width=width;
        this.height=height;
        generateCoordinates();
        generatePolygons();
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public  void addCoordinates(Coordinates coordinates){
        this.coordinates.add(coordinates);
    }

    /**
     * Fills the coordinates array with new coordinates
     * based on the heightmap width and height
     */
    public void generateCoordinates(){
        this.coordinates.clear();
        for(int i=0;i<width;i++){
            for(int j =0;j<height;j++){
                Coordinates coordinates=new Coordinates(i,j);
                this.coordinates.add(coordinates);
            }
        }
    }
    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * Generates square polygons for the polygon array from the coordinates
     */
    public void generatePolygons(){
        for(int i=1;i<=this.coordinates.size();i++){
            if(i%width!=0){
                if(!(i>width*height-width)){
                    System.out.println("Adding: "+i+" "+(i+1)+" "+(i+width)+" "+(i+width+1));
                    Polygon polygon=new Polygon(i,i+1,i+width+1,i+width);
                    this.polygons.add(polygon);
                }
            }
        }
    }
    public ArrayList<Polygon> getPolygons(){
        return polygons;
    }

    /**
     * Generates a terrain.obj file from the coordinates and polygons.
     * The 3D object has smooth shading, but no material.
     *
     */
    public void writeObj(){
        try {
            FileWriter myWriter = new FileWriter("terrain.obj");
            myWriter.write("o Terrain\n\n");
            for(Coordinates c:this.coordinates){
                myWriter.write(c.toString());
            }
            myWriter.write("\n");
            myWriter.write("usemtl None");
            myWriter.write("\n");
            myWriter.write("s on");
            myWriter.write("\n");

            for(Polygon p:this.polygons){
                myWriter.write(p.toString());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
