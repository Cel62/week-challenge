#pragma once

#include <iostream>  // Pour envoyer et recevoir des messages venant de la console
#include <string>    // Pour faire des strings

#include <algorithm> // Pour std::shuffle
#include <random>    // Pour std::default_random_engine et std::random_device 

#include <windows.h> // Pour accéder à l'API de windows
#include <cstring> // Pour accéder à strcpy_s

/* Permet de mettre un texte dans le Presse-Papier de Windows
   (je sais pas si c'est optimisé ou pas mais ça marche donc merci ChatGPT)
*/
void setClipboardText(const std::string& text);

// Génère un mot de passe
std::string givePassword(const int passwordLength, const bool withUpperCase, const bool withNumber, const bool withSpecialCharacter, std::default_random_engine& rng);

/* Permet de vérifier si l'entrée mise est "oui".
Si cela l'est alors cela renvoie true, sinon false.
Si l'utilisateur a mis ni 'oui' ni 'non' alors c'est qu'il a mis autre chose et cela renverra false
*/
bool yesOrNo(const std::string input);