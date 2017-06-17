/*
 * This software is released under the terms of the GNU LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.*;
import javax.imageio.ImageIO;

/**
* Programa para generar archivos basados en Criptografía visual.
* @author Mayra Aceves
* @author Luis Flores
* @version 1.0
*/
public class Criptografia extends Application {

	@Override
	public void start(Stage primaryStage){

		Parameters p = getParameters();
		/* 
		img recibe en forma de argumentos los nombres de las imágenes. 
		Si recibe 2, se decrifran, si recibe una, se cifra.
		*/
		String[] img = p.getRaw().toArray(new String[getParameters().getRaw().size()]);
		
		Image image1 = new Image(img[0]);
		Image image2 = new Image(img[1]);

		System.out.println(img[0]);
		System.out.println(img[1]);

		/* 
		Si la longitud de los argumentos en la terminal es igual a 1, 
		quiere decir que sólo se escribe el nombre de una imagen en la terminal, 
		por lo que la imagen se va a cifrar.
		*/
		if(img.length == 1){

		// Se crean las dos imágenes sobre las que se van a escribir los pixeles. 
		WritableImage img1 = new WritableImage((int) image1.getWidth()*2, (int)image1.getHeight()*2);
		WritableImage img2 = new WritableImage((int) image2.getWidth()*2, (int)image2.getHeight()*2);
			
		try{
		
		//Imagen auxiliar con el doble del tamaño de la original
		Image aux = new Image(img[0]);
		PixelReader pixelReaderAux = aux.getPixelReader();
		WritableImage wImageAux = new WritableImage((int) aux.getWidth()*2, (int)aux.getHeight()*2); //*2
		PixelWriter pixelWriterAux = wImageAux.getPixelWriter();
		int r = 0;
		int s;

		// Se recorre la imagen auxiliar pixel por pixel
		for(int readY = 0; readY<aux.getHeight(); readY++){
			s = 0;
	    	for(int readX = 0; readX<aux.getWidth(); readX++){
	    		Color color = pixelReaderAux.getColor(readX, readY);
	    			pixelWriterAux.setColor(readX+s, readY+r, color);
	    			pixelWriterAux.setColor(readX+1+s, readY+r, color);
	    			pixelWriterAux.setColor(readX+s, readY+1+r, color);
	    			pixelWriterAux.setColor(readX+1+s, readY+1+r, color);
	    			s++;
	    	}
	    	r++;
	    } //Fin de imagen auxiliar
		
		//Para poder leer cada pixel
		PixelReader pixelReader = image1.getPixelReader();

		//Crea una imagen sobre la que se va a escribir
		//WritableImage wImage = new WritableImage((int) image1.getWidth()*2, (int)image1.getHeight()*2); //*2
		PixelWriter pixelWriter = img1.getPixelWriter();
		PixelWriter pixelWriter2 = img2.getPixelWriter();

		int k = 0;
		int m;

		//Se lee cada pixel de la imagen
		for(int readY = 0; readY<wImageAux.getHeight(); readY++){
			m = 0;
	    	for(int readX = 0; readX<wImageAux.getWidth(); readX++){

	    		Color color = pixelReader.getColor(readX, readY);
	    		
	    		//if(color.equals(Color.BLACK.toString())) {

	    		/*
	    		Si el pixel en la imagen coincide con el color negro, quiere decir que se
	    		debe de escoger de forma aleatoria alguna de las siguientes combinaciones 
	    		de pixeles para que en las 2 imágenes que se vayan a crear, al 
	    		sobreponerlas, completen el pixel.
	    		*/
	    			if(pixelReader.getColor(readX, readY).equals(Color.BLACK)){
	    				int choose = (int)(Math.random()*10)%6;
	    				switch(choose){
	    				case 1:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				case 2:
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					break;
	    				case 3:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				case 4:
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					break;
	    				case 5:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					break;
	    				case 6:
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				default:
	    					//pixelWriter.setColor(readX+m, readY+k, color);
	    			}

	    				//pixelWriter.setColor(readX, readY, color);
	    			//if(pixelReader.getColor(readX+1, readY) == Color.BLACK) pixelWriter.setColor(readX+1, readY, color);
					//if(pixelReader.getColor(readX, readY+1) == Color.BLACK) pixelWriter.setColor(readX, readY+1, color);
					//if(pixelReader.getColor(readX+1, readY+1) == Color.BLACK) pixelWriter.setColor(readX+1, readY+1, color);
	    		/*
				Si al leer la imagen original el pixel es blanco, se escoge aleatoriamente
				alguna de las siguientes posiciones para escribir los pixeles, de tal manera
				que al sobreponer las imágenes, se empalmen los de la imagen 1 como los de
				la imagen 2.
	    		*/
	    		} else {
	    			color = Color.BLACK;
	    			int choose2 = (int)(Math.random()*10)%6;
	    			switch(choose2){
	    				case 1:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					break;
	    				case 2:
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				case 3:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					break;
	    				case 4:
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				case 5:
	    					pixelWriter.setColor(readX+m, readY+k, color);
	    					pixelWriter.setColor(readX+1+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+m, readY+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+1+k, color);
	    					break;
	    				case 6:
	    					pixelWriter.setColor(readX+1+m, readY+k, color);
	    					pixelWriter.setColor(readX+m, readY+1+k, color);
	    					pixelWriter2.setColor(readX+1+m, readY+k, color);
	    					pixelWriter2.setColor(readX+m, readY+1+k, color);
	    					break;
	    				default:
	    					//pixelWriter.setColor(readX+m, readY+k, color);
	    			}
	    		}
	    		m++;	    		
			//}	
			}
			k++;
		}

		// Se crean las dos imágenes cifradas
		File outFile1 = new File("cifrado1.png");
		File outFile2 = new File("cifrado2.png");

		// Se escriben las dos imágenes cifradas en formato png
		ImageIO.write(SwingFXUtils.fromFXImage(img1, null), "png", outFile1);
		ImageIO.write(SwingFXUtils.fromFXImage(img2, null), "png", outFile1);

			
			} catch (IOException e){
				e.printStackTrace();
			}
		}

		/*
		Si la longitud de los argumentos escritos en la terminal es igual a 2, quiere
		decir que las imágenes se van a descifrar.
		*/
		if(img.length == 2){
			
			
			WritableImage img1 = new WritableImage((int) image1.getWidth(), (int)image1.getHeight());
			WritableImage img2 = new WritableImage((int) image2.getWidth(), (int)image2.getHeight());
	   		try{

	   		//Para poder leer cada pixel
			PixelReader pixelReader1 = img1.getPixelReader();
			PixelReader pixelReader2 = img2.getPixelReader();

			//Crea una imagen sobre la que se va a escribir
			WritableImage wImage = new WritableImage((int) img1.getWidth()/2, (int)img1.getHeight()/2); //*2
			PixelWriter pixelWriter = wImage.getPixelWriter();

			//Se lee cada pixel de la imagen
			int x = 0;
			int y = 0;
			for(int readY = 0; readY<img1.getHeight(); readY+=2){
				x = 0;
	    		for(int readX = 0; readX<img1.getWidth(); readX+=2){
	    			Color color1 = pixelReader1.getColor(readX, readY);
	    			Color color2 = pixelReader2.getColor(readX, readY);
	    			if(color1.equals(color2)){
	    				pixelWriter.setColor(x, y, color1);
	    			} else {
	    				Color black = Color.BLACK;
						pixelWriter.setColor(x, y, black);
	    			}
	    			x++;

	    		}
	    		y++;
	    	}
	    	// Se crea el archivo de la imagen descifrada.
	    	File outFile = new File("descifrado.png");
	   		ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", outFile);
			} catch (IOException e){
				e.printStackTrace();
			}
		}

		Group root = new Group();
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Imagen de Prueba");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}	

    
    public static void main(String[] args) throws IOException{

    	launch(args); 

    }
}