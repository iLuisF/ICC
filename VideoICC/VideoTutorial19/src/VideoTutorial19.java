
public class VideoTutorial19 {

    public static void main(String[] args) {
        // Variable polimorfica es aquella que contiene un Objeto.
        Optimista objOptimista = new Optimista();
        Pesimista objPesimista = new Pesimista();
        Extrovertido objExtrovertido = new Extrovertido();
        Introvertido objIntrovertido = new Introvertido();
        //Creando mi variable Polimorfica.
        Personalidad objPersonalidades[] = new Personalidad[4];
        objPersonalidades[0] = objOptimista;
        objPersonalidades[1] = objPesimista;
        objPersonalidades[2] = objExtrovertido;
        objPersonalidades[3] = objIntrovertido;
        //Poniendo a trabajr nuestra variable polimorfica
        objPersonalidades[0].hablar();
        objPersonalidades[1].hablar();
        objPersonalidades[2].hablar();
        objPersonalidades[3].hablar();
    }
    
}
