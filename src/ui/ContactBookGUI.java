package ui;

import exceptions.ExistentContactException;
import exceptions.NotExistentContactException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.ContactBook;

public class ContactBookGUI {

	@FXML
    private Button BTTN_REGISTER;

    @FXML
    private Button BTTN_REMOVE;

    @FXML
    private TextArea TXTA_CONTACTS;

    @FXML
    private TextField TXT_NAME;

    @FXML
    private TextField TXT_TLF;
    
    private ContactBook contactBook;
    
    public ContactBookGUI() {
    	contactBook = new ContactBook();
    }

    @FXML
    void registerContact(ActionEvent event) {
    	if(!TXT_NAME.getText().equals("") && !TXT_TLF.getText().equals("")) {
    		String name = TXT_NAME.getText();
    		String phone = TXT_TLF.getText();
    		
    		try {
    			contactBook.addContact(name, phone);
    			
    			updateContacts();
    			
    			TXT_NAME.clear();
    			TXT_TLF.clear();
    		}catch (ExistentContactException e) {
				e.printStackTrace();
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Contact was not registered");
				alert.setContentText("The contact you tried to create has been created before. Try again");
				alert.show();
    		}
    	}
    }

    @FXML
    void removeContact(ActionEvent event) {
    	if(!TXT_TLF.getText().equals("")) {
    		String phone = TXT_TLF.getText();
    		
    		try {
				contactBook.removeContact(phone);
				
				updateContacts();
				
				TXT_NAME.clear();
				TXT_TLF.clear();
			} catch (NotExistentContactException e) {
				e.printStackTrace();
				
				TXT_NAME.clear();
				TXT_TLF.clear();
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Contact not found");
				alert.setContentText("The contact you tried to remove doesn't exist. Try again");
				alert.show();
			}
    	}
    }
    
    public void updateContacts() {
    	TXTA_CONTACTS.setText(contactBook.contactsToString());
	}
}
