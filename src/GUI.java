import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea area;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colourMenu;

    //file option
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //format options
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize20;
    JMenu menuFontStyle, menuFontSize;

    File_Functions file = new File_Functions(this);
    Format_Functions format = new Format_Functions(this);

    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        format.selectedFont = "Arial";
        format.font(14);
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

    public void createFormatMenu(){
        iWrap = new JMenuItem("Wrap text: off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Wrap");
        formatMenu.add(iWrap);

        menuFontStyle = new JMenu("Font");
        formatMenu.add(menuFontStyle);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFontStyle.add(iFontArial);

        iFontCSMS = new JMenuItem("CSMS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");
        menuFontStyle.add(iFontCSMS);

        iFontTNR = new JMenuItem("TNR");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFontStyle.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        formatMenu.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("font8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("font12");
        menuFontSize.add(iFontSize12);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("font20");
        menuFontSize.add(iFontSize20);
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
            case "Wrap": format.wordWrap(); break;
            case "font8": format.font(8); break;
            case "font12": format.font(12); break;
            case "font20": format.font(20); break;
            case "Arial": format.setFont("Arial"); break;
            case "CSMS": format.setFont("Comic Sans MS"); break;
            case "TNR": format.setFont("Times New Roman"); break;
        }
    }
}
