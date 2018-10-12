package smallapps1;

public class VolumeCalc {
    
    public static void calculateVolume(int length, int width, int height){
        
        int volumeOfPrisim = length*width*height;
        int surfaceArea = 2*(length*width + length*height + width*height);
        System.out.println("Volume: " + volumeOfPrisim);//display Volume
        System.out.println("Surface area: " + surfaceArea);//display Surface Area
        
    }
    
}
