import tkinter as tk

def main():
    def on_vertical_scroll(*args):
        canvas.yview(*args)

    root = tk.Tk()
    root.geometry("200x200")

    # Création de la scrollbar verticale
    scrollbar = tk.Scrollbar(root, orient="vertical")
    scrollbar.pack(side="right", fill="y")

    # Création du canevas
    canvas = tk.Canvas(root, yscrollcommand=scrollbar.set)
    canvas.pack(side="left", fill="both", expand=True)

    # Attache la scrollbar au canevas
    scrollbar.config(command=on_vertical_scroll)

    # Ajoute du contenu au canevas
    frame = tk.Frame(canvas)
    canvas.create_window((0, 0), window=frame, anchor="nw")

    for i in range(20):
        tk.Label(frame, text="Label " + str(i)).pack()

    # Configurer le canevas pour qu'il puisse déterminer sa taille
    frame.update_idletasks()
    canvas.config(scrollregion=canvas.bbox("all"))

    root.mainloop()


if __name__ == '__main__':
    main()
