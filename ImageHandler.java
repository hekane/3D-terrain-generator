import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;


public class ImageHandler {
    private BufferedImage image=null;
    private ArrayList<Double> pixelData;
    private int width;
    private int height;
    public ImageHandler(){
        width=0;
        height=0;
        this.pixelData=new ArrayList<>();
    }

    public void loadImage(){
        try{
            File pixels=new File("F:\\Java Repos\\IntelliJ projects\\mun3d\\src\\pixels.png");
            image= ImageIO.read(pixels);
            this.width=image.getWidth();
            this.height=image.getHeight();
            for(int x=0;x<this.width;x++){
                for(int y=0;y<this.height;y++){
                    int rgba=image.getRGB(x,y);
                    int r,g,b;
                    b=rgba&0xFF;
                    g=(rgba>>8)&0xFF;
                    r=(rgba>>16)&0xFF;
                    pixelData.add(r/255.0);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public ArrayList<Double> getPixelData(){
        return pixelData;
    }
}
