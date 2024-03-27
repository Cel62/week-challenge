#pragma once

#include <iostream>  // Pour envoyer et recevoir des messages venant de la console
#include <string>    // Pour faire des strings

#include <algorithm> // Pour std::shuffle
#include <random>    // Pour std::default_random_engine et std::random_device 

#include <windows.h> // Pour acc�der � l'API de windows
#include <cstring> // Pour acc�der � strcpy_s

/* Permet de mettre un texte dans le Presse-Papier de Windows
   (je sais pas si c'est optimis� ou pas mais �a marche donc merci ChatGPT)
*/
void setClipboardText(const std::string& text);

// G�n�re un mot de passe
std::string givePassword(const int passwordLength, const bool withUpperCase, const bool withNumber, const bool withSpecialCharacter, std::default_random_engine& rng);

/* Permet de v�rifier si l'entr�e mise est "oui".
Si cela l'est alors cela renvoie true, sinon false.
Si l'utilisateur a mis ni 'oui' ni 'non' alors c'est qu'il a mis autre chose et cela renverra false
*/
bool yesOrNo(const std::string input);