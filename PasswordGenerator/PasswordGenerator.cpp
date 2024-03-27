#include "PasswordGenerator.h"

int main()
{
    std::string passwordLengthString, withUpperCaseString, withNumberString, withSpecialCharacterString;

    // Demande la longueur du mot de passe
    std::cout << "Mettez la longueur du mot de passe" << std::endl;
    std::cin >> passwordLengthString;

    int passwordLength;

    // V�rifie si la longueur du mot de passe est bien un nombre sinon vide la console et envoie un message d'erreur
    try {
        passwordLength = std::stoi(passwordLengthString);
    }
    catch (...) {
        system("cls");
        std::cerr << "Erreur. La longueur du mot de passe doit etre un nombre valide." << std::endl;
        return 1;
    }

    // Questions suppl�mentaires
    std::cout << "Voulez-vous des majuscules ? (oui ou non)" << std::endl;
    std::cin >> withUpperCaseString;

    std::cout << "Voulez-vous des nombres ? (oui ou non)" << std::endl;
    std::cin >> withNumberString;

    std::cout << "Voulez-vous des caracteres speciaux ? (oui ou non)" << std::endl;
    std::cin >> withSpecialCharacterString;

    bool withUpperCase = yesOrNo(withUpperCaseString);
    bool withNumber = yesOrNo(withNumberString);
    bool withSpecialCharacter = yesOrNo(withSpecialCharacterString);

    // Permet de g�rer l'al�atoire
    std::random_device rd;
    std::default_random_engine rng(rd());

    // Vide la console, donne le mot de passe et le met dans le presse-papier (de Windows)
    system("cls");
    std::string password = givePassword(passwordLength, withUpperCase, withNumber, withSpecialCharacter, rng);
    std::cout << "Le mot de passe est : " << password << std::endl;
    std::cout << "Le mot de passe a ete mis dans le presse-papier. (Ctrl + V)" << std::endl;

    setClipboardText(password);

    return 0;
}

void setClipboardText(const std::string& text) {
    if (OpenClipboard(nullptr)) {
        EmptyClipboard();
        HGLOBAL hClipboardData = GlobalAlloc(GMEM_DDESHARE, text.size() + 1);
        if (hClipboardData != nullptr) {
            char* pchData = static_cast<char*>(GlobalLock(hClipboardData));
            if (pchData != nullptr) {
                strcpy_s(pchData, text.size() + 1, text.c_str());
                GlobalUnlock(hClipboardData);
                SetClipboardData(CF_TEXT, hClipboardData);
            }
        }
        CloseClipboard();
    }
}

std::string givePassword(const int passwordLength, const bool withUpperCase, const bool withNumber, const bool withSpecialCharacter, std::default_random_engine& rng) {
    std::string alphabet = "abcdefghijklmnopqrstuvwxyz";
    std::string numbers = "0123456789";
    std::string specialCharacters = "&*@-_";

    // Initialise la cha�ne de caract�res � partir de laquelle on va choisir les caract�res
    std::string characterSet = alphabet;

    // Ajout des caract�res suppl�mentaires en fonction des param�tres
    if (withUpperCase)
        characterSet += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if (withNumber)
        characterSet += numbers;
    if (withSpecialCharacter)
        characterSet += specialCharacters;

    // Le mot de passe doit faire au moins 4 caract�res
    if (passwordLength < 4) {
        std::cerr << "Erreur. La longueur du mot de passe doit �tre d'au moins 4 caract�res pour inclure un caract�re de chaque type." << std::endl;
        return "";
    }

    // G�n�re le mot de passe en choisissant al�atoirement un caract�re de characterSet pour chaque position
    std::shuffle(characterSet.begin(), characterSet.end(), rng);
    std::string password;
    for (int i = 0; i < passwordLength - 3; ++i) {
        password += characterSet[rng() % characterSet.size()];
    }

    // Ajoute un caract�re de chaque type � la fin du mot de passe
    if (withUpperCase)
        password += "ABCDEFGHIJKLMNOPQRSTUVWXYZ"[rng() % 26];
    if (withNumber)
        password += numbers[rng() % 10];
    if (withSpecialCharacter)
        password += specialCharacters[rng() % 5];

    // On rem�lange le mot de passe final
    std::shuffle(password.begin(), password.end(), rng);

    return password;
}

bool yesOrNo(const std::string input) {
    return input == "oui" || input == "Oui";
}