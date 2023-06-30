/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD_T1_B_FicherosObjetos;

import com.github.javafaker.Faker;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author Vespertino
 */
public class Run {

    public static void main(String[] args) {
        ImpDAODepartamento a = new ImpDAODepartamento();
        LinkedHashSet<Empleado> empleados = new LinkedHashSet<Empleado>();
        Scanner sc = new Scanner(System.in);
        Faker f = new Faker();
        byte numero;

        while (true) {

            // Mostrar menu
            System.out.println("Menu del fichero: PRESIONA\t "
                    + "1.ALTA\t"
                    + "2.BAJA\t"
                    + "3.MOSTRAR TODO \t");

            numero = sc.nextByte();

            switch (numero) {
                case 1:
                    int cont = 0;
                    for (int i = 0; i < 5; i++) {
                        Empleado em = new Empleado(f.number().numberBetween(0, 1000), f.name().firstName(), f.job().position());
                        empleados.add(em);
                        cont++;
                    }
                    Departamento d = new Departamento(f.number().numberBetween(1, 10), f.job().position(), f.address().city(), empleados);
                    a.Alta(d);
                    if (cont > 0) {
                        empleados.clear();
                    }
                    break;
                case 2:
                    int num;
                    System.out.println("Introduce el numero del departamento: ");
                    num = sc.nextInt();
                    Departamento d2 = new Departamento(num);
                    a.Baja(d2);
                    break;
                case 3:
                    a.verTodos();
                    break;
            }
        }

    }

}
