import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File_Functions {

    GUI gui;
    String fileName;
    String fileAddress;
    public File_Functions(GUI gui){
        this.gui = gui;
    }

    public void newFile(){
        gui.area.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void openFile(){
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.area.setText("");
            String line = null;

            while((line = br.readLine()) != null){
                gui.area.append(line + "\n");
            }
            br.close();

        } catch (Exception e){
            System.out.println("File did not open");
        }
    }

    public void saveFile(){
        if (fileName == null){
            saveAs();
        } else {
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.area.getText());
                fw.close();
                gui.window.setTitle(fileName);

            } catch (Exception e){
                System.out.println("Failed to save file");
            }
        }
    }

    public void saveAs(){
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.area.getText());
            fw.close();

        } catch (Exception e){
            System.out.println("Failed to save file as...");
        }
    }

    public void exitFile(){
        System.exit(0);
    }

}
