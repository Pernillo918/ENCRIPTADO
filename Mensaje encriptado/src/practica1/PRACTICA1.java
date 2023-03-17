package practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Pernillo918
 */
public class PRACTICA1 {

  static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    static int matrizM[][];
    static int[][] MatrizA = new int[3][3];
    static int[][] MatrizB;
    static String mensaje, ruta, direccion;
    static int columnas;
    static int[][] MatrizC;
    static int[][] multimatriz = new int[3][];
    static double[][] desencriptar;
    static int Bcolumnas;
    static int COC;
    static int[][] MOriginal = new int[3][3];
    static int[][] Mcifrado;
    static int cfilas;
    static int ccifrado;

    //SE UTILIZARON PARA LA REALIZACION DE LOS REPORTES DE ENCRIPTADO 
    static String letra[];
    static int numero[];
    static String mayusculas;
    //DESENCRIPTAR
    static double inversa[][] = new double[3][6];
    static double fila2, fila1;
    static double auxiliar1, auxiliar2;
    static double[][] resta;

    public static void main(String[] args) {

        Scanner sc2 = new Scanner(System.in, "ISO-8859-1");
        Scanner sc3 = new Scanner(System.in, "ISO-8859-1");

        int opcion = 0;

        while (opcion != 5) {

            System.out.println("=========== MENU ===========");
            System.out.println("| 1. Encriptar              |");
            System.out.println("| 2. Desencriptar           |");
            System.out.println("| 3. Ataque con texto plano |");
            System.out.println("| 4. Generar Reportes       |");
            System.out.println("| 5. Salir                  |");
            System.out.println("=============================");
            System.out.print("Tu opcion a escoger es:");

            try {
                opcion = sc.nextInt();
                switch (opcion) {

                    case 1:

                        while (opcion != 0) {
                            System.out.println("--------BIENVENIDO AL MENU DE ENCRIPTAR--------");
                            System.out.println("Escoge una opcion:");
                            System.out.println("1. Ingreso Mensaje ");
                            System.out.println("2. Ingreso Matriz Clave A ");
                            System.out.println("3. Ingreso Matriz Clave B  ");
                            System.out.println("4. Encriptar");
                            System.out.println("0. Salir");
                            System.out.print("Tu opcion a escoger es:");

                            opcion = sc3.nextInt();

                            switch (opcion) {
                                case 1:

                                    System.out.println("Ingrese el mensaje que desa Encriptar");
                                    mensaje = sc2.nextLine();
                                    matrizM = codificar(mensaje);

                                    //IMPRESION DE LA MATRIZ MENSAJE
                                    /*for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < matrizM[0].length; j++) {
                                            System.out.print(matrizM[i][j] + " -- ");
                                        }
                                        System.out.println("");
                                    }*/
                                    System.out.println("Mensaje guardado con exito");
                                    System.out.println("");
                                    System.out.println("");

                                    break;
                                case 2:
                                    System.out.println("Ingrese la direccion de la matriz A");
                                    ruta = sc2.nextLine();
                                    MA(ruta);
                                    System.out.println("Matriz guardada con exito");
                                    System.out.println("");
                                    System.out.println("");


                                    break;
                                case 3:
                                    System.out.println("Ingrese la direccion de la matriz B");
                                    direccion = sc2.nextLine();
                                    MB(direccion);
                                    System.out.println("Matriz guardada con exito");
                                    System.out.println("");
                                    System.out.println("");


                                    break;
                                case 4:
                                    System.out.println("El mensaje Encriptado es:");
                                    ENCRIPTAR();
                                    System.out.println("");
                                    System.out.println("");


                                    break;
                                case 0:
                                    System.out.println("Regresara al menu principal");
                                    System.out.println("");
                                    System.out.println("");

                                    break;
                                default:
                                    System.out.println("INVALIDO");

                            }
                        }

//TERMINADO DEL SWTICH DEL PRIMER CASE 1          
                        break;

                    case 2:
                        for (int i = 0; i < 5; i++) {
                            System.out.println("");//solo es para dar espacio xd
                        }
                        System.out.println("--------BIENVENIDO AL MENU DE DESENCRIPTAR--------");
                        inversa();

                        break;

                    case 3:

                        while (opcion != 0) {
                            System.out.println("--------BIENVENIDO AL MENU DE ATAQUE AL TEXTO PLANO--------");
                            System.out.println("Escoge una opcion:");
                            System.out.println("1. Ingrese matriz mensaje original ");
                            System.out.println("2. Ingrese matriz mensaje cifrado ");
                            System.out.println("3. Obtener clave ");
                            System.out.println("0. Salir");
                            System.out.print("Tu opcion a escoger es:");

                            opcion = sc3.nextInt();

                            switch (opcion) {
                                case 1:

                                    System.out.println("Ingrese la direccion de la matriz mensaje original");
                                    String dire1;
                                    dire1 = sc2.nextLine();
                                    A1(dire1);
                                    System.out.println("Matriz guardada con exito");

                                    //IMPRESION DE LA MATRIZ ORIGINAL
                                   /* for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < 3; j++) {
                                            System.out.print(MOriginal[i][j]);
                                        }
                                        System.out.println("");

                                    }*/

                                    break;
                                case 2:

                                    System.out.println("Ingrese la direccion de la matriz cifrado");
                                    String dire2;
                                    dire2 = sc2.nextLine();
                                    A2(dire2);
                                    System.out.println("Matriz guardada con exito");

                                    //IMPRESION DE LA MATRIZ ORIGINAL
                                   /* for (int i = 0; i < cfilas; i++) {
                                        for (int j = 0; j < ccifrado; j++) {
                                            System.out.print(Mcifrado[i][j] + " \t");
                                        }
                                        System.out.println("");

                                    }*/

                                    break;
                                case 3:
                                    System.out.println("Lo sentimos esta area no se encuentra disponible :( ");

                                    break;
                                case 0:
                                    System.out.println("Regresara al menu principal");
                                    break;
                                default:
                                    System.out.println("INVALIDO");

                            }
                        }

                        break;

                    case 4:
                        System.out.println("--------BIENVENIDO AL MENU DE GENERAR REPORTES--------");
                        Reportes();
                        break;

                    case 5:
                        System.out.println("Gracias por usar nuestro programa hasta pronto");

                        break;

                    default:
                        System.out.println("Opcion invalida");

                }

            } catch (InputMismatchException e) {
                System.out.println(" OPCION INVALIDAD DEBE SER UN NUMERO");
                sc.next();
            }

        }

    }//TERMINA EL ARGS
     public static void A2(String dire2) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(dire2);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            cfilas = 0;
            ccifrado = 0;
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                ccifrado = numeros.length;
                cfilas++;
            }
            Mcifrado = new int[cfilas][ccifrado];

            if (cfilas == 3) {

                //LLENANDO LA MATRIZ cifrado
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                cfilas = 0;
                while ((linea = br.readLine()) != null) {
                    //System.out.println(linea);
                    String[] numeros = linea.split(",");
                    for (int i = 0; i < numeros.length; i++) {
                        Mcifrado[cfilas][i] = Integer.parseInt(numeros[i]);
                    }

                    cfilas++;
                }

            } else {
                System.out.println("Numero de filas no coincide con 3");
            }
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA MATRIZ CIFRADO

    public static void A1(String dire1) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(dire1);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            int Filas = 0;
            while ((linea = br.readLine()) != null) {

                String[] numeros = linea.split(",");

                for (int i = 0; i < numeros.length; i++) {

                    MOriginal[Filas][i] = Integer.parseInt(numeros[i]);
                }

                Filas++;
            }

            //IMPRESION DE LA MATRIZ ORIGINAL
            /*for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(MatrizA[i][j]);
                }
                System.out.println("");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA MATRIZ ORIGINAL

    public static void inversa() {

        DESENCRIPTAR();

    }//TERMINA LLAMADO DEL METODO LLAMAR INVERSA

    static void DESENCRIPTAR() {
        try {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    inversa[i][j] = MatrizA[i][j];
                }
            }

            //poniendo la transpuesta en la nmatriz
            //fila 1
            inversa[0][3] = 1;
            inversa[0][4] = 0;
            inversa[0][5] = 0;

            //fila 2
            inversa[1][3] = 0;
            inversa[1][4] = 1;
            inversa[1][5] = 0;

            //fila 3
            inversa[2][3] = 0;
            inversa[2][4] = 0;
            inversa[2][5] = 1;

            //IMPRESION DEL PEL PASO 1
            /* System.out.println("paso 1:");
               for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
               }
            System.out.println("");
        }*/
            //paso 2: convertir la columna 1 a 0
            //fila 2   
            auxiliar1 = inversa[0][0];
            auxiliar2 = inversa[1][0];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[1][i];
                inversa[1][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);

            }//fin del for

            //fila 3
            auxiliar2 = inversa[2][0];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[2][i];
                inversa[2][i] = fila2 * auxiliar1 + (fila1 * auxiliar2 * -1);
            }//fin del for

            //IMPRESION DEL PEL PASO 2
            /*System.out.println("paso 2:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/
            //PASO 3: CONVERTIR EL CENTRO EN 1 (POSICION 1.1=1)
            auxiliar1 = inversa[1][1];
            for (int i = 0; i < 6; i++) {
                inversa[1][i] /= auxiliar1;
            }
            //IMPRESION DEL PEL PASO 3
            /*System.out.println("paso 3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/

            //PASO 4: CONVERTIR POSICION 0.1 EN 0
            auxiliar1 = inversa[1][1];
            auxiliar2 = inversa[0][1];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[1][i];
                inversa[0][i] = (fila2 * auxiliar2 * -1) + (fila1 * auxiliar1);
            }//fin del for

            //IMPRESION DEL PEL PASO 4
            /* System.out.println("paso 4:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/
            //PASO 5: CONVERTIR POSICION 2.1=0
            auxiliar2 = inversa[2][1];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[1][i];
                fila2 = inversa[2][i];
                inversa[2][i] = (auxiliar2 * fila1 * -1) + (auxiliar1 * fila2);
            }
            //IMPRESION DEL PEL PASO 5
            /* System.out.println("paso 5:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/

            //PASO 6: CONVIRTIENDO LA POSICION 2.2 EN 1
            auxiliar1 = inversa[2][2];
            for (int i = 0; i < 6; i++) {
                inversa[2][i] /= auxiliar1;
            }

            //IMPRESION DEL PEL PASO 6
            /*System.out.println("\npaso 6:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/
            //PASO 7: CONVIRTIENDO LA POSICION 1.2 EN 0
            auxiliar1 = inversa[1][2];
            auxiliar2 = inversa[2][2];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[1][i];
                fila2 = inversa[2][i];
                inversa[1][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);
            }
            //IMPRESION DEL PEL PASO 7
            /*System.out.println("\npaso 7:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/

            //PASO 8: CONVERTIR LA POSICION 0.2=0
            auxiliar1 = inversa[0][2];
            auxiliar2 = inversa[2][2];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[2][i];
                inversa[0][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);
            }

            //IMPRESION DEL PEL PASO 8
            /*System.out.println("\npaso 8:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "    ");
            }
            System.out.println("");
        }*/
            //PASO 9: CONVERTIR LA POSICION 0.0 EN 1
            auxiliar1 = inversa[0][0];
            for (int i = 0; i < 6; i++) {
                inversa[0][i] /= auxiliar1;
            }

            //IMPRESION DE MATRIZ A REDUCIDA Y MATRIZ INVERSA
            /*System.out.println("\n\nRESULTADO FINAL:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(inversa[i][j] + "         ");
            }
            System.out.println("\n");
        }*/
            //PASANDO LA MATRIZ INVERSA A UNA MATRIZ 3*3
            int x;
            double inversaA[][] = new double[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    x = j;
                    x += 3;
                    inversaA[i][j] = inversa[i][x];
                }

            }

            //IMPRESION DE LA MATRIZ INVERSA
            /* System.out.println("\n La matriz inversa es:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(inversaA[i][j] + " \t");
                }
                System.out.println("\n");
            }*/
            int columna = MatrizC[0].length;

            //INICIA PROCESO DE DESENCRIPTADO---------------------------------------------------------------------------------------  
            //RESTA DE LA MATRIZ C - LA MATRIZ B
            resta = new double[3][columna];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columna; j++) {
                    resta[i][j] = MatrizC[i][j] - MatrizB[i][j];
                }
            }

            //IMPRIMIENDO LA MATRIZ C
            /*System.out.println("ESTA ES LA MATRIZ C");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columna; j++) {
                    System.out.print(MatrizC[i][j]+" \t");
                }
                System.out.println("");
            }*/
            //IMPRIMIENDO LA RESTA 
            /*  System.out.println("ESTA ES LA MATRIZ DE LA RESTA DE C Y B ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columna; j++) {
                    System.out.print(resta[i][j]+" \t");
                }
                System.out.println("");
            }*/
            //HACIENDO LA MULTIPLICACION DE LA MATRIZ INVERSA DE A POR LA RESTA DE C Y B 
            desencriptar = new double[3][MatrizB[0].length];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < MatrizB[0].length; j++) {
                    for (int k = 0; k < 3; k++) {
                        desencriptar[i][j] += inversaA[i][k] * resta[k][j];
                    }
                }
            }

            //IMPRIMIENDO LA MATRIZ MENSAJE
            /* System.out.println("ESTA ES LA MATRIZ FINAL ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < MatrizB[0].length; j++) {
                    System.out.print(desencriptar[i][j]+"  \t\t\t");
                }
                System.out.println(" ");
            }*/
            //REDONDEANDO LA MATRIZ FINAL 
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columnas; j++) {
                    desencriptar[i][j] = Math.round(desencriptar[i][j]);
                }
            }

            //IMPRIMIENDO LA MATRIZ REDONDEADA 
            /* System.out.println("ESTA ES LA MATRIZ FINAL ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < MatrizB[0].length; j++) {
                    System.out.print("[ " + desencriptar[i][j] + "]  \t");
                }
                System.out.println(" ");
            }*/
            int tamañoVector = 3 * columnas;
            int vectorFinal[] = new int[tamañoVector];

            int posicionVector = 0;
            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j < 3; j++) {
                    vectorFinal[posicionVector] = (int) desencriptar[j][i];
                    posicionVector += 1;
                }

            }

            String vectorDesencriptado[] = new String[tamañoVector];
            for (int i = 0; i < tamañoVector; i++) {

                vectorDesencriptado[i] = numerosaletras(vectorFinal[i]);
            }

            //MOSTRANDO EL MENSAJE FINAL 
            System.out.println("\nMensaje decifrado es:: ");
            for (int i = 0; i < tamañoVector; i++) {
                System.out.print(vectorDesencriptado[i]);

            }
            System.out.println("\n");
        } catch (InputMismatchException e) {
            System.out.println(" OCURRIO UN ERROR EN EL PROCESO DE LA INVERSA");
            sc.next();
        }

    }//TERMINA METODO GAUSS Y DESENCRIPTAR

    public static void ENCRIPTAR() {
        try {

            //MULTIPLICACION DE MATRIZ A POR MATRIZ MENSAJE 
            multimatriz = new int[3][matrizM[0].length];

            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < matrizM[i].length; j++) {
                    for (int r = 0; r < 3; r++) {
                        multimatriz[i][j] += MatrizA[i][r] * matrizM[r][j];
                    }
                }
            }
            COC = multimatriz[0].length;
            //IMPRIMIENDO MATRIZ MULTIPLICADA 
            /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j <multimatriz[0].length ; j++) {
                System.out.print(multimatriz [i][j]+"-");
            }
            System.out.println("");
        }*/
            //HACIENDO LA SUMA DE LA MATRIZ MULTI Y MATRIZ B 
            MatrizC = new int[3][multimatriz[0].length];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < multimatriz[0].length; j++) {
                    MatrizC[i][j] = multimatriz[i][j] + MatrizB[i][j];
                }
            }

            //IMPRIMIENDO LA MATRIZ C 
            for (int i = 0; i < multimatriz[0].length; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(MatrizC[j][i] + "  ");
                }

            }
            System.out.println("");

        } catch (InputMismatchException e) {
            System.out.println(" OCURRIO UN ERROR EN EL PROCESO DE ENCRIPTAR");
            sc.next();
        }
    }//TERMINA ENCRIPTAR

    public static void MB(String direccion) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(direccion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            int nfilas = 0;
            Bcolumnas = 0;
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                Bcolumnas = numeros.length;
                nfilas++;
            }
            MatrizB = new int[nfilas][Bcolumnas];

            if (nfilas == 3) {

                //LLENANDO LA MATRIZ B 
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                nfilas = 0;
                while ((linea = br.readLine()) != null) {
                    //System.out.println(linea);
                    String[] numeros = linea.split(",");
                    for (int i = 0; i < numeros.length; i++) {
                        MatrizB[nfilas][i] = Integer.parseInt(numeros[i]);
                    }

                    nfilas++;
                }

            } else {
                System.out.println("Numero de filas no coincide con 3");
            }
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA MATRIZ B

    public static void MA(String ruta) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            int Filas = 0;
            while ((linea = br.readLine()) != null) {

                String[] numeros = linea.split(",");

                for (int i = 0; i < numeros.length; i++) {

                    MatrizA[Filas][i] = Integer.parseInt(numeros[i]);
                }

                Filas++;
            }

            //IMPRESION DE LA MATRIZ A 
            /*for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(MatrizA[i][j]);
                }
                System.out.println("");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA MATRIZ A 

    public static int[][] codificar(String mensaje) {

        mayusculas = mensaje.toUpperCase();

        letra = new String[mayusculas.length()];
        numero = new int[mayusculas.length()];

        for (int i = 0; i < mayusculas.length(); i++) {
            letra[i] = String.valueOf(mayusculas.charAt(i));
        }

        for (int i = 0; i < letra.length; i++) {
            numero[i] = conversionletrasanumeros(letra[i]);
        }

        //CODIGO PARA VERIFICAR LA TRANSFORMACION
        /*for(int i=0;i<mayusculas.length();i++){
            System.out.println(letra[i]+"  =  "+numero[i]);
        }*/
        columnas = ((numero.length) / 3) + 1;
        int matriz[][] = new int[3][columnas];
        int contador = 0;

        //LLENANDO LA MATRIZ 
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < 3; j++) {
                if (contador < numero.length) {
                    matriz[j][i] = numero[contador];
                    contador++;
                } else {
                    matriz[j][i] = 27;
                }
            }
        }

        return matriz;

    }//TERMINA CODIFICACION 

    static int conversionletrasanumeros(String caracter) {
        switch (caracter) {
            case "A":
                return 0;

            case "B":
                return 1;

            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 9;
            case "K":
                return 10;
            case "L":
                return 11;
            case "M":
                return 12;
            case "N":
                return 13;
            case "Ñ":
                return 14;
            case "O":
                return 15;
            case "P":
                return 16;
            case "Q":
                return 17;
            case "R":
                return 18;
            case "S":
                return 19;
            case "T":
                return 20;
            case "U":
                return 21;
            case "V":
                return 22;
            case "W":
                return 23;
            case "X":
                return 24;
            case "Y":
                return 25;
            case "Z":
                return 26;

        }

        return 27;

    }//TERMINCA CONVERSION DE LETRAS A NUMEROS

    static String numerosaletras(int caracter) {
        switch (caracter) {
            case 0:
                return "A";

            case 1:
                return "B";

            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
            case 11:
                return "L";
            case 12:
                return "M";
            case 13:
                return "N";
            case 14:
                return "Ñ";
            case 15:
                return "O";
            case 16:
                return "P";
            case 17:
                return "Q";
            case 18:
                return "R";
            case 19:
                return "S";
            case 20:
                return "T";
            case 21:
                return "U";
            case 22:
                return "V";
            case 23:
                return "W";
            case 24:
                return "X";
            case 25:
                return "Y";
            case 26:
                return "Z";

        }

        return " ";

    }//TERMINCA CONVERSION DE LETRAS A NUMEROS

    static void Reportes() {
        
        try {

            
            if(Bcolumnas==0){
                
                System.out.println("Se deben ingresar datos antes  de generar los reportes! ");
                
                   
            }else{
                        REncriptado();
                        RDesencriptado();
                        RAtaque();
                        System.out.println("REPORTES GENERADOS CON EXITO :D ");
                        System.out.println("");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'a las' hh:mm a ");
                        ZonedDateTime datetime = ZonedDateTime.now();
                        String fullForm = datetime.format(formatter);
                        System.out.println("");
                        System.out.println("Se generaron el:: \t" + fullForm);
                
            }
            
            
             
          
        } catch (InputMismatchException e) {
            System.out.println(" OPCION INVALIDA");
            sc.next();
        }

    }//TERMINA MENU REPORTES

    static void REncriptado() {

        FileWriter fichero = null;
        PrintWriter es = null;
        try {
            fichero = new FileWriter("REPORTES\\REPORTE ENCRIPTADO.html");
            es = new PrintWriter(fichero);

            es.println("<HTML>");
            es.println("<title> REPORTE ENCRIPTADO </title>");
            es.println("<body style=\"background-color: white; text-align: justify;\">");
            //CSS------------------------------------------------------         
            es.println("<style type=\"text/css\">");
            es.println("h1 { color: white; size: 17; background-color: black; font-family: Tahoma; }");
            es.println("b {color:black; size: 12; justify; font-family: Tahoma");
            es.println("</style>");
            //INICIO DE CODIGO-----------------------------------------
            es.println("<center><h1> ENCRIPTADO </h1></center>");
            es.println();
            es.println();
            es.println();
            es.println("<b>El el proceso de Encritado se realizaron operaciones entre matriz tales como la multiplicacion de la matriz A "
                    + "por la matriz mensaje y la suma de la matriz B para obtener la matriz C(A*M +B = C) con la finalidad de mostrar"
                    + "la matriz que contiene el mensaje que el usuario ingreso.</b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Se obtuvo atravez del  proceso de codificacion  la conversion de "
                    + "un mensaje ingresado por el usuario a numeros utilizando una funcion Swtich que contiene los valores para cada letra,"
                    + "la conversion del mensaje a mayusculas con la funcion <u>.toUpperCase</u>, almacenando esA conversion en un vector, "
                    + "realizando la lectura de dicho vector con la funcion <u>.length</u>, la conversion de los valores a  char con la "
                    + " funcion <u>String.valueOf(NombreVector.charAt(i))</u> y finalmente con la ayuda de un For se "
                    + "realizo la conversion llamando al metodo que almacena el switch donde finalmente se obtuvo:</b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>El mensaje que ingreso fue:</b> " + mensaje);
            es.println("<br>");
            es.println("<br>");
            es.println("<b>La conversion de letras a numeros que se realizo fue:</b>");
            es.println("<br>");
            for (int i = 0; i < mayusculas.length(); i++) {
                es.print("<b>");
                es.print(letra[i] + "  =  " + numero[i] + "\t");
                es.print("</b>");
            }
            es.println("<br>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Se realizo el llenado de la matriz mensaje con los valores correspientes para cada letra(el llanado de la "
                    + "matriz fue de columnas a filas) la matriz obtenida fue:</b>");
            es.print("</b>");
            es.print("</b>");
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < matrizM[0].length; j++) {
                    es.println("<td><b\t>" + matrizM[i][j] + "  &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Se crearon los metodos <u>MA</u> y <u>MB</u> correspondiendo uno a la Matriz A y el otro a la Matriz B "
                    + "en cada metodo se ulizaron las funciones <u> File, FileReader y  BufferedReader</u>"
                    + "para solicitar al usuario digitara la ubicacion del archivo de texto que contenida cada una de las matrices. "
                    + "En la lectura del archivo de texto para almacenarlo en una matriz (Matriz A 3x3, Matriz B 3xn) para realizarlo se empleo un ciclo while, un contador y donde se le indico"
                    + " al programa que el cambio de valor estaria indicado por una coma(se utlizo la funcion <u> .split(,)</u>) "
                    + " y que el contador aumentaria su valor en 1 al realizar el cambio de fila y finalmente se obtuvo:"
                    + "  </b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<center>");
            es.println("<table class=\"default\">");
            es.println("<tr>");
            es.println("<td>");
            es.print("<b> Matriz A</b> \t\t\t");
            es.println("<table class=\"table table-dark\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 3; j++) {
                    es.println("<td><b\t>" + MatrizA[i][j] + "&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>");
            es.print("<b> Matriz B</b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < Bcolumnas; j++) {
                    es.println("<td><b\t>" + MatrizB[i][j] + "&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("</tr>");
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");

            es.println("<b>Se realizaron las operaciones entre matrices correspondientes siendo la primera la multiplicacion de la"
                    + "matriz A por la matriz Mensaje.");
            es.println("<br>");
            es.println("<br>");

            es.println("<center>");
            es.println("<table class=\"default\">");
            es.println("<tr>");
            es.println("<td>");
            es.print("<b> Matriz A</b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 3; j++) {
                    es.println("<td><b\t>" + MatrizA[i][j] + " &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>    &nbsp&nbsp&nbsp    x    &nbsp&nbsp&nbsp    </td>");
            es.println("<td>");
            //MATRIZ B 
            es.print("<b> Matriz M </b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < Bcolumnas; j++) {
                    es.println("<td><b\t>" + matrizM[i][j] + " &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>      &nbsp&nbsp&nbsp     =   &nbsp&nbsp&nbsp     </td>");
            //MULTIMATRIZ
            es.println("<td>");
            es.print("<b> Matriz J</b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < MatrizA.length; i++) {
                es.println("<tr>");
                for (int j = 0; j < matrizM[i].length; j++) {
                    es.println("<td><b\t>" + multimatriz[i][j] + "&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("</tr>");
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Finalmente se realizo la suma de matrices entre la matriz J que se obtuvo con la matriz B</b>");
            es.println("<br>");
            es.println("<br>");

            es.println("<center>");
            es.println("<table class=\"default\">");
            es.println("<tr>");
            es.println("<td>");
            es.print("<b> Matriz J</b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < MatrizA.length; i++) {
                es.println("<tr>");
                for (int j = 0; j < matrizM[i].length; j++) {
                    es.println("<td><b\t>" + multimatriz[i][j] + "  &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>    &nbsp&nbsp&nbsp     +     &nbsp&nbsp&nbsp     </td>");
            es.println("<td>");
            //MATRIZ B 
            es.print("<b> Matriz B  </b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < Bcolumnas; j++) {
                    es.println("<td><b\t>" + MatrizB[i][j] + " &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>   &nbsp&nbsp&nbsp     =     &nbsp&nbsp&nbsp     </td>");
            es.println("<td>");
            //MATRIZ B 
            es.print("<b> Matriz C  </b> \t\t\t");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < multimatriz[0].length; j++) {
                    es.println("<td><b\t>" + MatrizC[i][j] + " &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("</tr>");
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Y se imprimio el resultado de la suma de estas matrices siendo el mensaje encriptado.</b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>El mensaje ecnriptado es:</b>");
            es.println("<br>");

            for (int i = 0; i < multimatriz[0].length; i++) {
                for (int j = 0; j < 3; j++) {
                    es.print("<b>" + MatrizC[j][i] + " \t </b>");
                }
            }
            es.println("<br>");
            es.println("<br>");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'a las' hh:mm a ");
            ZonedDateTime datetime = ZonedDateTime.now();
            String fullForm = datetime.format(formatter);
            es.println("<b>El reporte se genero el: \t</b>" + fullForm);

            es.println("</body>");
            es.println("</HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA REPORTE ENCRIPTADO

    static void RDesencriptado() {

        FileWriter fichero = null;
        PrintWriter es = null;
        try {

            fichero = new FileWriter("REPORTES\\REPORTE DESENCRIPTADO.html");
            es = new PrintWriter(fichero);

            es.println("<HTML>");
            es.println("<title> REPORTE DESENCRIPTADO </title>");
            es.println("<body style=\"background-color: white; text-align: justify;\">");
            //CSS------------------------------------------------------         
            es.println("<style type=\"text/css\">");
            es.println("h1 { color: white; size: 17; background-color: black; font-family: Tahoma; }");
            es.println("b {color:black; size: 12; justify; font-family: Tahoma}");
            es.println("td {   WIDTH =100; HEIGTH=100;}");
            es.println("</style>");
            //INICIO DE CODIGO-----------------------------------------
            es.println("<center><h1> DESENCRIPTADO </h1></center>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>En el proceso de Desencriptado se utilizo las operaciones entre matrices tales como la "
                    + "resta de la matriz C con la matriz B y la multiplicacion de la inversa de A (A^−1 ∗ C -B = M) con la finalidad "
                    + "de obtener la matriz que contiene el mensaje que el usuario ingreso</b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Se realizo la resta de la matriz C con la matriz B</b>");
            es.println("<br>");

            es.println("<center>");
            es.println("<table class=\"default\">");
            es.println("<tr>");
            es.println("<td>");

            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < multimatriz[0].length; j++) {
                    es.println("<td><b\t>" + MatrizC[i][j] + "  &nbsp&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>    \t \t      &nbsp&nbsp  -  &nbsp&nbsp   \t\t     </td>");
            es.println("<td>");
            //MATRIZ B 

            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < Bcolumnas; j++) {
                    es.println("<td><b\t>" + MatrizB[i][j] + " &nbsp&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>      \t\t   &nbsp&nbsp    =   &nbsp&nbsp \t\t       </td>");
            //MULTIMATRIZ
            es.println("<td>");

            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < MatrizC[0].length; j++) {
                    es.println("<td><b\t>" + resta[i][j] + " &nbsp&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("</tr>");
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<b>Se obtuvo a travez del proceso  de Gauss-Jordan la matriz inversa de la matriz A"
                    + ", el procedimiento empleado fue:</b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Colocando la matriz transpuesta en la matriz </b>");
            es.println("<br>");
            es.println("<br>");

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    inversa[i][j] = MatrizA[i][j];
                }
            }

            //fila 1
            inversa[0][3] = 1;
            inversa[0][4] = 0;
            inversa[0][5] = 0;

            //fila 2
            inversa[1][3] = 0;
            inversa[1][4] = 1;
            inversa[1][5] = 0;

            //fila 3
            inversa[2][3] = 0;
            inversa[2][4] = 0;
            inversa[2][5] = 1;
             es.println("<center>");
            //IMPRESION DEL PEL PASO 1
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
             es.println("</center>");
            
            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la columa 1 a 0 </b>");
            es.println("<br>");
            es.println("<br>");
            //fila 2   
            auxiliar1 = inversa[0][0];
            auxiliar2 = inversa[1][0];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[1][i];
                inversa[1][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);

            }//fin del for

            //fila 3
            auxiliar2 = inversa[2][0];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[2][i];
                inversa[2][i] = fila2 * auxiliar1 + (fila1 * auxiliar2 * -1);
            }//fin del for

            //IMPRESION DEL PEL PASO 2
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo en 1 la posicion 1.1 </b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar1 = inversa[1][1];
            for (int i = 0; i < 6; i++) {
                inversa[1][i] /= auxiliar1;
            }
            //IMPRESION DEL PEL PASO 3
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la posicion 0.1 en 0 </b>");
            es.println("<br>");
            es.println("<br>");
            auxiliar1 = inversa[1][1];
            auxiliar2 = inversa[0][1];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[1][i];
                inversa[0][i] = (fila2 * auxiliar2 * -1) + (fila1 * auxiliar1);
            }//fin del for

            //IMPRESION DEL PEL PASO 4 
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la posicion 2.1 en 0 </b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar2 = inversa[2][1];
            for (int i = 0; i < 6; i++) {
                fila1 = inversa[1][i];
                fila2 = inversa[2][i];
                inversa[2][i] = (auxiliar2 * fila1 * -1) + (auxiliar1 * fila2);
            }
            //IMPRESION DEL PEL PASO 5
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convirtiendo la posicon 2.2 en 1 </b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar1 = inversa[2][2];
            for (int i = 0; i < 6; i++) {
                inversa[2][i] /= auxiliar1;
            }

            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la posicion 1.2 en 0</b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar1 = inversa[1][2];
            auxiliar2 = inversa[2][2];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[1][i];
                fila2 = inversa[2][i];
                inversa[1][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);
            }
            //IMPRESION DEL PEL PASO 7
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la posicion 0.2 en 0 </b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar1 = inversa[0][2];
            auxiliar2 = inversa[2][2];

            for (int i = 0; i < 6; i++) {
                fila1 = inversa[0][i];
                fila2 = inversa[2][i];
                inversa[0][i] = (fila2 * auxiliar1 * -1) + (fila1 * auxiliar2);
            }

            //IMPRESION DEL PEL PASO 8
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Convertiendo la posicion 0.0 en 1 </b>");
            es.println("<br>");
            es.println("<br>");

            auxiliar1 = inversa[0][0];
            for (int i = 0; i < 6; i++) {
                inversa[0][i] /= auxiliar1;
            }

            //IMPRESION DE MATRIZ A REDUCIDA Y MATRIZ INVERSA
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 6; j++) {
                    es.println("<td><b\t>" + inversa[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Pasando la matriz inversa a una matriz 3x3</b>");
            es.println("<br>");
            es.println("<br>");

            int x;
            double inversaA[][] = new double[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    x = j;
                    x += 3;
                    inversaA[i][j] = inversa[i][x];
                }

            }

            //IMPRESION DE LA MATRIZ INVERSA  
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 3; j++) {
                    es.println("<td><b\t>" + inversaA[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("<center>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Luego de obtener la matriz inversa de matriz A se realizo la multiplicacion de la inversa de "
                    + " A con el residuo de la resta de la matriz C y B  </b>");
            es.println("<br>");
            es.println("<br>");

            es.println("</center>");
            es.println("<table class=\"default\">");
            es.println("<tr>");
            es.println("<td>");

            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 3; j++) {
                    es.println("<td><b\t>" + inversaA[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>    \t \t      &nbsp&nbsp  x  &nbsp&nbsp   \t\t     </td>");
            es.println("<td>");
            //MATRIZ B 
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < MatrizC[0].length; j++) {
                    es.println("<td><b\t>" + resta[i][j] + " &nbsp&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("<td>      \t\t   &nbsp&nbsp    =   &nbsp&nbsp \t\t       </td>");
            //MULTIMATRIZ
            es.println("<td>");

            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < MatrizB[0].length; j++) {
                    es.println("<td><b\t>" + desencriptar[i][j] + " &nbsp&nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</td>");
            es.println("</tr>");
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");

            //REDONDEANDO LA MATRIZ FINAL 
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < columnas; j++) {
                    desencriptar[i][j] = Math.round(desencriptar[i][j]);
                }
            }

            //IMPRIMIENDO LA MATRIZ REDONDEADA
            es.println("<table class=\"default\">");
            for (int i = 3; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < columnas; j++) {
                    es.println("<td><b\t>" + desencriptar[i][j] + "  \t\t\t\t" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");

            es.println("<br>");
            es.println("<br>");
            es.println("<b>Al obtener el resultado  de la multiplicacion se redondeo para poder convertir dicha matriz "
                    + "a una matriz de enteros y se hizo la conversion de los valores obtenidos en la matriz de numeros a letras "
                    + "obteniendo el mensaje ingresado por el usuario, para este proceso se utilizo dos ciclos for y una variable "
                    + "auxiiar que recorreria el vector final finalmente guardando los valores en un vector (para la conversion "
                    + "y llenado se utilizo dos ciclos for donde uno se utizo para enviarle las letras al vector Desencriptado). </b>");
            es.println("<br>");
            es.println("<br>");
            int tamañoVector = 3 * columnas;
            int vectorFinal[] = new int[tamañoVector];

            int posicionVector = 0;
            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j < 3; j++) {
                    vectorFinal[posicionVector] = (int) desencriptar[j][i];
                    posicionVector += 1;
                }

            }

            String vectorDesencriptado[] = new String[tamañoVector];
            for (int i = 0; i < tamañoVector; i++) {

                vectorDesencriptado[i] = numerosaletras(vectorFinal[i]);
            }

            //MOSTRANDO EL MENSAJE FINAL 
            es.println("<b>Finalmente se muestra el mensaje obtenido de la desencriptacion </b>");
            es.println("<br>");
            es.println("<br>");
            es.println("<center>");
            es.println("<b>El mensaje desencriptado es: </b>");
            for (int i = 0; i < tamañoVector; i++) {
                es.print(vectorDesencriptado[i]);

            }
            es.println("</center>");

            es.println("<br>");
            es.println("<br>");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy 'a las' hh:mm a ");
            ZonedDateTime datetime = ZonedDateTime.now();
            String fullForm = datetime.format(formatter);
            es.println("<b>El reporte se genero el: \t</b>" + fullForm);
            es.println("</body>");
            es.println("</HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA REPORTE DESENCRIPTADO

   static void RAtaque() {

        FileWriter fichero = null;
        PrintWriter es = null;
        try {
            fichero = new FileWriter("REPORTES\\REPORTE ATAQUE.html");

            es = new PrintWriter(fichero);

            es.println("<HTML>");
            es.println("<title> REPORTE ATAQUE AL TEXTO PLANO  </title>");
            es.println("<body style=\"background-color: white; text-align: justify;\">");
            //CSS------------------------------------------------------         
            es.println("<style type=\"text/css\">");
            es.println("h1 { color: white; size: 17; background-color: black; font-family: Tahoma; }");
            es.println("b {color:black; size: 12; justify; font-family: Tahoma");
            es.println("</style>");
            //INICIO DE CODIGO-----------------------------------------
            es.println("<h1>Ataque al texto plano</h1>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>El usuario digito la direccion de la matriz mensaje original</b>");
     es.println("<br>");
     es.println("<br>");
     es.println("<b>La matriz mensaje original es:</b>");
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < 3; i++) {
                es.println("<tr>");
                for (int j = 0; j < 3; j++) {
                    es.println("<td><b\t>" + MOriginal[i][j] + "  &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");
            es.println("<b>El usuario digito la direccion de la matriz mensaje cifrado</b>");
     es.println("<br>");
     es.println("<br>");
     es.println("<b>La matriz mensaje cifrado es es:</b>");
            es.println("<center>");
            es.println("<table class=\"default\">");
            for (int i = 0; i < cfilas; i++) {
                es.println("<tr>");
                for (int j = 0; j < ccifrado; j++) {
                    es.println("<td><b\t>" + Mcifrado[i][j] + "  &nbsp&nbsp&nbsp" + "</b></td>");
                }
                es.println("</tr>");
            }
            es.println("</table>");
            es.println("</center>");
            es.println("<br>");
            es.println("<br>");
            
          
            
            
            es.println("</body>");
            es.println("</HTML>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }//TERMINA REPORTE ATAQUE TEXTO PLANO 
}
