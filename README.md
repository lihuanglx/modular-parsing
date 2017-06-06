# Type-Safe Modular Parsing

## Code

There are 4 folders under `src/main/scala`:

* `ModOA` - Modular version with Object Algebras
* `ModClass` - Modular version with classes
* `NonMod` - Non-modular version, modified from https://github.com/ilya-klyuchnikov/tapl-scala
* `NonModLM` - Non-modular version with longest-match alternative combinator (`|||`)

## Build

This project can be built by Scala's build tool sbt. Just type `sbt` then `compile` and `run`.

To build it manually, add the only dependency from https://github.com/scala/scala-parser-combinators.

## Run

1. Type `run` under SBT:

```
> run
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list

Multiple main classes detected, select one to run:

 [1] ModClass.Test
 [2] ModOA.Test
 [3] NonMod.Test
 [4] NonModLM.Test
```

2. Select which version to run by the number:

```
Enter number: 1

[info] Running ModClass.Test
Calculus name:
```

3. Enter a calculus name (case-insensitive). It will parse every line from file `examples/{calculus-name}.tapl`, and pretty-print the AST. Those files contain randomly generated expressions, one per line.

## List of calculus names

* Arith           
* Untyped         
* FullUntyped 
* TyArith         
* SimpleBool      
* FullSimple      
* Bot             
* FullRef       
* FullError    
* RcdSubBot       
* FullSub         
* FullEquiRec     
* FullIsoRec      
* EquiRec         
* Recon           
* FullRecon       
* FullPoly        
* FullOmega       
