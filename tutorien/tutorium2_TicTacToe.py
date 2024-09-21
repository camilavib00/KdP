import random
import time

def printBoard(board): #board - 3x3
    print("+---+---+---+")
    for row in board:
        print("| " + " | ".join(row) + " |")
        print("+---+---+---+")

def checkWinner(board, symbol):
    if (board[0][0] == board[1][1]==board[2][2]==symbol) or (board[0][2]==board[1][1]==board[2][0]==symbol):
        return True
    for i in range(3):
        onRow=0
        for cell in board[i]:
            if(cell == symbol):
                onRow+=1
        onCol=0
        for j in range(3):
            if(board[j][i] == symbol):
                onCol+=1
        if(onRow == 3 or onCol == 3):
            return True
    return False  
        
print("Das ist ein tic Tac Toe Spiel")
p1 = input("Spieler 1, bitte gib deinen Namen ein: ")
p2 = input("Spieler 2, bitte gib deinen Namen ein: ")
print("Hallo", p1, "und", p2,"!")
time.sleep(1)
print("Um auf die Felder zu setzen, gebt die Koordinate ein. \nDie erste Koordinate ist die Zeile des Felds und die zweite die Spalte.")
erster_spieler = random.choice([p1, p2])
time.sleep(2)
print(erster_spieler, "darf anfangen!")

board = [[' ', ' ', ' '],[' ', ' ', ' '],[' ', ' ', ' ']]
play=["X","O"]
current = 0

while True:
    printBoard(board)
    print("Player", play[current])
    row = int(input("Zeile (0,1,2)"))
    col = int(input("Spalte (0,1,2)"))

    try:
        if(board[row][col] == " "):
            board[row][col] = play[current]
            if(checkWinner(board, play[current])):
                printBoard(board)
                print("Spieler", play[current], "hat gewonnen! :-)")
                break
            current=(current+1)%2
        else:
            print("Dieses Feld ist schon besetzt. Versuche es noch ein Mal!")
    except:
        print("Falsche Koordinate eingegeben")

















