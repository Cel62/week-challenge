from tkinter import Tk, Button, Label, Scrollbar
from ContactList import ContactList
from AddContactWindow import AddContactWindow
from Contact import Contact


class ContactManager(Tk):
    def __init__(self):
        super().__init__()

        self.title("Contact Manager")
        self.geometry("500x700")
        self.resizable(False, False)
        self.configure(background="grey")

        self.mainTitle = Label(self, text="Contacts", bg='grey', font=("Arial", 30))
        self.mainTitle.pack(pady=5)

        self.addContactButton = Button(self, text="Ajouter", command=lambda: AddContactWindow(self), width=15, height=3, bg="grey")
        self.addContactButton.pack(pady=7)

        self.updateButton = Button(self, text="Actualiser", command=self.update, width=8, height=1, bg="grey")
        self.updateButton.pack(pady=7)

        self.scrollBar = Scrollbar(self, orient="vertical")
        self.scrollBar.pack(side="right", fill="y")

        self.contactList = ContactList(self, yscrollcommand=self.scrollBar.set)
        self.contactList.pack()

        self.scrollBar.config(command=self.contactList.yview)

    def addContact(self, details):
        newContact = Contact(details[0], details[1], details[2], details[3], details[4], details[5], details[6])
        newContact.saveJsonToFile()
        self.contactList.display_contacts()

    def update(self):
        self.contactList.display_contacts()


if __name__ == '__main__':
    app = ContactManager()
    app.mainloop()
