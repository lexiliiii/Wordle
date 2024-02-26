# Reflection Questions

Answer these questions thoroughly after completing the assignment, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

 In the Black-Box testing for GameState.submitGuess() portion of the assignment, list the partitions of inputs and fields that you used for your test plan. Cite specific tests by name and line number that cover each partition. A bulleted list is acceptable here. You should include all of your tests covering at least one partition. Additionally, for each partition, label it is equivalence, boundary, or exception.

## Answer

[1.Valid Guess Within Dictionary (Equivalence) Test: test_submitGuess_Equivalence_PLAYING
line:67
2.Correct Guess (Equivalence) Test: test_submitGuess_Status_WIN
line:84
3.Last Guess Incorrect (Boundary)Test: test_isGameOver_Loss_True
line:49
4.Last Guess Correct (Boundary)Test:test_submitGuess_Status_Boundary_WIN
line:76
5.First Guess Incorrect(Boundary) Test:test_submitGuess_Equivalence_PLAYING
line:58
6.Guess Not in Dictionary (Exception)Test: InvalidWordGetThrowsExceptions
line:92
7.Game Already Over (Exception)Test: GameAlreadyWINThrowsException and GameAlreadyLOSSThrowsException
line:98,104
8.Invalid (Empty or Null) Guess (Exception)Test: EmptyInputGetThrowsExceptions and NullInputGetThrowsExceptions
line:110,116
9.Invalid Answer Test(Exception) :NULLAnswerThrowsException, answernotindictionaryThrowsException
line:150,157
10.Invalid Status Test(Exception) :InvalidGameStatus_NULL_ThrowsException, InvalidGameStatus2_LOSSThrowsException and InvalidGameStatus0_PlayingThrowsException
line:130,135,140
11.Empty Dictionary Test(Exception) :EmptyDictionaryThrowsException
line:123
12.Invalid Guess Remaining Test(Exception): InvalidGuessesRemaingthrowsException
line:145
13.Valid Guess Remaining(Equivalence):RemainingGuess_Test
line:164
]



## Question 2

The function submitGuess(String) in WordleGameState can throw two different Exceptions. Why would we as developers intentionally design our program to throw Exceptions? What is the benefit?

## Answer

[]
