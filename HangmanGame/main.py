from tkinter import Tk, Canvas, PhotoImage, Button
from random import choice

blamesTaken = 0
hiddenWord = ""
penduImage = None


def update_hidden_word(word, letter):
    global hiddenWord
    new_hidden_word = ""
    for i in range(len(word)):
        if word[i] == letter:
            new_hidden_word += letter + " "
        else:
            new_hidden_word += hiddenWord[2 * i] + " "
    return new_hidden_word.strip()


def update_pendu_image(canvas):
    global blamesTaken
    if 0 < blamesTaken <= 11:
        photo = PhotoImage(file="images/pendu" + str(blamesTaken) + ".png")
        canvas.itemconfigure(penduImage, image=photo)
        canvas.image = photo


def main():
    window = Tk()
    window.title("Hangman Game")
    window.geometry("1280x720")
    window.resizable(False, False)
    window.configure(background="grey")

    # la liste de mots disponibles (seulement en minuscules pour l'instant)
    wordList = ["youtube", "twitch", "twitter", "instagram", "snapchat", "tiktok"]
    word = choice(wordList)
    # print(word, "est le mot choisi")

    # le mot en tiret du bas
    global hiddenWord
    for _ in range(0, len(word)):
        hiddenWord += "_ "

    canvas = Canvas(window, bg="grey", width=1280, height=650, highlightthickness=0)
    canvas.pack()

    hiddenWordText = canvas.create_text(670, 60, text=hiddenWord, font=("Arial", 70))

    global penduImage
    photo = PhotoImage(file="images/pendu0.png")
    penduImage = canvas.create_image(670, 450, image=photo, anchor="center")

    button = Button(window, text="ê", command=lambda: tryKey("ê"), font=("Arial", 40))
    button.pack()

    def tryKey(pressedKey):
        global hiddenWord, blamesTaken
        if blamesTaken >= 11 or hiddenWord.replace(" ", "") == word:
            return
        if pressedKey in word:
            # si la lettre est bien dans le mot alors on la place
            hiddenWord = update_hidden_word(word, pressedKey)
            canvas.itemconfigure(hiddenWordText, text=hiddenWord)

            # si le mot a deviné est bien égal au mot d'origine, alors la partie est gagnée
            if hiddenWord.replace(" ", "") == word:
                canvas.create_text(670, 155, text="Vous avez gagné !", font=("Arial", 50))
        else:
            blamesTaken += 1
            update_pendu_image(canvas)

            # au bout du 11ème blame (= pendaison), la partie est fini
            if blamesTaken == 11:
                canvas.create_text(670, 155, text="Fin de partie ! Le mot était : " + word, font=("Arial", 50))

    def onKeyPress(event):
        keysAllowed = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
        otherKeysAllowed = {"ugrave": "ù", "eacute": "é", "apostrophe": "'", "egrave": "è", "ccedilla": "ç", "agrave": "à"}

        if event.keysym in otherKeysAllowed.keys():
            tryKey(otherKeysAllowed[event.keysym])
        elif event.keysym in keysAllowed:
            tryKey(event.keysym)

    canvas.bind("<Key>", onKeyPress)
    canvas.focus_set()

    window.mainloop()


if __name__ == '__main__':
    main()
