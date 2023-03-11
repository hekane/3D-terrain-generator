import com.sun.nio.sctp.AbstractNotificationHandler;

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


    /**
     * loads a .png image from file named "pixels.png"
     * and saves it's pixel data from the RGB red channel into
     * an arraylist. The function separates RGB values of pixels with
     * a bitewise AND operation.
     */
    public void loadImage(){
        try{
            String path=new File("").getAbsolutePath();
            path=path+"\\pixels.png";
            File pixels=new File(path);
            image= ImageIO.read(pixels);
            this.width=image.getWidth();
            this.height=image.getHeight();
            for(int x=0;x<this.width;x++){
                for(int y=0;y<this.height;y++){
                    int rgba=image.getRGB(x,y);
                    int r,g,b;
                    b=rgba&0xFF; //Get GREEN value
                    g=(rgba>>8)&0xFF; //Shift bits 8 steps to the right and get BLUE value
                    r=(rgba>>16)&0xFF;//Shift bits 16 steps to the right and get RED value
                    pixelData.add(r/255.0);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @return image width in pixels
     */
    public int getWidth(){
        return width;
    }

    /**
     * @return image height in pixels
     */
    public int getHeight(){
        return height;
    }

    /**
     * Get's the arraylist of pixel's red color values
     * @return an arraylist of type double
     */
    public ArrayList<Double> getPixelData(){
        return pixelData;
    }
}
