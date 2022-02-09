package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.ExistentContactException;
import exceptions.NotExistentContactException;

public class ContactBook {
	private List<Contact> contacts;
	
	private int indexAux;
	
	public ContactBook() {
		indexAux = 0;
		contacts = new ArrayList<Contact>();
	}
	
	public void addContact(String name, String phone) throws ExistentContactException{
		Contact newContact = new Contact(name, phone);
		
		if(contacts.size() == 0) {
			contacts.add(newContact);
		}else if(!searchContact(phone)){
			contacts.add(newContact);
		}else if(searchContact(phone)) {
			throw new ExistentContactException(phone);
		}
	}
	
	public void removeContact(String phone) throws NotExistentContactException{
		if(contacts.size() == 0){
			throw new NotExistentContactException(phone);
		}else if(searchContact(phone)) {
			contacts.remove(indexAux);
		}else {
			throw new NotExistentContactException(phone);
		}
	}
	
	public boolean searchContact(String phone) {
		boolean found = false;
		
		for (int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getPhone().equals(phone)) {
				found = true;
				indexAux = i;
				break;
			}
		}
		
		return found;
	}

	public String contactsToString() {
		String contactsInfo = "";
		
		if(contacts.size() != 0) {
			for (int i = 0; i < contacts.size(); i++) {
				contactsInfo += contacts.get(i).getName() + ": " 
						+ contacts.get(i).getPhone() + "\n\n";
			}
		}
		
		return contactsInfo;
	}
}
