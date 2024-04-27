from tkinter import Toplevel, Label, Entry, Button, Variable


class AddContactWindow(Toplevel):
    def __init__(self, parent):
        super().__init__(parent)

        self.title("Ajouter un contact")
        self.geometry("300x325")
        self.resizable(False, False)

        # First Name
        self.firstNameLabel = Label(self, text="Prénom")
        self.firstNameLabel.pack()

        self.firstNameEntry = Entry(self)
        self.firstNameEntry.pack()

        # Name
        self.nameLabel = Label(self, text="Nom de famille")
        self.nameLabel.pack()

        self.nameEntry = Entry(self)
        self.nameEntry.pack()

        # Address
        self.addressLabel = Label(self, text="Adresse")
        self.addressLabel.pack()

        self.addressEntry = Entry(self)
        self.addressEntry.pack()

        # Postal Address
        self.postalAddressLabel = Label(self, text="Adresse Postale")
        self.postalAddressLabel.pack()

        self.postalAddressEntry = Entry(self)
        self.postalAddressEntry.pack()

        # City
        self.cityLabel = Label(self, text="Ville/Village")
        self.cityLabel.pack()

        self.cityEntry = Entry(self)
        self.cityEntry.pack()

        # Country
        self.countryLabel = Label(self, text="Pays")
        self.countryLabel.pack()

        self.countryEntry = Entry(self)
        self.countryEntry.pack()

        # Phone Number
        self.phoneNumberLabel = Label(self, text="Numéro de téléphone")
        self.phoneNumberLabel.pack()

        self.phoneNumberEntry = Entry(self)
        self.phoneNumberEntry.pack()

        # Register Button
        self.submitButton = Button(self, text="Enregistrer", command=self.submit)
        self.submitButton.pack(pady=10)

    def submit(self):
        firstNameValue = self.firstNameEntry.get()
        nameValue = self.nameEntry.get()
        addressValue = self.addressEntry.get()
        postalAddressValue = self.postalAddressEntry.get()
        cityValue = self.cityEntry.get()
        countryValue = self.countryEntry.get()
        phoneNumberValue = self.phoneNumberEntry.get()

        self.master.addContact([firstNameValue, nameValue, addressValue, postalAddressValue, cityValue, countryValue, phoneNumberValue])

        self.destroy()
