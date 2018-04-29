
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author toshiba
 */
public class accountdata {

    public void store(String s1, String s2) throws IOException {
        String name, pass;
        name = new RC4().operation(s1, "453AFD", true);
        pass = new RC4().operation(s2, "453AFD", true);
        try{
        File database = new File("test.txt");
        FileWriter font = new FileWriter(database, true);
        BufferedWriter buffer = new BufferedWriter(font);
            try (PrintWriter fout = new PrintWriter(buffer)) {
                if (database.exists() == false) {
                    database.createNewFile();
                }
                fout.println(name);
                fout.println(pass);
            }
        } catch (Exception ex) {
        }

    }

    public boolean chick(String s1) {
        String name;
        String pass1;
        String name1;
        boolean bool = true;

        try {
            File database = new File("test.txt");
            Scanner fout = new Scanner(database);
            fout.nextLine();

            while (fout.hasNext()) {
                name = fout.nextLine();
                pass1 = fout.nextLine();
                name1 = new RC4().operation(name, "453AFD", false);
                if (s1.equals(name1)) {
                    bool = false;
                    break;
                }
            }

        } catch (Exception ex) {
        }
        return bool;
    }

    public boolean bring(String user, String pass) {
        String name;
        String pass1;
        String name1;
        String pass2;
        boolean bool = false;

        try {
            File database = new File("test.txt");
            Scanner fout = new Scanner(database);

            fout.nextLine();
            while (fout.hasNext()) {
                name = fout.nextLine();
                pass1 = fout.nextLine();
                name1 = new RC4().operation(name, "453AFD", false);
                pass2 = new RC4().operation(pass1, "453AFD", false);
                if (user.equals(name1) && pass.equals(pass2)) {
                    bool = true;
                    break;
                }
            }

        } catch (Exception ex) {
        }
        return bool;

    }
}
