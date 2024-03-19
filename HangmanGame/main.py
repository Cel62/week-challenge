from tkinter import Tk, Canvas, PhotoImage
from random import choice

blamesTaken = 0
hiddenWord = ""
penduImage = None


def update_hidden_word(word, hidden_word, letter):
    new_hidden_word = ""
    for i in range(len(word)):
        if word[i] == letter:
            new_hidden_word += letter + " "
        else:
            new_hidden_word += hidden_word[2 * i] + " "
    return new_hidden_word.strip()


def update_pendu_image(canvas):
    global blamesTaken
    if 0 < blamesTaken <= 11:
        image_path = "pendu" + str(blamesTaken) + ".png"
        photo = PhotoImage(file="images/" + image_path)
        canvas.itemconfigure(penduImage, image=photo)
        canvas.image = photo


def main():
    window = Tk()
    window.title("Hangman Game")
    window.geometry("1280x720")
    window.resizable(False, False)

    # la liste de mots disponibles (à remplir)
    wordList = ["youtube", "twitch", "twitter", "instagram", "snapchat", "tiktok"]

    # le mot choisi au hasard
    word = choice(wordList)
    print(word, "est le mot choisi")

    # le mot en tiret du bas
    global hiddenWord
    for _ in range(0, len(word)):
        hiddenWord += "_ "

    canvas = Canvas(window, bg="grey", width=1280, height=720, highlightthickness=0)
    canvas.pack()

    hiddenWordText = canvas.create_text(670, 60, text=hiddenWord, font=("Arial", 70))

    global penduImage
    penduImage = canvas.create_image(670, 450, anchor="center")

    def onKeyPress(event):
        global blamesTaken, hiddenWord
        if blamesTaken >= 11 or hiddenWord.replace(" ", "") == word:
            return

        # ne marche pas avec les accents circonflexes du coup
        if event.keysym in word:
            # si la lettre est bien dans le mot alors on la place
            hiddenWord = update_hidden_word(word, hiddenWord, event.keysym)
            canvas.itemconfigure(hiddenWordText, text=hiddenWord)

            if hiddenWord.replace(" ", "") == word:
                canvas.create_text(670, 155, text="Vous avez gagné !", font=("Arial", 50))
        else:
            # au bout du 11ème blame (=pendaison) c'est fini
            blamesTaken += 1
            update_pendu_image(canvas)
            if blamesTaken == 11:
                canvas.create_text(670, 155, text="Fin de partie ! Le mot était : " + word, font=("Arial", 50))

    canvas.bind("<Key>", onKeyPress)
    canvas.focus_set()

    window.mainloop()


if __name__ == '__main__':
    main()
