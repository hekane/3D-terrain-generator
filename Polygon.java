public class Polygon {
    private int[] vertex =new int[4];

    /**
     * Creates a new polygon
     * @param p1 is the first vertex of the polygon
     * @param p2 is the second vertex of the polygon
     * @param p3 is the third vertex of the polygon
     * @param p4 is the fourth vertex of the polygon
     */
    public Polygon(int p1, int p2, int p3, int p4) {
        if(p1<0 || p2<0 || p3<0 || p4<0){//Do not allow negative values
            System.out.println("Failed to create polygon. Vertex index has negative values.");
        }
        this.vertex[0]=p1;
        this.vertex[1]=p2;
        this.vertex[2]=p3;
        this.vertex[3]=p4;
    }

    @Override
    public String toString(){
        return "f "+vertex[0]+" "+vertex[1]+" "+vertex[2]+" "+vertex[3]+"\n";
    }
}
