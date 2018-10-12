
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.Float.max;
import javax.swing.event.*;

public class CTScanner extends JFrame {
    
    JFrame main = new JFrame("CT Scanner");
    JButton mip_button;
    JLabel image_icon1;
    JLabel image_icon2;
    JLabel image_icon3;
    JLabel label = new JLabel();
    JSlider xslice_slider, zslice_slider, yslice_slider;
    BufferedImage imageX, imageZ, imageY;
    short cthead[][][];
    short min, max;

    public void CTScanner() throws IOException {

        File file = new File("CThead"); //HARDCODED FILENAME

        imageZ = new BufferedImage(256, 256, BufferedImage.TYPE_3BYTE_BGR); //IMAGE STORED HERE
        imageX = new BufferedImage(256, 112, BufferedImage.TYPE_3BYTE_BGR);
        imageY = new BufferedImage(256, 112, BufferedImage.TYPE_3BYTE_BGR);        

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file))); //READ DATA QUICKLY WITH A BUFFER

        int i, j, k;
        min = Short.MAX_VALUE;
        max = Short.MIN_VALUE; //SET MAX
        short read;
        int b1, b2;

        cthead = new short[113][256][256]; //ALLOCATE MEM - FOR THIS DATA SET ONLY

        for (k = 0; k < 113; k++) {
            for (j = 0; j < 256; j++) { //READ THROUGH THE DATA WITH THIS LOOP
                for (i = 0; i < 256; i++) { //FIXING THE ENDIAN PROBLEM
                    b1 = ((int) in.readByte()) & 0xff;
                    b2 = ((int) in.readByte()) & 0xff;
                    //System.out.println(b1 + " " + b2);
                    read = (short) ((b2 << 8) | b1);//SWIZZLE
                    if (read < min) {
                        min = read;//NEW MIN
                    }
                    if (read > max) {
                        max = read;//NEW MAX
                    }
                    cthead[k][j][i] = read;
                }
            }
        }

        System.out.println(min + " " + max); //diagnostics. There are 3366 levels of grey

        //GUI SET-UP 
        
        Container container = getContentPane();
        setTitle("CT Scanner");
        //container.setLayout(new FlowLayout());
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        image_icon1 = new JLabel(new ImageIcon(imageZ));
        
        
        zslice_slider = new JSlider(0, 112);
        
        zslice_slider.setMajorTickSpacing(44);
        zslice_slider.setMinorTickSpacing(11);
        zslice_slider.setPaintTicks(true);
        zslice_slider.setPaintLabels(true);
        container.add(image_icon1);
        container.add(zslice_slider);        
        container.add(label);

        image_icon2 = new JLabel(new ImageIcon(imageX));
        container.add(image_icon2);
        
        xslice_slider = new JSlider(0, 255);
        container.add(xslice_slider);
        xslice_slider.setMajorTickSpacing(50);
        xslice_slider.setMinorTickSpacing(100);
        xslice_slider.setPaintTicks(true);
        xslice_slider.setPaintLabels(true);

        image_icon3 = new JLabel(new ImageIcon(imageY));
        container.add(image_icon3);
        
        yslice_slider = new JSlider(0, 255);
        container.add(yslice_slider);
        yslice_slider.setMajorTickSpacing(50);
        yslice_slider.setMinorTickSpacing(100);
        yslice_slider.setPaintTicks(true);
        yslice_slider.setPaintLabels(true);

        
        mip_button = new JButton("MIP");
        container.add(mip_button);

        GUIEventHandler handler = new GUIEventHandler();

        mip_button.addActionListener(handler);
        zslice_slider.addChangeListener(handler);
        xslice_slider.addChangeListener(handler);
        yslice_slider.addChangeListener(handler);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        }

    
        

    private class GUIEventHandler implements ActionListener, ChangeListener {

        public void stateChanged(ChangeEvent e) {

            if (e.getSource() == zslice_slider) {

                imageZ = genTopImage(imageZ);
                image_icon1.setIcon(new ImageIcon(imageZ));
                //System.out.println(zslice_slider.getValue()); //DEBUGGING
            }

            if (e.getSource() == xslice_slider) {

                imageX = genSideImage(imageX);
                image_icon2.setIcon(new ImageIcon(imageX));
               // System.out.println(xslice_slider.getValue()); //DEBUGGING
            }
            if (e.getSource() == yslice_slider) {

                imageY = genFrontImage(imageY);
                image_icon3.setIcon(new ImageIcon(imageY));
                // System.out.println(yslice_slider.getValue()); //DEBUGGING
            }
        }

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == mip_button) {

                imageX = MIPSide(imageX);
                image_icon2.setIcon(new ImageIcon(imageX));
                imageY = MIPFront(imageY);
                image_icon3.setIcon(new ImageIcon(imageY));
                imageZ = MIPTop(imageZ);
                image_icon1.setIcon(new ImageIcon(imageZ));

            }

        }
    }

    //don't have to bother with this, it just speeds up a complex process
    public static byte[] GetImageData(BufferedImage image) {
        WritableRaster WR = image.getRaster();
        DataBuffer DB = WR.getDataBuffer();
        if (DB.getDataType() != DataBuffer.TYPE_BYTE) {
            throw new IllegalStateException("That's not of type byte");
        }

        return ((DataBufferByte) DB).getData();
    }

    public BufferedImage MIPTop(BufferedImage image) {

        int w = image.getWidth(), h = image.getHeight(), i, j, c, k;

        byte[] data = GetImageData(image);
        float col;
        short datum;
        for (j = 0; j < h; j++) {
            for (i = 0; i < w; i++) {
                int maximum = 0;
                for (k = 0; k < 112; k++) {
                    maximum = (int) max(cthead[k][j][i], maximum);

                    col = (255.0f * ((float) maximum - (float) min) / ((float) (max - min)));
                    for (c = 0; c < 3; c++) {
                        data[c + 3 * i + 3 * j * w] = (byte) col;
                    }
                }
            }
        }
        return image;
    }

    public BufferedImage MIPFront(BufferedImage image) {
        int w = image.getWidth(), h = image.getHeight(), i, j, c, k, y;
        byte[] data = GetImageData(image);
        float col;
        for (k = 0; k < h; k++) {
            for (i = 0; i < w; i++) {
                int maximum = 0;
                for (y = 0; y < 255; y++) {
                    maximum = (int) max(cthead[k][y][i], maximum);
                    col = (255.0f * ((float) maximum - (float) min) / ((float) (max - min)));
                    for (c = 0; c < 3; c++) {
                        data[c + 3 * i + 3 * k * w] = (byte) col;
                    }
                }
            }
        }
        return image;
    }

    public BufferedImage MIPSide(BufferedImage image) {
        int w = image.getWidth(), h = image.getHeight(), i, j, c, k, x;
        byte[] data = GetImageData(image);
        float col;
        for (k = 0; k < h; k++) {
            for (j = 0; j < w; j++) {
                int maximum = 0;
                for (x = 0; x < 255; x++) {
                    maximum = (int) max(cthead[k][j][x], maximum);
                    col = (255.0f * ((float) maximum - (float) min) / ((float) (max - min)));
                    for (c = 0; c < 3; c++) {
                        data[c + 3 * j + 3 * k * w] = (byte) col;
                    }
                }
            }
        }
        return image;
    }

    public BufferedImage genTopImage(BufferedImage image) {
        int w = image.getWidth(), h = image.getHeight(), i, j, c, k, z;
        byte[] data = GetImageData(image);
        float col;
        short datum;

        z = zslice_slider.getValue();

        for (j = 0; j < h; j++) {
            for (i = 0; i < w; i++) {
                datum = cthead[z][j][i];
                col = (255.0f * ((float) datum - (float) min) / ((float) (max - min)));
                for (c = 0; c < 3; c++) {
                    data[c + 3 * i + 3 * j * w] = (byte) col;
                } // colour loop
            } // column loop
        } // row loop

        return image;
    }

    public BufferedImage genSideImage(BufferedImage image) {
        int w = image.getWidth(), h = image.getHeight(), i, j, c, k, x;
        byte[] data = GetImageData(image);
        float col;
        short datum;

        x = xslice_slider.getValue();

        for (k = 0; k < h; k++) {
            for (j = 0; j < w; j++) {                
                datum = cthead[k][j][x];
                col = (255.0f * ((float) datum - (float) min) / ((float) (max - min)));
                for (c = 0; c < 3; c++) {
                    data[c + 3 * j + 3 * k * w] = (byte) col;
                } // colour loop
            } // column loop
        } // row loop

        return image;
    }

    public BufferedImage genFrontImage(BufferedImage image) {
        int w = image.getWidth(), h = image.getHeight(), i, j, c, k, y;
        byte[] data = GetImageData(image);
        float col;
        short datum;

        y = yslice_slider.getValue();

        for (k = 0; k < h; k++) {
            for (i = 0; i < w; i++) {
                datum = cthead[k][y][i];
                col = (255.0f * ((float) datum - (float) min) / ((float) (max - min)));
                for (c = 0; c < 3; c++) {
                    data[c + 3 * i + 3 * k * w] = (byte) col;
                } // colour loop
            } // column loop
        } // row loop

        return image;
    }
    
    public BufferedImage genHistogramSide(BufferedImage image) {int w = image.getWidth(), h = image.getHeight(), i, j, c, k, x;
        byte[] data = GetImageData(image);
        float col;
        short datum;
        int minimum = -1117;
        int maximum = 2248;
        
        
        for (x = 0; x < h; x++){
        
        for (k = 0; k < h; k++) {
            for (j = 0; j < w; j++) {
                datum = cthead[k][k][x];
                col = (255.0f * ((float) datum - (float) min) / ((float) (max - min)));
                for (c = 0; c < 3; c++) {
                    data[c + 3 * j + 3 * k * w] = (byte) col;
                    }
                }
            } 
        }
        return image;
    }

    public static void main(String[] args) throws IOException {

        CTScanner e = new CTScanner();
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.CTScanner();
    }
}
