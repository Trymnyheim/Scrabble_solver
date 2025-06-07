# Scrabble_solver

## About
Just a fun little program that gives optimal words for scrabble. The ´ScrabbleSolver´-class creates a wordlist from the dictionary using a prefix tree for efficient lookups. From there all possible permutations of the scrabble pieces are searched for in the tree and the longest match is chosen. The scrabble value of the word gets calculated and each word is mapped with the value as key.