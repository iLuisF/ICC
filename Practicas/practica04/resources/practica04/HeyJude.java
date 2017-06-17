/*
 * This software is released under the terms of the GNU LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */

/**
 * La clase HeyJude usas la diferentes estructura
 * de control para poder representar la cancion
 * Hey Jude, ya que se divide en varios segmentos de repeticion.
 * @author Luis Flores
 * @version 1.0
 */
public class HeyJude{

    private static final String HEY = "Hey Jude ";
    private static final String DON = "don't ";
    private static final String MAK = "make it bad.";
    private static final String BEA = "be afraid.";
    private static final String LET = "let me down.";
    private static final String TAK = "Take a sad song and make it better.";
    private static final String YOW = "You were made to go out and get her.";
    private static final String YOH = "You have found her, now go and get her.";
    private static final String REM = "Remember to ";
    private static final String LEH = "let her into you heart.";
    private static final String LES = "let her into your skin.";
    private static final String THE = "Then you ";
    private static final String CAN = "can start ";
    private static final String BEG = "begin ";
    private static final String TOM = "to make it better ";
    private static final String BET = "better ";
    private static final String NA  = "na ";

    private static final String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
	                            + "Don’t carry the world upon your shoulders.\n"
                                    + "For well you know that it’s a fool who plays it cool\n"
	                            + "By making his world a little colder.";

    private static final String SOL = "So let it out and let it in, hey Jude, begin,\n"
	                            + "You’re waiting for someone to perform with.\n"
	                            + "And don’t you know that it’s just you, hey jude, you’ll do,\n"
	                            + "The movement you need is on your shoulder.";

    /**
     * Se imprimen las estructuras de control.
     * @param Args no se usa.
     */
    public static void main(String[] args){
	for(int i=0; i<4; i++){
	    System.out.println();
	    System.out.print(HEY);
	    System.out.print(DON);
	    switch(i){
	    case 0: case 3:
		System.out.println(MAK);
		System.out.println(TAK);
		break;
	    case 1:
		System.out.println(BEA);
		System.out.println(YOW);
	    break;
	    case 2:
		System.out.println(LET);
		System.out.println(YOH);
	    break;
	    default:
	    }
	    if(i == 0 || i == 1 || i == 2 || i ==3){
		System.out.print(REM);
	    }
	    if(i == 0 || i == 2){
		System.out.println(LEH);
	    }
	    if(i == 1 || i == 3){
		System.out.println(LES);
	    }	 
	    if(i == 0 || i == 1 || i == 2 || i ==3){
		System.out.print(THE);
	    }	 
	    if(i == 0 || i == 2){
		System.out.print(CAN);
	    }
	    if(i == 1 || i == 3){
		System.out.print(BEG);
	    }
	    if(i == 0 || i == 1 || i == 2 || i == 3){
		System.out.println(TOM);
	    }
	    if(i == 1){
		System.out.println();
		System.out.println(AND);
	    }
	    if(i == 2){
		System.out.println();
		System.out.println(SOL);
	    }
	    if(i == 3){
		for(int k = 0; k<6; k++){
		    System.out.print(BET);
		}
		System.out.println();
	    }
	    if(i == 1 || i == 2 || i ==3){
		System.out.println();
		for(int j = 0; j<10; j++){
		    System.out.print(NA);
		}
		System.out.println();
	    }
	}
    }    
}
