from json import dump


class Contact:
    def __init__(self, firstName: str, name: str, address: str, postalAddress: int, city: str, country: str, phoneNumber: str):
        self.__firstName = firstName
        self.__name = name
        self.__address = address
        self.__postalAddress = postalAddress
        self.__city = city
        self.__country = country
        self.__phoneNumber = phoneNumber

    def getFirstName(self):
        return self.__firstName

    def getName(self):
        return self.__name

    def getFullName(self):
        return self.__firstName + " " + self.__name

    def getAddress(self):
        return self.__address

    def getPostalAddress(self):
        return self.__postalAddress

    def getCity(self):
        return self.__city

    def getCountry(self):
        return self.__country

    def getPhoneNumber(self):
        return self.__phoneNumber

    def getJson(self):
        dict_contact = {
            "firstName": self.__firstName,
            "name": self.__name,
            "address": self.__address,
            "postalAddress": self.__postalAddress,
            "city": self.__city,
            "country": self.__country,
            "phoneNumber": self.__phoneNumber
        }

        return dict_contact

    def saveJsonToFile(self):
        """Cette fonction permet de sauvegarder dans un fichier sous format JSON le contact"""
        fileName = "contacts/" + self.getFullName() + ".json"
        dict_contact = self.getJson()

        with open(fileName, "w", encoding="utf-8") as file:
            dump(dict_contact, file, indent=2, separators=(", ", ": "), ensure_ascii=False)
