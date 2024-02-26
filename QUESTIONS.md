# Reflection Questions

Answer these questions thoroughly after completing the assignment, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

 In the Black-Box testing for GameState.submitGuess() portion of the assignment, list the partitions of inputs and fields that you used for your test plan. Cite specific tests by name and line number that cover each partition. A bulleted list is acceptable here. You should include all of your tests covering at least one partition. Additionally, for each partition, label it is equivalence, boundary, or exception.

## Answer

[1.Valid Guess Within Dictionary (Equivalence) Test: test_submitGuess_Status_PLAYING 
line:82
2.Correct Guess (Equivalence) Test: test_submitGuess_Status_WIN
line:64
3.Last Guess Incorrect (Boundary)Test: test_isGameOver_Loss_True
line:55
4.Last Guess Correct (Boundary)Test:test_submitGuess_Status_Boundary_WIN
line:73
5.Guess Not in Dictionary (Exception)Test: InvalidWordGetThrowsExceptions
line:91
6.Game Already Over (Exception)Test: GameAlreadyWINThrowsException and GameAlreadyLOSSThrowsException
line:98,104
7.Invalid (Empty or Null) Guess (Exception)Test: EmptyInputGetThrowsExceptions and NullInputGetThrowsExceptions
line:111,117
8.Invalid Answer Test(Exception) :NULLAnswerThrowsException, answernotindictionaryThrowsException
line:L151,158
9.Invalid Status Test(Exception) :InvalidGameStatus_NULL_ThrowsException, InvalidGameStatus2_LOSSThrowsException and InvalidGameStatus0_PlayingThrowsException
line:131,136,141
10.Empty Dictionary Test(Exception) :EmptyDictionaryThrowsException
line:124
11.Invalid Guess Remaining Test(Exception): InvalidGuessesRemaingthrowsException
line:146]

## Question 2

The function submitGuess(String) in WordleGameState can throw two different Exceptions. Why would we as developers intentionally design our program to throw Exceptions? What is the benefit?

## Answer

[The reason why we as developer always intentionally design the program to throw Exceptions is to keep everything in check. Particularly in the case like our WordleGame assignment program, we need to make sure we can catch and stop any weird stuff, such as not a valid word input, before it gets through the code and messes up our game. By throwing exceptions in submitGuess, we can accomplish this goal, and enforce a correct use of the methods that we are providing. Additionally, while indicating an error is happening, exception can at the same time include error messages and other context about the error state. In this way, throwing exceptions can allow us to communicate with our uses with much more detailed information about what they did incorrect when using our program.]
