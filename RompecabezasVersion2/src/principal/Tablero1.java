package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * 
 * 
 * @author amado
 */
public class Tablero1 extends JFrame implements ActionListener {

    ArrayList<Fragmento> listaFragmento;
            //arreglo dinamicos
    Fragmento pieza,frag;//
//    opciones nuevas para el desarrollo
    private int click1 = -1, click2 = -1, contador=1, cantidad;
    private boolean completado=false;
    private Tablero1 miTablero;
    private JButton boton1;
    private JButton boton2;
    public JButton boton3;
    JLabel  etiqueta1, etiTiempo, etiCronometro; // Creamos las etiquetas para mostrar el tiempo 
    Timer reloj;
    int segundero,minutero;
    
    public Tablero1(int cantidadPieza) //Creamos nuestro tablero
    {
        

        this.setTitle("ROMPECABEZAS: AMADO GOMEZ RENTERIA");
        this.getContentPane().setBackground(Color.BLACK);
        listaFragmento = new ArrayList();
        this.setBounds(0,0,700,500);// es el tamaño de mi JFRAME
        this.setLayout(null);
        setLocationRelativeTo(null);//Centramos la ventana
        this.setResizable(false);//para establer un tamaño que el usuario ya no pueda cambiar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        
        etiqueta1 = new JLabel("OBSERVA BIEN LA IMAGEN PARA PODER ARMARLA ");
        etiqueta1.setBounds(108,20,400,100);
        etiqueta1.setForeground(Color.YELLOW);
        etiTiempo = new JLabel("Tiempo:");
        etiTiempo.setBounds(520,10,80,200);
        etiTiempo.setForeground(Color.yellow);
        etiCronometro = new JLabel("0");
        etiCronometro.setBounds(570,100,50,20);
        etiCronometro.setForeground(Color.yellow);
//        etiqueta1.setVisible(true);
        reloj = new Timer(10,
                
                
        
           new ActionListener()
           {
                    @Override
                    public void actionPerformed(ActionEvent e)  //Creamos el timer
                    {

                        
                        segundero++;
                        etiCronometro.setText(   minutero+":"+segundero  );
                     
                        if(segundero==59)
                        {
                            segundero=-1;
                            minutero++;
                            
                        }
                        if(minutero==60) //Establecemos el tiempo limite para armar el rompecabezas
                        {
                        contador=0; 
                        JOptionPane.showMessageDialog(null, "LO SENTIMOS NO TERMINASTE A TIEMPO \n VUELVE A INICIAR OTRA PARTIDA");
                        
                        reloj.stop(); //Detenemos el reloj
                        etiqueta1.setVisible(true); //Hacemos visible el reloj
                        minutero=segundero=0; // Reiniciamos el reloj
                        }

                        
                        
                        
                        
                    }
           }
        
        
        );
        
        
        for(int i=0; i<cantidadPieza;i++)
        {
            
            pieza =new Fragmento(i);
           
            pieza.setIcon(new ImageIcon("src\\imagenes\\"+i+".jpg"));//especificamos la direccion en la que estan las imagenes
            pieza.addActionListener(this);
            listaFragmento.add(pieza);//se añaden las imagenes al JFRAME pero en orden
        }
//         Collections.shuffle(listaFragmento);


        
        boton1=new JButton("SALIR");
        boton1.setBounds(500,250,100,50);
        add(boton1);
        boton1.addActionListener(this);
        boton1.addActionListener (new ActionListener(){
        public void actionPerformed(ActionEvent e){
            reloj.stop();
            int exit = JOptionPane.showConfirmDialog(null,"ESTA A PUNTO DE SALIR DE LA APLICACION\n ¿DESEA CONTINUAR?", "",
             JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (exit == JOptionPane.YES_OPTION || exit==JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "HASTA PRONTO");
                    System.exit(0);
                }
                reloj.start();
        }
        });
        
        
        boton2=new JButton("JUGAR");
        boton2.setBounds(500,150,100,50);
        add(boton2);
        boton2.addActionListener(this);
        boton2.addActionListener (new ActionListener(){
        public void actionPerformed(ActionEvent e){
            reloj.stop();
            etiqueta1.setVisible(true);
            contador=1; 
            JOptionPane.showMessageDialog(null,"INICIAR");
            int x,y;
            
            
            
        x=y=100;
        
 Collections.shuffle(listaFragmento);//
        for(int i = 0; i<listaFragmento.size(); i++)
        {
            listaFragmento.get(i).setBounds(x,y,100,100);  
            x+=100; 
           if(i==2){
              y+=100; 
              x=100;
           }
           if(i==5){
              y+=100; 
              x=100;
           }
           
//            Collections.shuffle(listaFragmentos);
           
                    }
        JOptionPane.showMessageDialog(null," SE HA INICIADO UNA \n NUEVA PARTIDA \n¡¡¡SUERTE!!!");
        etiqueta1.setVisible(false);
        segundero=minutero=0;
        reloj.start();
        }
        
        });
        int x,y;
         x=y=100;

        for(int i = 0; i<listaFragmento.size(); i++)
        {
            listaFragmento.get(i).setBounds(x,y,100,100);  
            x+=100; 
           if(i==2){
              y+=100; 
              x=100;
           }
           if(i==5){
              y+=100; 
              x=100;
           }
 
 this.add(listaFragmento.get(i));
 this.add(etiqueta1);
 this.add(etiTiempo);
 this.add(etiCronometro);
 
 
 
   
        
        
        }
    }
    
    
    public static void main(String args[])
    {
        Tablero1 miTablero1 = new Tablero1(9);
        miTablero1.setVisible(true);
        
        
        
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        frag = new Fragmento(0);
        int auxId;
        int confirmar=0;
           
        for(int i=0;i<listaFragmento.size();i++)
        {
            if(e.getSource()==listaFragmento.get(i))
            {
                if(contador==1)
                {
                    click1 = i;
                    contador=-1;   
                }

                else if(contador==-1)
                        {
                            click2=i;
                                frag.setIcon(listaFragmento.get(click1).getIcon());
                                listaFragmento.get(click1).setIcon(listaFragmento.get(click2).getIcon());
                                listaFragmento.get(click2).setIcon(frag.getIcon());

                                auxId=listaFragmento.get(click1).getId();
                                listaFragmento.get(click1).setId(listaFragmento.get(click2).getId());
                                listaFragmento.get(click2).setId(auxId);

                                contador=1;
                                click1=-1;
                                click2=-1;

                                    for(int j=0;j<listaFragmento.size();j++)
                                    {
                                        if(listaFragmento.get(j).getId()==j)
                                        {
                                            confirmar++;

        //                                            if(confirmar==cantidad*cantidad)
                                            if(confirmar==listaFragmento.size())
                                            {
                                                reloj.stop();
                                                completado=true;
                                                JOptionPane.showMessageDialog(null, " FELICIDADES LOGRASTE TERMINAR CON UN TIEMPO DE "+minutero+":"+segundero);
                                                contador=0; 
                                                JOptionPane.showMessageDialog(null, " PARA MOVER LAS IMAGENES DEBES INICIAR OTRA NUEVA PARTIDA ");
                                                minutero=segundero=0;
                                                etiqueta1.setVisible(true);
                                                
                
                                            }
                                            
                                        }
                                    }
                            }
                          
                        }
            }
        }            
    }


