# Brackets Language Validator

This is a project to analyze and solve if any word within the given alphabet are valid or not, according to their structure. The main goal is to create a compiler capable of receiving some filename and generating another with the necessary analysis.

Given alphabet:

    Char 1: {
    Char 2: [
    Char 3: ( 
    Char 4: )
    Char 5: ]
    Char 6: }

Yes, the alphabet is composed by braces, brackets and parentheses.

### Validation Required
For each symbol you open, you must close, respecting the hierarchy of symbols that open and close within and around itself.

## The mission
### Part I
Read a text file and mark each line with "OK" or "Inválido":

*Input example:*

    {[]}
    ([)]
    [{()()}[]]
    {}()[()]]
    )[{}]()(
    (()[)]

*Output example:*

    {[]} - OK
    
    ([)] - Inválido
    
    [{()()}[]] - OK
    
    {}()[()]] - Inválido
    
    )[{}]()( - Inválido
    
    (()[)] - Inválido
    


### Part II
Create a java program that receives a text file with code via the command line, something like this:

    $ java prog.txt  
*Output:* prog-check.txt
