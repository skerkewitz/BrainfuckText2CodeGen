# BrainfuckText2CodeGen
Generate Brainfuck code to reproduce a given string of text


# How to use it

This project uses Gradle 5. Use the gradle wrapper if needed.

To create the brainfuck code for a text like _Hallo Freunde!_ just run

    gradle run --args="Hallo Freunde!"

Gradle will compile the code if needed and run the application. You will find
your brainfuck code at the end of the output:

```
...

> Task :run
Brainfuck code:
++++++++++[->+>+++>++++++>++++++++>++++++++++>++++++++++++<<<<<<]>>>>--------.>---.+++++++++++..>---------.

BUILD SUCCESSFUL in 0s
2 actionable tasks: 1 executed, 1 up-to-date

```

Have fun!