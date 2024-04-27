from Contact import Contact
from tkinter import Canvas, Button, Frame
from os import path, listdir
from json import load


class ContactList(Canvas):
    def __init__(self, master, *args, **kwargs):
        super().__init__(master, *args, **kwargs)

        self.update_idletasks()
        self.display_contacts()

        self.config(width=350, height=530, bg="red", highlightthickness=0, scrollregion=self.bbox("all"))

    def loadContacts(self):
        contacts_list = []

        script_directory = path.dirname(__file__)
        contacts_directory = path.join(script_directory, "contacts")

        for fileName in listdir(contacts_directory):
            if fileName.endswith(".json"):
                file_path = path.join(contacts_directory, fileName)

                with open(file_path, encoding="utf-8") as file:
                    data = load(file)
                contacts_list.append(
                    Contact(data["firstName"], data["name"], data["address"], data["postalAddress"], data["city"],
                            data["country"], data["phoneNumber"]))

        return contacts_list

    def show_contact_details(self, contact):
        print("Détails du contact:")
        print(f"Prénom: {contact.getFirstName()}")
        print(f"Nom: {contact.getName()}")
        print(f"Adresse: {contact.getAddress()}")
        print(f"Adresse postale: {contact.getPostalAddress()}")
        print(f"Ville: {contact.getCity()}")
        print(f"Pays: {contact.getCountry()}")
        print(f"Téléphone: {contact.getPhoneNumber()}")
        print("----------------------")

    def display_contacts(self):
        for widget in self.winfo_children():
            widget.destroy()

        contacts = self.loadContacts()

        y = 35
        for i, contact in enumerate(contacts):
            button = Button(self, text=f"{contact.getFullName()}", command=lambda c=contact: self.show_contact_details(c))
            self.create_window(20, y, anchor="center", window=button)
            y += 35
