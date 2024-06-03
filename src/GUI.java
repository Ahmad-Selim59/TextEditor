import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea area;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colourMenu;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    File_Functions file = new File_Functions(this);

    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){
        area = new JTextArea();
        scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);

    }

    public void createMenuBar(){
        menuBar = new JMenuBar();

        window.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        formatMenu = new JMenu("Format");
        menuBar.add(formatMenu);

        colourMenu = new JMenu("Colour");
        menuBar.add(colourMenu);

    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        fileMenu.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        fileMenu.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        fileMenu.add(iSave);

        iSaveAs = new JMenuItem("Save as");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        fileMenu.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        fileMenu.add(iExit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save as": file.saveAs(); break;
            case "Save": file.saveFile(); break;
            case "Exit": file.exitFile(); break;
        }
    }
}
