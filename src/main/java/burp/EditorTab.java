package burp;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class EditorTab implements BurpExtension {


    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("ToDecaedron");
    }

    private String loadVersion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("version.properties")) {
            Properties props = new Properties();
            if (input != null) {
                props.load(input);
                return props.getProperty("version", "Unknown");
            } else {
                return "Not Found";
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
