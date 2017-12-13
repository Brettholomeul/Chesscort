TO RUN:

Go to Run on top bar of Eclipse > Run Configurations
  > Arguments
    > Program arguments:
    Type: area1.txt

From then on, you can run it normally using the green arrow button

- Once it's running, there will be scanner prompts in the console that are pretty self explanatory. 
- You start by choosing a white piece to move based on the coordinates. 
- A good one to test is one of the rooks (i.e. (1,1) or (8,1)). 
- You then are presented a list of viable moves.
- Choose a tile from those moves to move the piece.
- Currently, you can move, say, rook at (1,1) to (1,8) as there is no pawn at (1,7) to block it.
- Moving it to (1,8) will take the enemy rook positioned there.
- The console then displays all the current pieces held by both teams, as well as the "current" removed pieces.
- It then changes teams.
- It asks you to type 'Y' to continue, but you can actually input anything other than 'end.'
- From there it changes teams and essentially repeats.


KNOWN BUGS:
- When play returns to the white rook moved to (1,8), the piece to its immediate right is not listed as a potential move.

- The same white rook at (1,8) currently seems to be allowed to move to any space in the row of y=8 as if there was nothing in the way.

- The list of removed pieces seems to reset after change of teams (or somewhere before)
  > white piece takes black --> black piece appears in removed section
  > black piece moves --> both removed sections appear empty
  > white piece moves --> both removed sections appear empty and black removed throws NullPointerException