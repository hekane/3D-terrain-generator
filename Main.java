public class Main {
    public static void main(String[] args) {

        ImageHandler imageHandler=new ImageHandler();
        imageHandler.loadImage();
        System.out.println(imageHandler.getHeight());;
        if(imageHandler.getHeight()!=0){
            HeightMap heightMap=new HeightMap(imageHandler.getWidth(),imageHandler.getHeight(), imageHandler.getPixelData());
            heightMap.writeObj();
        }
    }
}