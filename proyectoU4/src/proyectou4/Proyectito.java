 /*
Instituto Tecnologico de Chihuahua 2
Proyecto para la materia de Fundamentos de la Programacion
Alumnos:
Luis Guerrero Arellano
Kevin Mejía Gutierrez
Alejando Ibarra Valdez
 */
package proyectou4;

import java.util.Scanner;

public class Proyectito {

    public static void main(String[] args) {
        //Nombre categorias principales
        String [] categoria = {"Herramientas Manuales", "Herramientas Electricas", "Tornilleria", "Materiales de Construccion"};
        //Areglo tridimensional de subcategorias y productos
        String [][][] inventario = {
            { // 0. Herramientas Manuales
                {"Martillos", "Martillo estandar", "Martillo de goma", "Martillo de bola", "Martillo de carpintero"},
                {"Destornilladores", "Plano", "Phillips", "Estrella", "Torx", "Multiusos"},
                {"Alicates", "Universal", "Punta fina", "De corte", "De presion"},
                {"Llaves", "Inglesa", "Combinada", "Ajustable", "Allen"},
                {"Sierras", "De arco", "Manual", "Serrucho"}
            },
            { // 1. Herramientas Eléctricas
                {"Taladros", "Inalambrico", "Con cable"},
                {"Amoladoras", "Angular", "Recta"},
                {"Sierras electricas", "Circular", "De calar"},
                {"Soldadoras", "Inverter", "De estanno"},
                {"Accesorios", "Brocas", "Discos de corte", "Discos de desbaste"}
            },
            { // 2. Tornillería
                {"Tornillos", "Para madera", "Para metal", "Drywall", "Autorroscantes"},
                {"Tuercas", "Hexagonal", "Mariposa", "Autoblocante"},
                {"Clavos", "Estandar", "De acero", "De concreto"}
            },
            { // 3. Materiales de Construcción
                {"Pinturas", "Esmalte", "Acrilica", "Para madera", "Para metales"},
                {"Aislantes", "Termico", "Acustico"},
                {"Masillas y selladores", "De silicona", "Epoxico"}
            }
        };
        int [][][] cantidad = {
            {// 0. Herram Mano
                {0,32,55,40,20},
                {0,27,12,32,45,17},
                {0,19,34,33,24},
                {0,32,50,24,17},
                {0,12,38,16}
            },
            {// 1. Herram Elec
                {0,28,12},
                {0,29,38},
                {0,38,27},
                {0,36,45},
                {0,34,26,40}
            },
            {// 2. Tornilleria
                {0,15,19,28,3},
                {0,56,34,75},
                {0,28,49,25}
            },
            {// 3. Materiales de Construccion
                {0,25,48,32,29},
                {0,23,41},
                {0,30,14}
            }
        };
        
        double[][][] precios = {
            { // 0. Herramientas Manuales
                {0.0, 10.50, 12.00, 15.75, 8.90},
                {0.0, 5.20, 6.30, 7.40, 4.50, 12.00},
                {0.0, 8.00, 9.50, 10.20, 14.30},
                {0.0, 15.00, 18.50, 22.00, 6.75},
                {0.0, 13.50, 11.75, 9.00}
            },
            { // 1. Herramientas Eléctricas
                {0.0, 60.00, 45.00},
                {0.0, 75.00, 65.00},
                {0.0, 80.00, 55.00},
                {0.0, 90.00, 25.00},
                {0.0, 10.00, 5.50, 7.20}
            },
            { // 2. Tornillería
                {0.0, 0.05, 0.10, 0.08, 0.12},
                {0.0, 0.15, 0.20, 0.25},
                {0.0, 0.03, 0.07, 0.12}
            },
            { // 3. Materiales de Construcción
                {0.0, 20.00, 15.00, 18.00, 25.00},
                {0.0, 10.00, 12.50},
                {0.0, 5.50, 8.00}
            }
        };

        int maxCarrito = 100;
        String[] nombresCarrito = new String[maxCarrito];
        int[] cantidadesCarrito = new int[maxCarrito];
        double[] preciosCarrito = new double[maxCarrito];
        int contadorCarrito = 0;
        
        
        int usu, admndecision, usudecision, categoriaElec, categPedido;
        String pedidoElec, subcateElec, confPed, regresar;
        int contraadmn = 0;
        int conta = 3;
        int cantPaq, numCate, numSubCate, numProd, cantProd, volver = 0;
        double totalCompra = 0;
        Scanner captu = new Scanner(System.in);
        do{
        System.out.println("//////////FERRETERIA TRI-UNITY//////////");
        System.out.println("Eliga el usuario: Administrador(1) / comprador(2)");
        usu = captu.nextInt();
       captu.nextLine();//Lee entre administrador y comprador
        switch(usu){
            case 1:
                do{
                    System.out.print("Ingrese PIN: "); //Aqui es un sistema de contraseña con 3 intentos
                    contraadmn = captu.nextInt();
                    captu.nextLine();
                    if (contraadmn != 1234){
                        conta--;
                        if (conta == 0){
                            System.out.println("Acceso bloqueado");
                            return;
                        }else if (conta > 0){
                        System.out.println("Incorrecto, le quedan " + conta + " intentos");
                        }
                    }else if(contraadmn == 1234){
                        conta = 0;
                    }
                }while(conta != 0);
        System.out.println("----------------------");
            System.out.println("BIENVENID@ ADMINISTRADOR/A"); //Empieza la vista de administrador
            System.out.println("Seleccione una opcion: "); 

        do{
            System.out.println("Inventario(1)     Pedido(2)       Salir(3)");
            admndecision = captu.nextInt();
             captu.nextLine();//Selecciona entre las 3 distintas opciones como admin
        System.out.println("----------------------");
            switch (admndecision){
                case 1: //Aqui empieza la eleccion de inventario imprimiendolo por subtemas
                    System.out.println("Bienvenid@ al inventario");
                    
                    System.out.println("Seleccione una categoria a continuacion: ");
                    for(int i = 0; i < categoria.length; i++){
                        System.out.println((i+1) + "- " + categoria[i]);
                        
                    }
                    categoriaElec = captu.nextInt();
                    captu.nextLine();
                    System.out.println("----------------------");
                    switch (categoriaElec){
                        case 1:
                            System.out.println("----------------------");
                                System.out.println("HERRAMIENTAS MANUALES:");
                                for(int i = 0; i < 5; i++){
                                    System.out.println(inventario[0][i][0] + ":");
                                      for(int j = 1; j < inventario[0][i].length; j++){
                                        System.out.println("  - " + inventario[0][i][j] + " x" +cantidad[0][i][j]);
                                    }
                                }
                                break;
                        case 2:
                            System.out.println("----------------------");
                                System.out.println("HERRAMIENTAS ELECTRICAS:");
                                for(int i = 0; i < 5; i++){
                                    System.out.println(inventario[1][i][0]);
                                    for(int j = 1; j < inventario[1][i].length; j++){
                                         System.out.println("  - " + inventario[1][i][j] + " x" +cantidad[1][i][j]);
                                    }
                                }      
                            break;
                        case 3:
                            System.out.println("----------------------");
                                System.out.println("TORNILLERIA:");
                                for(int i = 0; i < 3; i++){
                                    System.out.println(inventario[2][i][0]);
                                    for(int j = 1; j < inventario[2][i].length; j++){
                                         System.out.println("  - " + inventario[2][i][j] + " x" +cantidad[2][i][j]);
                                    }
                                }      
                            break;
                        case 4:
                            System.out.println("----------------------");
                                System.out.println("MATERIALES DE CONSTRUCCION:");
                                for(int i = 0; i < 3; i++){
                                    System.out.println(inventario[3][i][0]);
                                    for(int j = 1; j < inventario[3][i].length; j++){
                                         System.out.println("  - " + inventario[3][i][j] + " x" +cantidad[3][i][j]);
                                    }
                                }      
                            break;
                        default:
                            System.out.println("Eleccion no establecida");
                    }
                    break;
                case 2:
                    System.out.println("Los pedidos son por paquetes (Herramientas Manuales, Herramientas Electricas, etc..");
                    System.out.println("Los pedidos no son de articulos en especifico");
                    System.out.println("REALIZAR PEDIDO? (si/no)");
                    pedidoElec = captu.nextLine();
                    if(!pedidoElec.contentEquals("si")) break;
                    System.out.println("Seleccione el paquete por pedir: ");
                    for(int i = 0; i < categoria.length; i++){
                        System.out.println((i+1) + "- " + categoria[i]);
                    }
                    categPedido = captu.nextInt();
                    captu.nextLine();
                    switch(categPedido){
                        case 1:
                            System.out.println("----------------------");
                                System.out.println("HERRAMIENTAS MANUALES:");
                                System.out.print("Cuantos paquetes?: ");
                                        cantPaq = captu.nextInt();
                                        captu.nextLine();
                                        System.out.println("Confirmar pedido? (si/no)");
                                        confPed = captu.nextLine();
                                        if (confPed.contentEquals("no")){
                                            break;}
                                        for(int i = 0; i < cantidad[0].length; i++){
                                            for(int j = 0; j < cantidad[0][i].length; j++){
                                                cantidad[0][i][j] += cantPaq;
                                            }
                                        }
                                        System.out.println("Pedido realizado!!");
                                break;
                        case 2:
                            System.out.println("----------------------");
                                System.out.println("HERRAMIENTAS ELECTRICAS:");
                                System.out.print("Cuantos paquetes?: ");
                                        cantPaq = captu.nextInt();
                                        captu.nextLine();
                                        System.out.println("Confirmar pedido? (si/no)");
                                        confPed = captu.nextLine();
                                        if (confPed.contentEquals("no")){
                                            break;}
                                        for(int i = 0; i < cantidad[1].length; i++){
                                            for(int j = 0; j < cantidad[1][i].length; j++){
                                                cantidad[1][i][j] += cantPaq;
                                            }
                                        }
                                        System.out.println("Pedido realizado!!");
                                break;
                        case 3:
                            System.out.println("----------------------");
                                System.out.println("TORNILLERIA:");
                                System.out.print("Cuantos paquetes?: ");
                                        cantPaq = captu.nextInt();
                                        captu.nextLine();
                                        System.out.println("Confirmar pedido? (si/no)");
                                        confPed = captu.nextLine();
                                        if (confPed.contentEquals("no")){
                                            break;}
                                        for(int i = 0; i < cantidad[2].length; i++){
                                            for(int j = 0; j < cantidad[2][i].length; j++){
                                                cantidad[2][i][j] += cantPaq;
                                            }
                                        }
                                        System.out.println("Pedido realizado!!");
                                break;
                        case 4:
                            System.out.println("----------------------");
                                System.out.println("MATERIALES DE CONSTRUCCION:");
                                System.out.print("Cuantos paquetes?: ");
                                        cantPaq = captu.nextInt();
                                        captu.nextLine();
                                        System.out.println("Confirmar pedido? (si/no)");
                                        confPed = captu.nextLine();
                                        if (confPed.contentEquals("no")){
                                            break;}
                                        for(int i = 0; i < cantidad[3].length; i++){
                                            for(int j = 0; j < cantidad[3][i].length; j++){
                                                cantidad[3][i][j] += cantPaq;
                                            }
                                        }
                                        System.out.println("Pedido realizado!!");
                                break;
                        default:
                            System.out.println("Eleccion no establecida");
                    }
                    break;
                case 3:
                    System.out.println("Seleccione 'no' para salir");
                    break;
                default: 
                    System.out.println("Opcion no establecida");
        } 
        System.out.println("Desea regresar? (si/no)"); //Despues del switch pregunta si desea volver
            regresar = captu.nextLine();
        }while(regresar.contentEquals("si"));
        
        break;
        
            case 2:
                System.out.println("----------------------");
                System.out.println("BIENVENID@ COMPRADOR/A");
                do{
                System.out.println("Seleccione una opcion a continuacion: ");
                System.out.println("Catalogo(1)      Carrtito (2)       Salir(3)");
                usudecision = captu.nextInt();
                 captu.nextLine();
                switch (usudecision){
                    case 1:
                        System.out.println("----------------------");
                        System.out.println("Bienvenid@ al Catalogo");
                        System.out.println("A continuacion elija la categoria");
                        
                         for(int i = 0; i < categoria.length; i++){
                        System.out.println((i+1) + "- " + categoria[i]);
                    }
                    categoriaElec = captu.nextInt();
                    captu.nextLine();
                    System.out.println("----------------------");
                    switch (categoriaElec){
                        case 1:
                            System.out.println("----------------------");
                                System.out.println("[0]HERRAMIENTAS MANUALES:");
                                for(int i = 0; i < 5; i++){
                                    System.out.println("[" + i + "]" + inventario[0][i][0] + ":");
                                      for(int j = 1; j < inventario[0][i].length; j++){
                                        System.out.println("  ["+ j +"]- " + inventario[0][i][j] + "(" + cantidad[0][i][j] + ")" + " $" + precios[0][i][j]);
                                    }
                                }
                                break;
                        case 2:
                            System.out.println("----------------------");
                                System.out.println("[1]HERRAMIENTAS ELECTRICAS:");
                                for(int i = 0; i < 5; i++){
                                    System.out.println("[" + i + "]" + inventario[1][i][0]);
                                    for(int j = 1; j < inventario[1][i].length; j++){
                                         System.out.println("  ["+ j +"]- " + inventario[1][i][j] + "(" + cantidad[1][i][j] + ")"  + " $" + precios[1][i][j]);
                                    }
                                }      
                            break;
                        case 3:
                            System.out.println("----------------------");
                                System.out.println("[2]TORNILLERIA:");
                                for(int i = 0; i < 3; i++){
                                    System.out.println("[" + i + "]" + inventario[2][i][0]);
                                    for(int j = 1; j < inventario[2][i].length; j++){
                                         System.out.println("  ["+ j +"]- " + inventario[2][i][j] + "(" + cantidad[2][i][j] + ")"  + " $" + precios[2][i][j]);
                                    }
                                }      
                            break;
                        case 4:
                            System.out.println("----------------------");
                                System.out.println("[3]MATERIALES DE CONSTRUCCION:");
                                for(int i = 0; i < 3; i++){
                                    System.out.println("[" + i + "]" + inventario[3][i][0]);
                                    for(int j = 1; j < inventario[3][i].length; j++){
                                         System.out.println("  ["+ j +"]- " + inventario[3][i][j] + "(" + cantidad[3][i][j] + ")"  + " $" + precios[3][i][j]);
                                    }
                                }
                            break;
                    }
                    System.out.println("Desea agregar un producto? (si/no)");
                    regresar = captu.nextLine();
                    if(regresar.contentEquals("no")){
                        break;
                    }else if(regresar.contentEquals("si")){
                        System.out.println("Ingrese los numeros de cada una de las secciones dentro de los []");
                        System.out.println("Serian un total de tres ( #categoria, #sub-categoria y #producto ");
                        System.out.print("#Categoria: ");
                        numCate = captu.nextInt();
                        captu.nextLine();
                        System.out.print("#Sub-Categoria: ");
                        numSubCate = captu.nextInt();
                        captu.nextLine();
                        System.out.print("#Producto: ");
                        numProd = captu.nextInt();
                        captu.nextLine();
                        System.out.println("Producto: " + inventario[numCate][numSubCate][numProd] + "(" + cantidad[numCate][numSubCate][numProd] + ")"  + " $" + precios[numCate][numSubCate][numProd]);
                        do{
                        System.out.print("Cuantos productos?: ");
                        cantProd = captu.nextInt();
                        captu.nextLine();
                        if (cantProd > cantidad[numCate][numSubCate][numProd]){
                            System.out.println("No hay tal cantidad de productos en existencia");
                            volver = 1;
                        }else if (cantProd < cantidad[numCate][numSubCate][numProd]){
                        cantidad[numCate][numSubCate][numProd] -= cantProd;
                        volver = 0;
                        }
                        }while (volver == 1);
                        // Agregar producto al carrito
                        nombresCarrito[contadorCarrito] = inventario[numCate][numSubCate][numProd];
                        cantidadesCarrito[contadorCarrito] = cantProd;
                        preciosCarrito[contadorCarrito] = precios[numCate][numSubCate][numProd];
                        contadorCarrito++;

                        System.out.println("Agregado: " + inventario[numCate][numSubCate][numProd] + " $" + precios[numCate][numSubCate][numProd] + " x" + cantProd);
                        System.out.println("Producto agregado al carrito por un total de: " + (precios[numCate][numSubCate][numProd] * cantProd) + " pesos");
                        totalCompra += precios[numCate][numSubCate][numProd] * cantProd;
                    }
                    break;
                    case 2:
                         System.out.println("Carrito de compras:");
                            for (int i = 0; i < contadorCarrito; i++) {
                                System.out.println(nombresCarrito[i] + " x" + cantidadesCarrito[i] + " $" + preciosCarrito[i] + "c/u");
                            }
                            System.out.println("Total a pagar: $" + totalCompra);
                        break;
                    case 3:
                        System.out.println("Ingrese 'no' para salir");
                        break;
                    default:
                        System.out.println("Opcion no establecida");
                }
                    System.out.println("Desea regresar? (si/no)");
                    regresar = captu.nextLine();
        }while(regresar.contentEquals("si"));
    }
            System.out.println("Desea volver al menu principal? (si/no)");
            regresar = captu.nextLine();
    }while(regresar.contentEquals("si"));
}
}
